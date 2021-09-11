package com.Mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;

    @FindBy(name="userName")
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;
    
    @FindBy(name="login")
    WebElement btnLogin;
    
    public LoginPage (WebDriver driver){
    	this.driver = driver;
        //This initElements method will create all WebElements
    	PageFactory.initElements(driver, this);
    }
    
    //Set user name in text box
    public void setUserName(String strUserName){
    	txtUserName.sendKeys(strUserName);     
    }

    //Set password in password text box
    public void setPassword(String strPassword){
    	txtPassword.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
    	btnLogin.click();
    }  
    
    public void loginToMercuryFlight(String strUserName, String strPassword) {
    	
    	this.txtUserName.sendKeys(strUserName);
       	this.txtPassword.sendKeys(strPassword);
    	    	
    	this.btnLogin.click();   	
    	
    }
}
