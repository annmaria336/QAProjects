package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"\\test-output\\Report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);  //to customize the reports
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ann");
		return extent;
	}

}
