package com.eva.Business;

import org.openqa.selenium.WebDriver;

import com.eva.Reports.Reporting;
import com.eva.Utils.FuncBank;
import com.eva.Utils.ImageComparator;

import problems.evaException;

public class SIMPLYBE {

	FuncBank fb ;
	WebDriver driver; 
	Reporting repo;
	
	
	public SIMPLYBE(WebDriver driver, Reporting repo)
	{
		this.driver = driver;
		this.repo = repo;
		fb = new FuncBank(driver, repo);
	}
	
	public void SelectAProd() throws evaException, InterruptedException
	{
		try
		{
			String url = "https://www.simplybe.com/en-au/";
			driver.navigate().to(url);
	
			new ImageComparator().checkVisual4Page(driver, "HomePage", repo);
			fb.performAction("Click","cssSelector", "div>a.backToShop", "", "Click on optional image", true);
			
			
			fb.performAction("Click","cssSelector", "a>img.showdesk", "", "Click on main image", true);
	//		fb.performAction("Click","cssSelector", "div>a.big-cta", "", "Click on 'ALL DRESSES' link", true);
			fb.performAction("Click", "cssSelector", "p.product-title>a", "", "Click on first available item", true);
			fb.performAction("Click", "cssSelector", "button[data-variantcode = size]", "", "Click on Size button", true);
//			fb.performAction("Click", "cssSelector", "button.btn.btn-ui-primary.btn-block", "", "Click on 'Add To Bag' button", true);
//			Thread.sleep(2000);
//			fb.performAction("Click", "cssSelector", "a[data-value=continue-to-checkout]", "", "Click on 'Continue to Checkout' button", true);
//			Thread.sleep(2000);
//			fb.performAction("Click", "cssSelector", "button#GoToCheckoutTOP", "", "Click on top 'Checkout' button", true);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}
