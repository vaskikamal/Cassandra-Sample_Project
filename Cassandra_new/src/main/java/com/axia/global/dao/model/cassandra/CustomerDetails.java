package com.axia.global.dao.model.cassandra;

import java.util.Set;

import com.axia.global.constants.CassandraKeySpaceConstants;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * Customer Details.
 */
@Table(keyspace = CassandraKeySpaceConstants.keyspace, name = CassandraKeySpaceConstants.customerDetailsTableName, readConsistency = "QUORUM", writeConsistency = "QUORUM", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class CustomerDetails {
	@PartitionKey
	private String customerID;
	private String customerName;
	private String headOfficeAddress1;
	private String headOfficeAddress2;
	private String city;
	private String state;
	private String customerMobNo;
	private String customerLandlineNo;
	private String pinCode;
	private Integer longitude;
	private Integer latitude;
	private Long totalNoEnergyMeters;
	private Long totalGasmeters;
	private Long totalsWatermeters;
	private Long totalDefinedRoles;
	private Set<String> customerLocationIds;
	private Set<String> customerBUIds;
	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the headOfficeAddress1
	 */
	public String getHeadOfficeAddress1() {
		return headOfficeAddress1;
	}
	/**
	 * @param headOfficeAddress1 the headOfficeAddress1 to set
	 */
	public void setHeadOfficeAddress1(String headOfficeAddress1) {
		this.headOfficeAddress1 = headOfficeAddress1;
	}
	/**
	 * @return the headOfficeAddress2
	 */
	public String getHeadOfficeAddress2() {
		return headOfficeAddress2;
	}
	/**
	 * @param headOfficeAddress2 the headOfficeAddress2 to set
	 */
	public void setHeadOfficeAddress2(String headOfficeAddress2) {
		this.headOfficeAddress2 = headOfficeAddress2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the customerMobNo
	 */
	public String getCustomerMobNo() {
		return customerMobNo;
	}
	/**
	 * @param customerMobNo the customerMobNo to set
	 */
	public void setCustomerMobNo(String customerMobNo) {
		this.customerMobNo = customerMobNo;
	}
	/**
	 * @return the customerLandlineNo
	 */
	public String getCustomerLandlineNo() {
		return customerLandlineNo;
	}
	/**
	 * @param customerLandlineNo the customerLandlineNo to set
	 */
	public void setCustomerLandlineNo(String customerLandlineNo) {
		this.customerLandlineNo = customerLandlineNo;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the longitude
	 */
	public Integer getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public Integer getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the totalNoEnergyMeters
	 */
	public Long getTotalNoEnergyMeters() {
		return totalNoEnergyMeters;
	}
	/**
	 * @param totalNoEnergyMeters the totalNoEnergyMeters to set
	 */
	public void setTotalNoEnergyMeters(Long totalNoEnergyMeters) {
		this.totalNoEnergyMeters = totalNoEnergyMeters;
	}
	/**
	 * @return the totalGasmeters
	 */
	public Long getTotalGasmeters() {
		return totalGasmeters;
	}
	/**
	 * @param totalGasmeters the totalGasmeters to set
	 */
	public void setTotalGasmeters(Long totalGasmeters) {
		this.totalGasmeters = totalGasmeters;
	}
	/**
	 * @return the totalsWatermeters
	 */
	public Long getTotalsWatermeters() {
		return totalsWatermeters;
	}
	/**
	 * @param totalsWatermeters the totalsWatermeters to set
	 */
	public void setTotalsWatermeters(Long totalsWatermeters) {
		this.totalsWatermeters = totalsWatermeters;
	}
	/**
	 * @return the totalDefinedRoles
	 */
	public Long getTotalDefinedRoles() {
		return totalDefinedRoles;
	}
	/**
	 * @param totalDefinedRoles the totalDefinedRoles to set
	 */
	public void setTotalDefinedRoles(Long totalDefinedRoles) {
		this.totalDefinedRoles = totalDefinedRoles;
	}
	/**
	 * @return the customerLocationIds
	 */
	public Set<String> getCustomerLocationIds() {
		return customerLocationIds;
	}
	/**
	 * @param customerLocationIds the customerLocationIds to set
	 */
	public void setCustomerLocationIds(Set<String> customerLocationIds) {
		this.customerLocationIds = customerLocationIds;
	}
	/**
	 * @return the customerBUIds
	 */
	public Set<String> getCustomerBUIds() {
		return customerBUIds;
	}
	/**
	 * @param customerBUIds the customerBUIds to set
	 */
	public void setCustomerBUIds(Set<String> customerBUIds) {
		this.customerBUIds = customerBUIds;
	}


}
