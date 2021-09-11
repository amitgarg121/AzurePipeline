package com.Mercury.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshot, alerts,frames , windows, sync issues, javascript executer
	public static String captureScreenShot (WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Mercury_" + getCurrentDateTime() + ".png"; 
		try {
			
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Capture the Screenshots. " + e.getMessage());
		} 
		
		return screenshotPath; 
		 
	}
	
	public static String getCurrentDateTime () {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		
		Date currentDate = new Date ();
		
		return customFormat.format(currentDate);
	}
	
	public void handleAlerts() {
		
	}
	
	

}
