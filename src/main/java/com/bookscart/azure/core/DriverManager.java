package com.bookscart.azure.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	static WebDriver driver;
	
	public static WebDriver createInstance(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static void launchBrowser(WebDriver driver, String url) {
		setDriver(driver);
		driver.get(url);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	private static void setDriver(WebDriver createdInstance) {
		driver = createdInstance;
	}
	
	public static WebDriver getDriver() {
		driver = TestListener.driver;
		return driver;
	}
	
	public static void quitDriver() {
		getDriver().quit();
	}
}
