package com.axia.global.ws.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.axia.global.ws.controller.AxiaGlobalRestURIConstants;

public class TestSpringRestExampleHttp {
public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	
	public static void main(String args[]){
		
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+AxiaGlobalRestURIConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

}
