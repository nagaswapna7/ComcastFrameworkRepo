package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Page Object Model class for Organization Information Page.
 * It provides access to confirmation and detail fields after creating an organization.
 */


public class OrganizationInfoPage {

//    WebDriver driver;
//
//    public OrganizationInfoPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(className = "dvHeaderText")
//    private WebElement headerMsg;
//
//    @FindBy(id = "dtlview_Phone")
//    private WebElement phoneNumberInfo;
//
//    public WebElement getHeaderMsg() {
//        return headerMsg;
//    }
//
//    public WebElement getPhoneNumberInfo() {
//        return phoneNumberInfo;
//    }
//
//	public WebElement getIndustryInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	


		// ======= WebElements ========= //

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerMsg;

		@FindBy(id = "dtlview_Industry")
		private WebElement industryInfo;

		@FindBy(id = "dtlview_Phone")
		private WebElement phoneNumberInfo;

		@FindBy(id = "dtlview_Type")
		private WebElement typeInfo;

		// ======= Constructor ========= //
		public OrganizationInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// ======= Getters ========= //
		/**
		 * Returns the header message displayed after creating the organization.
		 */
		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		/**
		 * Returns the Industry information text.
		 */
		public WebElement getIndustryInfo() {
			return industryInfo;
		}

		/**
		 * Returns the Phone Number information text.
		 */
		public WebElement getPhoneNumberInfo() {
			return phoneNumberInfo;
		}

		/**
		 * Returns the Organization Type information text.
		 */
		public WebElement getTypeInfo() {
			return typeInfo;
		}
	}


