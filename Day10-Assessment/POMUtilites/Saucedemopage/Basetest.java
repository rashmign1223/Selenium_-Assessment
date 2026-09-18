package Saucedemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver d;

    public Properties p;

    @BeforeClass
    public void bc() throws IOException {

        System.out.println("Open Database connectivity");

        System.out.println("PreCondition");

        // Read properties file
        FileInputStream file = new FileInputStream(
                "./src/test/java/Saucedemo/config.Properties");

        p = new Properties();

        p.load(file);

        file.close();

        String browser = p.getProperty("browser");

        String url = p.getProperty("url");

        System.out.println("Browser: " + browser);

        System.out.println("URL: " + url);

        // Open browser
        System.out.println("Open the browser");

        if (browser.equalsIgnoreCase("chrome")) {

            // Avoid Chrome Change Password popup
            ChromeOptions settings = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("profile.password_manager_leak_detection", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("credentials_enable_autosave", false);

            settings.setExperimentalOption("prefs", prefs);

            d = new ChromeDriver(settings);

        } else {

            throw new RuntimeException(
                    "Browser not supported: " + browser);
        }

        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        d.get(url);

        System.out.println(
                "SauceDemo application opened successfully");
    }

    @BeforeMethod
    public void bm() {

        System.out.println("Before Method");
    }

    @AfterMethod
    public void am() {

        System.out.println("PostCondition");
    }

    @AfterClass
    public void ac() {

        if (d != null) {

            d.quit();

            System.out.println("Browser closed successfully");
        }

        System.out.println("Close Database connectivity");
    }
}
