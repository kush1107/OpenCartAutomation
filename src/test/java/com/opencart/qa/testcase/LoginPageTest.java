package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	
	
	
	public LoginPageTest()	
	{
		super();
	}
	
	@BeforeSuite
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyForgottenpasswordLinkPresent()
	{
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Boolean flag = loginpage.ValidateForgottenpassword_link();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=2)
	public void VerifyLoginUser()
	{
		loginpage.ValidateLogin();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).click();
		Boolean flag = driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
}
