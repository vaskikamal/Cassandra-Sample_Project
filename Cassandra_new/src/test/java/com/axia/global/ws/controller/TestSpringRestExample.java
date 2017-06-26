package com.axia.global.ws.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.axia.global.dao.model.cassandra.CustomerDetails;
import com.axia.global.ws.controller.AxiaGlobalRestURIConstants;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";

	public static void main(String args[]) {
		testCreateCustomerDetails();
		System.out.println("*****");
		testGetCustomerDetails();
		System.out.println("*****");
	}

	private static void testCreateCustomerDetails() {
		RestTemplate restTemplate = new RestTemplate();
		CustomerDetails details = new CustomerDetails();

		Set<String> customerBUIds = new HashSet<String>();
		customerBUIds.add("7654321");
		customerBUIds.add("7564321");
		details.setCustomerBUIds(customerBUIds);
		details.setCustomerID("1212");

		Set<String> customerLocationIds = new HashSet<String>();
		customerLocationIds.add("212121");
		customerLocationIds.add("313131");
		details.setCustomerLocationIds(customerLocationIds);

		details.setCustomerMobNo("809518350");
		details.setCustomerName("Biks");
		details.setHeadOfficeAddress1("JPNagar");
		details.setCity("Balasore");
		CustomerDetails response = restTemplate.postForObject(SERVER_URI + AxiaGlobalRestURIConstants.CREATE_EMP,
				details, CustomerDetails.class);
	}

	public static void testGetCustomerDetails() {
		RestTemplate restTemplate = new RestTemplate();
		CustomerDetails custDetails = restTemplate.postForObject(SERVER_URI + "/rest/emp/1212", null,
				CustomerDetails.class);

	}
}
