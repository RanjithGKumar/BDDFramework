package com.bdd.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath="src/main/resources/config.properties";
	private final String userdir=System.getProperty("user.dir")+"\\src\\main\\resources\\files\\";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties filr noe found at "+propertyFilePath);
		}
	}
	
	public String getUrl() {
		String url=null;
		url=properties.getProperty("URL");
		if(url!=null) {
			return url;
		}else {
			throw new RuntimeException("URL not specified in Config.property file "); 
		}
	}
	
	public String getApplication() {
		String app=null;
		app=properties.getProperty("Applicatio");
		if(app!=null) {
			return app;
		}else {
			throw new RuntimeException("Application not specified in Config.property file "); 
		}
	}
	
	public String getDriverPath() {
		String driverPath=null;
		driverPath=properties.getProperty("driverPath");
		if(driverPath!=null) {
			return driverPath;
		}else {
			throw new RuntimeException("driverPath not specified in Config.property file "); 
		}
	}
	
	public String getApplicationEnvName() {
		return properties.getProperty("Envirinment");
	}
	public String getUserName() {
		return properties.getProperty("username");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public String getEnvironment() {
		return properties.getProperty("URL");
	}
}
