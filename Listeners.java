package com.banking.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.banking.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		//result variable will store all the information of the test being executed, and also the driver information.
		
		//Attaching screenshot to reports on test failure
		//Step 1- Each test will have its driver.  Now, we need a driver with life to be sent to the screenshot method.
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Step 2- Let's send the driver to the screenshot method, take screenshot, and return the location where its saved.
		
		String screenshotPath=null;
		try {
			screenshotPath= getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Step 3- Add the screenshot to the report. To do so, tell where the screenshot is located.
		extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TEST has passed");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
