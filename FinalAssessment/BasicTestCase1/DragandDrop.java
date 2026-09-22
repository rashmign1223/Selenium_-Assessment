package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrogdropPage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		Actions action = new Actions(driver);
		
		 WebElement Laptop= driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		 WebElement Mobile=driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		 WebElement Laptop2=driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		 WebElement Mobile2=driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		 
		 WebElement MobileAccess = driver.findElement(By.id("dropZone1"));
		 WebElement LaptopAccess = driver.findElement(By.id("dropZone2"));
		  
		Laptop.click();
		Mobile.click();
		action.dragAndDrop(Laptop,Mobile).perform();
		 
	    Laptop2.click();
	    Mobile2.click();
	    
	    action.dragAndDrop(Laptop2, Mobile2).perform();
	    
	    System.out.println("accessories draganddrop successfully");
	    
	    driver.quit();
	}
	
}


