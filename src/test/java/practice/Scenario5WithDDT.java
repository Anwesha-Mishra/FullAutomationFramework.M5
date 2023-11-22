package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5WithDDT {

	public static void main(String[] args) throws Throwable {
		
		///CREATE CONTACT AND CHOOOSE THE ORGANISATION FROM THE LOOK UP ICON AND SAVE
		//Step 1: Read all the necessary Data
		 /*read data from property file-common data*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		 /*read data from excel-test data*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(4).getCell(2).getStringCellValue();
		String ORGANISATIONNAME = wb.getSheet("Contacts").getRow(4).getCell(3).getStringCellValue();
		
		
		WebDriver driver=null;
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the Application
		driver.get(URL);
		
		//Step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to Contacts LInk
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: Click on create conatct look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 6: create conatct
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step:7 click on organization look up icon
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Thread.sleep(2000);
		
		String mainwin=driver.getWindowHandle();
		System.out.println(mainwin);
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin);
		
		for(String a: allwin)
		{
			if(!mainwin.equals(a))
			{
				driver.switchTo().window(a);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[.='"+ORGANISATIONNAME+"']")).click();
			}
		}
		driver.switchTo().window(mainwin);
		Thread.sleep(2000);
		
		
		//Step 8: Save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		System.out.println(ORGANISATIONNAME +LASTNAME +" name saved ");
		
		Thread.sleep(2000);
		//Step 10: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("SignOut successful");


	}

}
