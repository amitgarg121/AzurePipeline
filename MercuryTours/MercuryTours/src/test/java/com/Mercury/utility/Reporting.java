package com.Mercury.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting implements ITestListener {
	
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports reports; 
	protected static ExtentTest test; 
	
	public void onTestStart(ITestResult result) {
		System.out.println(" on test start");
		test = reports.createTest(result.getTestContext().getAttribute("testName").toString());
		test.log(Status.INFO, result.getMethod().getMethodName()+ " test is started."); 
	}
	
	public void onTestSuccess (ITestResult result) {
		System.out.println(" on test success");
		test.log(Status.PASS, result.getMethod().getMethodName() + " test is passed.");
		reports.flush();
	}
	
	public void onTestFailure (ITestResult result) {
		System.out.println(" on test failure");
		test.log(Status.FAIL, result.getMethod().getMethodName() + " test is Failed.");
		reports.flush();
	}
	
	public void onTestSkipped (ITestResult result) {
		System.out.println(" on test skipped");
		test.log(Status.SKIP, result.getMethod().getMethodName() + " test is Skipped.");
		reports.flush();
	}
	
	public static synchronized void logsGeneration(String message) {
		
		Reporter.log(message, true);
		
	}
	
	public static synchronized void passLogsGeneration(String message) {
		
		Reporter.log(message, true);
		
	}
	
	public static synchronized void failLogsGeneration(String message) {
		
		Reporter.log(message, true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
