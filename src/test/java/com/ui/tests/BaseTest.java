package com.ui.tests;

import static com.ui.constants.Browser.CHROME;
import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.constants.Browser;
import com.ui.pages.LoginPage;

import utility.BrowserUtility;
import utility.LambdaTestUtility;
import utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class BaseTest {
	protected LoginPage loginPage;
	private Logger logger=LoggerUtility.getLogger(this.getClass());
	private boolean isLambda;
	
	@Parameters({"browser","isLambda","isHeadless"})
	@BeforeMethod(description = "Load the browser and open the website")
	public void setUp(@Optional("chrome")String browserName,
			          @Optional("false")boolean isLambda,
			          @Optional("false")boolean isHeadless,ITestResult result){
		WebDriver lambdaDriver;
		this.isLambda=isLambda;
		if(isLambda) {
			lambdaDriver=LambdaTestUtility.initializeLambdaTest(browserName,result.getMethod().getMethodName());
			loginPage=new LoginPage(lambdaDriver);
			System.out.println("URL loaded from properties = " + readProperty("URL", PREPROD));
			loginPage.goToWebsite(readProperty("URL",PREPROD));
			loginPage.maximizeWindow();
		}
		else {
		logger.info("Loading the browser");
		loginPage=new LoginPage(Browser.valueOf(browserName.toUpperCase()),isHeadless);
		logger.info("Opening the webshop");
		loginPage.goToWebsite(readProperty("URL",PREPROD));
		loginPage.deleteCookies();
		logger.info("Maximizing the browser");
		loginPage.maximizeWindow();
		}
	}
	
	public BrowserUtility getInstance() {
		return loginPage;
	}
	
	/*@AfterMethod
    public void teardown() {
        if (loginPage != null) {
        	logger.info("Closing the browser");
            loginPage.getWd().quit(); // or driver.quit()
        }
    }*/
}
