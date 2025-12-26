package practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "userData")
    public Object[][] getDataProvider() {
        Object[][] obj = new Object[2][3]; 

        obj[0][0] = "Ramya";
        obj[0][1] = "Katari";
        obj[0][2] = "Ramya@gmail.com";

        obj[1][0] = "Deepika";
        obj[1][1] = "Katari";
        obj[1][2] = "Deepika@gmail.com";

        return obj;
    }

    @Test(dataProvider = "userData")
    public void data(String firstName, String lastName, String email) {
        WebDriver driver = new ChromeDriver();
        driver.get(""); 
        System.out.println("Testing signup with:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("-----------------------");

        driver.quit();
    }
}
