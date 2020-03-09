package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_ApplyProcessHomePage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_ApplyProcessHomePage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Apply Process Home PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//label//span[text()='Single account']")
//	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountType_RadioValidationMessageWrapper_block_wtWrapper_WebPatterns_wt61_block_wtRadioButtonText")	
	private WebElement SingleAccountButton;
	
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountType_RadioValidationMessageWrapper_block_wtWrapper_WebPatterns_wt61_block_wtRadioButtonText2")
	private WebElement JointAccountButton;
	
//	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountReason_RadioValidationMessageWrapper_block_wtWrapper_ThinkMoney_Patterns_wt105_block_wtWrapper_ThinkMoney_Patterns_wt6_block_wtCheckBox_wtBillsRadioOption")
	@FindBy(how = How.XPATH, using = "//div/label[text()='Income and bills']/../..//input")
	private WebElement IncomeAndBillsRadioButton;
	
	@FindBy(how = How.XPATH, using = "//div/label[text()='Spending money']/../..//input")
//	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountReason_RadioValidationMessageWrapper_block_wtWrapper_ThinkMoney_Patterns_wt105_block_wtWrapper_ThinkMoney_Patterns_wt23_block_wtCheckBox_wtCreditRadioOption")
	private WebElement SpendingMoneyRadioButton;
	
	@FindBy(how = How.XPATH, using = "//div/label[text()='Borrowing money']/../..//input")
//	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountReason_RadioValidationMessageWrapper_block_wtWrapper_ThinkMoney_Patterns_wt105_block_wtWrapper_ThinkMoney_Patterns_wt62_block_wtCheckBox_wtIncomeSpendingRadioOption")
	private WebElement BorrowingMoneyRadioButton;

	@FindBy(how = How.XPATH, using = "//div/label[text()='Second account']/../..//input")
//	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt98_block_wtMainContent_ThinkMoney_Patterns_wtAccountReason_RadioValidationMessageWrapper_block_wtWrapper_ThinkMoney_Patterns_wt105_block_wtWrapper_ThinkMoney_Patterns_wt3_block_wtCheckBox_wtSecondAccountRadioOption")
	private WebElement SecondAccountRadioButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;
	
	
	/***
	 * function to Set Account Type i.e. Single or Joint Account
	 * @param testCaseData
	 */
	public void chooseAccountType(LinkedHashMap <String,String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				browserAction.click(SingleAccountButton, imgPath, "Selecting Single Account");
				report.assertThat(SingleAccountButton.getAttribute("class").contains("active"), "Single Account button has been selected successfully", "Single Account button has not been selected successfully");
			} 
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				browserAction.clickJS(JointAccountButton, imgPath, "Selecting Joint Account");
				report.assertThat(JointAccountButton.getAttribute("class").contains("active"), "Joint Account button has been selected successfully", "Joint Account button has not been selected successfully");
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
		} catch (Exception e) {
			System.out.println("Account Type has not been selected");
		}
	}
	
	/***
	 * function to Set Account Usage Purpose i.e. Income and bills, Spending money, Borrowing money, Second account
	 * @param testCaseData
	 */
	public void chooseAccountUsagePurpose(LinkedHashMap <String,String> testCaseData)
	{
		try {
			if (testCaseData.get("AccountUsagePurpose").equalsIgnoreCase("Income and bills"))
			{
				browserAction.clickJS(IncomeAndBillsRadioButton, imgPath, "Selecting Income and bills");
				report.assertThat(IncomeAndBillsRadioButton.isSelected(), "Income and bills button has been selected successfully", "Income and bills button has not been selected successfully");
			}
			else if (testCaseData.get("AccountUsagePurpose").equalsIgnoreCase("Spending money")) {
				browserAction.clickJS(SpendingMoneyRadioButton, imgPath, "Selecting Spending money");
				report.assertThat(SpendingMoneyRadioButton.isSelected(), "Spending money button has been selected successfully", "Spending money button has not been selected successfully");
			}
			else if (testCaseData.get("AccountUsagePurpose").equalsIgnoreCase("Borrowing money")) {
				browserAction.clickJS(BorrowingMoneyRadioButton, imgPath, "Selecting Borrowing money");
				report.assertThat(BorrowingMoneyRadioButton.isSelected(), "Borrowing money button has been selected successfully", "Borrowing money button has not been selected successfully");
			}
			else if (testCaseData.get("AccountUsagePurpose").equalsIgnoreCase("Second account")) 
			{
				browserAction.clickJS(SecondAccountRadioButton, imgPath, "Selecting Second account");
				report.assertThat(SecondAccountRadioButton.isSelected(), "Second account button has been selected successfully", "Second account button has not been selected successfully");
			}
			else
			{
				System.out.println("Account Usage purpose is wrong. Please enter the valid account usage purpose.");
			}
		} catch (Exception e) {
			System.out.println("Account Usage purpose has not been selected");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on Apply Process Home Page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on Apply Process Home Page");
		}
	}
	
	/***
	 * function to set Account Details
	 * 
	 * @param testCaseData
	 */
	public void setAccountDetails(LinkedHashMap<String, String> testCaseData) {
		try {
			chooseAccountType(testCaseData);
			chooseAccountUsagePurpose(testCaseData);
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("Details has not been set successfully on Apply Process Home Page");
		}
	}
	
}
