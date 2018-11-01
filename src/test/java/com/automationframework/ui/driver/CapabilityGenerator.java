package com.automationframework.ui.driver;

import org.openqa.selenium.remote.DesiredCapabilities;



import com.automationframework.ui.config.GlobalProperties;
import com.automationframework.ui.config.PropertiesRepository;


public class CapabilityGenerator {

	
	public static DesiredCapabilities getCapabilities(String browserType){
		
		DesiredCapabilities cap = null;
		System.out.println("Launching the browser: " + browserType);
		
		switch(browserType){
		case GlobalProperties.FIREFOX:
			System.setProperty("webdriver.gecko.driver", PropertiesRepository.getString("global.browser.gecko.driver.executable"));	
			cap=DesiredCapabilities.firefox();
			break;
		case GlobalProperties.CHROME:
			System.setProperty("webdriver.chrome.driver", PropertiesRepository.getString("global.browser.chrome.driver.executable"));
			cap=DesiredCapabilities.chrome();
			break;
		case GlobalProperties.IE:
			System.setProperty("webdriver.ie.driver", PropertiesRepository.getString("global.browser.ie.driver.executable"));
			cap=DesiredCapabilities.internetExplorer();
		default:
			System.setProperty("webdriver.gecko.driver", PropertiesRepository.getString("global.browser.gecko.driver.executable"));	
			cap=DesiredCapabilities.firefox();
	}
		return cap;
	
	
		}
	}
