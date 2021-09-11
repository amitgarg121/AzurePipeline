package com.Mercury.testcases;
import org.testng.annotations.Test;

import com.Mercury.pages.BaseClass;
import com.Mercury.pages.LoginPage;


public class LoginMercuryTest extends BaseClass{

	
	@Test(priority = 1, enabled = false)
	public void loginApplication() {
		
		logger = report.createTest("Login into Mercury Flight Booking Application"); 
		
		logger.info("Launching the application..");
		
		LoginPage lp = new LoginPage(driver); 
		
		logger.info("The title of the Launched Application is: " + driver.getTitle());
		
		logger.info("Now Logging into the application using User Name: " + excel.getStringData("Login", 1, "LoginName"));
		
		lp.loginToMercuryFlight(excel.getStringData("Login", 1, "LoginName"), excel.getStringData("Login", 1, "Password"));
		
		logger.pass("Login Successful"); 
	}
	
	@Test(priority = 2, enabled = false)
	public void loginApplication1() {
		
		logger = report.createTest("Login into Mercury Flight Booking Application"); 
		
		logger.info("Launching the application..");
		
		LoginPage lp = new LoginPage(driver); 
		
		logger.info("The title of the Launched Application is: " + driver.getTitle());
		
		logger.info("Now Logging into the application using User Name: " + excel.getStringData("Login", 1, "LoginName"));
		
		lp.loginToMercuryFlight(excel.getStringData("Login", 1, "LoginName"), excel.getStringData("Login", 1, "Password"));
		
		logger.pass("Login Successful"); 

	}
	
	
}

