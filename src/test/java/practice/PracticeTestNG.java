package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestNG {

	/*
	///based on ascii values it will execute
		@Test(priority=1, invocationCount=3)
		public void c()
		{
			System.out.println("Hi testng working");
		}
		@Test
		public void b()
		{
			
			System.out.println("failed test");
		}
		
		@Test(priority=2)
		public void a()
		{
			
			System.out.println("passed test");
		}
		

		@Test
		public void D()
		{
			
			System.out.println("no priority will execute as per ascii");
		}
		
		@Test(priority=-2)
		public void negative()
		{
			
			System.out.println("It accepts negative values, and will execute first");
		}
		
		@Test(priority=0)
		public void defaultValue()
		{
			
			System.out.println("default value of priority is zero");
		}
		
		@Test(invocationCount=-1)//disabled, not considered for execution
		public void invocationmethod()
		{
			
			System.out.println("not get executed if 0 or negatives");
		}
		
		@Test(enabled=false)
		public void enableMethod()
		{
			
			System.out.println("enabled=false, will not execute");
		}
		
		*/
	
	@Test
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		
		System.out.println("modify");
	}
	
	@Test
	public void deleteCustomer()
	{
		
		System.out.println("delete");
	}
	

}
