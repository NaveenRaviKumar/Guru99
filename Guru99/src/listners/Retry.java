package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import testCases.BaseClass;

public class Retry extends BaseClass implements IRetryAnalyzer {

	int retrycount = 0;
	 int maxretyrcount =1;
	

	public boolean retry(ITestResult result) {
	
		if (retrycount<maxretyrcount){
			app_logs.debug("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
			retrycount++;
            return true;
		}
		
		return false;
	}

	 public String getResultStatusName(int status) {
	    	String resultName = null;
	    	if(status==1)
	    		resultName = "SUCCESS";
	    	if(status==2)
	    		resultName = "FAILURE";
	    	if(status==3)
	    		resultName = "SKIP";
			return resultName;
	    }
}
