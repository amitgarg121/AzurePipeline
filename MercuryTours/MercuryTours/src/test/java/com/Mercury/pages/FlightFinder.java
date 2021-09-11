package com.Mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;;

public class FlightFinder {
	
	WebDriver driver;

	@FindBy(xpath="//input[@name='tripType' and @value='roundtrip']")
	WebElement tripTypeRound;
	
	@FindBy(xpath="//input[@name='tripType' and @value='oneway']")
	WebElement tripTypeoneway;
	
	@FindBy(name="passCount")
    WebElement passCount;
	
    @FindBy(name="fromPort")
    WebElement fromPort;

    @FindBy(name="fromMonth")
    WebElement fromMonth;
    
    @FindBy(name="fromDay")
    WebElement fromDay;
    
    @FindBy(name="toPort")
    WebElement toPort;

    @FindBy(name="toMonth")
    WebElement toMonth;
    
    @FindBy(name="toDay")
    WebElement toDay;
    
    @FindBy(xpath="//input[@name='servClass' and @value='Coach']")
    WebElement servClassEconomy;
    
    @FindBy(xpath="//input[@name='servClass' and @value='Business']")
    WebElement servClassBusiness;
    
    @FindBy(xpath="//input[@name='servClass' and @value='First']")
    WebElement servClassFirst;
    
    @FindBy(name="airline")
    WebElement airline;
    
    @FindBy(name="findFlights")
    WebElement btnfindFlights;
    
    @FindBy(tagName="title")
    WebElement titleText;
        
    public FlightFinder (WebDriver driver){
    	this.driver = driver;
        //This initElements method will create all WebElements
    	PageFactory.initElements(driver, this);
    }
    
    public Boolean checkLoginTitle()
    {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	System.out.println(driver.getTitle());
       if (driver.getTitle().equals("Find a Flight: Mercury Tours:"))
       		return true; 
       else
    		return false;          
    }
    
    public void setTripType (String strTripType)
    {
    	if (strTripType.equals("Round Trip")){
    		this.tripTypeRound.click();
    	}else if (strTripType.equals("One Way")){
    		this.tripTypeoneway.click();
    	}
    }
    
    public void setServiceClass (String strServiceClass)
    {
    	if (strServiceClass.equals("Economy class")){
    		this.servClassEconomy.click();
    	}else if (strServiceClass.equals("Business class")){
    		this.servClassBusiness.click();
    	}else if (strServiceClass.equals("First class")){
    		this.servClassFirst.click();
    	}
    }
    	
	public void selectPassengers (String strPassengers)
    {
		Select dropPassengers = new Select(this.passCount); 
		dropPassengers.selectByVisibleText(strPassengers);
    }
	
	public void selectDepartingFrom (String strDepartingFrom)
    {
		Select dropDepartingFrom = new Select(this.fromPort); 
		dropDepartingFrom.selectByVisibleText(strDepartingFrom);
    }
	
	public void selectAirline (String strAirLine)
    {
		Select dropAirline = new Select(this.airline); 
		dropAirline.selectByVisibleText(strAirLine);
    }
	
	public void selectArrvingIn (String strArrvingIn)
    {
		Select dropstrArrvingIn = new Select(this.toPort); 
		dropstrArrvingIn.selectByVisibleText(strArrvingIn);
    }
	
	public void selectOnMonth (String strOnMonth)
    {
		Select dropOnMonth = new Select(this.fromMonth); 
		dropOnMonth.selectByVisibleText(strOnMonth);
    }
	
	public void selectOnDay (String strOnDay)
    {
		Select dropOnDay = new Select(this.fromDay); 
		dropOnDay.selectByVisibleText(strOnDay);
    }
	
	public void selectReturnMonth (String strReturnMonth)
    {
		Select dropReturnMonth = new Select(this.toMonth); 
		dropReturnMonth.selectByVisibleText(strReturnMonth);
    }
	
	public void selectReturnDay (String strReturnDay)
    {
		Select dropReturnDay = new Select(this.toDay); 
		dropReturnDay.selectByVisibleText(strReturnDay);
    }
    	
  	public void clickContinueButton () {
  		this.btnfindFlights.click();
  	}
}
