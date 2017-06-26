package com.axia.global.dao.model.cassandra;

import java.util.Set;

import com.axia.global.constants.CassandraKeySpaceConstants;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = CassandraKeySpaceConstants.keyspace, name = CassandraKeySpaceConstants.customerBUWiseTableName, readConsistency = "QUORUM", writeConsistency = "QUORUM", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class CustomerBUWiseDetails {
	@PartitionKey
	private Integer bu_ID;
	@ClusteringColumn
	private Integer customerId;
	private String bu_NAME;
	private Integer totalNoEnergyMeters;
	private Integer totalGasmeters;
	private Integer totalsWatermeters;
	private Set<Integer> bu_LocationIds;

	/**
	 * @return the bu_ID
	 */
	public Integer getBu_ID() {
		return bu_ID;
	}

	/**
	 * @param bu_ID
	 *            the bu_ID to set
	 */
	public void setBu_ID(Integer bu_ID) {
		this.bu_ID = bu_ID;
	}

	/**
	 * @return the bu_NAME
	 */
	public String getBu_NAME() {
		return bu_NAME;
	}

	/**
	 * @param bu_NAME
	 *            the bu_NAME to set
	 */
	public void setBu_NAME(String bu_NAME) {
		this.bu_NAME = bu_NAME;
	}

	/**
	 * @return the bu_LocationIds
	 */
	public Set<Integer> getBu_LocationIds() {
		return bu_LocationIds;
	}

	/**
	 * @param bu_LocationIds
	 *            the bu_LocationIds to set
	 */
	public void setBu_LocationIds(Set<Integer> bu_LocationIds) {
		this.bu_LocationIds = bu_LocationIds;
	}

	/**
	 * @return the totalNoEnergyMeters
	 */
	public Integer getTotalNoEnergyMeters() {
		return totalNoEnergyMeters;
	}

	/**
	 * @param totalNoEnergyMeters
	 *            the totalNoEnergyMeters to set
	 */
	public void setTotalNoEnergyMeters(Integer totalNoEnergyMeters) {
		this.totalNoEnergyMeters = totalNoEnergyMeters;
	}

	/**
	 * @return the totalGasmeters
	 */
	public Integer getTotalGasmeters() {
		return totalGasmeters;
	}

	/**
	 * @param totalGasmeters
	 *            the totalGasmeters to set
	 */
	public void setTotalGasmeters(Integer totalGasmeters) {
		this.totalGasmeters = totalGasmeters;
	}

	/**
	 * @return the totalsWatermeters
	 */
	public Integer getTotalsWatermeters() {
		return totalsWatermeters;
	}

	/**
	 * @param totalsWatermeters
	 *            the totalsWatermeters to set
	 */
	public void setTotalsWatermeters(Integer totalsWatermeters) {
		this.totalsWatermeters = totalsWatermeters;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
