package com.crm.orgTest;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * Test class to verify Organization creation features.
 * Uses data-driven testing (Excel), POM, and BaseClass setup.
 */
public class CreateOrg extends BaseClass {

	/**
	 * Test: Create an organization and verify its name in the header.
	 */
	@Test(groups = "ST")
	public void createOrgTest() throws Throwable {
		System.out.println("Executing: Create Organization and verify");

		// Read test data from Excel
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
		
		// Step 1: Navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 2: Click on create organization button
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		// Step 3: Fill details and save
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createOrg(orgName);

		// Step 4: Verify created organization name
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		String actualHeader = infoPage.getHeaderMsg().getText();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actualHeader.contains(orgName),
				"❌ Org name mismatch! Expected part: " + orgName + ", Actual: " + actualHeader);
		sa.assertAll();
	}

	/**
	 * Test: Create organization with phone number and verify both name and number.
	 */
	@Test(groups = "RT")
	public void createOrgWithPhoneNumberTest() throws Throwable {

		// Read test data from Excel
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
		

		// Navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Create organization with phone number
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createOrganizationWithPhoneNumber(orgName, phoneNumber, shippingAddress);

		// Verify organization name and phone number
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		String actualHeader = infoPage.getHeaderMsg().getText();
		String actualPhone = infoPage.getPhoneNumberInfo().getText();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actualHeader.contains(orgName),
				"❌ Org name mismatch! Expected part: " + orgName + ", Actual: " + actualHeader);
		sa.assertEquals(actualPhone, phoneNumber, "❌ Phone number mismatch!");
		sa.assertAll();
	}

	/**
	 * Test: Create organization with Industry and Type selection.
	 */
	@Test(groups = "RT")
	public void createOrgWithIndustriesTest() throws Throwable {
		System.out.println("Executing: Create organization with Industry and Type");

		// Read data from Excel
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
		

		// Navigate to Organizations
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Create org with Industry and Type
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createOrg(orgName, industry, type, shippingAddress);

		// Verify name + industry
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		String actualHeader = infoPage.getHeaderMsg().getText();
		String actualIndustry = infoPage.getIndustryInfo().getText();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actualHeader.contains(orgName),
				"❌ Org name mismatch! Expected part: " + orgName + ", Actual: " + actualHeader);
		sa.assertEquals(actualIndustry, industry, "❌ Industry mismatch!");
		sa.assertAll();
	}
}
