package Uitilites;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

	public class PropertiesUtility {

	    public static String getData(String key) throws IOException {

	        FileInputStream fis = new FileInputStream("./src/test/java/Final2Assessment/Login.Properties");

	        Properties prop = new Properties();

	        prop.load(fis);

	        String value = prop.getProperty(key);

	        fis.close();

	        return value;
	    }
	}


