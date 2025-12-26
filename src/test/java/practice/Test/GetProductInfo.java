package practice.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileuility.ExcelUtility;

public class GetProductInfo {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		// Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

		// Capture product Info
		// dynamic xpath plays major role in e commerce application
		String x = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}

	@DataProvider
	public Object[][] getData() throws Throwable {

//		objArr[0][0] = "iphone";
//		objArr[0][1] = "Apple iPhone 15 (256 GB) - Blue";
//
//		
//		objArr[1][0] = "iphone";
//		objArr[1][1] = "Apple iPhone 15 (256 GB) - Pink";
//
//		
//		objArr[2][0] = "iphone";
//		objArr[2][1] = "Apple iPhone 15 (256 GB) - Black";

		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("product");

		Object[][] objArr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("product", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i + 1, 1);
		}

		return objArr;
	}

}
