package com.ui.tests;

import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.CartPage;
import com.ui.pages.PromotionalMaterialsPage;

public class PromotionalTest extends BaseTest {
	
	@Test(description = "Verify the promotional materials flow")
	public void promotionalTest() {
		PromotionalMaterialsPage promotionalMaterialsPage=loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).clickOnPromotionalMaterialsPage();
		CartPage cartPage=promotionalMaterialsPage.addToCart();
		Assert.assertEquals(cartPage.getPosItemName(), "Chocomel Mok");
		cartPage.goToCheckout();
	}
}
