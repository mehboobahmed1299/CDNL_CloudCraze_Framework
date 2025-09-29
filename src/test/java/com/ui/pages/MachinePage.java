package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class MachinePage extends BrowserUtility {
	
	private static final By REQUEST_BUTTON_LOCATOR=By.id("requestBtn");
	private static final By UPLOAD_FILE_LOCATOR=By.id("fileUpload");
	private static final By SUBMIT_BUTTON_LOCATOR=By.cssSelector("#submitEnquiryBtn");
	private static final By REQUEST_CONFIRMATION_LOCATOR=By.xpath("//div[@class='order-confirm-msg']/h2");
	
	public MachinePage(WebDriver wd) {
		super(wd);
	}
	
	public String submitMachineEnquiryForm() {
		scrollToElement(REQUEST_BUTTON_LOCATOR);
		clickOn(REQUEST_BUTTON_LOCATOR);
		uploadFile(UPLOAD_FILE_LOCATOR, "C:\\Users\\USER\\Downloads\\Chocomel Hot Koop 2025 1 (2).pdf");
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return getText(REQUEST_CONFIRMATION_LOCATOR);
	}
	
}
