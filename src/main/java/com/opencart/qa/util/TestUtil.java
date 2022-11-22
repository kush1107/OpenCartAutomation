package com.opencart.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIMEOUT = 20;
	public static final long IMPLICIT_WAIT = 10;
	
	public TestUtil()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void SwitchToFrame()  //Switch Frame method
	{
		driver.switchTo().frame("mainframe");
	}
	
	
	public  void ScrollToBottom() throws InterruptedException   //Scroll to bottom method
	{
		

		JavascriptExecutor je = (JavascriptExecutor) driver;

		// now execute query which actually will scroll until that element is not appeared on page.

		je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);

		
	}

}
