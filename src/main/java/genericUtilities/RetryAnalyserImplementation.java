package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This is a Implementation class for IRetryAnalyzer interface of TestNG
 * @author Anwesha
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count =0;
	int retrycount =3;// manual analysis
	

	public boolean retry(ITestResult result) {
		
		while(count<retrycount)
		{
			count++;
			return true;// retry 3 times
		}

		
		return false; //stop the retrying
	}
	
	

}
