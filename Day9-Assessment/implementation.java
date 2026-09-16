package Day9Assessment;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Sauseimplementation {
	       WebDriver driver;
	       
	       //launch the browser
	       
	       public void launchbrowser() {
	    	   driver = new ChromeDriver();
	    	   driver.manage().window().maximize();
	    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       }
	       
	       public void openurl() {
	    	   driver.get("https://www.saucedemo.com/");
	       }
	       
	       public void Username() {
	    	   driver.findElement(By.id("user-name")).sendKeys("standard_user");
	       }
	       
	       public void Password() {
	    	   driver.findElement(By.id("password")).sendKeys("secret_sauce");
	       }
	       
	       public void loginbutton() {
	    	   driver.findElement(By.id("login-button")).click();
	       }
	}


