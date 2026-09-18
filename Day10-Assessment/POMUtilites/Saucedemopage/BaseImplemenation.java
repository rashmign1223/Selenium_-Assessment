package Saucedemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import POMUtilites.CartPage;
import POMUtilites.CheckOut;
import POMUtilites.CheckOutoverview;
import POMUtilites.Checkoutcompeletepage;
import POMUtilites.Homepage;
import POMUtilites.LoginPage;

public class BaseImplemenation extends BaseTest {

    @Test(priority = 1)
    public void LoginTest() throws IOException, InterruptedException {

       
        FileInputStream file = new FileInputStream("./src/test/java/Saucedemo/config.Properties");

        Properties p = new Properties();
        p.load(file);

        String un = p.getProperty("username");
        String pw = p.getProperty("password");

        file.close();

        // Login
        LoginPage l = new LoginPage(d);

        l.getUsername(un);
        l.getPassword(pw);

        Thread.sleep(2000);

        l.getLogin();

        System.out.println("Login completed successfully");
    }


    @Test(priority = 2, dependsOnMethods = "LoginTest")
    public void oderPalcementTest() throws InterruptedException, IOException {

        
        Homepage h = new Homepage(d);

        if (h.getProduct().equals("Products")) {

            System.out.println("Product page is displayed");

        } else {

            System.out.println("Product page is not displayed");
        }

        Thread.sleep(2000);

        
        h.getAddtocart();

        Thread.sleep(2000);

        // Verify quantity
        if (h.getquantity().equals("1")) {

            System.out.println("Only one product is added");

        } else {

            System.out.println("Many products are added");
        }

        // Click cart
        h.getCart();

        CartPage ca = new CartPage(d);

        // Verify product
        if (ca.getProductverify().equals("Sauce Labs Backpack")) {

            System.out.println("BackPack product is added");

        } else {

            System.out.println("Wrong product is added");
        }

        Thread.sleep(2000);

        // Click checkout
        ca.getCheckout();

        Thread.sleep(2000);

       
        CheckOut co = new CheckOut(d);

        // Read Excel data
        FileInputStream excelFile = new FileInputStream( "./src/test/java/Saucedemo/SauceData1.xlsx");

        Workbook workbook = WorkbookFactory.create(excelFile);

        Sheet sheet = workbook.getSheet("sheet1");

        Row row = sheet.getRow(1);

        DataFormatter formatter = new DataFormatter();

        String fn = formatter.formatCellValue(row.getCell(0));
        String ln = formatter.formatCellValue(row.getCell(1));
        String c = formatter.formatCellValue(row.getCell(2));

        System.out.println("First Name: " + fn);
        System.out.println("Last Name: " + ln);
        System.out.println("Postal Code: " + c);

        
        co.getFName(fn);
        co.getLName(ln);
        co.getCode(c);

        Thread.sleep(2000);

        
        co.getContinuebtn();

        Thread.sleep(2000);

        System.out.println("Current URL after Continue: " + d.getCurrentUrl());

        CheckOutoverview o = new CheckOutoverview(d);

        if (o.getOverview().equals("Checkout: Overview")) {
            System.out.println("Product overview is displayed");
        } else {
            System.out.println("Product overview is not displayed");
        }
        
        o.getFinish();

        Thread.sleep(2000);

        
        Checkoutcompeletepage a = new Checkoutcompeletepage(d);

        if (a.getMessage().equals("Thank you for your order!")) {

            System.out.println("Thank you for your order message is displayed");
        } else {
            System.out.println("Thank you for your order message is not displayed");
        }
        workbook.close();
        excelFile.close();
        System.out.println("Order placement completed successfully");
    }
}
