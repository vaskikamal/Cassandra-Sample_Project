package com.axia.global.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axia.global.dao.ICustomerDetailsDAO;
import com.axia.global.dao.cassandra.impl.CustomerDetailsCassandraDAOImpl_New;
import com.axia.global.dao.model.cassandra.CustomerDetails;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class CustomerDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);
	
	ICustomerDetailsDAO customerDAO =null;
	
	public CustomerDetailsController(){
		customerDAO = new CustomerDetailsCassandraDAOImpl_New();
	}

	@RequestMapping(value = AxiaGlobalRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody CustomerDetails getEmployee(@PathVariable("id") String custId) {
		logger.info("Start getCustomerDetails. ID="+custId);
		return customerDAO.getCustomerDetails(custId);
	}
		
	@RequestMapping(value = AxiaGlobalRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody CustomerDetails createEmployee(@RequestBody CustomerDetails custDetails) {
		logger.info("Start createEmployee.");
		customerDAO.saveCustomerDetails(custDetails);
		return custDetails;
	}
	
	@RequestMapping(value = AxiaGlobalRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody CustomerDetails deleteCustomerDetails(@PathVariable("id") String custId) {
		logger.info("Start deleteEmployee.");
		customerDAO.deleteCustomerDetails(custId);
		return new CustomerDetails();
	}
}
