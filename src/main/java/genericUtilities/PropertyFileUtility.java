package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
	 * This class consists of generic methods to read data from property file
	 * @author Anwesha
	 */

public class PropertyFileUtility {
	/**
	 * 
	 * This method will read data from property file and return value to the caller
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	
	public String readDataFromPropertyfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}


}
