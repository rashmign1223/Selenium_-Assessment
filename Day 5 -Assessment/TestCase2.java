//Testcase 2 

//1.Navigate to orange Hrm application
//2.Enter the username password and click on login buuton
//by redaing the data from excel file.

package AdvanceSeleniumDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase2 {

    public static void main(String[] args)
            throws EncryptedDocumentException, IOException, InterruptedException {

        // Read data from Excel file
        FileInputStream fil = new FileInputStream(
                "./src/test/resources/DDT/OrangeHRM_Login.xlsx");

        Workbook wb = WorkbookFactory.create(fil);

        String browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        String username = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
        String pass = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

        // Print Excel data
        System.out.println(browser);
        System.out.println(url);
        System.out.println(username);
        System.out.println(pass);

        // Launch browser
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        // Check whether the browser was launched
        if (driver == null) {
            System.out.println("Invalid browser name");
            wb.close();
            fil.close();
            return;
        }

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Navigate to OrangeHRM
        driver.get(url);

        // Enter username
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys(username);

        // Enter password
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys(pass);

        // Click login button
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(3000);

        // Close browser
        driver.quit();

        // Close Excel file and input stream
        wb.close();
        fil.close();
    }
}
