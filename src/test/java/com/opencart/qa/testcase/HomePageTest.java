package com.opencart.qa.testcase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 homepage = new HomePage();
	}
	
	@AfterMethod   //ITestResult method is added just to see screenshot taken in it. Learning purpose!!
	public void tearDown(ITestResult result)
	{

	
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + result.getName() + ".png"));
	System.out.println("Screenshot taken");
	
	} 
	catch (Exception e)
	{
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	
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
		
		homepage.ValidateSearchField();
		String title = driver.getTitle();
		System.out.println(title);
		
	
	
	}
		
		
		
	@Test(priority=4)
	public void VerifyAccount_LoginRedirection() throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		homepage.ValidateMyAccount_Login();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(),"Account Login");
	}
	
	@Test(priority=5)
	public void VerifyAccount_RegisterRedirection() throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("navigate_url"));
		homepage.ValidateMyAccount_Register();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(),"Register Account");
	}
}
