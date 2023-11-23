package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test  //Hard Assert
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(2, 1);
		System.out.println("Step 3");
	}
	
	
	@Test //Soft Assert
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step 1");
		sa.assertEquals(true, false);
		System.out.println("step 2");
		sa.assertEquals("B", "A");
		System.out.println("Step 3");
		sa.assertAll();// to log the failures---should be the last statement
		System.out.println("done");
	}

}
