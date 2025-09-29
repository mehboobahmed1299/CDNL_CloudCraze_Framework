package com.ui.tests;

import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ui.pages.SupportPage;

public class SupportTest extends BaseTest {

private SupportPage supportPage;
	
	
	@Test(description = "Verify the support creation")
	public void supportCreation() {
		supportPage =loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).clickOnSupportLink();
		String ticketCreatedText=supportPage.supportCreation();
		Assert.assertEquals(ticketCreatedText, "Ticket Aangemaakt");
		String ticketNumber=supportPage.getTicketNumber();
		System.out.println("Ticket Number is: "+ticketNumber);
	}
}
