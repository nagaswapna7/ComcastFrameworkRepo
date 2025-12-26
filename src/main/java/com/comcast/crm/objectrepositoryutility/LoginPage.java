package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.webDriverUtility;
/**
 * 
 * @author Ramya
 * 
 * Contains Login Page elements & Business lib like login()
 */
public class LoginPage extends webDriverUtility {
	
	//Rule 1 : Create separate java class
	//Rule 2 : Object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3 : Object Initialization
	
	//Rule 4 : Object Encapsulation
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}
	
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	
	/**
	 * Login to application based on username, password, url parameters
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule 5 : provide Action
	public void loginToapp(String url, String username, String password) {
//		usernameEdt.sendKeys(username);
//		passwordEdt.sendKeys(password);
//		loginBtn.click();
		
		waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}

}
