package POM;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BuzzPage {

	    WebDriver driver;
	    WebDriverWait wait;

	    public BuzzPage(WebDriver driver) {

	        this.driver = driver;

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//span[text()='Buzz']")
	    private WebElement buzzLink;

	    @FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
	    private  WebElement postTextBox;

	    @FindBy(xpath = "//button[contains(.,'Post')]")
	    private WebElement postButton;

	    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
	     private WebElement profileButton;

	    @FindBy(xpath = "//a[text()='Logout']")
	     private WebElement logoutButton;


	    public void clickBuzz() {

	        wait.until(ExpectedConditions.elementToBeClickable(buzzLink));

	        buzzLink.click();
	    }


	    public void enterPost(String post) {

	        wait.until(ExpectedConditions.visibilityOf(postTextBox));

	        postTextBox.sendKeys(post);
	    }


	    public void clickPost() {

	        wait.until(ExpectedConditions.elementToBeClickable(postButton));

	        postButton.click();
	    }


	    public boolean verifyPost(String post) {

	        WebElement element = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//p[contains(text(),\"" + post + "\")]")
	                )
	        );

	        return element.isDisplayed();
	    }


	    public void logout() {

	        wait.until(ExpectedConditions.elementToBeClickable(profileButton));

	        profileButton.click();

	        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

	        logoutButton.click();
	    }
	}


