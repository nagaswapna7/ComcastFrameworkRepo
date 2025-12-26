package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest1 extends BaseClass {

	@Test
	// Test Case 4
	public void createContactTest1() throws Throwable {

		// read test Script data from Excel File
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 2 : navigate to Contact module

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// Step 3: Click on "Create Contact" Button

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details & create new Contact

		String endDate = jLib.getSystemDateYYYYDDMM();
		String startDate = jLib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// Verify the Header Phone Number info expected result
		String actStartDate = driver.findElement(By.name("support_start_date")).getText();

		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information is not verified==FAIL");
		}

		String actendDate = driver.findElement(By.name("support_end_date")).getText();

		if (actendDate.equals(endDate)) {
			System.out.println(endDate + " information is verified==PASS");
		} else {
			System.out.println(endDate + " information is not verified==FAIL");
		}

	}
}
