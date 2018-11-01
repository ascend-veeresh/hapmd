package com.automationframework.test;



import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;
import org.testng.ITestResult;
import com.automationframework.ui.config.PropertiesRepository;
import com.automationframework.ui.driver.DriverFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {
	
	
	protected static WebDriver driver = null;
	private static Logger logger = Logger.getLogger(BaseTest.class);
	ExtentReports report;
	ExtentTest test;
	String filepath=PropertiesRepository.getString("extentreports.path");
	String screencapture=PropertiesRepository.getString("screencapture.path");
	static {
			
			try {
				PropertiesRepository.loadAllProperties();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	@BeforeSuite
	public void init(){
		
		report = new ExtentReports(filepath);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(Method method){
		test= report.startTest(method.getName());
		logger.info("Method Name in the BaseTest :" +method.getName());
		driver = DriverFactory.getInstance().initialValue();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result){
		
		int status=result.getStatus();
				if(status==1){
					test.log(LogStatus.PASS, "Test Passed");
				}
				else{
					test.log(LogStatus.FAIL, "Test Failed");
					test.addScreenCapture(screencapture);
				}
				report.endTest(test);
				DriverFactory.getInstance().removeDriver();
				logger.info("Method Name in the BaseTest :" +result.getName());
	}
	
	@AfterSuite()
	public void end(){
		report.flush();
	}
	
	
	public void loadProperties(String propfile) throws Exception{
		try {
			PropertiesRepository.appendProperties(propfile);
		} catch (Exception e) {
			logger.error("Unable to load the properties file",e);
		}
		PropertiesRepository.appendProperties(propfile);
	}

	
	
	public void loadAllProperties(){
		try {
			PropertiesRepository.loadAllProperties();
		} catch (Exception e) {
			
		}
	}
}


