package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario1withDDTandGU {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//create objects of all utilities
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		
		WebDriver driver = null;
		
		//Step 1: Read all the necessary Data
		
		 /*read data from property file-common data*/
		String URL = putil.readDataFromPropertyfile("url");
		String BROWSER = putil.readDataFromPropertyfile("browser");
		String USERNAME = putil.readDataFromPropertyfile("username");
		String PASSWORD = putil.readDataFromPropertyfile("password");
		
		 /*read data from excel-test data*/
		String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 2: Launch the Browser // Run Time Polymorphism - driver
		if(BROWSER.equalsIgnoreCase("chrome"))
		{ 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		
      
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		
		//Step 2: Load the Application
		driver.get(URL);
		
		//Step 3: Login to Application
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		/*
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		*/
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Able to fetch data from POM class");
		
		//Step 4: Navigate to Contacts LInk
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: Click on create conatct look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 6: create conatct
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step 9: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wutil.mouseHoverAction(driver, ele);
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("SignOut successful");

	}

}
