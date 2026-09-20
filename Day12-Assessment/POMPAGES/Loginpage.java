package Day12Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMLoginpage {
	WebDriver driver;
	public POMLoginpage(WebDriver driver) {
		this.driver=driver;
	     PageFactory.initElements(driver,this);
	     
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement uname;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public WebDriver getDriver() {
		return driver;
		
	}
	public void getuname(String value) {
		uname.sendKeys(value);
	}
	public void getpass(String value) {
		pass.sendKeys(value);
	}
	public void getLogin() {
		login.click();
	}
	
}

