package com.axia.global.dao.cassandra.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.axia.global.config.CassandraConnection;
import com.axia.global.dao.ICustomerDetailsDAO;
import com.axia.global.dao.model.cassandra.CustomerDetails;
import com.datastax.driver.mapping.Mapper;

public class CustomerDetailsCassandraDAOImpl_New implements ICustomerDetailsDAO{

	Logger log = Logger.getLogger(CustomerBUWiseDetailsCassandraDAOImpl.class);
	CassandraConnection conn = new CassandraConnection("127.0.0.1", 9042);
	private Mapper<CustomerDetails> mapper;

	public CustomerDetailsCassandraDAOImpl_New() {
		mapper = conn.getManager().mapper(CustomerDetails.class);
	}

	/**
	 * saves the data to the table.
	 * 
	 * @param details
	 */
	public void saveCustomerDetails(CustomerDetails details) {
		if (details != null) {
			mapper.save(details);
		} else {
			log.info("saveCustomerBUWiseDetails : Null CustomerBUWiseDetails received. Hence, ignoring");
		}
	}

	public CustomerDetails getCustomerDetails(String custId) {
		CustomerDetails details = mapper.get(custId);
		return details == null ? null : details;
	}

	public void deleteCustomerDetails(String custId) {
		mapper.delete(custId);
	}

	public void updateCustomerDetails(CustomerDetails details) {
		saveCustomerDetails(details);
	}

	public void saveListCustomerDetails(List<CustomerDetails> custDetails) {
		if (custDetails != null && !custDetails.isEmpty()) {
			for (CustomerDetails e : custDetails) {
				saveCustomerDetails(e);
			}
		}
	}

	public void updateLocationIds(String custId, String LocId) {

		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerLocationIds().add(LocId);
		saveCustomerDetails(details);
	}
	
	public void updateBUIds(String custId, String BuId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerBUIds().add(BuId);
		saveCustomerDetails(details);
	}
	
	public void deleteLocationIds(String custId, String LocId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerLocationIds().remove(LocId);
		saveCustomerDetails(details);
	}

	public void deleteBUIds(String custId, String buId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerBUIds().add(buId);
		saveCustomerDetails(details);
	}
}
