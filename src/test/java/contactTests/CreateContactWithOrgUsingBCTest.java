package contactTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganiztionsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithOrgUsingBCTest extends BaseClass {
	
	@Test
	public void createNewContactWithOrgTest() throws Throwable
	{

				/* Test Data */
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
				
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
				
				//Navigate to contacts
				hp.clickOnContactsLnk();
				
				//Click on Create Contact look up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Create  contact with Organization
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, ORGNAME, LASTNAME);
				
				//Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.getContactHeader();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
					
				
	}


}
