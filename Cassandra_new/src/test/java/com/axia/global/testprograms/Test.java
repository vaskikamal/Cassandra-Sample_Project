package com.axia.global.testprograms;

import java.text.ParseException;
import java.util.Date;

import com.axia.global.utils.DateUtils;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		 String inputString = "2013-04-03";
		 String inputString1 = "2013-04-04";

        Date d = DateUtils.getTimeStampFromString(inputString);
        Date d1 = DateUtils.getTimeStampFromString(inputString1);
        if(d.before(d1)){
        	System.out.println("hello");
        }

	}

}
