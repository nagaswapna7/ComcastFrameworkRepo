package practice.Test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * Test Class For Contact Module
 * !@author Ramya
 * 
 */

public class SearchContact extends BaseClass {
	
	/**
	 * 
	 * Scenario : Login() ==> NavigateContact ===> createContact() ===>Verify
	 * 
	 * 
	 */
	

	@Test
	public void searchcontactTest()
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "password");
	}
}
