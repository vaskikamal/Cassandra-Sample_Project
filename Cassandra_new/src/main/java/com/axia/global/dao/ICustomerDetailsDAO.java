package com.axia.global.dao;

import java.util.List;

import com.axia.global.dao.model.cassandra.CustomerDetails;

public interface ICustomerDetailsDAO {

	void saveCustomerDetails(CustomerDetails custDetails);
	
	void saveListCustomerDetails(List<CustomerDetails> custDetails);
	
	CustomerDetails getCustomerDetails(String custId);
	
	//List<CustomerDetails> getAllCustomerDetails();
	
	void deleteCustomerDetails(String custId);
	
	void updateCustomerDetails(CustomerDetails details);
	
	void updateLocationIds(String custId, String locId);
	
	void updateBUIds(String custId, String buId);
	
	public void deleteLocationIds(String custId, String LocId);
	
	public void deleteBUIds(String custId, String buId);
	
}
