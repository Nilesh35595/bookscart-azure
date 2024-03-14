package com.bookscart.azure.core;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.google.common.io.Files;

@Listeners(TestListener.class)
public class BaseTestPage {

	
	protected static final Logger LOGGER = LogManager.getLogger(BaseTestPage.class.getName());
	
	Config config = new Config();
	public String username = config.getUsername();
	public String password = config.getPassword();
	public String commonPassword = config.getPassword();
	

	public void waitUntilElementIsClickble(By locator) {
		Wait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitUntileElementIsVisible(By locator) {
		Wait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	public boolean isElementVisible(By locator) {
		waitUntileElementIsVisible(locator);
		boolean flag = getDriver().findElement(locator).isDisplayed();
	    return flag;
	}
	
	public void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click(By locator) {
		getDriver().findElement(locator).click();
	}
	
	public String getText(By locator) {
		return getDriver().findElement(locator).getText();
	}
	
	public void setValue(By locator, String value) {
		getDriver().findElement(locator).clear();
		getDriver().findElement(locator).sendKeys(value);
	}
	
	public void refreshPage() {
		getDriver().navigate().refresh();
	}
	
	public void scrollToElement(By locator) {
		WebElement element = getDriver().findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToPageTop() {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollTo(0, 0);");
	}
	
	public static void captureScreenshot(ITestResult result) {
		TakesScreenshot ss = (TakesScreenshot) DriverManager.getDriver();
		File source = ss.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshot\\"+result.getMethod().getMethodName()+"_"+System.currentTimeMillis()+".png");
		try {
			Files.copy(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
