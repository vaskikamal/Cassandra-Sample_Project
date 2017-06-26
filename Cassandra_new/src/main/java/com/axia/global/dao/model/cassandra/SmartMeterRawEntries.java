package com.axia.global.dao.model.cassandra;

import java.io.Serializable;

import com.axia.global.constants.CassandraKeySpaceConstants;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = CassandraKeySpaceConstants.keyspace, name = CassandraKeySpaceConstants.smartMeterEntriesTableName, readConsistency = "QUORUM", writeConsistency = "QUORUM", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class SmartMeterRawEntries implements Serializable{
	@PartitionKey
	private Integer meterID;
	private String date;	
	private Long reading;
	@ClusteringColumn
	private String timeStamp;
	/**
	 * @return the meterID
	 */
	public Integer getMeterID() {
		return meterID;
	}
	/**
	 * @param meterID the meterID to set
	 */
	public void setMeterID(Integer meterID) {
		this.meterID = meterID;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	/**
	 * @return the reading
	 */
	public Long getReading() {
		return reading;
	}
	/**
	 * @param reading the reading to set
	 */
	public void setReading(Long reading) {
		this.reading = reading;
	}
	
}
