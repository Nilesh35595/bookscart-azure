package com.bookscart.azure.pages;

import org.openqa.selenium.By;

import com.bookscart.azure.core.BaseTestPage;

public class HomePage extends BaseTestPage {
	
	private By getLoginLink() {
		return By.xpath("//button//span[contains(text(),'Login')]");
	}

	public LoginPage clickLogin() {
		LOGGER.info("Clicking Lghin link");
		click(getLoginLink());
		return new LoginPage();
	}
	
	
}
