package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class RegisterPage extends TestBase {
	
	//Page Factory - OR:
	
	@FindBy(linkText= "My Account")
	WebElement myaccount_link;
	
	@FindBy(linkText= "Register")
	WebElement myaccount_register;
	
//Form Fields 
	
	@FindBy(id= "input-firstname")
	WebElement input_firstname;
	
	@FindBy(id= "input-lastname")
	WebElement input_lastname;
	
	@FindBy(id= "input-email")
	WebElement input_email;
	
	@FindBy(id= "input-telephone")
	WebElement input_telephone;
	
	@FindBy(id= "input-password")
	WebElement input_password;
	
	@FindBy(id= "input-confirm")
	WebElement input_confirm;
	
	@FindBy(xpath= "//input[@name='agree']")
	WebElement agree_checkbox;
	
	@FindBy(xpath= "//input[@value='Continue']")
	WebElement continue_btn;
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void EnterRegisterUserData(String firstname1,String lastname1,String Email1,String telephone1,String password1,String confirm1)
	{
		myaccount_link.click();
		myaccount_register.click();
		input_firstname.sendKeys(firstname1);
		input_lastname.sendKeys(lastname1);
		input_email.sendKeys(Email1);
		input_telephone.sendKeys(telephone1);
		input_password.sendKeys(password1);
		input_confirm.sendKeys(confirm1);
		agree_checkbox.click();
		continue_btn.click();
	}
	

}
