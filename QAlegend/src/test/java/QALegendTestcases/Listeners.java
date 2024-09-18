package QALegendTestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationCore.BaseClass;
import Utilities.extentReportNG;

public class Listeners extends BaseClass implements ITestListener {
 ExtentTest test;
 ExtentReports extent = extentReportNG.getReportObject();
 ThreadLocal<ExtentTest>extenttest = new ThreadLocal<ExtentTest>();  //to lock the thread
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test Execution started");
		test= extent.createTest(result.getMethod().getMethodName()); 
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result); //pass aayi kazhnjal
		System.out.println("Test case passed");
		extenttest.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result); //fail aayal
		System.out.println("Test case failed");
		extenttest.get().fail(result.getThrowable());  //to print the error
	
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extenttest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodname, driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().log(Status.FAIL, "Test failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result); 
		System.out.println("Test case skip");
		extenttest.get().log(Status.SKIP, "Test skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);  //timeout issue vannal
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		System.out.println("test execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("Test Execution finished");
		extent.flush();  //mandatory
	}

}
