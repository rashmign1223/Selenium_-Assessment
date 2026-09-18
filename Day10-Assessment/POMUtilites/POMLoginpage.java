package POMUtilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login;

    public LoginPage(WebDriver d) {

        PageFactory.initElements(d, this);
    }

    public void getUsername(String un) {

        username.sendKeys(un);
    }

    public void getPassword(String pw) {

        password.sendKeys(pw);
    }

    public void getLogin() {

        login.click();
    }
}
