package com.automationframework.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LinkHandler extends BaseHandler {

	public LinkHandler(WebDriver driver) {
		super(driver);
	}

	public void selectLink(String selector, String... waitFor)
			throws Exception {
		WebElement link = findElement(selector);
		if (link != null) {
			link.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate link element");
		}
	}
	
	public void selectLink(WebElement webElement, String... waitFor)
			throws Exception {
		if (webElement != null) {
			webElement.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate link element");
		}
	}
	
	public void selectLink(String selector, boolean flag, String... waitFor)
			throws Exception {
		WebElement link = findElement(selector);
		if (link != null) {
			if(flag) {
				waitToBeDisplayed(link);
				link.click();
				if (waitFor != null && waitFor.length > 0) {
					setDriverWait(waitFor[0]);
				}
			}
		} else {
			throw new Exception("Unable to locate link element");
		}
	}
	

	public WindowHandler selectLinkToLaunchNewWindow(String selector,
			String... waitFor) throws Exception {
		WebElement link = findElement(selector);
		WindowHandler windowHandler = null;
		if (link != null) {
			link.click();
			windowHandler = new WindowHandler(driver);
			windowHandler.switchToLatestWindow(waitFor);
		} else {
			throw new Exception("Unable to locate link element");
		}
		return windowHandler;
	}

	public void selectLinkByText(String text, boolean exactMatch,
			String... waitFor) throws Exception {
		WebElement link = (exactMatch == true) ? driver.findElement(By
				.linkText(text)) : driver.findElement(By.partialLinkText(text));
		if (link != null) {
			link.click();
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new Exception("Unable to locate link element");
		}
	}
	
	public void selectLinkByText(String text, boolean exactMatch, boolean flag,
			String... waitFor) throws Exception {
		WebElement link = (exactMatch == true) ? driver.findElement(By
				.linkText(text)) : driver.findElement(By.partialLinkText(text));
		if (link != null) {
			if(flag) {
				waitToBeDisplayed(link);
				link.click();
				if (waitFor != null && waitFor.length > 0) {
					setDriverWait(waitFor[0]);
				}
			}
		} else {
			throw new Exception("Unable to locate link element");
		}
	}
	
}
