package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest1 extends BaseClass {

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

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);

		// Verify the Header Phone Number info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information is not verified==FAIL");
		}

	}

	@Test
	public void createContactWithSupportDateTest1() throws Throwable {

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

	@Test
	public void createContactWithOrgTest1() throws Throwable {
		
		// read test Script data from Excel File
				String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
				String ContactLastName = eLib.getDataFromExcel("contact", 7, 3);
				
				
				// Step 2 : navigate to Organization module

				HomePage hp = new HomePage(driver);
				hp.getOrgLink().click();

				// Step 3: Click on "Create Organization" Button

				OrganizationsPage cnp = new OrganizationsPage(driver);
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(cnp.getCreateNewOrgBtn()));
				cnp.getCreateNewOrgBtn().click();

				// Step 4: Enter all the details & create new Organization

				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.createOrg(orgName);
				
				
				// Verify the Header OrgName info expected result
				String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();

				System.out.println(actOrgName);

				if (actOrgName.trim().equals(orgName)) {
					System.out.println(orgName + "information is created==PASS");
				} else {
					System.out.println(orgName + "information is not created==FAIL");
				}
				
				

				//Step 5: Navigate to Contact Module
				hp.getContactLink().click();
				
				//Step 6 : Click on "Create Contact" Button
				ContactPage cp = new ContactPage(driver);
				cp.getCreateNewOrgBtn().click();
				
				//Step 7: enter all the details & create new contact
				CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
				ccp.createContact(ContactLastName, actOrgName);
				
				//Verify Header orgName info Expected Result
				actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				
				if (actOrgName.trim().equals(orgName)) {
					System.out.println(orgName + "information is created==PASS");
				} else {
					System.out.println(orgName + "information is not created==FAIL");
				}




	}
}
