package com.axia.global.dao.cassandra.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.axia.global.dao.model.cassandra.CustomerBUWiseDetails;
import com.axia.global.dao.model.cassandra.CustomerDetails;

public class CustomerDetailsBUWiseCassandraDAOImplTest {
//
//	private CustomerBUWiseDetailsCassandraDAOImpl impl;
//
//	@Before
//	public void setup() {
//		impl = new CustomerBUWiseDetailsCassandraDAOImpl();
//	}
//
//	@Test
//	public void testSaveCustomerBUWiseDetails() {
//		CustomerBUWiseDetailsCassandraDAOImpl impl = new CustomerBUWiseDetailsCassandraDAOImpl();
//		CustomerBUWiseDetails details = new CustomerBUWiseDetails();
//
//		details.setBu_ID(12345);
//		details.setCustomerId(2222);
//		details.setBu_NAME("Manipal");
//		details.setTotalGasmeters(200);
//		details.setTotalNoEnergyMeters(1000);
//		details.setTotalsWatermeters(12);
//		Set<Integer> customerBUIds = new HashSet<Integer>();
//		customerBUIds.add(111);
//		customerBUIds.add(222);
//		customerBUIds.add(333);
//		customerBUIds.add(444);
//		details.setBu_LocationIds(customerBUIds);
//
//		impl.saveCustomerBUWiseDetails(details);
//
//	}
//
//	@Test
//	public void getCustomerDetails() {
//		CustomerBUWiseDetails 	details = impl.getCustomerBUWiseDetailsByCustId(12345, 2222);
//		"12345".equals(details.getBu_ID());
//		"Manipal".equals(details.getBu_NAME());
//		"4".equals(details.getBu_LocationIds().size());
//	}
//
//	
//	@Test
//	public void testGetLocationIds() {
//		// when both custid and buid is available.
//		Set<Integer> locIds = impl.getLocationIds(12345,2222);
//		"2".equals(locIds);
//	}
//
//	@Test
//	public void testUpdateLocationIds() {
//		// when both custid and buid is available.
//		CustomerBUWiseDetails details = impl.updateBULocationIds(12345,2222, 11213);
//		details.getBu_LocationIds().contains("11213");
//		"3".equals(details.getBu_LocationIds());
//		
//	}
//
//	@Test
//	public void deleteBUWiseDetails() {
//		impl.deleteBUWiseDetails(12345,2222);
//	}
}
