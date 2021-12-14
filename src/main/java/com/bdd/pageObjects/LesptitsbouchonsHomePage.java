package com.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LesptitsbouchonsHomePage {
	
	WebDriver driver; 
	
	public LesptitsbouchonsHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="lpb-header-navbar-item")
	public WebElement appLogo;
	
	@FindBy(xpath="//*[@id='root']/div/div/div[1]/div[1]/div/div/div[2]/div[1]/nav/div/ul/li[4]/a")
	public WebElement appLogoXpath;

}
