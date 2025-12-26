package listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

class InvoiceTest extends BaseClass {
	
	@Test
	public void creatinvoiceTest() {
		System.out.println("excute cretainvoicetest");
		String actTitel=driver.getTitle();
		Assert.assertEquals(actTitel, "Login");

		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

		
	}
	
	@Test(retryAnalyzer= com.comcast.crm.listenersutility.RetryListenerImp.class)
	public void ActivateSim() {
	System.out.println("step-1");
	Assert.assertEquals("Login", "Login");

	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4"); 
		System.out.println("excute cretainvoice with contacttest");
	}

}
