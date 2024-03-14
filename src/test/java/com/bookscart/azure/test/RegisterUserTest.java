package com.bookscart.azure.test;

import org.testng.annotations.Test;

import com.bookscart.azure.core.BaseTestPage;
import com.bookscart.azure.pages.DashboardPage;
import com.bookscart.azure.pages.HomePage;
import com.bookscart.azure.pages.LoginPage;
import com.bookscart.azure.pages.RegistartionPage;

public class RegisterUserTest extends BaseTestPage{

	
	RegistartionPage registrationPage;
	DashboardPage dashboardPage;
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	
	
	@Test
	public void registerUser() {
		
		LOGGER.info("Navigate to registration page");
		registrationPage = homePage.clickLogin().clickRegister();
		
		LOGGER.info("Submit users registration details");
		String userName = registrationPage.submitRegistrationDetails();
		
		LOGGER.info("Click Register");
		registrationPage.clickRegister().clickLogin();
		
		LOGGER.info("Login with newly registerd user credentials");
		dashboardPage = loginPage.login(userName, commonPassword);
		
		LOGGER.info("Validate registration successful");
		dashboardPage.validateLoginSuccessful(userName);
	}
	
}
