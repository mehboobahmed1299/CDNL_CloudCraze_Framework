package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class PromotionalMaterialsPage extends BrowserUtility {

	private static final By CHOCOMEL_MOK_LOCATOR = By
			.xpath("//p[normalize-space(text())='Chocomel Mok']/parent::div/following-sibling::div/descendant::button");
	private static final By PLUS_SVG_ICON=By.xpath("(//*[name()='svg'])[5]");
	private static final By CART_ICON=By.id("cartHeader");

	public PromotionalMaterialsPage(WebDriver wd) {
		super(wd);
	}
	
	public CartPage addToCart() {
		try {
			clickOn(CHOCOMEL_MOK_LOCATOR);
			System.out.println("🛒 Clicked on 'In winkelwagen' button");
		}catch(TimeoutException e) {
			clickOn(PLUS_SVG_ICON);
			System.out.println("➕ Clicked on plus SVG icon");
		}
		clickOn(CART_ICON);
		return new CartPage(getWd());
	}

}
