
package POMUtilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutcompeletepage {

    WebDriver driver;

    // Constructor
    public Checkoutcompeletepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement FName;

    @FindBy(id = "last-name")
    private WebElement LName;

    @FindBy(id = "postal-code")
    private WebElement code;

    @FindBy(id = "continue")
    private WebElement continuebtn;

    @FindBy(className = "complete-header")
    private WebElement message;

    // Enter first name
    public void getFName(String value) {
        FName.sendKeys(value);
    }

    // Enter last name
    public void getLName(String value) {
        LName.sendKeys(value);
    }

    // Enter postal code
    public void getCode(String value) {
        code.sendKeys(value);
    }

    // Click Continue
    public void getContinuebtn() {
        continuebtn.click();
    }

    // Get order success message
    public String getMessage() {
        return message.getText();
    }
}
