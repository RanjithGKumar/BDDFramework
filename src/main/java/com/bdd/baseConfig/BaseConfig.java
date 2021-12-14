package com.bdd.baseConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.bdd.fileReaderManager.FileReaderManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfig {
	private WebDriver driver = null;
	String driverPath = null;

	public BaseConfig() {
		driverPath = FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getDriverPath();
	}

	public WebDriver getDriver() {
		if (driver == null) {
			driver = initializeDriver();
		}

		return driver;
	}

	private WebDriver initializeDriver() {
//		String browserType = System.getProperty("browserType");
//		if(browserType.equals("")|browserType==null|) {
			String browserType="chrome";
//		}
		if ("chrome".equalsIgnoreCase(browserType)) {
			try {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chrome = new ChromeOptions();
				chrome.addArguments("--disable-infobar");
				String chromeOptionArg = System.getProperty("chromeOptionsArg");
				if ("--headless".equalsIgnoreCase(chromeOptionArg)) {
					chrome.addArguments("--headless");
					chrome.addArguments("window-size=1600x400");
				}
				driver = new ChromeDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browserType.equalsIgnoreCase("ie")) {
			try {
				WebDriverManager.iedriver().setup();
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability("nativeEvents", false);
				options.setCapability("requireWindowFocus", true);
				options.setCapability("unexpectedAlertBehaviour", "accept");
				options.setCapability("ignoreZoomSetting", true);
				options.setCapability("disable-popup-blocking", true);
				driver = new InternetExplorerDriver(options);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			throw new RuntimeException("Browser name not specified");
		}
		return driver;
	}
}
