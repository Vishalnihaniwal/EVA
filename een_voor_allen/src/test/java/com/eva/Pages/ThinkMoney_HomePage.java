package com.eva.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;
import com.relevantcodes.extentreports.LogStatus;

public class ThinkMoney_HomePage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_HomePage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money HOME PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//a[@href='/logon/']")
	private WebElement LoginButton;
	
	@FindBy(how = How.XPATH, using = "(//a[@href='/account/'])[2]")
	private WebElement OpenAnAccountButton;
	
	
	/** 
	 * Click Open an account button 
	 */
	public void clickOpenAnAccountButton() {
		browserAction.WaittoPageLoad();
		try {
			report.logStepToReport(LogStatus.INFO, "Click", "Open an account button clicked on Home Page", imgPath, OpenAnAccountButton);
			browserAction.clickJS(OpenAnAccountButton);
			System.out.println("Open an account button clicked on Home Page");
		} catch (Exception e) {
			System.out.println("Open an account button not clicked on Home page");
		}
	}
	
}
