package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author Anwesha
 *
 */

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();//Name of the @Test method
		System.out.println(methodName+" -----Test Execution started -----");
			
			//@Test execution started
			test = report.createTest(methodName);
		}
		

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -----Test PASS -----");
		
			test.log(Status.PASS, methodName+" ---- Test PASS ----");
			
		}
		

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -----Test FAIL -----");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName+" ---- Test FAIL ----");
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil= new JavaUtility();
		String screenshotName = methodName+jutil.getSystemDate();
		
		try {
			String path =wutil.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -----Test SKIP -----");
		
			System.out.println(result.getThrowable());
			
			test.log(Status.SKIP, methodName+" ---- Test SKIP ----");
			test.log(Status.INFO, result.getThrowable());
			
		}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println(" -----Suite Execution started -----");
		
		//Extent Report configuration
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("QCO-SOEAJD-M5-Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base PlatForm", "Windows Family");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Anwesha");
		

		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(" -----Suite Execution Finished -----");

			//generate the report
			report.flush();
			
		}
		
	
	

}
