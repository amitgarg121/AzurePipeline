package com.Mercury.testcases;

import org.testng.annotations.Test;

import com.Mercury.pages.*;
import com.Mercury.utility.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.Mercury.pages.BaseClass; 

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;

public class MercuryFlightTest extends BaseClass  {
	
	@Test(dataProvider = "testdata")
	public void fnBookFlightTest(String strTCName, String username, String password, String tripType, String noOfPassengers, String strFrom, 
							String onMonth,	String onDay, String strTo, String strReturnMonth, String strReturnDay, 
							String strClass, String strAirlines) throws IOException {

		
		logger = report.createTest(strTCName);
		
		LoginPage lp = new LoginPage(driver); 
		
		lp.loginToMercuryFlight(username, password);
		
		FlightFinder flightfinderPage = new FlightFinder(driver); 
		
		if (flightfinderPage.checkLoginTitle())
			logger.pass("Login Passed with user name: " + username);
		else
			logger.fail("Login Failed with user name: " + username);
		
		flightfinderPage.setTripType(tripType);
		flightfinderPage.selectPassengers(noOfPassengers);
		flightfinderPage.selectDepartingFrom(strFrom);
		flightfinderPage.selectOnMonth(onMonth);
		flightfinderPage.selectOnDay(onDay);
		flightfinderPage.selectArrvingIn(strTo);
		flightfinderPage.selectReturnMonth(strReturnMonth);
		flightfinderPage.selectReturnDay(strReturnDay);
		flightfinderPage.setServiceClass(strClass);
		flightfinderPage.selectAirline(strAirlines);
		
		logger.info("Filled the Data on Flight Finder Page", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		
		flightfinderPage.clickContinueButton();
			 
		SelectFlight selectFlightPage = new SelectFlight(driver); 
		logger.info("Selectd the flight", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		
		selectFlightPage.clickContinueButton();
					
		BookAFlight bookAFlight = new BookAFlight(driver); 
		bookAFlight.fillPassengersDetails (Integer.parseInt(noOfPassengers));
		bookAFlight.fillCreditCardDetails("2345252876568343434");
		
		logger.info("Filled the Booking Details on Flight Booking Page. Now Clicking on Secure Purchase Button.", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		bookAFlight.clickSecurePurchaseButton();
		
		FlightConfirmation flightConfirmation = new FlightConfirmation(driver); 
		
		if (flightConfirmation.isFlightBooked()) {
			logger.pass("Flight booked successfully.", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			Assert.assertTrue (true);
		}			
		else {
			logger.fail("Flight couldn't be booked", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			Assert.assertTrue (false);
		}
		flightConfirmation.clickLogOutButton();
	}
	
	
	 @DataProvider(name="testdata")
	  public Object[][] fnTestData() {
		  
		  ReadExcelFile config = new ReadExcelFile(System.getProperty("user.dir") + "/TestData/" + "FlightBookingData.xlsx"); 
		  
		  int row = config.getRowCount ("Flight"); 
		  int col = config.getColCount ("Flight"); 
		  
		  Object[][] bookingData = new Object[row-1][col-1]; 
		  
		  for (int i = 0 ; i < row-1 ; i++)
		  {
		  				
			  if (config.getRowDataBasedOnColumnName ("Flight", i+1, "Flag").trim().toUpperCase().equals("Y")){
				  
				  bookingData[i][0] = config.getRowDataBasedOnColumnName ("Flight", i+1, "TestCaseName");
				  bookingData[i][1] = config.getRowDataBasedOnColumnName ("Flight", i+1, "UserName");
				  bookingData[i][2] = config.getRowDataBasedOnColumnName ("Flight", i+1, "Password");
				  bookingData[i][3] = config.getRowDataBasedOnColumnName ("Flight", i+1, "TripType");
				  bookingData[i][4] = config.getRowDataBasedOnColumnName ("Flight", i+1, "NoOfPassengers");
				  bookingData[i][5] = config.getRowDataBasedOnColumnName ("Flight", i+1, "Source");
				  bookingData[i][6] = config.getRowDataBasedOnColumnName ("Flight", i+1, "DepMonth");
				  bookingData[i][7] = config.getRowDataBasedOnColumnName ("Flight", i+1, "DepDay");
				  bookingData[i][8] = config.getRowDataBasedOnColumnName ("Flight", i+1, "Destination");
				  bookingData[i][9] = config.getRowDataBasedOnColumnName ("Flight", i+1, "ReturnMonth");
				  bookingData[i][10] = config.getRowDataBasedOnColumnName ("Flight", i+1, "ReturnDay");
				  bookingData[i][11] = config.getRowDataBasedOnColumnName ("Flight", i+1, "Class");
				  bookingData[i][12] = config.getRowDataBasedOnColumnName ("Flight", i+1, "Airlines");
				  
			  }
		  }
		  return bookingData; 
	  } 
	
}

