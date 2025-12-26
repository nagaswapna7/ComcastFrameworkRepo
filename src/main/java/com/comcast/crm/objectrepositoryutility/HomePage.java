package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(xpath  = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void navigateToCampaginPage() {

		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();

		campaignLink.click();

	}

	public void logout() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    Actions act = new Actions(driver);

	    // Hover over the user icon first
	    wait.until(ExpectedConditions.visibilityOf(adminImg));
	    act.moveToElement(adminImg).perform();

	    // Wait until the Sign Out link is visible & clickable
	    wait.until(ExpectedConditions.elementToBeClickable(signOutLink));

	    // Click Sign Out
	    signOutLink.click();
	}

}
