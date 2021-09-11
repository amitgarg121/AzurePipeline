package com.Mercury.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	static Properties pro; 
	
	public ConfigDataProvider() {
		
		File src = new File(System.getProperty("user.dir") + "//Config//Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Not able to load config file. " + e.getMessage());
		}
				
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	public static String getBrowser () {	
		return pro.getProperty("Browser");			
	}
	
	public static String getqaURL () {
		return pro.getProperty("qaURL");
	}
}
