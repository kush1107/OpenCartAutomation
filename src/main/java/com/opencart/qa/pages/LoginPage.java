package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	
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
	
	@FindBy(linkText= "Forgotten Password")
	WebElement forgot_password_link;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ValidateLogin()
	{
		myaccount_link.click();
		myaccount_login.click();
		email_id.sendKeys(prop.getProperty("username"));
		password_id.sendKeys(prop.getProperty("password"));
		login_btn.click();
	}
	
	public Boolean ValidateForgottenpassword_link()
	{
		return  forgot_password_link.isDisplayed();
		
	}

}
