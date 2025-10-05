package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.constants.Browser;

import utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By USERNAME_LOCATOR=By.xpath("//input[contains(@id,'Username')]");
	private static final By  PASSWORD_LOCATOR=By.xpath("//input[contains(@id,'password')]");
	private static final By INLOGGEN_LOCATOR=By.xpath("//input[@value='Inloggen']");
	private static final By LOGIN_TEXT_LOCATOR=By.xpath("//form/descendant::h4");
	
	public LoginPage(Browser browserName) {
		super(browserName);
		// TODO Auto-generated constructor stub
	}
	public LoginPage(WebDriver wd) {
		super(wd);
	}
	
	public HomePage doLoginWith(String userName,String password) {
		enterText(USERNAME_LOCATOR, userName);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(INLOGGEN_LOCATOR);
		return new HomePage(wd.get());
	}
	
	public String loginHeader() {
		
		return getText(LOGIN_TEXT_LOCATOR);
	}
}