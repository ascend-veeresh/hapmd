package com.automationframework.handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckboxHandler extends BaseHandler {
	public CheckboxHandler(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getCheckbox(String selector) {
		return findElement(selector);
	}
	
	public boolean isCheckboxSelected(String selector) {
		WebElement checkbox = findElement(selector);
		return checkbox.isSelected();
	}
	
	public void selectCheckbox(WebElement checkbox, String...waitFor) throws Exception {
		if (checkbox != null) {
			checkbox.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate checkbox element");
		}
	}
	
	public void selectCheckbox(String selector, String...waitFor) throws Exception {
		WebElement checkbox = findElement(selector);
		if (checkbox != null) {
			checkbox.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate checkbox element");
		}
	}
	
	public void selectCheckbox(String selector, boolean flag, String...waitFor) throws Exception {
		WebElement checkbox = findElement(selector);
		if (checkbox != null) {
			if(flag) {
				waitToBeDisplayed(selector);
				checkbox.click();
			}
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate checkbox element");
		}
	}
}
