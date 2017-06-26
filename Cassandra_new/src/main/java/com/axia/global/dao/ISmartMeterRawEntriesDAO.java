package com.axia.global.dao;

import java.util.List;

import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;

public interface ISmartMeterRawEntriesDAO {

	void saveSmartMeterData(SmartMeterRawEntries smartMeterData);

	void saveListSmartMeterData(List<SmartMeterRawEntries> smartMeterData);

	List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo);

	List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo, int days);

	List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo, String from, String to);

	void deleteSmartMeterData(int meterNo);

	void deleteSmartMeterData(List<Integer> meterNo);

	void deleteSmartMeterData(int meterNo, String todate);

	void deleteSmartMeterData(List<Integer> meterNo, String todate);
	
	void deleteSmartMeterData(int meterNo, String from , String todate);

	void deleteSmartMeterData(List<Integer> meterNo, String from, String todate);

}
