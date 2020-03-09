package com.eva.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_LegalStuffPage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_LegalStuffPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Legal Stuff PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'The legal stuff')]")
	private WebElement LegalStuffTitle;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt43_block_wtMainContent_wtTermsAndConditionsCheckBox")
	private WebElement TermsAndConditionCheckbox;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Submit')]")
	private WebElement SubmitButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to select Terms and Condition
	 * 
	 * @param testCaseData
	 */
	public void setTermsAndCondition() {
		try {
			clickTermsAndConditionCheckbox();
			clickSubmitButton();
		} catch (Exception e) {
			System.out.println("Your Income Details has not been set successfully");
		}
	}
	
	/** 
	 * Click Terms and Condition checkbox 
	 */
	public void clickTermsAndConditionCheckbox() {
		try {
			browserAction.WaittoPageLoad();
			browserAction.waitForElement(TermsAndConditionCheckbox);
			browserAction.click(TermsAndConditionCheckbox, imgPath, "Terms and Condition checkbox clicked");
		} catch (Exception e) {
			System.out.println("Terms and Condition checkbox not clicked on Legal stuff page");
		}
	}
	
	/** 
	 * Click Submit button 
	 */
	public void clickSubmitButton() {
		try {
			browserAction.waitForElement(SubmitButton);
			browserAction.click(SubmitButton, imgPath, "Submit button clicked on Legal stuff Page");
		} catch (Exception e) {
			System.out.println("Submit button not clicked on Legal stuff page");
		}
	}
	
}
