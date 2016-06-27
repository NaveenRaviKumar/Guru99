package testCases;



import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomeLoginPage;
import utility.Utility;


public class VerifyHomeLoginPage extends BaseClass {
	
	
	@BeforeTest
	public void checkRunMode(){
			app_logs.debug("Checking Runmode..");
		if(!Utility.isExecutable("LoginTest", excel))
		{
			app_logs.debug("Skipping test case");
			throw new SkipException("Skipping the test");
		}
			
	}
	
	@Test(dataProvider="getData")
	public void testLogin(Hashtable<String,String> data)
	{
		app_logs.debug("Login Page Testing");
		HomeLoginPage hlp = PageFactory.initElements(driver,HomeLoginPage.class);
		hlp.doLogin(data.get("username"),data.get("password"));
		String title = driver.getCurrentUrl();
		
		Assert.assertEquals("http://www.demo.guru99.com/V4/manager/Managerhomepage.php",title);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		//return test data from the sheet name provided
		app_logs.debug("In Dataprovider");
		
		app_logs.debug("Data returned");
		return Utility.getData("LoginTest",excel);
	}
	
	

}
