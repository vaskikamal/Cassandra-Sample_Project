package com.axia.global.dao.cassandra.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.axia.global.config.CassandraConnection;
import com.axia.global.dao.ISmartMeterRawEntriesDAO;
import com.axia.global.dao.cassandra.accessor.ISmartMeterEntriesAccessor;
import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;
import com.datastax.driver.mapping.Mapper;

public class SmartMeterRawEntriesCassandraDAOImpl implements ISmartMeterRawEntriesDAO {

	Logger log = Logger.getLogger(SmartMeterRawEntriesCassandraDAOImpl.class);

	CassandraConnection conn = new CassandraConnection("127.0.0.1", 9042);

	private Mapper<SmartMeterRawEntries> mapper = null;

	ISmartMeterEntriesAccessor smartMeterAccessor = null;

	public SmartMeterRawEntriesCassandraDAOImpl() {
		mapper = conn.getManager().mapper(SmartMeterRawEntries.class);
		smartMeterAccessor = conn.getManager().createAccessor(ISmartMeterEntriesAccessor.class);
	}

	@Override
	public void saveSmartMeterData(SmartMeterRawEntries smartMeterData) {
		if (smartMeterData != null) {
			mapper.save(smartMeterData);
		} else {
			log.info("saveSmartMeterData : Null CustomerBUWiseDetails received. Hence, ignoring");
		}
	}

	@Override
	public void saveListSmartMeterData(List<SmartMeterRawEntries> smartMeterData) {
		if (smartMeterData != null && smartMeterData.size() > 0) {
			int count = 0;
			for (SmartMeterRawEntries e : smartMeterData) {
				System.out.println(e.getDate());
				mapper.save(e);
				System.out.println("Count " + count++);
			}
		} else {
			log.info("saveListSmartMeterData : Null CustomerBUWiseDetails received. Hence, ignoring");
		}
	}

	@Override
	public List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo) {
		List<SmartMeterRawEntries> smartMeterData = smartMeterAccessor.getAllSmartMetersData(meterNo).all();
		return smartMeterData == null ? null : smartMeterData;
	}

	@Override
	public List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo, int limit) {

		List<SmartMeterRawEntries> smartMeterData = smartMeterAccessor.getAllSmartMetersData(meterNo, limit).all();
		return smartMeterData == null ? null : smartMeterData;
	}

	@Override
	public List<SmartMeterRawEntries> getAllSmartMeterData(int meterNo, String from, String to) {
		List<SmartMeterRawEntries> smartMeterData = smartMeterAccessor.getSmartMetersData(meterNo, from, to).all();
		return smartMeterData == null ? null : smartMeterData;
	}

	@Override
	public void deleteSmartMeterData(int meterNo) {
		smartMeterAccessor.deleteTheMeterId(meterNo);
	}

	@Override
	public void deleteSmartMeterData(List<Integer> meterNo) {
		for (Integer e : meterNo) {
			deleteSmartMeterData(e);
		}
	}

	@Override
	public void deleteSmartMeterData(int meterNo, String todate) {
		smartMeterAccessor.deleteTheMeterId(meterNo, todate);
	}
	
	@Override
	public void deleteSmartMeterData(List<Integer> meterNo,String todate) {
		for (Integer e : meterNo) {
			deleteSmartMeterData(e, todate);
		}
	}

	@Override
	public void deleteSmartMeterData(int meterNo, String from, String todate) {
		smartMeterAccessor.deleteTheMeterId(meterNo, from, todate);
		
	}

	@Override
	public void deleteSmartMeterData(List<Integer> meterNo, String from, String todate) {
		for (Integer e : meterNo) {
			deleteSmartMeterData(e, from, todate);
		}
	}
}
