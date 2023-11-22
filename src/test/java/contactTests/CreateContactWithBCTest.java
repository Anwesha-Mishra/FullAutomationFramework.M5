package contactTests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithBCTest extends BaseClass {
	
	@Test(groups="RegressionSuite")
	//@Test(groups={"RegressionSuite","SmokeSuite"})
	public void createNewContactTest() throws Throwable 
	 {
				//Step 1:
				 /*read data from excel-test data*/
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
				
				//Step 4: Navigate to Contacts LInk
				HomePage hp = new HomePage(driver);
				hp.clickOnContactsLnk();
				
				//Step 5: Click on create conatct look up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Assert.fail();
				
				//Step 6: create new conatct
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
				
				//Step 7: Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.getContactHeader();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
				
				
				
	 }

}
