package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.util.TestUtil;

public class dummytest extends TestBase {
	
	
	
	TestUtil testUtil ;
	
	
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
		
		
		
		
	}
}
