package com.ui.tests;

import static com.ui.constants.Browser.CHROME;
import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ui.pages.LoginPage;

import utility.BrowserUtility;
import utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class BaseTest {
	protected LoginPage loginPage;
	private Logger logger=LoggerUtility.getLogger(this.getClass());
	@BeforeMethod(description = "Load the browser and open the website")
	public void setUp() {
		logger.info("Loading the browser");
		loginPage=new LoginPage(CHROME);
		logger.info("Opening the webshop");
		loginPage.goToWebsite(readProperty("URL",PREPROD));
		logger.info("Maximizing the browser");
		loginPage.maximizeWindow();
	}
	
	public BrowserUtility getInstance() {
		return loginPage;
	}
	
	@AfterMethod
    public void teardown() {
        if (loginPage != null) {
        	logger.info("Closing the browser");
            loginPage.getWd().quit(); // or driver.quit()
        }
    }
}
