package com.Mercury.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Mercury.utility.UtilityMethods;

public class BookAFlight {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement editCreditCardNumber;

	@FindBy(xpath="//input[@name='buyFlights']")
	WebElement btnSecurePurchase;
	
    public BookAFlight (WebDriver driver){
    	this.driver = driver;
        //This initElements method will create all WebElements
    	PageFactory.initElements(driver, this);
    }
    
    public void fillPassengersDetails (int intNoOfPassengers) {
    	
    	for (int i = 0; i < intNoOfPassengers; i++) {
    		
    		String strCurrPassengerFirstNameXpath = "//input[@name='passFirst" + i + "']"; 
    		String strCurrPassengerLastNameXpath = "//input[@name='passLast" + i + "']"; 
    		String strCurrPassengerMealPrefName = "pass."+ i + ".meal"; 
    		
    		this.driver.findElement(By.xpath(strCurrPassengerFirstNameXpath)).sendKeys(UtilityMethods.generateRandomFirstName());
    		this.driver.findElement(By.xpath(strCurrPassengerLastNameXpath)).sendKeys(UtilityMethods.generateRandomLastName());
    		
    		Select mealPref = new Select(this.driver.findElement(By.name(strCurrPassengerMealPrefName)));
    		mealPref.selectByIndex(new Random().nextInt(9));
    	}
    	
    }
    
    public void fillCreditCardDetails (String strCardNumber) {
        this.editCreditCardNumber.sendKeys(strCardNumber);
    }
      
	public void clickSecurePurchaseButton () {
  		this.btnSecurePurchase.click();
  	}

}
