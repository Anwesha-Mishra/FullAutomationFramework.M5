package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getcreateContactLookUpIcon() {
		return createContactLookUpImg;
	}
	
	//Business library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
	}

}
