package Uitilites;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("open database connectivity");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Pre condition");
    }

    @BeforeClass
    public void beforeClass() throws IOException {

        // Read data from Properties file
        String browser = PropertiesUtility.getData("Browser");
        String url = PropertiesUtility.getData("url");
        String username = PropertiesUtility.getData("username");
        String password = PropertiesUtility.getData("password");

        // Print the values
        System.out.println("Browser = " + browser);
        System.out.println("URL = " + url);
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

        // Launch browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        // Browser settings
        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        // Open URL
        driver.get(url);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("close browser");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("close database connectivity");
    }
}
