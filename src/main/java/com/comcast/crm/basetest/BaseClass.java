package com.comcast.crm.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileuility.ExcelUtility;
import com.comcast.crm.generic.fileuility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	/* Utility Objects */
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver;// Static driver for Listeners
	

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws Throwable {
		System.out.println("======Connect to Db, report Config========");
		dbLib.getDbconnection();

		
	}

	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {
		System.out.println("======Launch Browser=====");

		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		sdriver = driver;
		
		// This class help us to share my static variable for multiple threads in case
		// of parallel execution for real time 
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("==Login===");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("===Logout===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("===Close Browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws Throwable {
		System.out.println("======Close DB , report Backup=========");
		dbLib.closeDbconnection();

	}
}
