package com.bdd.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bdd.ExtentReport.ExtentReportConfig;
import com.bdd.pageObjects.LesptitsbouchonsHomePage;
import com.bdd.textContent.TestContent;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GlobalHooks extends ExtentReportConfig {

	TestContent testContent;
	WebDriver driver;
	public static ExtentTest test;
	public Scenario scenario;
	public static String currentscenario;
	public static String featureName;
	public JavascriptExecutor js;
	public WebDriverWait wait, fluentwait;
	public static ExtentReports extent=null;
	String url=null;
	public static String user;
	LesptitsbouchonsHomePage lp;
	public GlobalHooks(TestContent testContent) {
		this.testContent=testContent;
		driver=testContent.getBaseConfigInstance().getDriver();
		lp=testContent.getPageObjectManagerInstance().getLesptitsbouchonsHomePage();
	}
	
	@Before
	public void setUp(Scenario scenario) {
		try {
			this.scenario=scenario;
			currentscenario=scenario.getName();
			String rawFeatureName=scenario.getId().split(";")[0].replace("_", " ");
			featureName=rawFeatureName.substring(0, 1).toUpperCase()+rawFeatureName.substring(1);
			extent=extentReportSetup();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getScenarioName() {
		return currentscenario;
	}
	
	public String getFeatureFileNameFromScenarioID() {
		return featureName;
	}
	
	@After
	public void flushBrowser() {
		if(driver!=null) {
			driver.quit();
		}
		extent.flush();
	}
}
