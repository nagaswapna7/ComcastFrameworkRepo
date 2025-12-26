
package com.comcast.crm.listenersutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("=======> Report Configuration Started <======");
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");


		// Spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Env Information & Create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-10");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("=======> Report Backup Completed <======");
		// report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=======> " + result.getMethod().getMethodName() + " Started <======");

		test = report.createTest(result.getMethod().getMethodName());
		
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>STARTED<=====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======> " + result.getMethod().getMethodName() + " PASSED <======");

		test.log(Status.PASS, result.getMethod().getMethodName() + "===>COMPLETED<=====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		// System.out.println("=======> " + testName + " FAILED <======");

		// try {
		// Take screenshot from BaseClass static driver
//        	 File srcFile = ((TakesScreenshot) BaseClass.sdriver).getScreenshotAs(OutputType.FILE);
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>FAILED<=====");

//             File destFile = new File("./Screenshot/" + testName + "_" + time + ".png");

//             FileUtils.copyFile(srcFile, destFile);
//             System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
//

//        } catch (IOException e) {
//            e.printStackTrace();
//        
//        
//        }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("=======> " + result.getMethod().getMethodName() + " SKIPPED <======");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Partial Failure: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("=======> Test Execution Started <======");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("=======> Test Execution Finished <======");
	}
}
