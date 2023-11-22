package practice;

import java.io.IOException;

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

public class Scenario6withDDTandGU {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		/**
		 * navigate to product
		 * create product with mandatory fields
		 * click on vendor lookup image and choose the vendor
		 * save validate and logout
		 */
		
		// Create Object of all Utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;
		
		// Step 1: Read all the required Data
		/* Common Data */
		String BROWSER = pUtil.readDataFromPropertyfile("browser");
		String URL = pUtil.readDataFromPropertyfile("url");
		String USERNAME = pUtil.readDataFromPropertyfile("username");
		String PASSWORD = pUtil.readDataFromPropertyfile("password");
		
		/* Test Data */
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);
		String VENDORNAME = eUtil.readDataFromExcel("Products", 1, 3);
		
		// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
		if (BROWSER.equalsIgnoreCase("Chrome"))// true f
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge"))// f
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		// Step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to Vendors
		//WebElement moreoption = driver.findElement(By.linkText("More"));
		//wUtil.mouseHoverAction(driver, moreoption);
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Vendors")).click();
		
		//Step 5: Click on Create Vendor look up Image
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
		//Step 6: Create Vendor With Mandatory fields
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		
		//Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String VendorHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(VendorHeader.contains(VENDORNAME))
		{
			System.out.println(VendorHeader);
			System.out.println("Vendor created");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		// Step 9: navigate to Products link
		driver.findElement(By.linkText("Products")).click();

		// Step 10: click on create Product look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		// Step 11: create Product with mandatory fields
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);

		// Step 12: Click on Vendor look Up Image
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		//Step 13: switch the control to child window
		wUtil.switchToWindow(driver, "Vendors");
		System.out.println("switched to child window");
		
		// Step 14: search for Vendors
		driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).click();
		
		// Step 15: swicth the control back to parent
		wUtil.switchToWindow(driver, "Products");
		System.out.println("swicthed back to parent");

		// Step 12: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 13: Validate
		String productHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (productHeader.contains(PRODUCTNAME)) {
			System.out.println(productHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 14: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		wUtil.mouseHoverAction(driver, ele);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout is successfull");
		

	}

}
