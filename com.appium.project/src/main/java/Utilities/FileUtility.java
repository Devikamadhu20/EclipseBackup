package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public static String dataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	

}
