package POM;
	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {

	    WebDriver driver;
	    WebDriverWait wait;

	    public LoginPage(WebDriver driver) {

	        this.driver = driver;

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath="//input[@name='username']")
	     private WebElement username;

	    @FindBy(xpath="//input[@name='password']")
	    private  WebElement password;

	    @FindBy(xpath = "//button[@type='submit']")
	     private WebElement loginButton;

	    public void login(String user, String pass) {

	        wait.until(ExpectedConditions.visibilityOf(username));

	        username.sendKeys(user);

	        password.sendKeys(pass);

	        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

	        loginButton.click();
	    }
	}


