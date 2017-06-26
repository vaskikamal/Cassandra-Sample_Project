package com.axia.global.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class SparkHourlyAggregator {

	private static final String keyDelim = ",";
	private static final Logger log = Logger.getLogger(SparkHourlyAggregator.class);
	private static JavaSparkContext sc;

	public SparkHourlyAggregator(JavaSparkContext sc) {
		this.sc = sc;
	}

	protected static JavaPairRDD<Tuple2<Integer, String>, Double> loadPoints(JavaSparkContext sc,
			String pointInputDir) {
		return sc.textFile(pointInputDir).mapToPair(new PairFunction<String, Tuple2<Integer, String>, Double>() {

			public Tuple2<Tuple2<Integer, String>, Double> call(String line) throws Exception {// 1000
																								// 111201|2.1,1.2,3.1...,4.3
				String[] fields = line.split(keyDelim);
				int meterID = Integer.valueOf(fields[0]); // MeterID
				String[] v = fields[1].split(" ");
				double readate = 1.0 * Integer.valueOf(v[0].replace("-", ""));
				String hour = v[1];
				double reading = Double.parseDouble(fields[2]);
				return new Tuple2<Tuple2<Integer, String>, Double>(new Tuple2<Integer, String>(meterID, hour), reading);
			}
		});
	}

	public static JavaPairRDD<Tuple2<Integer, String>, Double> run(String trainingSetData) {
		log.setLevel(Level.INFO);
		JavaPairRDD<Tuple2<Integer, String>, Double> pointsRDD = SparkHourlyAggregator.loadPoints(sc, trainingSetData);
		return pointsRDD;
	}

	public static void train(JavaPairRDD<Tuple2<Integer, String>, Double> pointsRDD, String centroidOutputDir) {
		pointsRDD.mapToPair(new PairFunction<Tuple2<Tuple2<Integer, String>, Double>, String, Double>() {
			@Override
			public Tuple2<String, Double> call(Tuple2<Tuple2<Integer, String>, Double> x) throws Exception {
				Integer ID = (x._1())._1;
				String time = (x._1())._2;
				String meterID = ID + time;
				return new Tuple2<String, Double>(meterID, x._2());
			}
		}).groupByKey().mapValues(new Function<Iterable<Double>, Double>() {
			@Override
			public Double call(Iterable<Double> x) throws Exception {
				List<Double> allPoints = new ArrayList<Double>();
				Double average = 0.0;
				int N = 0;
				Iterator<Double> itr = x.iterator();
				while (itr.hasNext()) {
					Double point = itr.next();
					average += point;
					allPoints.add(new Double(point));
					++N;
				}
				return average / N;
			}
		}).saveAsTextFile(centroidOutputDir);
	}

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("SparkJoins").setMaster("local"));
		SparkHourlyAggregator job = new SparkHourlyAggregator(sc);
		JavaPairRDD<Tuple2<Integer, String>, Double> pointsRDD = job.run("G:\\AXIA_Data\\1004.txt");
		// output_rdd.saveAsTextFile(args[1]);
		SparkHourlyAggregator.train(pointsRDD, "G:\\AXIA_Data\\text");
		sc.close();
	}
}
