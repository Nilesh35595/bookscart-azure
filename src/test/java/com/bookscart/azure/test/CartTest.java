package com.bookscart.azure.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import com.bookscart.azure.core.BaseTestPage;
import com.bookscart.azure.core.TestDataProvider;
import com.bookscart.azure.pages.CartPage;
import com.bookscart.azure.pages.DashboardPage;
import com.bookscart.azure.pages.HomePage;
import com.bookscart.azure.pages.LoginPage;

public class CartTest extends BaseTestPage {

	CartPage cartPage;
	DashboardPage dashboardPage = new DashboardPage();;
	List<String> itemsList;
	List<String> itemPriceList;
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	TestDataProvider dataProvider = new TestDataProvider();
	int itemQuantity = 2;

	
	@Test(description="Add and remove items from the cart, validate corresponding item details update in the cart")
	public void validateCartDetailsUpdate() {
		
        itemsList = dataProvider.itemsList();
		
		LOGGER.info(" Login with user credentials");
		homePage.clickLogin().login(username, commonPassword);
		
		LOGGER.info("Search and add item to the cart");
		itemPriceList = dashboardPage.serachAndAddItemToCart(itemsList);
		cartPage = dashboardPage.clickCartIcon();
		
		LOGGER.info("Add multiple quantities of each item");
		cartPage.updateQuanity(itemsList, itemQuantity, true);
		
		LOGGER.info("Search and add item to the cart");
		cartPage.validateQuantityUpdate(itemsList, itemQuantity, true);
		
		LOGGER.info("Search and add item to the cart");
		cartPage.validateProductPriceUpdated(itemsList, itemPriceList, itemQuantity, true);
		
		LOGGER.info("Remove multiple quantities of each item");
		cartPage.updateQuanity(itemsList, itemQuantity, false);
		
		LOGGER.info("Search and add item to the cart");
		cartPage.validateQuantityUpdate(itemsList, itemQuantity, false);
		
		LOGGER.info("Search and add item to the cart");
		cartPage.validateProductPriceUpdated(itemsList, itemPriceList, itemQuantity, false);
		
		LOGGER.info("Remove items from the cart");
		cartPage.removeItemFromCart(itemsList);
		
	}
	
}
