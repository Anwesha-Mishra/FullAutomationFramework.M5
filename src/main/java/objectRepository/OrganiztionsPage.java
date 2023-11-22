package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganiztionsPage {

	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	public OrganiztionsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//business library
	/**
	 * This method will click on create org look up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		createOrgLookUpImg.click();
	}
	
}
