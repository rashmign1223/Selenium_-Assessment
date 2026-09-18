package POMUtilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    @FindBy(id = "first-name")
    private WebElement fname;

    @FindBy(id = "last-name")
    private WebElement lname;

    @FindBy(id = "postal-code")
    private WebElement code;

    @FindBy(id = "continue")
    private WebElement continuebtn;

    public CheckOut(WebDriver d) {
        PageFactory.initElements(d, this);
    }

    public void getFName(String fn) {
        fname.sendKeys(fn);
    }

    public void getLName(String ln) {
        lname.sendKeys(ln);
    }

    public void getCode(String c) {
        code.sendKeys(c);
    }

    public void getContinuebtn() {
        continuebtn.click();
    }
}
