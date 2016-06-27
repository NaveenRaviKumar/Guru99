package testCases;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.excel_reader;



import config.Configuration;

import factory.BrowserFactory;


public class BaseClass {
	
	public static WebDriver driver;
	public  static excel_reader excel = null;
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp()
	{	
		app_logs.debug("Loading testdata Excel...");
		excel = new excel_reader(System.getProperty("user.dir")+"\\src\\testData\\testdata.xlsx");
		app_logs.debug("testdata Excel loaded");
		driver = BrowserFactory.getBrowser(Configuration.browser);
		app_logs.debug("Getting browser");
		driver.get(Configuration.testsite);
		app_logs.debug("Getting URL");
	}
	
	@AfterSuite
	public void tearDown()
	{
		app_logs.debug("Quitting...");
		//driver.quit();
	}
	

}
