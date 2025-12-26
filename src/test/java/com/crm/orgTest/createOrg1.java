package com.crm.orgTest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


@Listeners(com.comcast.crm.listenersutility.ListImpClass.class)
public class createOrg1 extends BaseClass {

	@Test(groups = "ST")
	public void createorgTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");

//	ListImpClass.test.log(Status.INFO,"read data from Excel" );

		String orgname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// step 2: Navigate to Organization Module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organisation
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create Org Page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgname);

		// verify the

		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgname)) {

			System.out.println(orgname + "is created ===pass");
		} else {
			System.out.println(orgname + "is not created ===fail");
		}

	}

	@Test(groups = "RT")
	public void createorgwithpnTest() throws Throwable {

		String orgname = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
		
		String phonenumber = eLib.getDataFromExcel("org", 7, 3);

		//

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organisation
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrganizationWithPhoneNumber(orgname, phonenumber, shippingAddress);

		//
		String phonenumber1 = driver.findElement(By.id("dtlview_Phone")).getText();
		if (phonenumber1.equals(phonenumber)) {

			System.out.println(phonenumber + "is created ===pass");

		} else {
			System.out.println(phonenumber + "is not created ===fail");

		}

	}

	@Test(groups = "RT")
	public void createorgwithindustryTest() throws Throwable {
		System.out.println("execute createorgwithindustry  and verify ");

		String orgname = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String shippingAddress = eLib.getDataFromExcel("org", 1, 5);
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organisation
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);

		cno.createOrg(orgname, industry, type, shippingAddress);
		//

		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.equals(industry)) {

			System.out.println(industry + "information is verified ===pass");

		} else {
			System.out.println(industry + "information is notverified===fail");

		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {

			System.out.println(type + "information is verified ===pass");

		} else {
			System.out.println(type + "information is notverified===fail");

		}

	}

}
