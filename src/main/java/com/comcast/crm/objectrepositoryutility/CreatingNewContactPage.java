package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the "Create New Contact" page. It contains all the
 * WebElements and business methods used to create a new contact.
 */
public class CreatingNewContactPage {

	WebDriver driver;

	// ===================== Web Elements ===================== //

	// Last Name input field
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(name = "support_start_date")
	private WebElement startDateEdt;

	@FindBy(name = "support_end_date")
	private WebElement endDateEdt;

	// Save button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// ===================== Constructor ===================== //
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== Getters ===================== //
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// ===================== Business Logic ===================== //
	/**
	 * This method will create a new contact by entering the last name and clicking
	 * the Save button.
	 * 
	 * @param lastName - Contact's last name
	 */
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	/**
	 * This method allows more flexible creation (future enhancement) if you want to
	 * fill more fields later.
	 * 
	 * @param lastName - Contact's last name
	 * @param orgName  - Organization name (future use)
	 */
	public void createContact(String lastName, String orgName) {
		lastNameEdt.sendKeys(lastName);
		// Future step: select organization dropdown and choose orgName
		saveBtn.click();
	}

	public void createContactWithSupportDate(String lastName, String startDate, String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDateEdt.sendKeys(startDate);
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}
}
