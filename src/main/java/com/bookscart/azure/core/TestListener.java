package com.bookscart.azure.core;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener, ISuiteListener {

	Config config = new Config();
	public static Logger LOGGER = LogManager.getLogger(TestListener.class);
    public static WebDriver driver;
	
	public void onStart(ISuite suite) {
		LOGGER.info("Starting test execution of "+ suite.getName()+" test");
	}
    
    public void onTestStart(ITestResult result) {
    	driver = DriverManager.createInstance(config.getBrowser());
    	DriverManager.launchBrowser(driver, config.getUrl());
    }
    

    public void onTestSuccess(ITestResult result) {
    	LOGGER.info("Method "+ result.getMethod().getMethodName()+" is successful");
    	DriverManager.quitDriver();
    }
    
    public void onTestFailure(ITestResult result) {
    	LOGGER.info("Method "+ result.getMethod().getMethodName()+" is failed");
    	BaseTestPage.captureScreenshot(result);
    	DriverManager.quitDriver();
    }
    
    public void onTestSkipped(ITestResult result) {
    	LOGGER.info("Method "+ result.getMethod().getMethodName()+" is skipped");
    	DriverManager.quitDriver();
    }
	
	public void onFinish(ISuite suite) {
		LOGGER.info("Finishing test execution of "+ suite.getName()+" test");
	}
	
	
}
