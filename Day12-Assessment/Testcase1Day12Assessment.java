package Day12Assessment;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase1day12Assessment extends BaseClass {
	@DataProvider
	public Object[][] excelPage() throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("src/test/java/Day12Assessment/VacencyName.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rc = sh.getLastRowNum();
	int cc = sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[rc][cc];
	for(int row =1;row<=rc;row++) {
		for(int column=0;column<cc;column++) {
			obj[row-1][column]=sh.getRow(row).getCell(column).getStringCellValue();
		}
		
		}
		return obj;	
		}
	 @Test(dataProvider="excelPage")
	 public void Base(String VacencyName,String Description,String HireManager) throws InterruptedException, AWTException, IOException {
	  FileInputStream fil = new FileInputStream("src/test/java/Day12Assessment/Login1.Properties");
	  Properties p = new Properties();
	  p.load(fil);
	  String browser = p.getProperty("browser");
	  String url = p.getProperty("url");
	  String uname = p.getProperty("username");
	  String pass = p.getProperty("password");
	  
		POMLoginpage p1 = new POMLoginpage(driver);
		p1.getuname(uname);
		p1.getpass(pass);
		p1.getLogin();
		
		Thread.sleep(3000);
		
		POMRecruitment2 p2 = new POMRecruitment2(driver);
		p2.getrbutton();
		p2.getVacancies();
		p2.getaddButton();
		
		Thread.sleep(3000);
		
		POMVacanciespage p3 = new POMVacanciespage(driver);
		p3.getVacancyName(VacencyName);
		p3.getjobtitle();
		p3.getDescription(Description);
		p3.getHireManager(HireManager);
		p3.getposition("50");
		p3.getsave();
		Thread.sleep(5000);
		
		POMmyinfopage p4 = new POMmyinfopage(driver);
		p4.getProfile();
	    Thread.sleep(3000);
	    p4.getLout();
		
	 }
}


