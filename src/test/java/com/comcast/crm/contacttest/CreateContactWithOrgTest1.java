package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest1 extends BaseClass{
	
	@Test
	public void createContactWithSupportDateTest() throws Throwable {

		// read test Script data from Excel File
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String ContactLastName = eLib.getDataFromExcel("contact", 7, 3);
		
		
		// Step 2 : navigate to Organization module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" Button

		OrganizationsPage cnp = new OrganizationsPage(driver);
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
