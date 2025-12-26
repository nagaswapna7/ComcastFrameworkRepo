package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {

	// This class help us to share my static variable for multiple threads in case
	// of parallel execution

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// for access test and driver

	public static ExtentTest getTest() {
		// it will give extent report of the Multiple threads -- for acheive parallel
		// execution

		return test.get();

	}

	public static void setTest(ExtentTest actTest) {

		test.set(actTest);

	}

	public static WebDriver getDriver() {
		return driver.get();

	}

	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
}
