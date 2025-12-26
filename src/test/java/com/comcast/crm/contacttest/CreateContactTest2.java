package com.comcast.crm.contacttest;

import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileuility.ExcelUtility;
import com.comcast.crm.generic.fileuility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest2{

	@Test
	// Test Case 4
	public void createContactTest() throws Throwable {
		
		/*Create Object*/

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();


		String URL = fLib.getDataFromPropertiesFile("url");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// generate the random Number
		Random random = new Random();
		int randomInt = random.nextInt(5000);


		
		//read test Script data from Excel File
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

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
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);

//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		// Step 2 : navigate to Contact module
		//driver.findElement(By.linkText("Contacts")).click();
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		

		// Step 3: Click on "Create Contact" Button
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details & create new Contact
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);

		// Verify the Header Phone Number info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information is not verified==FAIL");
		}

		// Step 5: Log out
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.findElement(By.linkText("Sign Out")).click();

		// driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
		// sc.close();

	}

}
