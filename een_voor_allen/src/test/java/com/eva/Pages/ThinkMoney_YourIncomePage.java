package com.eva.Pages;

import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_YourIncomePage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_YourIncomePage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Your Income PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your income')]")
	private WebElement YourIncomeTitle;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt236_block_wtInput_Label_wtPrimaryApplicant_Income_Input")
	private WebElement MonthlyIncomeField;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt148_block_wtInput_Label_wtPrimaryApplicant_HowPaid_Input")
	private WebElement HowPaidDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt258_block_wtInput_Label_wtPrimaryApplicant_HowOften_Input")
	private WebElement HowOftenPaidDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt233_block_wtInput_Label_wtPrimaryApplicant_EmploymentStatus_Input")
	private WebElement EmploymentStatusDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt13_block_wtInput_Label_wtPrimaryApplicant_JobTitle_Input")
	private WebElement JobTitleDropdown;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt290_block_wtInput_Label_wtPrimaryApplicant_Input_BusinessName")
	private WebElement BusinessNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt271_block_wtInput_Label_wtPrimaryApplicant_WorkplaceLocation_Input")
	private WebElement WorkplaceLocationField;
	
	/*Second Applicant*/
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt43_block_wtInput_Label_wtSecondApplicant_Income_Input")
	private WebElement SecondApplicantMonthlyIncomeField;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt211_block_wtInput_Label_wtSecondApplicant_HowPaid_Input")
	private WebElement SecondApplicantHowPaidDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt263_block_wtInput_Label_wtSecondApplicant_HowOften_Input")
	private WebElement SecondApplicantHowOftenPaidDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt175_block_wtInput_Label_wtSecondApplicant_EmploymentStatus_Input")
	private WebElement SecondApplicantEmploymentStatusDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt2_block_wtInput_Label_wtSecondApplicant_JobTitle_Input")
	private WebElement SecondApplicantJobTitleDropdown;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt163_block_wtInput_Label_wtSecondApplicant_Input_BusinessName")
	private WebElement SecondApplicantBusinessNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt192_block_wtMainContent_ThinkMoney_Patterns_wt244_block_wtInput_Label_wtSecondApplicant_WorkplaceLocation_Input")
	private WebElement SecondApplicantWorkplaceLocationField;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to set Monthly Income
	 * 
	 * @param testCaseData
	 */
	public void setMonthlyIncome(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			browserAction.setText(MonthlyIncomeField, testCaseData.get("MonthlyIncome"), imgPath, "Monthly Income has been entered");
		} catch (Exception e) {
			System.out.println("Monthly Income has not been entered on Your Income Page");
		}
	}
	
	/***
	 * function to set How Paid
	 * 
	 * @param testCaseData
	 */
	public void setHowPaid(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(HowPaidDropdown, testCaseData.get("HowPaid"), imgPath, "How is this Paid has been selected");
		} catch (Exception e) {
			System.out.println("How is this Paid has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set How Often Paid
	 * 
	 * @param testCaseData
	 */
	public void setHowOftenPaid(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(HowOftenPaidDropdown, testCaseData.get("HowOftenPaid"), imgPath, "How often are you Paid has been selected");
		} catch (Exception e) {
			System.out.println("How often are you Paid has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set Employment Status
	 * 
	 * @param testCaseData
	 */
	public void setEmploymentStatus(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(EmploymentStatusDropdown, testCaseData.get("EmploymentStatus"), imgPath, "Employment Status has been selected");
			if (testCaseData.get("EmploymentStatus").equalsIgnoreCase("Employed full-time") || testCaseData.get("EmploymentStatus").equalsIgnoreCase("Employed part-time") || testCaseData.get("EmploymentStatus").equalsIgnoreCase("Self - Employed")) 
			{
				browserAction.selectFromDD(JobTitleDropdown, testCaseData.get("JobTitle"), imgPath, "Job Title has been selected");
				browserAction.ScrollAndSetText(BusinessNameField, testCaseData.get("BusinessName"), imgPath, "Business Name has been entered");
				browserAction.ScrollAndSetText(WorkplaceLocationField, testCaseData.get("WorkplaceLocation"), imgPath, "Workplace Location has been entered");
			}
		} catch (Exception e) {
			System.out.println("Employment Status has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set Monthly Income for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setMonthlyIncomeSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.setText(SecondApplicantMonthlyIncomeField, testCaseData.get("MonthlyIncomeSecondApplicant"), imgPath, "Monthly Income has been entered for Second Applicant");
		} catch (Exception e) {
			System.out.println("Monthly Income for Second Applicant has not been entered on Your Income Page");
		}
	}
	
	/***
	 * function to set How Paid for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setHowPaidSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(SecondApplicantHowPaidDropdown, testCaseData.get("HowPaidSecondApplicant"), imgPath, "How is this Paid for Second Applicant has been selected");
		} catch (Exception e) {
			System.out.println("How is this Paid for Second Applicant has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set How Often Paid for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setHowOftenPaidSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(SecondApplicantHowOftenPaidDropdown, testCaseData.get("HowOftenPaidSecondApplicant"), imgPath, "How often are you Paid for Second Applicant has been selected");
		} catch (Exception e) {
			System.out.println("How often are you Paid for Second Applicant has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set Employment Status for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setEmploymentStatusSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(SecondApplicantEmploymentStatusDropdown, testCaseData.get("EmploymentStatusSecondApplicant"), imgPath, "Employment Status for Second Applicant has been selected");
			if (testCaseData.get("EmploymentStatusSecondApplicant").equalsIgnoreCase("Employed full-time") || testCaseData.get("EmploymentStatusSecondApplicant").equalsIgnoreCase("Employed part-time") || testCaseData.get("EmploymentStatusSecondApplicant").equalsIgnoreCase("Self - Employed")) 
			{
				browserAction.selectFromDD(SecondApplicantJobTitleDropdown, testCaseData.get("JobTitleSecondApplicant"), imgPath, "Job Title has been selected for Second Applicant");
				browserAction.ScrollAndSetText(SecondApplicantBusinessNameField, testCaseData.get("BusinessNameSecondApplicant"), imgPath, "Business Name has been entered for Second Applicant");
				browserAction.ScrollAndSetText(SecondApplicantWorkplaceLocationField, testCaseData.get("WorkplaceLocationSecondApplicant"), imgPath, "Workplace Location has been entered for Second Applicant");
			}
		} catch (Exception e) {
			System.out.println("Employment Status for Second Applicant has not been selected on Your Income Page");
		}
	}
	
	/***
	 * function to set Your Income Details
	 * 
	 * @param testCaseData
	 */
	public void setYourIncomeDetails(LinkedHashMap<String, String> testCaseData) {
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				setMonthlyIncome(testCaseData);
				setHowPaid(testCaseData);
				setHowOftenPaid(testCaseData);
				setEmploymentStatus(testCaseData);
			}
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				setMonthlyIncome(testCaseData);
				setHowPaid(testCaseData);
				setHowOftenPaid(testCaseData);
				setEmploymentStatus(testCaseData);
				setMonthlyIncomeSecondApplicant(testCaseData);
				setHowPaidSecondApplicant(testCaseData);
				setHowOftenPaidSecondApplicant(testCaseData);
				setEmploymentStatusSecondApplicant(testCaseData);
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("Your Income Details has not been set successfully");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on Your Income page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on Your Income page");
		}
	}
	
}
