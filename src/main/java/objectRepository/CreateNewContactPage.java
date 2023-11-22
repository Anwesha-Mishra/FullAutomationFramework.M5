package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement orgLookUpImg;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy (name="search")
	private WebElement OrgSearchBtn;
	
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//business library
	/**
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();

	}
	/**
	 * This method will create contact by choosing the organization
	 * @param driver
	 * @param ORGNAME
	 * @param LASTNAME
	 */
	public void createNewContact(WebDriver driver, String ORGNAME, String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	

}
