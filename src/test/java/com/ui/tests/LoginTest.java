package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.User;

import static com.ui.constants.Env.*;

import utility.LoggerUtility;

import static utility.PropertiesUtility.*;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends BaseTest {
	
	private Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@Test(description = "Verify the login scenario",dataProviderClass = com.ui.dataproviders.LoginDataProviders.class,dataProvider = "loginDataProviders")
	public void loginTest(User user) {
		logger.info("Verifying the home page banner");
		logger.info("User details: "+user.getEmailAddress()+" "+user.getPassword());
		String bannerContent =loginPage.doLoginWith(user.getEmailAddress(),user.getPassword()).getBannerContent();
		Assert.assertEquals(bannerContent, "FrieslandCampina, speciaal voor ondernemers in de horeca");
	}
	

}
