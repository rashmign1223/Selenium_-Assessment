package FinalTestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.BuzzPage;
import POM.LoginPage;
import Uitilites.BaseClass;
import Uitilites.excel;
import Uitilites.PropertiesUtility;

public class BuzzTest extends BaseClass {

    @Test
    public void buzzPostTest() throws IOException {

        // Get username and password from Properties file
        String username = PropertiesUtility.getData("username");
        String password = PropertiesUtility.getData("password");

        // Get post from Excel
        String post = excel.getData("Sheet1", 1, 0);

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("Post = " + post);

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Buzz
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();
        buzzPage.enterPost(post);
        buzzPage.clickPost();

        // Verify post
        boolean result = buzzPage.verifyPost(post);

        Assert.assertTrue(result, "Post is not displayed in Recent Posts");

        System.out.println("Post is successfully displayed in Recent Posts");

        // Logout
        buzzPage.logout();

        System.out.println("Logout successful");
    }
}
