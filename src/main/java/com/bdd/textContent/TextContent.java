package com.bdd.textContent;

import com.bdd.baseConfig.BaseConfig;
import com.bdd.pageObjectManager.PageObjectManager;

public class TextContent {

	private PageObjectManager pageObjectManager;
	private BaseConfig baseConfig;
	
	public TextContent() {
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
