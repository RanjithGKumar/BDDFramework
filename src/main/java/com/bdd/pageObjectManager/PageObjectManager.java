package com.bdd.pageObjectManager;

import org.openqa.selenium.WebDriver;

import com.bdd.pageObjects.LesptitsbouchonsHomePage;

public class PageObjectManager {
	private WebDriver driver;
	private LesptitsbouchonsHomePage lespHomePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LesptitsbouchonsHomePage getLesptitsbouchonsHomePage() {
		return (lespHomePage == null) ? lespHomePage = new LesptitsbouchonsHomePage(driver) : lespHomePage;
	}

}
