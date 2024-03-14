package com.bookscart.azure.pages;

import org.openqa.selenium.By;
import com.bookscart.azure.core.BaseTestPage;

public class LoginPage extends BaseTestPage{

	private By getRegisterButton() {
		return By.xpath("//span[contains(text(),'Register')]");
	}
	
	public RegistartionPage clickRegister() {
		LOGGER.info("Clicking register button");
		click(getRegisterButton());
		return new RegistartionPage();
	}
	
	private By getUsernameInput() {
		return By.xpath("//input[@placeholder='Username']");
	}
	
	private By getPasswordInput() {
		return By.xpath("//input[@placeholder='Password']");
	}
	
	private By getLoginButton() {
		return By.xpath("//mat-card-actions//span[contains(text(),'Login')]");
	}

	public DashboardPage login(String userName, String password) {
		LOGGER.info("Logging in to the application");
		setValue(getUsernameInput(), userName);
		setValue(getPasswordInput(), password);
		click(getLoginButton());
		return new DashboardPage();
	}
	
}
