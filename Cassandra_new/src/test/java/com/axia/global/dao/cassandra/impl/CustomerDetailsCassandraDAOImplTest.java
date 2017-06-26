package com.axia.global.dao.cassandra.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.axia.global.dao.model.cassandra.CustomerDetails;

public class CustomerDetailsCassandraDAOImplTest 
{
//
//	private CustomerDetailsCassandraDAOImpl impl;
//
//	@Before
//	public void setup() {
//		impl = new CustomerDetailsCassandraDAOImpl("127.0.0.1", 9042);
//	}
//
//	@Test
//	public void testSaveCustomerDetails() {
//		CustomerDetails details = new CustomerDetails();
//
//		Set<String> customerBUIds = new HashSet<String>();
//		customerBUIds.add("111");
//		customerBUIds.add("222");
//		details.setCustomerBUIds(customerBUIds);
//		details.setCustomerID("1234567");
//
//		Set<String> customerLocationIds = new HashSet<String>();
//		customerLocationIds.add("11111");
//		customerLocationIds.add("22222");
//		details.setCustomerLocationIds(customerLocationIds);
//
//		details.setCustomerMobNo("9886742532");
//		details.setCustomerName("Vaski");
//		details.setHeadOfficeAddress1("GInserv");
//
//		impl.saveCustomerDetails(details);
//
//	}
//
//	@Test
//	public void getCustomerDetails() {
//		CustomerDetails details = impl.getCustomerDetails("1234567");
//		"123456".equals(details.getCustomerID());
//		"Vaski".equals(details.getCustomerName());
//		"GInserv".equals(details.getHeadOfficeAddress1());
//		"2".equals(details.getCustomerBUIds().size());
//		"3".equals(details.getCustomerLocationIds().size());
//	}
//
//	@Test
//	public void deleteCustomerDetails() {
//		impl.deleteCustomerDetails("123456");
//	}
//
//	@Test
//	public void updateCustomerDetails() {
//		CustomerDetails details = new CustomerDetails();
//
//		Set<String> customerBUIds = new HashSet<String>();
//		customerBUIds.add("111");
//		customerBUIds.add("222");
//		customerBUIds.add("333");
//		customerBUIds.add("444");
//		details.setCustomerBUIds(customerBUIds);
//		details.setCustomerID("123456");
//
//		Set<String> customerLocationIds = new HashSet<String>();
//		customerLocationIds.add("11111");
//		customerLocationIds.add("22222");
//		customerLocationIds.add("33333");
//		customerLocationIds.add("44444");
//		details.setCustomerLocationIds(customerLocationIds);
//
//		details.setCustomerMobNo("111111111");
//		details.setCustomerName("Sandeep");
//		details.setHeadOfficeAddress1("DiamondCity");
//		
//		impl.updateCustomerDetails(details);
//	}
//	
//	@Test
//	public void updateLocIds() {
//		impl.updateLocationIds("123456", "66666");
//	}
//	
//	@Test
//	public void updateBUIds() {
//		impl.updateBUIds("123456", "666");
//	}
}
