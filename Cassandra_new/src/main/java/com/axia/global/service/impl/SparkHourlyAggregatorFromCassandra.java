package com.axia.global.service.impl;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.javaFunctions;
import static com.datastax.spark.connector.japi.CassandraJavaUtil.mapRowTo;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;

public class SparkHourlyAggregatorFromCassandra {

	private static final String keyDelim = ",";
	private static final Logger log = Logger.getLogger(SparkHourlyAggregatorFromCassandra.class);
	private static JavaSparkContext sc;

	/**
	 * constructor.
	 * 
	 * @param sc
	 */
	public SparkHourlyAggregatorFromCassandra(JavaSparkContext sc) {
		this.sc = sc;
	}

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("SparkJoins").setMaster("local").set("spark.cassandra.connection.host", "127.0.0.1"));
		SparkHourlyAggregatorFromCassandra sparkHourlAggregatorJob = new SparkHourlyAggregatorFromCassandra(sc);
		
		JavaRDD<SmartMeterRawEntries> cassandraRowsRDD = 
				javaFunctions(sc).cassandraTable("axiaglobal", "smartmeter_entries",
				mapRowTo(SmartMeterRawEntries.class));
		
		

		sc.close();
	}
}
