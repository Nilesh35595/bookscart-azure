package com.bookscart.azure.core;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataGenerator {

	
	public static String getFirstname() {
		String name = "User FN "+ RandomStringUtils.randomAlphabetic(3);
		return name;
	}
	
	public static String getLasttname() {
		String name = "User LN "+ RandomStringUtils.randomAlphabetic(3);
		return name;
	}
	
	public static String getUsertname() {
		String name = "Username"+ RandomStringUtils.randomAlphabetic(3);
		return name;
	}
	
}
