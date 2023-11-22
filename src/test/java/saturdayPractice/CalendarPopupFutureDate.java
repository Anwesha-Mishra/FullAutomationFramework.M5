package saturdayPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupFutureDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		// navigate to any future Date date in calendar 
		/*
		while(true)
		{
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();//forward arrow
		String month=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		System.out.println(month);
		if(month.equalsIgnoreCase("December 2023"))
		{
			driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click();
			break;
		}
		}
		*/
		
		
		for(;;)//infinite loop
		{
			try 
			{ //not visible - exception - visible - click()
				driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click(); // No such element exception
				break;
			} 
			catch (Exception e) 
			{//click on next month
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
			}
		}

	}
}


