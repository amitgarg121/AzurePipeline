package com.Mercury.testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AzurePipelineDemo {
	
	WebDriver driver ; 
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get("http://www.freshworks.com");
	}
	
	@Test(priority = 1)
	public void freshworkslogtest() {
		boolean flag = false; 
		flag = driver.findElement(By.xpath("//img[@class='logo logo-fworks ']")).isDisplayed(); 
		Assert.assertTrue(flag); 
	}
	
	@Test(priority = 2)
	public void freshworkstitletest() {
		System.out.println(driver.getTitle()); 
		assertEquals(driver.getTitle(), "Freshworks | Modern and Easy Customer and Employee Experience Software"); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}

}