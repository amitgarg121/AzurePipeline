package com.Mercury.utility;

import java.util.Random;
public class UtilityMethods {

	public static String generateRandomFirstName () {
		
		String firstnames[] = {"Amit", "Arnav", "Mayuri", "Diwakar", "Neha", "Vinay","Chandrakant", "Shrey", "Shivam", "Arjun", "Yudhisthir", "Bheem", "Nakul","Sahdev"};
		return firstnames[new Random().nextInt(13)];
	    
	}
	
	public static String generateRandomLastName () {
		
		String lastnames[] = {"Garg", "Gupta", "Yadav", "Jain", "Sharma", "Tyagi","Singhal", "Gaur", "Dutt", "Dwivedi", "Prakash", "Khera", "Agrawal","Mittal"};
    	return lastnames[new Random().nextInt(13)]; 
    	
	}
	
}
