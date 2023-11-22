package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganiztionsPage;

public class CreateOrganizationTest {

	@Test
	public void createNewOrganizationTest() throws Throwable
	 {
		
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
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		

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
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Navigate to Org link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		
		//Click on Org look Up Image
		OrganiztionsPage op = new OrganiztionsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Create new Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Validate for Organization
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout
		hp.logoutOfApp(driver);
		
		//close the browser
		driver.quit();
		
		
	}

}
