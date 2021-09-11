package com.Mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	
	WebDriver driver;

	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement btnContinue;
	
    public SelectFlight (WebDriver driver){
    	this.driver = driver;
        //This initElements method will create all WebElements
    	PageFactory.initElements(driver, this);
    }
    
	public void clickContinueButton () {
  		this.btnContinue.click();
  	}

}
