package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BrowserUtility;

public class HomePage extends BrowserUtility {
	
	private static final By BANNER_CONTENT_LOCATOR=By.xpath("//div[contains(@class,'top-banner')]/p");
	private static final By ACCOUNTS_DROPDOWN_LOCATOR=By.xpath("//a[normalize-space()='Accounts']");
	private static final By LOGOUT_LOCATOR=By.xpath("//a[normalize-space()='Logout']");
	private static final By SUPPORT_LINK_LOCATOR=By.xpath("//a[contains(text(),'Support')]");
	private static final By MACHINE_PAGE_LOCATOR=By.xpath("//h5[contains(text(),'Machine aanvragen')]");
	private static final By PROMOTIONALMATERIALS_LOCATOR=By.xpath("//h5[text()='Promotiematerialen']");
	private static final By PRODUCTS_LOCATOR=By.xpath("//h5[text()='Chocomel & Fristi Producten']");
	
	public HomePage(WebDriver wd) {
		super(wd);
	}
	
	public String getBannerContent() {
		return getText(BANNER_CONTENT_LOCATOR);
	}
	
	public LoginPage logout() {
		clickOn(ACCOUNTS_DROPDOWN_LOCATOR);
		clickOn(LOGOUT_LOCATOR);
		return new LoginPage(wd.get());
	}
	public SupportPage clickOnSupportLink() {
		clickOn(SUPPORT_LINK_LOCATOR);
		switchToNewWindow();
		return new SupportPage(wd.get());
	}
	public MachinePage clickOnMachinePage() {
		clickOn(MACHINE_PAGE_LOCATOR);
		return new MachinePage(wd.get());
	}
	public PromotionalMaterialsPage clickOnPromotionalMaterialsPage() {
		clickOn(PROMOTIONALMATERIALS_LOCATOR);
		return new PromotionalMaterialsPage(wd.get());
	}
	public ProductsPage clickOnProductPage() {
		clickOn(PRODUCTS_LOCATOR);
		return new ProductsPage(wd.get());
	}
}
