package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {

	SearchPage searchpage;
	JavascriptExecutor js;
	
	String SearchText2 = prop.getProperty("SearchText");
	
	public SearchPageTest()	
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		 searchpage = new SearchPage();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1) 
	public void VerifyValidKeyword_search()
	{
		Boolean valid_search = searchpage.ValidateSearchField_with_validkeyword();
		Assert.assertTrue(valid_search);
	}
	
	@Test (priority=2)
	public void VerifyInValidKeyword_search()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		Boolean invalid_search = searchpage.ValidateSearchField_with_invalidkeyword();
		Assert.assertTrue(invalid_search);
	}
}
