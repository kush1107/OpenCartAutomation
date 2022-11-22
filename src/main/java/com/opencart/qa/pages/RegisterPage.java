package com.opencart.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class RegisterPage extends TestBase {
	
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver,this);
	}

}
