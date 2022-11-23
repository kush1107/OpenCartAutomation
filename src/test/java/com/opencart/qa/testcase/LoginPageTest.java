package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	
	
	
	public LoginPageTest()	
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyForgottenpasswordLinkPresent() throws InterruptedException
	{
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);
		Boolean flag = loginpage.ValidateForgottenpassword_link();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=2)
	public void VerifyLoginUser() throws InterruptedException
	{
		
		loginpage.ValidateLogin();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).click();
		Boolean flag = driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
}
