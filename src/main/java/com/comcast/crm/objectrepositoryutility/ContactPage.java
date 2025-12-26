package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

//	/**
//	 * This class contains all the elements and business logic
//	 * related to the Contact Page in the CRM.
//	 */
//
//		 WebDriver driver;
//
//		    // ===================== Web Elements ===================== //
//
//		    // "Create Contact" button (usually an image or link)
//		    @FindBy(xpath = "//img[@alt='Create Contact...']")
//		    private WebElement createNewOrgBtn;
//
//		    // ===================== Constructor ===================== //
//		    public ContactPage(WebDriver driver) {
//		        this.driver = driver;
//		        PageFactory.initElements(driver, this);
//		    }
//
//		    // ===================== Getters ===================== //
//		    /**
//		     * Returns the WebElement for the "Create Contact" button.
//		     * (Kept method name same as your test for compatibility)
//		     */
//		    public WebElement getCreateNewOrgBtn() {
//		        return createNewOrgBtn;
//		    }
//
//		    // ===================== Business Logic ===================== //
//		    /**
//		     * Clicks on the "Create Contact" button.
//		     */
//		    public void clickOnCreateContactBtn() {
//		        createNewOrgBtn.click();
//	    }

}
