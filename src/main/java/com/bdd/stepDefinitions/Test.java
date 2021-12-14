package com.bdd.stepDefinitions;

import com.bdd.ExtentReport.ExtentReportConfig;
import com.bdd.fileReaderManager.FileReaderManager;
import com.bdd.textContent.TestContent;

public class Test extends ExtentReportConfig{
	
	TestContent testContent;
	String url=null;
	GlobalHooks hook;
	public Test(TestContent content) {
		testContent=content;
		hook=new GlobalHooks(content);
		url=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getUrl();
	}

	
	
}
