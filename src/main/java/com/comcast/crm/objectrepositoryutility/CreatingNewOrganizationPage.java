package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class represents the "Create New Organization" page.
 * It provides reusable business methods for creating organizations
 * with different combinations of fields (name, phone, industry, type).
 */
public class CreatingNewOrganizationPage {

    WebDriver driver;

    // ======= Constructor ======= //
    public CreatingNewOrganizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======= OBJECT REPOSITORY ======= //
    @FindBy(name = "accountname")
    private WebElement orgNameEdit;

    @FindBy(name = "industry")
    private WebElement industryDropDown;

    @FindBy(name = "accounttype")
    private WebElement typeDropDown;

    @FindBy(id = "phone")
    private WebElement phoneEdit;

    @FindBy(name = "button")
    private WebElement saveBtn;
    
    @FindBy(name="ship_street")
    private WebElement shippingAddress;

   

	// ======= GETTERS ======= //
    public WebElement getOrgNameEdit() {
        return orgNameEdit;
    }

    public WebElement getIndustryDropDown() {
        return industryDropDown;
    }

    public WebElement getTypeDropDown() {
        return typeDropDown;
    }

    public WebElement getPhoneEdit() {
        return phoneEdit;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }
    
    public WebElement getShippingAddress() {
		return shippingAddress;
	}

    // ======= BUSINESS LOGIC ======= //

    /**
     * 1️⃣ Create Organization with only name
     */
    public void createOrg(String orgName) {
        orgNameEdit.sendKeys(orgName);
        saveBtn.click();
    }

    /**
     * 2️⃣ Create Organization with name & phone number
     */
    public void createOrganizationWithPhoneNumber(String orgName, String phoneNumber, String address) {
        orgNameEdit.sendKeys(orgName);
        phoneEdit.sendKeys(phoneNumber);
        shippingAddress.sendKeys(address);
        saveBtn.click();
    }

    /**
     * 3️⃣ Create Organization with name, industry & type
     */
    public void createOrg(String orgName, String industry, String type, String address) {
        orgNameEdit.sendKeys(orgName);

        Select industrySelect = new Select(industryDropDown);
        industrySelect.selectByVisibleText(industry);

        Select typeSelect = new Select(typeDropDown);
        typeSelect.selectByVisibleText(type);

        shippingAddress.sendKeys(address);
        
        saveBtn.click();
    }
    
    public void createOrgWithShippingAddress(String orgName, String address) {
        orgNameEdit.sendKeys(orgName);
        shippingAddress.sendKeys(address);
        saveBtn.click();
    }


}
