package Day12Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase2Day12Assessment  extends BaseClass{
	@DataProvider
		public Object[][] myinfo() throws EncryptedDocumentException, IOException {
			FileInputStream fil = new FileInputStream("./src/test/java/Day12Assessment/myinfo.xlsx");
			Workbook wb = WorkbookFactory.create(fil);
			Sheet sh = wb.getSheet("Sheet1");
			int rc = sh.getLastRowNum();
			 int cc = sh.getRow(0).getLastCellNum();
			 Object[][] obj = new Object[rc][cc];
			 for(int row=1;row<=rc;row++) {
				 for(int c=0;c<cc;c++) {
					 obj[rc-1][c]=sh.getRow(row).getCell(c).getStringCellValue();
				 }
			 }
			 return obj;
		}
		
		@Test(dataProvider = "myinfo")
		public void testcase2(String Fname,String Mname,String Lname,String EMpid) throws IOException, InterruptedException {
			
			FileInputStream f = new FileInputStream("./src/test/java/Day12Assessment/Login1.Properties");
			Properties p = new Properties();
			p.load(f);
			 String browser = p.getProperty("browser");
			 String url = p.getProperty("url");
			 String uname = p.getProperty("username");
			 String pass = p.getProperty("password");
			 
			
			WebDriver driver = null;
			POMLoginpage p1 = new POMLoginpage(driver);
			p1.getuname(uname);
			p1.getpass(pass);
			p1.getLogin();
			
			POMmyinfopage p2 = new POMmyinfopage(driver);
			p2.getmyinfo();
			
		
			
			POMmyinfooverview p3 = new POMmyinfooverview(driver);
			p3.getFname(Fname);
			p3.getMname(Mname);
			p3.getLname(Lname);
			p3.getEmpId(EMpid);
			Thread.sleep(3000);
			p3.getSave();
			Thread.sleep(2000);
			p3.getProfile();
			Thread.sleep(3000);
			p3.getLout();
			
			//Login again
			
			p1.getuname(uname);
			p1.getpass(pass);
			p1.getLogin();
			
			//click my info
			p2.getmyinfo();
			
			//verification
	        Thread.sleep(5000);
			Assert.assertEquals(p3.verifyFname(), Fname);
			Assert.assertEquals(p3.verifyMname(), Mname);
			Assert.assertEquals(p3.verifyLname(), Lname);
			Assert.assertEquals(p3.verifyEmpId(), EMpid);
			System.out.println("✔️");
			System.out.println("Verifed succesfully 👍 My data is updated");
			
		
			
			
		}
	          
	}
		
	
