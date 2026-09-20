package Day12Assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMmyinfooverview {
	WebDriver driver;
	public POMmyinfooverview(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement Fname;
	public WebDriver getDriver() {
		return driver;
	}

	public void getFname(String value) throws InterruptedException {
		Fname.click();
		Fname.sendKeys(Keys.CONTROL,"a");
		Fname.sendKeys(Keys.BACK_SPACE);
		Fname.sendKeys(value);
	}
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement Mname;
	
	public void getMname(String value) {
		Mname.click();
		Mname.sendKeys(Keys.CONTROL,"a");
		Mname.sendKeys(Keys.BACK_SPACE);
		Mname.sendKeys(value);
	}
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement Lname;
	
	public void getLname(String value) {
		Lname.click();
		Lname.sendKeys(Keys.CONTROL,"a");
		Lname.sendKeys(Keys.BACK_SPACE);
		Lname.sendKeys(value);
	}
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement EmpId;
	
	public void getEmpId(String value) throws InterruptedException {
		EmpId.click();
		EmpId.sendKeys(Keys.CONTROL,"a");
		EmpId.sendKeys(Keys.BACK_SPACE);
		EmpId.sendKeys(value);
	}
	
	@FindBy(xpath="(//button[@type='submit'][normalize-space()='Save'])[1]")
	private WebElement save;
	
	public void getSave() {
		save.click();
	}
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	private WebElement profile;
	
	public void getProfile() {
		profile.click();
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement Lout;
	
	public void getLout() {
		Lout.click();
	}
	
	
	public String verifyFname() {
	    return Fname.getDomProperty("value");
	}

	public String verifyMname() {
	    return Mname.getDomProperty("value");
	}

	public String verifyLname() {
	    return Lname.getDomProperty("value");
	}

	public String verifyEmpId() {
	    return EmpId.getDomProperty("value");
	}

}
