package com.bdd.ExtentReport;

import java.sql.Timestamp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bdd.fileReaderManager.FileReaderManager;

public class ExtentReportConfig {

	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports extentReportSetup() {
		String timestamp=new Timestamp(System.currentTimeMillis()).toString();
		timestamp=timestamp.substring(0,timestamp.length()-6).replaceAll(":", "");
		if(extent!=null)
			return extent;
		report=new ExtentHtmlReporter("src/main/resources/OutPut/ExtentReport"+timestamp+".html");
		report.config().setDocumentTitle("Application Report");
		String env=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getApplicationEnvName();
		String browser=System.getProperty("browserType");
		report.config().setReportName("Application Name-"+env+"_"+browser);
		report.config().setTheme(Theme.DARK);
		report.config().setTimeStampFormat("MMM dd, yyyy hh:mm:ss");
		report.config().enableTimeline(true);
		report.start();
		extent=new ExtentReports();
		extent.attachReporter(report);
		return extent;
	}
}
