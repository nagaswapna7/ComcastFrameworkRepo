package practice.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class Invoice extends BaseClass{
	
	@Test(retryAnalyzer = com.comcast.crm.listenersutility.RetryListenerImp.class)
	public void activeSim()
	{
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

		
	}
	
//	@Test
//	public void createInvoiceTest()
//	{
//		System.out.println("execute createInvoiceTest");
//		String actTitle=driver.getTitle();
//		Assert.assertEquals(actTitle, "Login");
//		System.out.println("step-1");
//		System.out.println("step-2");
//		System.out.println("step-3");
//		System.out.println("step-4");
//
//		
//	}
	
//	@Test
//	public void createInvoiceWithContactTest()
//	{
//		System.out.println("execute createInvoiceWithContactTest");
//		System.out.println("step-1");
//		System.out.println("step-2");
//		System.out.println("step-3");
//		System.out.println("step-4");
//
//		
//
//	}

}
