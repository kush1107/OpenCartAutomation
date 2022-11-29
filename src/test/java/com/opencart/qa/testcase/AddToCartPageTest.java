package com.opencart.qa.testcase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.AddToCartPage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.qa.util.TestUtil;

public class AddToCartPageTest extends TestBase {
	LoginPage loginpage;
	AddToCartPage addtocartPage;
	
	
	
	@FindBy(linkText= "My Account")
	WebElement myaccount_link;
	
	@FindBy(linkText= "Login")
	WebElement myaccount_login;
	
	@FindBy(id= "input-email")
	WebElement email_id;
	
	@FindBy(id= "input-password")
	WebElement password_id;
	
	@FindBy(xpath= "//input[@value='Login']")
	WebElement login_btn;
	
	public AddToCartPageTest()	
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		addtocartPage = new AddToCartPage();
	}
	
	@AfterMethod   //ITestResult method is added just to see screenshot taken in it. Learning purpose!!
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyAddToCartFunctionality() throws InterruptedException
	{
		
		TestUtil testUtil = new TestUtil();
		testUtil.LoginUser();
		
		Thread.sleep(2000);
		addtocartPage.VerifyAddToCart();
		
	}
}
