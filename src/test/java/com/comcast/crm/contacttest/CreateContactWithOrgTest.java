package com.comcast.crm.contacttest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileuility.ExcelUtility;
import com.comcast.crm.generic.fileuility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.webDriverUtility;

public class CreateContactWithOrgTest {

	// Test Case 6

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		/* Create Object */

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		webDriverUtility wLib = new webDriverUtility();

		String URL = fLib.getDataFromPropertiesFile("url");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String ContactLastName = eLib.getDataFromExcel("contact", 7, 3);

		// At compilation it is null
		WebDriver driver = null;

		// at the time of execution in Run Time based on user input it going to take
		// decision
		// driver object behaves differently in Run Time polymorphism

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else
		// if user forgot to give the data at run time (unexpected enter will click)
		{
			driver = new ChromeDriver();
		}

		System.out.println(BROWSER);
		System.out.println(URL);

		// WebDriver driver = new FirefoxDriver();

		// Step 1: Login to App
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 2 : navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// Step 3: Click on "Create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the Header Phone Number info expected result

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "header verified==PASS");
		} else {
			System.out.println(orgName + "header verified==FAIL");
		}

		// Step 5: Navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// Step 6: Click on "Create contact" Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 7: Enter all the details & create new Organization
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Switch to Child Window
		wLib.switchToTabOnUrl(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// Switch to Parent Window
		wLib.switchToTabOnUrl(driver, "Contacts&action");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the header msg with expected result
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerInfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + "header verified==PASS");
		} else {
			System.out.println(ContactLastName + "header verified==FAIL");
		}

		// Verify the header OrgName Info with expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		System.out.println(actOrgName);

		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		} else {
			System.out.println(orgName + "information is not created==FAIL");
		}

		// Step 6: Log out
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.linkText("Sign Out")).click();

		// driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
		// sc.close();

	}

}
