package com.Mercury.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Mercury.utility.BrowserFactory;
import com.Mercury.utility.ConfigDataProvider;
import com.Mercury.utility.ExcelDataProvider;
import com.Mercury.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver; 
	public ExcelDataProvider excel; 
	public ConfigDataProvider config; 
	public ExtentReports report; 
	public ExtentTest logger; 
	
	@BeforeSuite
	public void setUpSuite() {		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider(); 
		
		ExtentHtmlReporter extent = new  ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/Mercury"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.startApplication(driver, ConfigDataProvider.getBrowser(), ConfigDataProvider.getqaURL());
	}
	
//	@AfterMethod
//	public void tearDown() {
//		BrowserFactory.quitBrowser(driver);
//	}	
	
	@AfterMethod
	public void tearDownMethod (ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
//			try {
//				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.println("couldn't save the screenshot " + e.getMessage());
//			} 
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
//			try {
//				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.println("couldn't save the screenshot " + e.getMessage());
//			} 
		}
		//report.flush();
		
		BrowserFactory.quitBrowser(driver);
	}
	
}
