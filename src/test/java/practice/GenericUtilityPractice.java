package practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.readDataFromPropertyfile("url");
		System.out.println(URL);
		
		String USERNAME = putil.readDataFromPropertyfile("username");
		System.out.println(USERNAME);
		
		String BROWSER = putil.readDataFromPropertyfile("browser");
		System.out.println(BROWSER);
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		String data = eutil.readDataFromExcel("Contacts", 1,2 );
		System.out.println(data);
		
		String data1 = eutil.readDataFromExcel("Organization", 7,3);
		System.out.println(data1);
		
		JavaUtility jutil = new JavaUtility();
		int r = jutil.getRandomNumber();
		System.out.println(r);
		
		String withran=data1+r;
		System.out.println(withran);
		
		String date = jutil.getSystemDate();
		System.out.println(date);
		
	

	}

}
