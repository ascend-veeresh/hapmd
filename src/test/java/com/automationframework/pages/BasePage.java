package com.automationframework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationframework.ui.config.GlobalProperties;

public class BasePage {

	protected WebDriver driver;
	
	protected BasePage(WebDriver driver){
		this.driver=driver;
	}

	protected void setDriverWait(String selector) {
		WebDriverWait driverWait = new WebDriverWait(driver, GlobalProperties.EXPLICIT_WAIT);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}
	
	
}

