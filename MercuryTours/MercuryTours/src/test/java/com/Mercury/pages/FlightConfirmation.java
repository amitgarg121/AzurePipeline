package com.Mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmation {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(), 'itinerary has been booked!')]")
	WebElement strBookingConfirmation;

	@FindBy(xpath="//img[@src='/images/forms/Logout.gif']")
	WebElement btnLogOut;
	
    public FlightConfirmation (WebDriver driver){
    	this.driver = driver;
        //This initElements method will create all WebElements
    	PageFactory.initElements(driver, this);
    }
    
    public boolean isFlightBooked() {
		
    	try {
    		if (this.strBookingConfirmation.equals(null))
        		return false;
        	else
        		return true;   
    	}catch (Exception e) {
    		
    		e.printStackTrace();
    		return false;
    	}
    	 			
    }
    
    public void clickLogOutButton () {
  		this.btnLogOut.click();
  	}
    
    
}
