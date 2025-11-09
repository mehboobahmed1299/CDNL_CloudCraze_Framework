package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class CheckoutPage extends BrowserUtility {

	private static final By WHOLESALERLOCATOR =By.id("wholesalerDropdown");
	private static final By WHOLESALERLOCATORTEXTLOCATOR=By.id("txtWholesalerSearch");
	
	public CheckoutPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}
	
	public void selectWholerSaler() {
		clickOn(WHOLESALERLOCATOR);
		enterText(WHOLESALERLOCATORTEXTLOCATOR, "Sligro");
	}

}
