package AdvanceSeleniumDemo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day6Assessment {

    public static void main(String[] args)
            throws IOException, EncryptedDocumentException, InterruptedException {

        
        // 1. Read data from Properties file
        

        FileReader fir = new FileReader(
                "./src/test/resources/DDT/Day6.Properties");

        Properties prop = new Properties();
        prop.load(fir);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        String adminUsername = prop.getProperty("adminUsername");
        String adminPassword = prop.getProperty("adminPassword");

        fir.close();

        
        // 2. Read employee data from Excel
        

        FileInputStream fis = new FileInputStream(
                "./src/test/resources/DDT/Emp1.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        DataFormatter df = new DataFormatter();

        String firstName = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(0));

        String middleName = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(1));

        String lastName = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(2));

        String employeeId = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(3));

        String username = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(4));

        String password = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(5));

        String role = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(6));

        String employeeName = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(7));

        String status = df.formatCellValue(
                wb.getSheet("Sheet1").getRow(1).getCell(8));

        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Username: " + username);
        System.out.println("Password present: " + !password.isEmpty());
        System.out.println("Role: " + role);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Status: " + status);

        
        // 3. Launch browser
        

        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            System.out.println("Invalid browser name");
            wb.close();
            fis.close();
            return;
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(20));

        
        // 4. Login to OrangeHRM
        

        driver.get(url);

        driver.findElement(By.name("username"))
                .sendKeys(adminUsername);

        driver.findElement(By.name("password"))
                .sendKeys(adminPassword);

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(3000);

       
        // 5. Click PIM
        

        driver.findElement(By.xpath("//span[text()='PIM']"))
                .click();

        Thread.sleep(2000);

        
        // 6. Click Add button
        
        driver.findElement(By.xpath("//button[contains(.,'Add')]"))
                .click();

        Thread.sleep(2000);

        
        // 7. Enter employee details
        

        driver.findElement(By.name("firstName"))
                .sendKeys(firstName);

        driver.findElement(By.name("middleName"))
                .sendKeys(middleName);

        driver.findElement(By.name("lastName"))
                .sendKeys(lastName);

        driver.findElement(By.xpath(
                "//label[normalize-space()='Employee Id']/following::input[1]"))
                .sendKeys(employeeId);

        
        // 8. Click Create Login Details
        
        driver.findElement(By.xpath(
                "//div[contains(@class,'oxd-switch-wrapper')]//span"))
                .click();

        Thread.sleep(1000);

        System.out.println("Create Login Details toggle clicked");

        
        // 9. Enter login details
        

        driver.findElement(By.xpath(
                "//label[normalize-space()='Username']/following::input[1]"))
                .sendKeys(username);

        driver.findElement(By.xpath(
                "//label[normalize-space()='Password']/following::input[1]"))
                .sendKeys(password);

        driver.findElement(By.xpath(
                "//label[normalize-space()='Confirm Password']/following::input[1]"))
                .sendKeys(password);

        
        // 10. Save employee
        

        driver.findElement(By.xpath(
                "//button[@type='submit']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Employee added successfully");

        
        // 11. Click Admin
        

        driver.findElement(By.xpath("//span[text()='Admin']"))
                .click();

        Thread.sleep(2000);

        
        // 12. Search Username
        
        driver.findElement(By.xpath(
                "//label[normalize-space()='Username']/following::input[1]"))
                .sendKeys(username);

        
        // 13. Select User Role
        driver.findElement(By.xpath(
                "//label[normalize-space()='User Role']"
                + "/following::div[contains(@class,'oxd-select-text')][1]"))
                .click();

        Thread.sleep(1000);

        List<WebElement> roleOptions = driver.findElements(
                By.xpath("//div[@role='option']"));

        for (WebElement option : roleOptions) {
            System.out.println(
                    "Available Role: " + option.getText());
        }

        driver.findElement(By.xpath(
                "//div[@role='option'][normalize-space()='" + role + "']"))
                .click();

        
        // 14. Enter Employee Name
        

        driver.findElement(By.xpath(
                "//label[normalize-space()='Employee Name']/following::input[1]"))
                .sendKeys(employeeName);

        Thread.sleep(2000);

        // Select employee suggestion
        driver.findElement(By.xpath(
                "//div[@role='option'][1]"))
                .click();

        
        // 15. Select Status
        

        driver.findElement(By.xpath(
                "//label[normalize-space()='Status']"
                + "/following::div[contains(@class,'oxd-select-text')][1]"))
                .click();

        Thread.sleep(500);

        driver.findElement(By.xpath(
                "//div[@role='option']//span[normalize-space()='"
                + status + "']"))
                .click();

        
        // 16. Click Search
       
        driver.findElement(By.xpath(
                "//button[@type='submit']"))
                .click();

        Thread.sleep(3000);

        
        // 17. Verify employee
        
        boolean employeeFound = driver.findElements(By.xpath(
                "//div[contains(@class,'oxd-table-body')]"
                + "//div[contains(@class,'oxd-table-row')]"
                + "[contains(.,'" + username + "')]"))
                .size() > 0;

        if (employeeFound) {

            System.out.println("Employee record is found");
            System.out.println("TEST CASE PASS");

        } else {

            System.out.println("Employee record is not found");
            System.out.println("TEST CASE FAIL");
        }

        
        // 18. Logout
        

        driver.findElement(By.xpath(
                "//span[contains(@class,'oxd-userdropdown-tab')]"))
                .click();

        Thread.sleep(500);

        driver.findElement(By.xpath(
                "//a[normalize-space()='Logout']"))
                .click();

        Thread.sleep(2000);

        
        // 19. Close browser and files
        
        driver.quit();

        wb.close();
        fis.close();
    }
}
