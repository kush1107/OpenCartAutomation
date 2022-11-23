package com.opencart.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.RegisterPage;
import com.opencart.qa.util.TestUtil;

public class RegisterPageTest extends TestBase {
	RegisterPage registerpage;
	JavascriptExecutor js;
	
	String sheetName = "RegisterPage";
	
	
	
	public RegisterPageTest()	
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		registerpage = new RegisterPage();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@DataProvider()
	public Object[][] getRegisterUserdata()
	{
		Object data[][] = TestUtil.getTestData( sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider = "getRegisterUserdata")
	public void VerifyRegisterUser(String firstname,String lastname, String Email,String telephone,String password,String confirm)
	{
		registerpage.EnterRegisterUserData(firstname,lastname,  Email ,telephone,password, confirm);
		String account_created_msg = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(account_created_msg,"Your Account Has Been Created!");
	}
	
	@Test(priority=2,dataProvider = "getRegisterUserdata")
	public void VerifyUserAlreadyRegister(String firstname,String lastname, String Email,String telephone,String password,String confirm)
	{
		registerpage.EnterRegisterUserData(firstname,lastname,  Email ,telephone,password, confirm);
		String account_alreadycreated_msg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(account_alreadycreated_msg,"Warning: E-Mail Address is already registered!");
	}
	
	

}
