package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.HomePage;



public class HomePageTest extends TestBase {
	HomePage homepage;
	JavascriptExecutor js;
	
	
	
	public HomePageTest()	
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		 homepage = new HomePage();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void VerifyPageTitle()
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		String text = homepage.ValidateHomePageTitle();
		Assert.assertEquals(text,"Your Store");
	}
	
	@Test(priority=2)
	public void VerifyCompanyLogo()
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		Assert.assertTrue(homepage.ValidateCompanyLogo());;
	}
	
	@Test(priority=3,dependsOnMethods = { "VerifyPageTitle" })
	public void VerifySearchFunctionality() throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		String SearchText2 = prop.getProperty("SearchText");
		homepage.ValidateSearchField();
		
	 //Hardcoded value
		if(SearchText2.equals("iphone"))
		{
Boolean productblock = driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']")).isDisplayed();
			
			Assert.assertTrue(productblock);
			System.out.println(" product found");
		}
		
		else
		{
			System.out.println("No Product Found");
		}
	
	}
		
		
		
	@Test(priority=4)
	public void VerifyAccount_LoginRedirection() throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		homepage.ValidateMyAccount_Login();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Account Login");
	}
	
	@Test(priority=5)
	public void VerifyAccount_RegisterRedirection() throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		homepage.ValidateMyAccount_Register();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Register Account");
	}
}
