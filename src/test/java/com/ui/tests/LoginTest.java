package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.ui.constants.Env.*;

import utility.LoggerUtility;

import static utility.PropertiesUtility.*;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends BaseTest {
	
	private Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@Test(description = "Verify the login scenario")
	public void loginTest() {
		logger.info("Verifying the home page banner");
		String bannerContent =loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).getBannerContent();
		Assert.assertEquals(bannerContent, "FrieslandCampina, speciaal voor ondernemers in de horeca");
	}
	

}
