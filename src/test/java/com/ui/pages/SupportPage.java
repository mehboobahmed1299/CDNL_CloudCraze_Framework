package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class SupportPage extends BrowserUtility {
	
	private static final By SUPPORT_BUTTON_LOCATOR=By.xpath("//a[contains(.,'Maak ticket aan')]");
	private static final By SELECT_SUBJECT_LOCATOR=By.xpath("//div[.='Selecteer onderwerp']");
	private static final By SUBJECT_NAME_LOCATOR=By.xpath("//div[contains(text(),'Anders')]");
	private static final By TEXT_AREA_LOCATOR=By.xpath("//textarea[contains(@id,'description')]"); 
	private static final By SUBMIT_BUTTON_LOCATOR=By.xpath("//input[@value='Aanvraag maken']");
	private static final By TICKET_CREATED_LOCATOR=By.xpath("//div[@class='ticket']/h2");
	private static final By TICKET_NUMBER_LOCATOR=By.xpath("//a[@class='caseNumber']");
	
	public SupportPage(WebDriver wd) {
		super(wd);
	}
	
	public String supportCreation() {
		clickOn(SUPPORT_BUTTON_LOCATOR);
		clickOn(SELECT_SUBJECT_LOCATOR);
		clickOn(SUBJECT_NAME_LOCATOR);
		enterText(TEXT_AREA_LOCATOR, "hello");
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return getText(TICKET_CREATED_LOCATOR);
	}
	public String getTicketNumber() {
		return getText(TICKET_NUMBER_LOCATOR);
	}
}
