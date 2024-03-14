package com.bookscart.azure.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	Properties properties;
	
	

	Config() {
		
		File file = new File("./testConfig.Properties");
		
		try {	
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getUrl() {
	    return properties.getProperty("url");
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
    public String getUsername() {
    	return properties.getProperty("username");
    }
    
    public String getPassword() {
    	return properties.getProperty("password");
    }
	
	public String getItem1() {
		return properties.getProperty("item1");
	}
	
	public String getItem2() {
		return properties.getProperty("item2");
	}
	
	public String getItem3() {
		return properties.getProperty("item3");
	}
	
	public String getItem4() {
		return properties.getProperty("item4");
	}
	
	public String getItem5() {
		return properties.getProperty("item5");
	}
	
	
}
