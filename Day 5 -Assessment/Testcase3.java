//Testcase 3 

1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login  submit button
3.Read the data from json file.
package AdvanceSeleniumDemo;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Testcase3 {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fil = new FileReader(
                "./src/test/resources/DDT/Testcase3.json");
		JSONParser jsonparser = new JSONParser();
   		Object obj = jsonparser.parse(fil);
   		JSONObject j = (JSONObject)obj;
   		String b = j.get("browser").toString();
   		String u = j.get("url").toString();
   		String e = j.get("email").toString();
   		String p = j.get("pass").toString();
   		System.out.println(b);
   		System.out.println(u);
   		System.out.println(e);
   		System.out.println(p);
   		
   		
   	  WebDriver driver = null;
    	 if(b.equals("chrome")) {
    		 driver = new ChromeDriver();
    	 }
    	 if(b.equals("edge")) {
    		 driver = new ChromeDriver();
    	 }
    	 if(b.equals("firefox")) {
    		 driver = new ChromeDriver();
    	 }
   		 driver.manage().window().maximize();
      	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      	 
      	 
      	 driver.get(u);
      	 driver.findElement(By.id("email")).sendKeys(e);
      	 driver.findElement(By.id("password")).sendKeys(p);
      	 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
}
}
