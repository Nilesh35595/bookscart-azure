package com.bookscart.azure.pages;

import org.openqa.selenium.By;

import com.bookscart.azure.core.BaseTestPage;
import com.bookscart.azure.core.TestDataGenerator;

public class RegistartionPage extends BaseTestPage {
	
	private By getFirstNameInput() {
		return By.xpath("//input[@placeholder='First name']");
	}
	
	private By getLastNameInput() {
		return By.xpath("//input[@placeholder='Last Name']");
	}
	
	private By getUsernameInput() {
		return By.xpath("//input[@placeholder='User name']");
	}
	
	private By getPasswordInput() {
		return By.xpath("//input[@placeholder='Password']");
	}
	
	private By getConfirmPasswordInput() {
		return By.xpath("//input[@placeholder='Confirm Password']");
	}
	
	private By getMaleGenderButton() {
		return By.xpath("//label[contains(text(),'Male')]//preceding-sibling::div");
	}
	
	private By getRegisterButton() {
		return By.xpath("//button//span[contains(text(),'Register')]");
	}
	
	public String submitRegistrationDetails() {
		LOGGER.info("Submitting registration details");
		setValue(getFirstNameInput(), TestDataGenerator.getFirstname());
		setValue(getLastNameInput(), TestDataGenerator.getLasttname());
		String userName = TestDataGenerator.getUsertname();
		setValue(getUsernameInput(), userName);
		setValue(getPasswordInput(), commonPassword);
		setValue(getConfirmPasswordInput(), commonPassword);
		click(getMaleGenderButton());
		return userName;
	}
	
	public RegistartionPage clickRegister() {
		LOGGER.info("Clicking registration button");
		shortWait();
		click(getRegisterButton());
		return this;
	}
	
	private By getLoginLink() {
		return By.xpath("//mat-toolbar-row//span[contains(text(),'Login')]");
	}
	
	public RegistartionPage clickLogin() {
		LOGGER.info("Clicking register page");
		click(getLoginLink());
		return this;
	}
}
