package com.opencart.qa.pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath= "//input[@placeholder='Search']")
	WebElement searchfield;
	
	@FindBy(xpath= "//button[@class='btn btn-default btn-lg']")
	WebElement search_btn;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public void ValidateSearchField()
	{
		
		searchfield.sendKeys(prop.getProperty("SearchText"));
		search_btn.click();
		
	}
	
}
