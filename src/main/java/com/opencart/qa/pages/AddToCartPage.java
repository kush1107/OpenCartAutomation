package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class AddToCartPage extends TestBase{
	
	
	
	
	//Page Factory - OR:
	
		@FindBy(xpath= "//a[normalize-space()='Desktops']")
		WebElement DesktopMenu_link;
		
		@FindBy(xpath= "//a[normalize-space()='Mac (1)']")
		WebElement MacMenu_link;
		
		@FindBy(xpath= "//span[normalize-space()='Add to Cart']")
		WebElement AddToCart_button;
		
		
		
		
		
		@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']")
		WebElement productadded_msg;
		
		public AddToCartPage()
		{
			PageFactory.initElements(driver,this);
		}

		
		public void VerifyAddToCart() throws InterruptedException
		{
			Actions act = new Actions(driver);
			act.moveToElement(DesktopMenu_link).build().perform();
			MacMenu_link.click();
			AddToCart_button.click();
			Thread.sleep(2000);
			if(productadded_msg.isDisplayed()==true)
			{
			String msg = productadded_msg.getText();
			System.out.println(msg);
			}
			
			else
			{
				System.out.println("Product is not added successfully & testcase failed.");
			}
			
		}
}
