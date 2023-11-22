package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business library
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	public String getOrganizationHeader()
	{
		return orgHeaderText.getText();
	}
	

}
