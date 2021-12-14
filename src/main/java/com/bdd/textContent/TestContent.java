package com.bdd.textContent;

import com.bdd.baseConfig.BaseConfig;
import com.bdd.pageObjectManager.PageObjectManager;

public class TestContent {

	private PageObjectManager pageObjectManager;
	private BaseConfig baseConfig;
	
	public TestContent() {
		baseConfig=new BaseConfig();
		pageObjectManager=new PageObjectManager(baseConfig.getDriver());
	}
	
	public BaseConfig getBaseConfigInstance() {
		return baseConfig;
	}
	
	public PageObjectManager getPageObjectManagerInstance() {
		return pageObjectManager;
	}
}
