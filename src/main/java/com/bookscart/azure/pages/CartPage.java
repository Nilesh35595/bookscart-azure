package com.bookscart.azure.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bookscart.azure.core.BaseTestPage;

public class CartPage extends BaseTestPage {

	
	private By getItemNameLink(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]");
	}
	
	public CartPage validateItemAddedSucessfully(String item) {
		LOGGER.info("Validate item added to the cart successfully");
		Assert.assertTrue(isElementVisible(getItemNameLink(item)), "Failed to add item to the cart");
		return this;
	}
	
	private By getItemSpecificAddQuantityIcon(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]/..//following-sibling::td//mat-icon[contains(text(),'add_circle')]/..");
	}
	
	private By getItemSpecificRemoveQuantityIcon(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]/..//following-sibling::td//mat-icon[contains(text(),'remove_circle')]/..");
	}
	
	private By getUpdatedQuantity(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]/..//following-sibling::td//mat-icon[contains(text(),'add_circle')]//ancestor::button/..//preceding-sibling::div[1]");
	}
	
	public CartPage updateQuanity(List<String> itemsList, int quantityToBeUpdated, boolean toBeAdded) {
		LOGGER.info("Updating "+quantityToBeUpdated+" quantity in the cart");
		scrollToPageTop();
		shortWait();
		int j=0;
	    for(String item : itemsList) { 
	    	
            j++;
            if(j>2) {
	        	  scrollToElement(getItemSpecificAddQuantityIcon(item));
	        }
            
	    	if(toBeAdded) {
		    	for(int i=1; i<=quantityToBeUpdated; i++) {
		    		shortWait();
			    	click(getItemSpecificAddQuantityIcon(item));
			    }
		    } else {
		    	for(int i=1; i<=quantityToBeUpdated; i++) {
		    		shortWait();
			    	click(getItemSpecificRemoveQuantityIcon(item));
			    }
		    }
	    	
	    }
	    return this;
	}
	
	public CartPage validateQuantityUpdate(List<String> itemsList, int quantityToBeUpdated, boolean toBeAdded) {
		LOGGER.info("Validating quantity updated successfully");
		scrollToPageTop();
		shortWait();
		int j=0;
		for(String item : itemsList) {
			
			j++;
			 if(j>2) {
	        	  scrollToElement(getItemSpecificAddQuantityIcon(item));
	         }
			 
			int actualUpdatedQuantity = Integer.parseInt(getText(getUpdatedQuantity(item)));
			if(toBeAdded) {
				if(!(actualUpdatedQuantity == quantityToBeUpdated+1)) {
					Assert.assertTrue(false, "Quantity in cart is not updated properly for the item "+ item );
				}
			} else {
				if(!(actualUpdatedQuantity == 1)) {
					Assert.assertTrue(false, "Quantity in cart is not updated properly for the item "+ item );
				}
			}
		}
		return this;
	}
	
	private By getTotalItemPrice(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]/..//following-sibling::td[contains(@class,'column-total')]");
	}
	
	private By getItemSpecificDeleteButton(String item) {
		return By.xpath("//a[contains(text(),'"+item+"')]/..//following-sibling::td//mat-icon[contains(text(),'delete')]/..");
	}
	
	public CartPage validateProductPriceUpdated(List<String> itemsList, List<String> itemsPriceList, int quantityToBeUpdated, boolean toBeAdded) {
		LOGGER.info("Validate final item price in the cart updated successfully");
		scrollToPageTop();
		shortWait();
		int j=0;
		for(int i=0; i<itemsPriceList.size(); i++) {
			
			j++;
			if(j>2) {
				scrollToElement(getItemSpecificAddQuantityIcon(itemsList.get(i)));
			}
			
			String totalPrice = getText(getTotalItemPrice(itemsList.get(i))).substring(1);
			if(totalPrice.contains(",")){
				totalPrice=totalPrice.replace(",", "");
			}
			double actualItemTotalPrice = Double.parseDouble(totalPrice);
			double pricePreItem = Double.parseDouble(itemsPriceList.get(i));
			
			if(toBeAdded) {
				double expectedTotalPrice =pricePreItem*(quantityToBeUpdated+1);
				Assert.assertTrue(actualItemTotalPrice == expectedTotalPrice, "Total item price is not updated properly for item "+itemsList.get(i));
			} else {
				double expectedTotalPrice = Double.parseDouble(itemsPriceList.get(i));
				Assert.assertTrue(actualItemTotalPrice == expectedTotalPrice, "Total item price is not updated properly for item "+itemsList.get(i));
			}
		}
		
		return this;
	}
	
	public CartPage validteItemAdditionToCart(List<String> itemsList, boolean isAdded) {
		LOGGER.info("Validating items added to the cart successfully");
		for(String item : itemsList) {
			if(isAdded) {
				if(!isElementVisible(getTotalItemPrice(item))) {
					Assert.assertTrue(false, "Failed to add "+item+" to the cart");
				}
			} else {
				if(isElementVisible(getTotalItemPrice(item))) {
					Assert.assertTrue(false, "Failed to remove "+item+" from the cart");
				}
			}
		}
		return this;
	}
	
	public CartPage removeItemFromCart(List<String> itemList) {
		LOGGER.info("Removing items from the cart");
		scrollToPageTop();
		shortWait();
		int j=0;
		for(String item : itemList) {
			j++;
			if(j>2) {
				scrollToElement(getItemSpecificAddQuantityIcon(item));
			}
			shortWait();
			click(getItemSpecificDeleteButton(item));
		}
		return this;
	}
	
}
