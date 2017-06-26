package com.axia.global.dao.cassandra.accessor;

import com.axia.global.dao.model.cassandra.SmartMeterRawEntries;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

/**
 * Interface which will be used by Cassandra DAO Impl to fetch customized data
 * from database.
 * 
 * @author Axia
 *
 */
@Accessor
public interface ISmartMeterEntriesAccessor {

	@Query("SELECT * FROM SmartMeter_Entries WHERE meterID = ? AND timeStamp >= ? AND timeStamp <= ?")
	Result<SmartMeterRawEntries> getSmartMetersData(Integer id, String fromDate, String toDate);

	@Query("SELECT * FROM SmartMeter_Entries WHERE meterID = ? LIMIT ?")
	Result<SmartMeterRawEntries> getAllSmartMetersData(Integer id, int limit);

	@Query("SELECT * FROM SmartMeter_Entries WHERE meterID = ?")
	Result<SmartMeterRawEntries> getAllSmartMetersData(Integer id);
	
	@Query(" DELETE FROM SmartMeter_Entries WHERE meterID = ?")
	Result<SmartMeterRawEntries> deleteTheMeterId(Integer id);
	
	@Query(" DELETE FROM SmartMeter_Entries WHERE meterID = ? AND timeStamp <= ?")
	Result<SmartMeterRawEntries> deleteTheMeterId(Integer id, String todate);
	
	@Query(" DELETE FROM SmartMeter_Entries WHERE meterID = ? AND timeStamp >= ? AND timeStamp <= ?")
	Result<SmartMeterRawEntries> deleteTheMeterId(Integer id, String fromdate, String todate);

}
