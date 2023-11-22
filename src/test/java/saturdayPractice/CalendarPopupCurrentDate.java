package saturdayPractice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupCurrentDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		for(String i:dArr)
		{
		System.out.println(i);
		}
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);

		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//LocalDate date = java.time.LocalDate.now();
		//System.out.println(date);
		
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		
		//Actions act = new Actions(driver);
		//act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		// navigate to desired date in calender
		Thread.sleep(1000);                       //dynamic xpath
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		                             //div[@aria-label='Sat Jul 08 2023']
		                             //div[@aria-label='Sat Jul 09 2023']
		                             //div[@aria-label='Sat Jul 18 2023']
	

	}

}

