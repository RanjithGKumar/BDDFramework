package com.bdd.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.bdd.fileReaderManager.FileReaderManager;
import com.bdd.textContent.TestContent;

public class CommonMethods {
WebDriver driver;
	public static String timestamp;
	GlobalHooks hook;
	ExtentTest logInfo=null;
	TestContent testContent;
	String url=null;
	
	public CommonMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public CommonMethods(TestContent testContent) {
		this.testContent=testContent;
		hook=new GlobalHooks(testContent);
		url=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getUrl();
	}
}
