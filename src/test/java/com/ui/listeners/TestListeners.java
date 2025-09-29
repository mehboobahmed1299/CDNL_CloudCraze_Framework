package com.ui.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ui.tests.BaseTest;
import utility.BrowserUtility;
import utility.ExtentReportUtility;
import utility.LoggerUtility;


public class TestListeners implements ITestListener {
	
	
	private Logger logger=LoggerUtility.getLogger(this.getClass());
	public void onTestStart(ITestResult result) {
	    logger.info("Test started: "+ result.getName());
	    logger.info("Test started: "+ result.getMethod().getMethodName());
	    ExtentReportUtility.createTest("Test started: "+ result.getMethod().getMethodName());;
	  }
	public void onTestSuccess(ITestResult result) {
	    logger.info("Test passed: "+result.getName());
	    logger.info("Test passed: "+result.getMethod().getMethodName());
	    ExtentReportUtility.getTest().pass("Test passed: "+result.getMethod().getMethodName());
	  }
	public void onTestFailure(ITestResult result) {
	    logger.error("Test failed: "+result.getName());
	    logger.error("Test failed: "+result.getThrowable().getMessage());
	    ExtentReportUtility.getTest().fail("Test failed: "+result.getThrowable());
	    Object testClass=result.getInstance();
	    BrowserUtility browserUtility=((BaseTest)testClass).getInstance();
	    String screenshotPath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
	    ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	  }
	public void onTestSkipped(ITestResult result) {
		logger.warn("Test skipped: "+result.getName());
	    logger.warn("Test skipped: "+result.getMethod());
	    ExtentReportUtility.getTest().skip("Test skipped: "+result.getMethod().getMethodName());
	  }
	public void onStart(ITestContext context) {
		ExtentReportUtility.setUpSparkReporter("report");
	    logger.info("Test suite started: "+context.getName());
	  }
	public void onFinish(ITestContext context) {
	    logger.info("Test suite ended: "+ context.getName());
	    ExtentReportUtility.flushReport();
	  }
}
