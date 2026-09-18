package POMUtilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutoverview {

    WebDriver d;
    WebDriverWait wait;

    @FindBy(css = "span.title")
    private WebElement overview;

    @FindBy(id = "finish")
    private WebElement finish;

    public CheckOutoverview(WebDriver d) {
        this.d = d;
        PageFactory.initElements(d, this);
        wait = new WebDriverWait(d, Duration.ofSeconds(10));
    }

    public String getOverview() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(overview));

        return element.getText();
    }

    public void getFinish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(finish)).click();
    }
}
