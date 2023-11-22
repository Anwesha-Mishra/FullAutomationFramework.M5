package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to web driver actions
 * @author Anwesha
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		//always pass the parameter in the method, if we initialize the driver as null, it will be null throughout and wont be able to use
		//so that we use the updated driver
		//for one line statement also we are creating methods just not to train the freshers in detail we can put everything in the framework itself
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		
		driver.manage().window().minimize();
		
	}
	/**
	 * this method will wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for a particular element to be visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element, String value) 
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 *  This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param text
	 */
	
	public void handleDropDown( String text,WebElement element) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();	
	}
	
	/**
	 * This method will move the cursor based on offset and click on web page
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10,10).click().perform();	
	}
	/**
	 * This method will perform right click
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();	
	}
	
	/**
	 * This method will perform double click action
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();	
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement target )
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	/**
	 * This method will click and hold on to a particular web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or ID
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToFrame(WebDriver driver,String NameOrID)
	{
		driver.switchTo().frame(NameOrID);
	}
	/**
	 * This method will handle frame by webElement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)");
	}
	
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-500)");
	}
	/**
	 * This method will scroll right for 500units
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(500,0);", "");
	}
	
	/**
	 * This method will scroll left for 500units
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(-500,0);", "");
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will fetch the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will capture the screenshot and return the dst path
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenshotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();//complete path of screenshot file-used for extent reports
	}
	
	/**
	 * this method will switch the windows based on partial with title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//step1: capture all the window IDs
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		//step2: navigate through each window ID
		for(String windowID:allWindowIDs)
		{
			
			//step 3- switch to each window and capture the title
			String actTitle= driver.switchTo().window(windowID).getTitle();
			
			//step 4- compare the actual title with expected partial window title
			if(actTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	

}
