package com.bookscart.azure.pages;

import org.openqa.selenium.By;

import com.bookscart.azure.core.BaseTestPage;

public class CommonElementsPage extends BaseTestPage {

	
	
	private By getShoppingCartIcon() {
		return By.xpath("//button[contains(@ng-reflect-router-link,'shopping-cart')]");
	}
	
	public CartPage clickShoppingCart() {
		LOGGER.info("Clicking Shopping icon");
		click(getShoppingCartIcon());
		return new CartPage();
	}
	
	
	
	
	
}
