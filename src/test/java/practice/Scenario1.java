package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Anwesha");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(1000);
		//validation
		 WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 String text = ele.getText();
		 
		if(text.contains("Anwesha"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		driver.findElement(By.xpath("(//td[@class='small' and @valign='bottom'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		System.out.println("Logout successful");
				

	}

}
