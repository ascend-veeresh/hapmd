package com.automationframework.handlers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ButtonHandler extends BaseHandler {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	public ButtonHandler(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getButton(String selector) {
		return findElement(selector);
	}
	
	public void clickButton(WebElement button, String...waitFor) throws Exception {
		if (button != null) {
			button.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate button element");
		}
	}
	
	public void clickButton(String selector, String...waitFor) {
		WebElement button = findElement(selector);
		if (button != null) {
			button.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		}
	}
	
	public void clickButton(String selector, boolean flag, String...waitFor) {
		try {
		WebElement button = findElement(selector);
		if (button != null) {
			if(flag) {
				waitToBeDisplayed(button);
				button.click();
				if (waitFor != null && waitFor.length > 0) {
					setDriverWait(waitFor[0]);
				}
			}
		} 
		} catch(Exception e) {
			String errorMessage = "Failed to click on button " + toString()
					+ e.getMessage();
			logger.error(errorMessage);
		}
		
 	}
	
	public void clickButtonWithWait(String selector, String... waitFor)
			throws Exception {
		WebElement button = findElement(selector);
		try {
			if (button != null) {
				waitToBeDisplayed(button);
				button.click();
				if (waitFor != null && waitFor.length > 0) {
					setDriverWait(waitFor[0]);
				}
			}
		} catch (Exception e) {
			String errorMessage = "Failed to click on button " + toString()
					+ e.getMessage();
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}
	
}
