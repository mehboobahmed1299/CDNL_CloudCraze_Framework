package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class CartPage extends BrowserUtility {

	private static final By POSITEMNAME=By.xpath("//div[contains(@class,'prodDetails')]//a");
	private static final By GO_TO_CHECKOUT=By.xpath("//button[contains(text(),'Ga naar afrekenen')]");
	
	public CartPage(WebDriver wd) {
		super(wd);
	}
	
	public String getPosItemName() {
		return getText(POSITEMNAME);
	}
	
	public void goToCheckout() {
		clickOn(GO_TO_CHECKOUT);
	}

}
