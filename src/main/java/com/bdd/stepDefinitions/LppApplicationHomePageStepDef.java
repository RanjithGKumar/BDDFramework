package com.bdd.stepDefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.bdd.ExtentReport.ExtentReportConfig;
import com.bdd.fileReaderManager.FileReaderManager;
import com.bdd.textContent.TestContent;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LppApplicationHomePageStepDef extends ExtentReportConfig{

	TestContent testContent;
	String url=null;
	GlobalHooks hook;
	public LppApplicationHomePageStepDef(TestContent content) {
		testContent=content;
		hook=new GlobalHooks(content);
		url=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getUrl();
	}
	
	@Given("^Launch LPP Application$")
	public void launch_lpp_application() throws IOException, ClassNotFoundException {
		ExtentTest loginfo=null;
		try {
			test=extent.createTest(Scenario.class, hook.getScenarioName()).
					createNode(Feature.class, hook.getFeatureFileNameFromScenarioID()).
					createNode(Scenario.class,hook.getScenarioName());
			loginfo=test.createNode(new GherkinKeyword("Given"), "Launch LPP applicatio");
			System.out.println("Launched App");	
			hook.driver.get(url);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Then("^Verify application logo$")
	public void verify_application_Logo() throws IOException, ClassNotFoundException {
		ExtentTest loginfo=null;
		try {
			loginfo=test.createNode(new GherkinKeyword("Then"), "Verify application logo");
					
			System.out.println("Verified app");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
