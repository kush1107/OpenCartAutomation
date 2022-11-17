package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class HomePage extends TestBase {

	
	
	//Page Factory - OR:
	
	@FindBy(linkText= "My Account")
	WebElement myaccount_link;
	
	@FindBy(linkText= "Wish List (0)")
	WebElement wishlist_link;
	
	@FindBy(linkText= "Shopping Cart")
	WebElement shoppingcart_link;
	
	@FindBy(linkText= "Checkout")
	WebElement checkout_link;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
}
