package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opencart.qa.base.TestBase;

public class SearchPage extends TestBase {
	
	
	//Page Factory - OR:
	
	@FindBy(xpath= "//input[@placeholder='Search']")
	WebElement searchfield;
	
	@FindBy(xpath= "//button[@class='btn btn-default btn-lg']")
	WebElement search_btn;
	
	public SearchPage()
	{
		PageFactory.initElements(driver,this);
	}

	public Boolean ValidateSearchField_with_validkeyword()
	{
		
		searchfield.sendKeys(prop.getProperty("SearchText"));
		search_btn.click();
		WebElement	productblock = driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']"));
		return productblock.isDisplayed();
		
	}
	
	public Boolean ValidateSearchField_with_invalidkeyword()
	{
		
		searchfield.sendKeys(prop.getProperty("SearchText_invalid"));
		search_btn.click();
		WebElement	noproducttext = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"));	
		return noproducttext.isDisplayed();
      }
}
