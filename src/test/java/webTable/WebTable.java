package webTable;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WebTable {

	// Entire Table data
	@Test
	public void fetch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//td"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		// ITERATOR

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

		driver.close();

	}

	// First Row
	@Test
	public void TC1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//tbody/tr[1]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

	// First Column
	@Test
	public void TC2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//td[1]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

//Even Rows
	@Test
	public void TC3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//tbody/tr[position() mod 2=0]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

	// Odd Rows
	@Test
	public void TC4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//tbody/tr[position() mod 2 = 1]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

	// even Columns

	@Test
	public void TC5() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//td[position() mod 2 = 0]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

//Odd Columns
	@Test
	public void TC6() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//td[position() mod 2 = 1]"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

	// Entire Header
	@Test
	public void TC7() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> tableData = driver.findElements(By.xpath("//thead//tr"));
		//List<WebElement> tableData = driver.findElements(By.xpath("//th"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		driver.close();
	}

	
	@Test
	public void TC9() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		List<WebElement> tableData = driver.findElements(By.xpath("//div[@class='table-data team']//following::div[@class='team-name']//following::p[contains(text(),'Dabang Delhi K.C.')]"));
		
		//(//div[contains(@class,'table-data matches-won')])[3]
		
		//p[contains(text(),'Dabang Delhi K.C.')]/ancestor::div[contains(@class,'table-ro')]//div[contains(@class,'lost')]
		//List<WebElement> tableData = driver.findElements(By.xpath("//th"));

		// FOR EACH LOOP
//		for (WebElement option : tableData) {
//			System.out.println(option.getText());
//
//		}

		// FOR LOOP
//		int count= tableData.size();
//		for(int i=0;i<count;i++)
//		{
//
//			System.out.println(tableData.get(i).getText());
//		}

		Iterator<WebElement> itr = tableData.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		//driver.close();
	}

}
