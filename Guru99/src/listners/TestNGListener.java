package listners;
import java.io.IOException;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import config.MailConfig;

import testCases.BaseClass;
//import utility.monitoringMail;
import utility.testUtil;

public class TestNGListener extends BaseClass implements ITestListener {

	
	public void onFinish(ITestContext arg0) {
		app_logs.debug("Execution finished");
		/*testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		monitoringMail mail = new monitoringMail();
		try {
			mail.sendMail(MailConfig.server, MailConfig.from, MailConfig.to, MailConfig.subject, MailConfig.messageBody, MailConfig.attachmentPath, MailConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
		
	

	
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString().trim();
		app_logs.debug("Error occured");

		try {
			testUtil.captureScreenshot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName().toString().trim();
		app_logs.debug("Testcase:"+methodName+"\tstatus:pass");
		
	}

}
