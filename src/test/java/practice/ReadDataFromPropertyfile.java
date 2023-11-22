package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyfile {
	
	public static void main(String[] args) throws IOException {
		
		//open the document in java readable format
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
		//create object of properties for java.util package
		Properties pro = new Properties();
		
		//load the file input stream into properties
		pro.load(fis);
		
		//provide the key and use the value
		String key = pro.getProperty("url");
		System.out.println(key);

}
}

