package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class ProductsPage extends BrowserUtility {

	private static final By CLICKONCARTLOCATOR=By.xpath("//p[contains(text(),'Chocomel Hot Pouch')]/../..//button");
	private static final By CART_ICON=By.id("cartHeader");
	
	public ProductsPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}
	

	public CartPage addToCart() {
		clickOn(CLICKONCARTLOCATOR);
		clickOn(CART_ICON);
		return new CartPage(getWd());
	}
	public void test() {
		
	}

}
