package com.axia.global.dao;

import java.util.Set;

import com.axia.global.dao.model.cassandra.CustomerBUWiseDetails;


public interface ICustomerBUWiseDetailsDAO {
	
	public void saveCustomerBUWiseDetails(CustomerBUWiseDetails details);

	public CustomerBUWiseDetails getCustomerBUWiseDetailsByCustId(Integer buId, Integer custId);

	public void deleteBUWiseDetails(Integer buId, Integer custId);

	public void updateBUWiseDetails(CustomerBUWiseDetails details);

	public CustomerBUWiseDetails updateBULocationIds(Integer buId, Integer custId, Integer locId);

	public Set<Integer> getLocationIds(Integer buId, Integer custId);
}
