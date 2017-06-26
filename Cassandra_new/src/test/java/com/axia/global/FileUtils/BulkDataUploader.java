package com.axia.global.FileUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.axia.global.dao.ISmartMeterRawEntriesDAO;
import com.axia.global.dao.cassandra.impl.SmartMeterRawEntriesCassandraDAOImpl;
import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;

public class BulkDataUploader {

	private static ISmartMeterRawEntriesDAO dao = new SmartMeterRawEntriesCassandraDAOImpl();

	public static void main(String[] args) {
		int count = 0;
		String csvFile = "G:\\AXIA_Data\\1004.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<SmartMeterRawEntries> smartMeterData = null;

		try {
			smartMeterData = new ArrayList<SmartMeterRawEntries>();
			SmartMeterRawEntries details = null;

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				count++;
				details = new SmartMeterRawEntries();

				String[] data = line.split(cvsSplitBy);
				details.setMeterID(Integer.parseInt(data[0].trim()));
				details.setReading(Long.parseLong(data[2].trim()));
				String[] vals = data[1].split(" ");
				details.setDate(vals[0].trim());
				details.setTimeStamp(data[1]);
				smartMeterData.add(details);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(count);
		System.out.println(smartMeterData.size());
		dao.saveListSmartMeterData(smartMeterData);
	}

}
