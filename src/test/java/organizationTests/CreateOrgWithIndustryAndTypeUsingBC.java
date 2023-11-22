package organizationTests;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganiztionsPage;


@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrgWithIndustryAndTypeUsingBC extends BaseClass {
	
	@Test
	public void createNewOrganizationWithIndustryAndTypeTest() throws Throwable
	{
	
	
	//CREATE ORGANISATION WITH INDUSTRY-ENERGY and TYPE-CUSTOMER
		
		/* Test Data */
		 /*read data from excel-test data*/
		String ORGANISATIONNAME = eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
		String INDUSTRYNAME= eUtil.readDataFromExcel("Organization", 7, 3);
		String TYPE=eUtil.readDataFromExcel("Organization", 7, 4);
		
		//Navigate to Org link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLnk();
				
				//Click on Org look Up Image
				OrganiztionsPage op = new OrganiztionsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				//Create new Organization with industry and Type
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGANISATIONNAME, INDUSTRYNAME, TYPE);
				System.out.println(ORGANISATIONNAME +INDUSTRYNAME + TYPE +" name saved ");
				
				//validation
				OrgInfoPage oip = new OrgInfoPage(driver);
				String orgHeader = oip.getOrganizationHeader();
				Assert.assertTrue(orgHeader.contains(ORGANISATIONNAME));
					System.out.println(orgHeader);
					System.out.println("---Organization created with industry and type---");
		}
	
}
	
	


