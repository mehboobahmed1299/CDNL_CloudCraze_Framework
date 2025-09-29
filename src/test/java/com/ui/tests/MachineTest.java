package com.ui.tests;

import static com.ui.constants.Env.PREPROD;
import static utility.PropertiesUtility.readProperty;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.MachinePage;

public class MachineTest extends BaseTest {
	
	private MachinePage machinePage;
	
	@Test(description = "Verify the machine order requests")
	public void machineTest() {
		machinePage=loginPage.doLoginWith(readProperty("Username",PREPROD), readProperty("Password", PREPROD)).clickOnMachinePage();
		String confrimationMsg=machinePage.submitMachineEnquiryForm();
		Assert.assertEquals(confrimationMsg, "Request confirmed");
		
	}
}
