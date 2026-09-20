package Day12Assessment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMVacanciespage {
	WebDriver driver;
	public POMVacanciespage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	private WebElement VacancyName;
	
	@FindBy(xpath="//input[@class='oxd-select-text oxd-select-text--active']")
	private WebElement jobtitle;
	
	@FindBy(xpath="//div[@role='option']//span[normalize-space(text()='Database Administrator']")
	private WebElement joboption;
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	private WebElement description;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement HireManager;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	private WebElement position;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	
	public void getVacancyName(String value) {
		VacancyName.sendKeys(value);
	}
	public void jobtitle() throws AWTException {
	     jobtitle.click();
	     joboption.click(); 
	}
	public void getDescription(String value) {
		description.sendKeys(value);
	}
	public void getHireManager(String value) throws InterruptedException, AWTException {
		HireManager.sendKeys(value);
		Thread.sleep(3000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_DOWN);
		
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyPress(KeyEvent.VK_ENTER);
	}
	public void getposition(String value) {
		position.sendKeys(value);
	}
	public void getsave() {
		save.click();
		
}
	public void getjobtitle() {
		// TODO Auto-generated method stub
		
	}
	
}


