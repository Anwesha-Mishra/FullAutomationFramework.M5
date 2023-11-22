package organizationTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;

import objectRepository.OrgInfoPage;
import objectRepository.OrganiztionsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrganizationWithBCTest extends BaseClass{
	
	@Test(groups ="Smokesuite")
	//@Test(groups={"RegressionSuite","SmokeSuite"})
	public void createNewOrganizationTest() throws Throwable
	 {
		
		/* Test Data */
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		
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
		Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(orgHeader);
			System.out.println("Organization created");
		
	
	 }
	
	@Test
	public void excludeMethod()
	{
		System.out.println("Excluded method running");
	}
	
	

}
