package com.bdd.stepDefinitions;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.bdd.ExtentReport.ExtentReportConfig;
import com.bdd.fileReaderManager.FileReaderManager;
import com.bdd.textContent.TestContent;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GenericMethodsStepdef extends ExtentReportConfig{
	
	
TestContent testContent;
String url=null;
GlobalHooks hook;
public GenericMethodsStepdef(TestContent content) {
	testContent=content;
	hook=new GlobalHooks(content);
	url=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getUrl();
}

@Given("^I want to demoQa application$")
public void launchApp() {
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


@When("^I enter \"(.*)\" field as \"(.*)\"$")
public void enteringText(String field, String fieldVal) {

	ExtentTest loginfo=null;
	try {
		
		Thread.sleep(3000);
		loginfo=test.createNode(new GherkinKeyword("Then"), "^I enter "+field+" field as"+fieldVal);
		hook.driver.findElement(By.xpath("//*[text()='"+field+"']/following::input[1]")).sendKeys(fieldVal);
		Thread.sleep(3000);
				
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
