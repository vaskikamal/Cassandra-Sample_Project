package com.axia.global.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public class DateUtils {
	Logger log = Logger.getLogger(DateUtils.class);

	public boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static Long convertToMillis(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

		String inputString = "2013-04-03 07:01:00";

		Date date1 = new Date();
		try {
			date1 = sdf.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1.getTime();
	}

	public static Date getTimeStampFromString(String s) {
			try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date parsedDate = (Date) dateFormat.parse(s);
			return parsedDate;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date getDateFromString(String s) {
		try {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date parsedDate = (Date) dateFormat.parse(s);
		return parsedDate;
	} catch (Exception e) {
		return null;
	}
}
}
