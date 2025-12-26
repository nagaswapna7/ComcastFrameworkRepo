package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class CreateOrgTest3 extends BaseClass{
	
	/**
	 * Combined Test Class for Organization Module
	 * --------------------------------------------------
	 * Includes:
	 *  1️⃣ Create Organization (Basic)
	 *  2️⃣ Create Organization with Industry & Type
	 *  3️⃣ Create Organization with Phone Number
	 *
	 * Date: October 2025
	 */


	    /**
	     * Test Case 1: Create Basic Organization
	     */
	    @Test
	    public void createOrganizationTest() throws Throwable {

	        // Step 1: Read data from Excel
	        String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

	        // Step 2: Navigate to Organization module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // Step 3: Click on "Create Organization" Button
	        OrganizationsPage orgPage = new OrganizationsPage(driver);
	        orgPage.getCreateNewOrgBtn().click();

	        // Step 4: Enter Organization details & save
	        CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
	        createOrg.createOrg(orgName);

	        // Step 5: Verify Organization Name
	        String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	        Assert.assertEquals(actOrgName.trim(), orgName.trim(), "Organization Name Mismatch!");

	        System.out.println("✅ Organization created successfully: " + orgName);
	    }

	    /**
	     * Test Case 2: Create Organization with Industry & Type
	     */
	    @Test
	    public void CreateOrganizationWithIndustriesTest() throws Throwable {

	        // Step 1: Read data from Excel
	        String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
	        String industry = eLib.getDataFromExcel("org", 4, 3);
	        String type = eLib.getDataFromExcel("org", 4, 4);

	        // Step 2: Navigate to Organization module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // Step 3: Click on "Create Organization" Button
	        OrganizationsPage orgPage = new OrganizationsPage(driver);
	        orgPage.getCreateNewOrgBtn().click();

	        // Step 4: Enter all the details
	        CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
	       // createOrg.createOrganizationWithIndustries(orgName, industry, type);

	        // Step 5: Verify industry & type
	        String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
	        String actType = driver.findElement(By.id("dtlview_Type")).getText();

	        Assert.assertEquals(actIndustry.trim(), industry.trim(), "Industry mismatch!");
	        Assert.assertEquals(actType.trim(), type.trim(), "Type mismatch!");

	        System.out.println("✅ Organization with Industry & Type created successfully!");
	        System.out.println("Org: " + orgName + " | Industry: " + industry + " | Type: " + type);
	    }

	    /**
	     * Test Case 3: Create Organization with Phone Number
	     */
	    @Test
	    public void CreateOrganizationWithPhoneNumberTest() throws Throwable {

	        // Step 1: Read data from Excel
	        String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
	        String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
	        String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
			

	        // Step 2: Navigate to Organization module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // Step 3: Click on "Create Organization" Button
	        OrganizationsPage orgPage = new OrganizationsPage(driver);
	        orgPage.getCreateNewOrgBtn().click();

	        // Step 4: Enter org name & phone number
	        CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
	        createOrg.createOrganizationWithPhoneNumber(orgName, phoneNumber, shippingAddress);

	        // Step 5: Verify phone number
	        String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();
	        Assert.assertEquals(actPhone.trim(), phoneNumber.trim(), "Phone number mismatch!");

	        System.out.println("✅ Organization with Phone Number created successfully!");
	        System.out.println("Org: " + orgName + " | Phone: " + phoneNumber);
	    }
	}




