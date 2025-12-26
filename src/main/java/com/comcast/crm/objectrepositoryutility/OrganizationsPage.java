package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "search_feild")
	private WebElement searchDD;

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") // change locator as per your app
	private WebElement createNewOrgBtn;

	@FindBy(name = "submit")
	private WebElement searchBtn;

//	@FindBy(xpath = "//img[@alt='Create Organization...']")
//	private WebElement createNewOrgBtn;

	public WebElement getSearchBtn() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
}

//	
