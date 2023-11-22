package practice;


import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		Properties p= new Properties();
		p.setProperty("username", "admin");
		p.setProperty("password", "admin");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\WriteData.properties",true);
		p.store(fos, "new file created");
		System.out.println("Property file created");

	}

}
