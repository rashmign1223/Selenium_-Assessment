package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopperStack {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.shoppersstack.com/");
		
		driver.findElement(By.xpath("//img[@alt='phone']")).click();
		
		driver.findElement(By.id("Check Delivery")).sendKeys("583103");
				
		WebElement product = driver.findElement(By.xpath("//button[@id='check']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   
		wait.until(ExpectedConditions.elementToBeClickable(product));
	     product.click();			
		String text = driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
	    
		System.out.println(text);
		
		Thread.sleep(3000);
	    
	    driver.quit();

			}

		}
		
		
	


