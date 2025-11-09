package com.ui.tests;

import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.testng.annotations.Test;

import com.ui.constants.Env;
import com.ui.pages.CartPage;
import com.ui.pages.CheckoutPage;
import com.ui.pages.ProductsPage;

import utility.PropertiesUtility;

public class ProductTest extends BaseTest {

	@Test
	public void productTest() {
		ProductsPage productPage=loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).clickOnProductPage();
		CartPage cartPage=productPage.addToCart();
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectWholerSaler();
	}
}
