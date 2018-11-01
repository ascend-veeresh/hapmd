package com.automationframework.handlers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GenericElementHandler extends BaseHandler {
	Logger logger = LogManager.getLogger(this.getClass());

	public GenericElementHandler(WebDriver webDriver) {
		super(webDriver);
	}
}
