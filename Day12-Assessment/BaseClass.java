package Day12Assessment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	WebDriver driver = null;
	@BeforeClass
	public void BC() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	}
	@AfterClass
	public void AC() {
		driver.quit();
		System.out.println("Close the browser");
	}

}
