package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.HomePage;



public class HomePageTest extends TestBase {
	HomePage homepage;
	JavascriptExecutor js;
	
	String SearchText2 = prop.getProperty("SearchText");
	
	public HomePageTest()	
	{
		super();
	}
	
	@BeforeSuite
	public void setup()
	{
		initialization();
		 homepage = new HomePage();
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void VerifyPageTitle()
	{
		String text = homepage.ValidateHomePageTitle();
		Assert.assertEquals(text,"Your Store");
	}
	
	@Test(priority=2)
	public void VerifyCompanyLogo()
	{
		Assert.assertTrue(homepage.ValidateCompanyLogo());;
	}
	
	@Test(priority=3,dependsOnMethods = { "VerifyPageTitle" })
	public void VerifySearchFunctionality() throws InterruptedException
	{
		homepage.ValidateSearchField();
		
	 //Hardcoded value
	
	
		Thread.sleep(1000);
		if(SearchText2.equals("iphone")) //For Valid search keyword - hardcoded need to change
		{
			
			WebElement	productblock = driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']"));
			Boolean text1 =  productblock.isDisplayed();
			Assert.assertTrue(text1);
			System.out.println(" product found");
		}
		else  //For InValid search keyword
		{
			
			WebElement	noproducttext = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"));	
			
			Assert.assertEquals(noproducttext.getText(),"There is no product that matches the search criteria.");
		}
		
		
	}
}
