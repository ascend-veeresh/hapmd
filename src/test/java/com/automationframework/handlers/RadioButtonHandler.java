package com.automationframework.handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class RadioButtonHandler extends BaseHandler {

	public RadioButtonHandler(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getRadioButton(String selector) {
		return findElement(selector);
	}
	
	public void selectRadioButton(WebElement radioButton, String...waitFor) throws Exception {
		if (radioButton != null) {
			radioButton.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate radio button element");
		}
	}
	
	public void selectRadioButton(String selector, String...waitFor) throws Exception {
		WebElement radioButton = findElement(selector);
		if (radioButton != null) {
			radioButton.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate radio button element");
		}
	}
	
	public void selectRadioButton(String selector, boolean waitflag,
			String... waitFor) throws Exception {
		WebElement radioButton = findElement(selector);
		if (radioButton != null) {
			if (waitflag) {
				waitToBeDisplayed(radioButton);
				radioButton.click();
				if (waitFor != null && waitFor.length > 0) {
					setDriverWait(waitFor[0]);
				}
			}
		} else {
			throw new Exception("Unable to locate radio button element");
		}
	}
	
}
