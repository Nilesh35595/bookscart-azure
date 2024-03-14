package com.bookscart.azure.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bookscart.azure.core.BaseTestPage;

public class DashboardPage extends BaseTestPage {

	private By getUsernameLink(String userName) {
		return By.xpath("//span[contains(text(),'"+userName+"')]");
	}
	
	public void validateLoginSuccessful(String userName) {
		LOGGER.info("Validate user logged in successfully");
		Assert.assertTrue(isElementVisible(getUsernameLink(userName)));
	}
	
	private By getSearchBox() {
		return By.xpath("//input[@placeholder='Search books or authors']");
	}
	
	private By getSearhedItem(String item) {
		return By.xpath("//span[contains(text(),'"+item+"')]");
	}
	
	private By getItemPrice(String item) {
		return By.xpath("//strong[contains(text(),'"+item+"')]//ancestor::div//following-sibling::p");
	}
	
	public DashboardPage serachAndAddItemToCart(String item) {
		LOGGER.info("Searching item");
		setValue(getSearchBox(), item);
		click(getSearhedItem(item));
		click(getItemSpecificAddToCartButton(item));
		return this;
	}
	
	
	private By getItemSpecificAddToCartButton(String item) {
		return By.xpath("//strong[contains(text(),'"+item+"')]//ancestor::div//following-sibling::app-addtocart//button");
	}
	
	private By getPriceFilter() {
		return By.xpath("//mat-card-title");
	}
	
	public List<String> serachAndAddItemToCart(List<String> itemList) {
		LOGGER.info("Searching item");
		waitUntileElementIsVisible(getPriceFilter());
		List<String> itemPrices = new ArrayList<String>();
        String price = "";
		for(String item : itemList) {
			shortWait();
			setValue(getSearchBox(), item);
			click(getSearhedItem(item));
			click(getItemSpecificAddToCartButton(item));
			price = getText(getItemPrice(item)).substring(1);
			itemPrices.add(price);
		}
		return itemPrices;
	}

   private By getCartIcon() {
	   return By.xpath("//button[contains(@ng-reflect-router-link,'shopping-cart')]");
   }
   
   public CartPage clickCartIcon() {
	   LOGGER.info("Clicking cart icon");
       click(getCartIcon());
       return new CartPage();
   }
	
}
