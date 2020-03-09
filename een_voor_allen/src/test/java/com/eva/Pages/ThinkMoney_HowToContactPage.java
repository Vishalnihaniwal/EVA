package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_HowToContactPage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_HowToContactPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money How to Contact PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'How we contact you')]")
	private WebElement HowToContactTitle;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtEmailValidationMessageWrapper_block_wtWrapper_WebPatterns_wt78_block_wtRadioButtonText")
	private WebElement EmailYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtEmailValidationMessageWrapper_block_wtWrapper_WebPatterns_wt78_block_wtRadioButtonText2")
	private WebElement EmailNoButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtTextValidationMessageWrapper_block_wtWrapper_WebPatterns_wt60_block_wtRadioButtonText")
	private WebElement TextMessageYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtTextValidationMessageWrapper_block_wtWrapper_WebPatterns_wt60_block_wtRadioButtonText2")
	private WebElement TextMessageNoButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtTelephoneValidationMessageWrapper_block_wtWrapper_WebPatterns_wt18_block_wtRadioButtonText")
	private WebElement TelephoneYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt92_block_wtMainContent_ThinkMoney_Patterns_wtTelephoneValidationMessageWrapper_block_wtWrapper_WebPatterns_wt18_block_wtRadioButtonText2")
	private WebElement TelephoneNoButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to set How to Contact details
	 * 
	 * @param testCaseData
	 */
	public void setHowToContactDetails(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			
			/*Email*/
			if (testCaseData.get("ContactEmail").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(EmailYesButton, imgPath, "Selecting Email as Yes to receive information");
				report.assertThat(EmailYesButton.getAttribute("class").contains("active"), "Email Yes button has been selected successfully", "Email Yes button has not been selected successfully");
			}
			else
			{
				browserAction.click(EmailNoButton, imgPath, "Selecting Email as No to receive information");
				report.assertThat(EmailNoButton.getAttribute("class").contains("active"), "Email No button has been selected successfully", "Email No button has not been selected successfully");
			}
			
			/*Text Message*/
			if (testCaseData.get("ContactTextMessage").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(TextMessageYesButton, imgPath, "Selecting Text Message as Yes to receive information");
				report.assertThat(TextMessageYesButton.getAttribute("class").contains("active"), "Text Message Yes button has been selected successfully", "Text Message Yes button has not been selected successfully");
			}
			else
			{
				browserAction.click(TextMessageNoButton, imgPath, "Selecting Text Message as No to receive information");
				report.assertThat(TextMessageNoButton.getAttribute("class").contains("active"), "Text Message No button has been selected successfully", "Text Message No button has not been selected successfully");
			}
			
			/*Telephone*/
			if (testCaseData.get("ContactTelephone").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(TelephoneYesButton, imgPath, "Selecting Telephone as Yes to receive information");
				report.assertThat(TelephoneYesButton.getAttribute("class").contains("active"), "Telephone Yes button has been selected successfully", "Telephone Yes button has not been selected successfully");
			}
			else
			{
				browserAction.click(TelephoneNoButton, imgPath, "Selecting Telephone as No to receive information");
				report.assertThat(TelephoneNoButton.getAttribute("class").contains("active"), "Telephone No button has been selected successfully", "Telephone No button has not been selected successfully");
			}
			
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("How to Contact Details has not been set successfully");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on How to Contact page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on How to Contact page");
		}
	}
	
}
