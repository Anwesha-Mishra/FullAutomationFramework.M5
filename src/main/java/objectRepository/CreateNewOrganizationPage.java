package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	//business libraries
	/**
	 * This method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
		
	}
	/**
	 * This method will create new organization with industry dropown
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRYNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRYNAME);
		saveBtn.click();
		
	}
	
	
	/**
	 * This method will create new organization with industry dropown and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRYNAME, String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRYNAME);
		handleDropDown(typeDropDown, TYPE);
		saveBtn.click();
		
	}
	
	

}
