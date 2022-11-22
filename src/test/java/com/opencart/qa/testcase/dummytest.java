package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dummytest  {
	
	
	public  WebDriver driver;
	public  JavascriptExecutor je;
	
	
//	//public TestUtil testUtil ;
//	@FindBy(xpath = "//a[normalize-space()='Brands']")
//	WebElement Link;
	
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test
	public void DummytestPass() throws InterruptedException
	{
		
		
		
		je = (JavascriptExecutor) driver;

		// now execute query which actually will scroll until that element is not appeared on page.

		je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		

		// Extract the text and verify
		
		
	}
	
//	public  WebDriver ScrollToElementVisible(WebElement element)
//	{
//		
//
//		// Create instance of Javascript executor
//
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//
//		// now execute query which actually will scroll until that element is not appeared on page.
//
//		je.executeScript("arguments[0].scrollIntoView(true);", element);
//
//		// Extract the text and verify
//		return driver;
//		
//	}

}
