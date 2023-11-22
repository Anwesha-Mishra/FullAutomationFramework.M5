package contactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
	
	@Test
	public void createNewContactTest() throws Throwable
	 {
		
		//create objects of all utilities
				ExcelFileUtility eutil = new ExcelFileUtility();
				JavaUtility jutil = new JavaUtility();
				PropertyFileUtility putil = new PropertyFileUtility();
				WebDriverUtility wutil= new WebDriverUtility();
				WebDriver driver = null;
				
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
				driver.get(URL);
				
				//Step 3: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//Step 4: Navigate to Contacts LInk
				HomePage hp = new HomePage(driver);
				hp.clickOnContactsLnk();
				
				//Step 5: Click on create conatct look up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Step 6: create new conatct
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
				
				//Step 7: Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.getContactHeader();
				
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				
				//Step 8: Logout
				hp.logoutOfApp(driver);
				
				//step9: close the browser
				driver.quit();

	}

}
