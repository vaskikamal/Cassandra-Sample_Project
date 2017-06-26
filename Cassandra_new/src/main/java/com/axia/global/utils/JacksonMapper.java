package com.axia.global.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 *
 */
public class JacksonMapper {
	private ObjectMapper jsonMapper = new ObjectMapper();
	private TypeReference<HashSet<String>> typeRefSet = new TypeReference<HashSet<String>>() {
	};
	private TypeReference<HashMap<String,String>> typeRefMap = new TypeReference<HashMap<String,String>>() {
	};

	public Set<String> readJsonReadingsAsSet(String data) {
		try {
			return jsonMapper.readValue(data, typeRefSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage() + " - JSON Readings cannot be turned into map - " + data);
		}
	}

	public String getJsonReadings(Set<String> setVals) {
		try {
			return jsonMapper.writeValueAsString(setVals);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage() + " - Readings cannot be turned into JSON - " + setVals);
		}
	}
}
