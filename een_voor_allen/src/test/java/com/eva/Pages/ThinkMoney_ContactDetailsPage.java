package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_ContactDetailsPage {
	
	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_ContactDetailsPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Contact Details PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Contact details')]")
	private WebElement ContactDetailsTitle;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt48_block_wtMainContent_ThinkMoney_Patterns_wt99_block_wtInput_Label_wtPrimaryApplicant_EmailAddress_Input")
	private WebElement EmailAddressField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt48_block_wtMainContent_ThinkMoney_Patterns_wt14_block_wtInput_Label_wtPrimaryApplicant_ContactNumber_Input")
	private WebElement ContactNumberField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt48_block_wtMainContent_ThinkMoney_Patterns_wt49_block_wtInput_Label_wtSecondApplicant_EmailAddress_Input")
	private WebElement SecondApplicantEmailAddressField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt48_block_wtMainContent_ThinkMoney_Patterns_wt74_block_wtInput_Label_wtSecondApplicant_ContactNumber_Input")
	private WebElement SecondApplicantContactNumberField;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to set Contact details
	 * 
	 * @param testCaseData
	 */
	public void setContactDetailsFirstApplicant(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			browserAction.setText(EmailAddressField, testCaseData.get("EmailAddress"), imgPath,"Email Address has been entered");
			browserAction.setText(ContactNumberField, testCaseData.get("ContactNumber"), imgPath,"Contact Number has been entered");
		} catch (Exception e) {
			System.out.println("Contact Details has not been set successfully");
		}
	}
	
	/***
	 * function to set Contact details for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setContactDetailsSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.setText(SecondApplicantEmailAddressField, testCaseData.get("EmailAddressSecondApplicant"), imgPath,"Email Address for Second Applicant has been entered");
			browserAction.setText(SecondApplicantContactNumberField, testCaseData.get("ContactNumberSecondApplicant"), imgPath,"Contact Number for Second Applicant has been entered");
		} catch (Exception e) {
			System.out.println("Contact Details for Second Applicant has not been set successfully");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on Contact Details page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on Contact Details page");
		}
	}
	
	/***
	 * function to set Contact details
	 * 
	 * @param testCaseData
	 */
	public void setContactDetails(LinkedHashMap<String, String> testCaseData) {
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				setContactDetailsFirstApplicant(testCaseData);
			}
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				setContactDetailsFirstApplicant(testCaseData);
				setContactDetailsSecondApplicant(testCaseData);
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("Contact Details has not been set successfully");
		}
	}
	
}
