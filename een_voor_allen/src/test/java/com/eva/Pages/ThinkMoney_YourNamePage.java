package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_YourNamePage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_YourNamePage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Your Name PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your name')]")
	private WebElement YourNameTitle;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt113_block_wtInput_Label_wtPrimaryApplicantTitle_Input")
	private WebElement TitleDropdown;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt82_block_wtInput_Label_wtPrimaryApplicantFirstName_Input")
	private WebElement FirstNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt42_block_wtInput_Label_wtPrimaryApplicantMiddleName_Input")
	private WebElement MiddleNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt26_block_wtInput_Label_wtPrimaryApplicantSurname_Input")
	private WebElement SurnameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt101_block_wtInput_Label_wtPrimaryApplicantDateOfBirth_Input")
	private WebElement DateOfBirthField;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt17_block_wtInput_Label_wtSecondApplicantTitle_Input")
	private WebElement SecondApplicantTitleDropdown;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt14_block_wtInput_Label_wtSecondApplicantFirstName_Input")
	private WebElement SecondApplicantFirstNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt134_block_wtInput_Label_wtSecondApplicantMiddleName_Input")
	private WebElement SecondApplicantMiddleNameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt47_block_wtInput_Label_wtSecondApplicantSurname_Input")
	private WebElement SecondApplicantSurnameField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt102_block_wtMainContent_ThinkMoney_Patterns_wt118_block_wtInput_Label_wtSecondApplicantDateOfBirth_Input")
	private WebElement SecondApplicantDateOfBirthField;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to set Title from Mr, Mrs, Miss, Ms, Dr for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setTitle(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			browserAction.selectFromDD(TitleDropdown, testCaseData.get("Title"), imgPath, "Title has been selected");
		} catch (Exception e) {
			System.out.println("Title for First Applicant has not been selected on Your Name page");
		}
	}
	
	/***
	 * function to set First Name,Middle name and Last Name for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setName(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.ScrollAndSetText(FirstNameField, testCaseData.get("FirstName"), imgPath,"FirstName has been entered");
			if (!(testCaseData.get("MiddleName").equals("") | testCaseData.get("MiddleName").equals(null))) 
			{
				browserAction.ScrollAndSetText(MiddleNameField, testCaseData.get("MiddleName"), imgPath,"MiddleName has been entered");
			}
			browserAction.ScrollAndSetText(SurnameField, testCaseData.get("Surname"), imgPath, "Surname has been entered");
		} catch (Exception e) {
			System.out.println("First, Middle or Last name has not been entered on Your Name page");
		}
	}

	/***
	 * function to set Date of Birth for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setDOB(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.ScrollAndSetText(DateOfBirthField, testCaseData.get("DateOfBirth"), imgPath, "Date of Birth has been entered");
		} catch (Exception e) {
			System.out.println("Date of Birth has not been entered on Your Name page");
		}
	}
	
	/***
	 * function to set Title from Mr., Mrs, Miss, Ms, Dr for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setTitleSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(SecondApplicantTitleDropdown, testCaseData.get("TitleSecondApplicant"), imgPath, "Title for Second Applicant has been selected");
		} catch (Exception e) {
			System.out.println("Title for Second Applicant has not been selected on Your Name page");
		}
	}
	
	/***
	 * function to set First Name,Middle name and Last Name for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setNameSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.ScrollAndSetText(SecondApplicantFirstNameField, testCaseData.get("FirstNameSecondApplicant"), imgPath,"FirstName for Second Applicant has been entered");
			if (!(testCaseData.get("MiddleNameSecondApplicant").equals("") | testCaseData.get("MiddleNameSecondApplicant").equals(null))) 
			{
				browserAction.ScrollAndSetText(SecondApplicantMiddleNameField, testCaseData.get("MiddleNameSecondApplicant"), imgPath,"MiddleName for Second Applicant has been entered");
			}
			browserAction.ScrollAndSetText(SecondApplicantSurnameField, testCaseData.get("SurnameSecondApplicant"), imgPath, "Surname for Second Applicant has been entered");
		} catch (Exception e) {
			System.out.println("First, Middle or Last name for Second Applicant has not been entered on Your Name page");
		}
	}

	/***
	 * function to set Date of Birth for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setDOBSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.ScrollAndSetText(SecondApplicantDateOfBirthField, testCaseData.get("DateOfBirthSecondApplicant"), imgPath, "Date of Birth for Second Applicant has been entered");
		} catch (Exception e) {
			System.out.println("Date of Birth for Second Applicant has not been entered on Your Name page");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on Your Name page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on Your Name page");
		}
	}
	
	/***
	 * function to set Details on Your name page
	 * 
	 * @param testCaseData
	 */
	public void setDetailsOfYourName(LinkedHashMap<String, String> testCaseData) {
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				setTitle(testCaseData);
				setName(testCaseData);
				setDOB(testCaseData);
			}
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				setTitle(testCaseData);
				setName(testCaseData);
				setDOB(testCaseData);
				setTitleSecondApplicant(testCaseData);
				setNameSecondApplicant(testCaseData);
				setDOBSecondApplicant(testCaseData);
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("Details has not been set successfully on Your Name page");
		}
	}
	
}
