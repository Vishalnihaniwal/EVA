package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_MoreAboutYouPage {
	
	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_MoreAboutYouPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money More About You PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'More about you')]")
	private WebElement HowToContactTitle;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_PreviousSurnameRadioValidationWrapper_block_wtWrapper_WebPatterns_wt196_block_wtRadioButtonText")
	private WebElement PreviousSurnameYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_PreviousSurnameRadioValidationWrapper_block_wtWrapper_WebPatterns_wt196_block_wtRadioButtonText2")
	private WebElement PreviousSurnameNoButton;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt235_block_wtInput_Label_wtPrimaryApplicant_PreviousSurname_Input")
	private WebElement PreviousSurnameField;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_UKNationalRadioValidationWrapper_block_wtWrapper_WebPatterns_wt206_block_wtRadioButtonText")
	private WebElement UKNationalYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_UKNationalRadioValidationWrapper_block_wtWrapper_WebPatterns_wt206_block_wtRadioButtonText2")
	private WebElement UKNationalNoButton;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt222_block_wtInput_Label_wtPrimaryApplicant_Nationality_Input")
	private WebElement NationalityDropdown;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_OnlyNationalityRadioValidationWrapper_block_wtWrapper_WebPatterns_wt154_block_wtRadioButtonText")
	private WebElement OnlyNationalityYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtPrimary_OnlyNationalityRadioValidationWrapper_block_wtWrapper_WebPatterns_wt154_block_wtRadioButtonText2")
	private WebElement OnlyNationalityNoButton;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt110_block_wtInput_Label_wtPrimaryApplicant_OtherNationality_Input")
	private WebElement OtherNationalityDropdown;
	
	/*Second Applicant*/
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_PreviousSurnameRadioValidationWrapper_block_wtWrapper_WebPatterns_wt149_block_wtRadioButtonText")
	private WebElement SecondApplicantPreviousSurnameYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_PreviousSurnameRadioValidationWrapper_block_wtWrapper_WebPatterns_wt149_block_wtRadioButtonText2")
	private WebElement SecondApplicantPreviousSurnameNoButton;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt88_block_wtInput_Label_wtSecondApplicant_PreviousSurname_Input")
	private WebElement SecondApplicantPreviousSurnameField;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_UKNationalRadioValidationWrapper_block_wtWrapper_WebPatterns_wt168_block_wtRadioButtonText")
	private WebElement SecondApplicantUKNationalYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_UKNationalRadioValidationWrapper_block_wtWrapper_WebPatterns_wt168_block_wtRadioButtonText2")
	private WebElement SecondApplicantUKNationalNoButton;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt97_block_wtInput_Label_wtSecondApplicant_Nationality_Input")
	private WebElement SecondApplicantNationalityDropdown;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_OnlyNationalityRadioValidationWrapper_block_wtWrapper_WebPatterns_wt62_block_wtRadioButtonText")
	private WebElement SecondApplicantOnlyNationalityYesButton;
	
	@FindBy(how = How.CSS, using = "label#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wtSecondary_OnlyNationalityRadioValidationWrapper_block_wtWrapper_WebPatterns_wt62_block_wtRadioButtonText2")
	private WebElement SecondApplicantOnlyNationalityNoButton;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt95_block_wtMainContent_ThinkMoney_Patterns_wt33_block_wtInput_Label_wtSecondApplicant_OtherNationality_Input")
	private WebElement SecondApplicantOtherNationalityDropdown;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	/***
	 * function to set How to Contact details for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setMoreAboutDetailsFirstApplicant(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			
			/*Email*/
			if (testCaseData.get("PreviousSurname").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(PreviousSurnameYesButton, imgPath, "Selecting Previous Surname as Yes");
				report.assertThat(PreviousSurnameYesButton.getAttribute("class").contains("active"), "Previous Surname Yes button has been selected successfully", "Previous Surname Yes button has not been selected successfully");
				browserAction.setText(PreviousSurnameField, testCaseData.get("PreviousSurnameValue"), imgPath,"Previous Surname has been entered");
			}
			else
			{
				browserAction.click(PreviousSurnameNoButton, imgPath, "Selecting Previous Surname as No");
				report.assertThat(PreviousSurnameNoButton.getAttribute("class").contains("active"), "Previous Surname No button has been selected successfully", "Previous Surname No button has not been selected successfully");
			}
			
			/*Text Message*/
			if (testCaseData.get("UKNational").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(UKNationalYesButton, imgPath, "Selecting UK National as Yes");
				report.assertThat(UKNationalYesButton.getAttribute("class").contains("active"), "UK National Yes button has been selected successfully", "UK National Yes button has not been selected successfully");
			}
			else
			{
				browserAction.click(UKNationalNoButton, imgPath, "Selecting UK National as No");
				report.assertThat(UKNationalNoButton.getAttribute("class").contains("active"), "UK National No button has been selected successfully", "UK National No button has not been selected successfully");
				browserAction.selectFromDD(NationalityDropdown, testCaseData.get("Nationality"), imgPath, "Nationality has been selected");
			}
			
			/*Telephone*/
			if (testCaseData.get("OnlyNationality").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(OnlyNationalityYesButton, imgPath, "Selecting Only Nationality as Yes");
				report.assertThat(OnlyNationalityYesButton.getAttribute("class").contains("active"), "Only Nationality Yes button has been selected successfully", "Only Nationality Yes button has not been selected successfully");
			}
			else
			{
				browserAction.click(OnlyNationalityNoButton, imgPath, "Selecting Telephone as No");
				report.assertThat(OnlyNationalityNoButton.getAttribute("class").contains("active"), "Only Nationality No button has been selected successfully", "Only Nationality No button has not been selected successfully");
				browserAction.selectFromDD(OtherNationalityDropdown, testCaseData.get("OtherNationality"), imgPath, "Other Nationality has been selected");
			}
		} catch (Exception e) {
			System.out.println("More About You Details has not been set successfully");
		}
	}
	
	/***
	 * function to set How to Contact details for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setMoreAboutDetailsSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			
			/*Email*/
			if (testCaseData.get("PreviousSurnameSecondApplicant").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(SecondApplicantPreviousSurnameYesButton, imgPath, "Selecting Previous Surname as Yes for Second Applicant");
				report.assertThat(SecondApplicantPreviousSurnameYesButton.getAttribute("class").contains("active"), "Previous Surname Yes button for Second Applicant has been selected successfully", "Previous Surname Yes button for Second Applicant has not been selected successfully");
				browserAction.setText(SecondApplicantPreviousSurnameField, testCaseData.get("PreviousSurnameValueSecondApplicant"), imgPath,"Previous Surname for Second Applicant has been entered");
			}
			else
			{
				browserAction.click(SecondApplicantPreviousSurnameNoButton, imgPath, "Selecting Previous Surname as No for Second Applicant");
				report.assertThat(SecondApplicantPreviousSurnameNoButton.getAttribute("class").contains("active"), "Previous Surname No button for Second Applicant has been selected successfully", "Previous Surname No button for Second Applicant has not been selected successfully");
			}
			
			/*Text Message*/
			if (testCaseData.get("UKNationalSecondApplicant").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(SecondApplicantUKNationalYesButton, imgPath, "Selecting UK National as Yes for Second Applicant");
				report.assertThat(SecondApplicantUKNationalYesButton.getAttribute("class").contains("active"), "UK National Yes button for Second Applicant has been selected successfully", "UK National Yes button for Second Applicant has not been selected successfully");
			}
			else
			{
				browserAction.click(SecondApplicantUKNationalNoButton, imgPath, "Selecting UK National as No for Second Applicant");
				report.assertThat(SecondApplicantUKNationalNoButton.getAttribute("class").contains("active"), "UK National No button for Second Applicant has been selected successfully", "UK National No button for Second Applicant has not been selected successfully");
				browserAction.selectFromDD(SecondApplicantNationalityDropdown, testCaseData.get("NationalitySecondApplicant"), imgPath, "Nationality has been selected for Second Applicant");
			}
			
			/*Telephone*/
			if (testCaseData.get("OnlyNationalitySecondApplicant").equalsIgnoreCase("Yes")) 
			{
				browserAction.click(SecondApplicantOnlyNationalityYesButton, imgPath, "Selecting Only Nationality as Yes for Second Applicant");
				report.assertThat(SecondApplicantOnlyNationalityYesButton.getAttribute("class").contains("active"), "Only Nationality Yes button for Second Applicant has been selected successfully", "Only Nationality Yes button for Second Applicant has not been selected successfully");
			}
			else
			{
				browserAction.click(SecondApplicantOnlyNationalityNoButton, imgPath, "Selecting Telephone as No for Second Applicant");
				report.assertThat(SecondApplicantOnlyNationalityNoButton.getAttribute("class").contains("active"), "Only Nationality No button for Second Applicant has been selected successfully", "Only Nationality No button for Second Applicant has not been selected successfully");
				browserAction.selectFromDD(SecondApplicantOtherNationalityDropdown, testCaseData.get("OtherNationalitySecondApplicant"), imgPath, "Other Nationality has been selected for Second Applicant");
			}
		} catch (Exception e) {
			System.out.println("More About You Details for Second Applicant has not been set successfully");
		}
	}
	
	/***
	 * function to set How to Contact details
	 * 
	 * @param testCaseData
	 */
	public void setMoreAboutDetails(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
		{
			setMoreAboutDetailsFirstApplicant(testCaseData);
		}
		else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
		{
			setMoreAboutDetailsFirstApplicant(testCaseData);
			setMoreAboutDetailsSecondApplicant(testCaseData);
		}
		else
		{
			System.out.println("Account Type is wrong. Please enter the valid account type.");
		}
		clickContinueButton();
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on More About You page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on More About You page");
		}
	}
	
}
