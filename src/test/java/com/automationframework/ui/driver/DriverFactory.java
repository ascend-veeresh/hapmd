package com.automationframework.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

import com.automationframework.ui.config.GlobalProperties;
import com.automationframework.ui.config.PropertiesRepository;

public class DriverFactory {

	Logger logger = Logger.getLogger(DriverFactory.class);
	String browserType=PropertiesRepository.getString("global.browser.name");
	DesiredCapabilities dc = new DesiredCapabilities();
	
	private DriverFactory(){
		
	}
	
	private static DriverFactory instance = new DriverFactory();


	public static DriverFactory getInstance(){
		
	return instance;	
	}

@SuppressWarnings("deprecation")
public WebDriver initialValue(){
	System.out.println(("browserType value first ==> " + browserType));
	
	switch (browserType) {
	case GlobalProperties.FIREFOX:
		System.setProperty("webdriver.gecko.driver", PropertiesRepository.getString("global.browser.gecko.driver.executable"));	
		dc=DesiredCapabilities.firefox();
		return new FirefoxDriver(dc);
	case GlobalProperties.IE:
		return new InternetExplorerDriver(dc);
	case GlobalProperties.CHROME:
		System.setProperty("webdriver.chrome.driver", PropertiesRepository.getString("global.browser.chrome.driver.executable"));
		dc=DesiredCapabilities.chrome();
		return new ChromeDriver(dc);
	default:
		System.setProperty("webdriver.gecko.driver", PropertiesRepository.getString("global.browser.gecko.driver.executable"));	
		dc=DesiredCapabilities.firefox();
		return new FirefoxDriver(dc);
	}
}

public void removeDriver(){
	
	 
	
}
		}

