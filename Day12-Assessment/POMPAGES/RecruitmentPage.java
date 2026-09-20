package Day12Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMRecruitment2 {
	WebDriver driver;
	public POMRecruitment2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")
	private WebElement rbutton;
	
	@FindBy(xpath="//a[@text()='Vacancies']")
	private WebElement Vacancies;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addButton;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void getrbutton() {
		rbutton.click();
	}
	public void getVacancies() {
		Vacancies.click();
	}
	public void getaddButton() {
		addButton.click();
	    
		
	}

}
