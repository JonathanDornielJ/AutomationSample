package com.banking.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		String reportPath= System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("TEST RESULTS");
		reporter.config().setReportName("Web Automation results");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jonathan");
		return extent;
	}
	
	
//	public static ExtentReports getReportObject() {
//		String reportPath=System.getProperty("user.dir")+"//Reports//index.html";
//		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
//		reporter.config().setDocumentTitle("TEST RESULTS");
//		reporter.config().setReportName("Web Automation Results");
//		reporter.config().setTheme(Theme.DARK);
//		
//		ExtentReports extent=new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Test triggered by:", "JonathanD");
//		return extent;
//	}

}
