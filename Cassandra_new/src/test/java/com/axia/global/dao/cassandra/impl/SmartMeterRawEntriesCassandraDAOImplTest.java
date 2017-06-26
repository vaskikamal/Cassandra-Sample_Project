package com.axia.global.dao.cassandra.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;

public class SmartMeterRawEntriesCassandraDAOImplTest {

//	private SmartMeterRawEntriesCassandraDAOImpl impl;
//
//	@Before
//	public void setup() {
//		impl = new SmartMeterRawEntriesCassandraDAOImpl();
//	}
//
//	@Test
//	public void delete() {
//		impl.deleteSmartMeterData(12345);
//	}
//
//	@Test
//	public void deleteListOfMeter() {
//		List<Integer> vals = new ArrayList<Integer>();
//		vals.add(1234);
//		vals.add(123456);
//		impl.deleteSmartMeterData(vals);
//	}
//
//	@Test
//	public void testSaveSmartEntries() {
//		List<SmartMeterRawEntries> smartMeterData = new ArrayList<SmartMeterRawEntries>();
//		SmartMeterRawEntries details = new SmartMeterRawEntries();
//		details.setMeterID(12345);
//		details.setDate("2012-12-1984");
//		details.setTimeStamp("2012-12-1984 23:10:10");
//		details.setReading(new Long(23));
//		smartMeterData.add(details);
//		details = new SmartMeterRawEntries();
//		details.setMeterID(123456);
//		details.setDate("2012-11-1984");
//		details.setTimeStamp("2012-12-1984 23:10:10");
//		details.setReading(new Long(25));
//		smartMeterData.add(details);
//		details = new SmartMeterRawEntries();
//		details.setMeterID(1234);
//		details.setDate("2013-04-03");
//		details.setTimeStamp("2013-04-03 07:01:00");
//		details.setReading(new Long(72));
//		smartMeterData.add(details);
//		details = new SmartMeterRawEntries();
//		details.setMeterID(1234);
//		details.setDate("2013-04-03");
//		details.setTimeStamp("2013-04-03 07:02:00");
//		details.setReading(new Long(73));
//		smartMeterData.add(details);
//
//		details = new SmartMeterRawEntries();
//		details.setMeterID(1234);
//		details.setDate("2013-04-04");
//		details.setTimeStamp("2013-04-04 07:01:00");
//		details.setReading(new Long(74));
//		smartMeterData.add(details);
//		details = new SmartMeterRawEntries();
//		details.setMeterID(1234);
//		details.setDate("2013-04-04");
//		details.setTimeStamp("2013-04-04 07:02:00");
//		details.setReading(new Long(75));
//		smartMeterData.add(details);
//
//		impl.saveListSmartMeterData(smartMeterData);
//
//	}
//
//	@Test
//	public void deletebasedOnFromDate() {
//		String todate = "2013-04-03 07:02:00";
//		impl.deleteSmartMeterData(12345, todate);
//	}
//
//	@Test
//	public void deleteListOfMeterFromDate() {
//		String todate = "2013-04-04 07:02:00";
//		List<Integer> vals = new ArrayList<Integer>();
//		vals.add(1234);
//		vals.add(12345);
//		vals.add(123456);
//		impl.deleteSmartMeterData(vals, todate);
//	}
//
//	@Test
//	public void deletebasedOnFromAndToDate() {
//		//testSaveSmartEntries();
//		String todate = "2013-04-03 07:01:00";
//		String fromdate = "2013-04-04 07:02:00";
//		impl.deleteSmartMeterData(1234, fromdate, todate);
//	}
//
//	@Test
//	public void deleteListOfMeterFromAndToDate() {
//		String todate = "2013-04-03 07:01:00";
//		String fromdate = "2013-04-04 07:01:00";
//		List<Integer> vals = new ArrayList<Integer>();
//		vals.add(1234);
//		vals.add(12345);
//		vals.add(123456);
//		impl.deleteSmartMeterData(vals, fromdate, todate);
//	}
//	
//	@Test
//	public void testOneSaveSmartEntries() {
//		SmartMeterRawEntries details = new SmartMeterRawEntries();
//		details.setMeterID(12345);
//		details.setDate("2012-12-1985");
//		details.setTimeStamp("2012-12-1985 23:10:10");
//		details.setReading(new Long(23));
//
//		impl.saveSmartMeterData(details);
//
//	}
//
//	@Test
//	public void testGetSmartMeterEntries() {
//		List<SmartMeterRawEntries> details = impl.getAllSmartMeterData(12345);
//		for (SmartMeterRawEntries e : details) {
//			System.out.println(e.getDate() + " " + e.getReading());
//		}
//	}
//
//	@Test
//	public void testGetSmartMeterEntriesLimit() {
//		List<SmartMeterRawEntries> details = impl.getAllSmartMeterData(12345, 1);
//		for (SmartMeterRawEntries e : details) {
//			System.out.println(e.getDate() + " " + e.getReading());
//		}
//	}
//
//	@Test
//	public void testGetSmartMeterEntriesDateLimit() {
//		String todate = "2013-04-03 07:02:00";
//		String fromdate = "2013-04-03 07:01:00";
//		List<SmartMeterRawEntries> details = impl.getAllSmartMeterData(1234, fromdate, todate);
//		for (SmartMeterRawEntries e : details) {
//			System.out.println(e.getDate() + " " + e.getReading());
//		}
//
//		fromdate = "2013-04-03 07:01:00";
//		todate = "2013-04-04 07:02:00";
//		details = impl.getAllSmartMeterData(1234, fromdate, todate);
//		for (SmartMeterRawEntries e : details) {
//			System.out.println(e.getDate() + " " + e.getReading());
//		}
//	}
}
