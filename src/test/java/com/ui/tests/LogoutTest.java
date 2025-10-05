package com.ui.tests;

import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
	
	@Test(description = "Verify the logout scenario")
	public void logout() {
		loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).logout();
		Assert.assertEquals(loginPage.loginHeader(), "Welkom in de FrieslandCampina Webshop");
	}
}
