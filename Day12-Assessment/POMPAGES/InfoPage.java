package Day12Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMmyinfopage {
	WebDriver driver;
	public POMmyinfopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='/web/index.php/pim/viewMyDetails']")
	private WebElement myinfo;
	
	
	public void getmyinfo() {
		myinfo.click();
	}
