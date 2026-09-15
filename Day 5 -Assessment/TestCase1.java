
//Test- case  1 
1.Navigate to DemoWebshop application 
2.Click on login link .
3.Enter email and password and click on login button by reading the data from property file.
package AdvanceSeleniumDemo;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Fetch the data from the properties file
        FileInputStream fil = new FileInputStream(
                "./src/test/resources/DDT/Config.Properties");
        Properties p = new Properties();
		p.load(fil);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String email = p.getProperty("email");
		String pass = p.getProperty("pass");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(email);
		System.out.println(pass);
		
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
    }
}
