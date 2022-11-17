package com.opencart.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.HomePage;



public class HomePageTest extends TestBase {
	HomePage homepage;
	
	public HomePageTest()	
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 homepage = new HomePage();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test
	public void VerifyPageTitle()
	{
		String text = homepage.ValidateHomePageTitle();
		Assert.assertEquals(text,"Your Store");
	}
}
