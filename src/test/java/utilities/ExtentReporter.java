package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter implements ITestListener {
	public ExtentHtmlReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
     String repname;
	public void onStart() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		 repname = "Test-Reports-"+timestamp+".html";

		sparkreporter = new ExtentHtmlReporter(".\\reports\\"+repname);
		sparkreporter.config().setDocumentTitle("Flight Automation test");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "Flight");
		extent.setSystemInfo("Module", "frontend");
		extent.setSystemInfo("Sub module", "customers");
		extent.setSystemInfo("Operating system", System.getProperty("os.name"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Paresh");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailed(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			String screenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ontestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext textcontext) {
		extent.flush();
	}

}
