package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;
import com.relevantcodes.extentreports.LogStatus;

public class ThinkMoney_CurrentAddressPage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_CurrentAddressPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Current Address PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Current address')]")
	private WebElement CurrentAddressTitle;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt268_block_wtInput_Label_wtResidentialStatus_Input")
	private WebElement ResidentialStatusDropdown;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt390_block_wtInput_Label_wtLookupPostcode_Input")
	private WebElement PostcodeField;
	
	@FindBy(how = How.CSS, using = "input#ThinkMoney_Theme_wt566_block_wtMainContent_wtFindAddressButton")
	private WebElement FindAddressButton;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please select your address')]")
	private WebElement PleaseSelectYourAddressTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Text_Darkgrey MarginLeftSmall']")
	private WebElement SelectedAddressText;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt531_block_wtInput_Label_wtYear_Input")
	private WebElement AdddressYearDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt441_block_wtInput_Label_wtMonth_Input")
	private WebElement AdddressMonthDropdown;
	
	/*Second Applicant*/
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt125_block_wtInput_Label_wtJOINT_ResidentialStatus_Input")
	private WebElement SecondApplicantResidentialStatusDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt249_block_wtInput_Label_wtJOINT_Year_Input4")
	private WebElement SecondApplicantAdddressYearDropdown;
	
	@FindBy(how = How.CSS, using = "select#ThinkMoney_Theme_wt566_block_wtMainContent_ThinkMoney_Patterns_wt579_block_wtInput_Label_wtJOINT_Month_Input4")
	private WebElement SecondApplicantAdddressMonthDropdown;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Back')]")
	private WebElement BackButton;
	
	
	/***
	 * function to set Residential Status for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setResidentialStatusFirstApplicant(LinkedHashMap<String, String> testCaseData) {
		browserAction.WaittoPageLoad();
		try {
			browserAction.selectFromDD(ResidentialStatusDropdown, testCaseData.get("ResidentialStatus"), imgPath, "Residential Status has been selected");
		} catch (Exception e) {
			System.out.println("Residential Status has not been selected on Current Address page");
		}
	}
	
	/***
	 * function to set PostCode
	 * 
	 * @param testCaseData
	 */
	public void setPostCode(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.ScrollAndSetText(PostcodeField, testCaseData.get("PostCode"), imgPath, "PostCode has been entered");
		} catch (Exception e) {
			System.out.println("PostCode has not been entered on Current Address Page");
		}
	}
	
	/** 
	 * Click Find Address button 
	 */
	public void clickFindAddressButton() {
		try {
			browserAction.waitForElement(FindAddressButton);
			browserAction.click(FindAddressButton, imgPath, "Find Address button clicked");
		} catch (Exception e) {
			System.out.println("Find Address button not clicked on Current Address Page");
		}
	}
	
	/** 
	 * Select Address from the list 
	 */
	public void selectAddress(LinkedHashMap<String, String> testCaseData) {
		try {
			Thread.sleep(5000);
			driver.switchTo().frame(0);
			browserAction.waitForElementVisibility(PleaseSelectYourAddressTitle);
			
			boolean addressFound =  false;
			String addresses = "//span[@id='WebPatterns_wt19_block_wtMainContent_wtPostCodeLookupList']//li";
			String currentAddress;
			int totalAddresses = driver.findElements(By.xpath(addresses)).size();
			
			for (int i = 0; i < totalAddresses; i++) {
				currentAddress = "(" + addresses+ ")[" + (i+1) + "]//a";
				WebElement element = driver.findElement(By.xpath(currentAddress));
				if (testCaseData.get("Address").equalsIgnoreCase(element.getText())) {
					browserAction.clickJS(element, imgPath, "Selecting Address");
					Thread.sleep(2000);
					addressFound = true;
					break;
				}
			}
			if (addressFound) {
				//report.logStepToReport(LogStatus.INFO, "Click", "Address selected on Current address Page", imgPath, SelectedAddressText);
				System.out.println("Address selected on Current Address Page");
			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("Address not selected on Current Address Page");
		}
	}
	
	/***
	 * function to set Address Move in Year and Month for First Applicant
	 * 
	 * @param testCaseData
	 */
	public void setAddressMoveInYearAndMonthFirstApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			Thread.sleep(4000);
			browserAction.selectFromDD(AdddressYearDropdown, testCaseData.get("AddressYear"), imgPath, "Adddress Year has been selected");
			browserAction.selectFromDD(AdddressMonthDropdown, testCaseData.get("AdddressMonth"), imgPath, "Adddress Month has been selected");
		} catch (Exception e) {
			System.out.println("Address Move in Year and Month has not been selected on Current Address Page");
		}
	}
	
	/***
	 * function to set Residential Status for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setResidentialStatusSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			browserAction.selectFromDD(SecondApplicantResidentialStatusDropdown, testCaseData.get("ResidentialStatusSecondApplicant"), imgPath, "Residential Status for Second Applicant has been selected");
		} catch (Exception e) {
			System.out.println("Residential Status for Second Applicant has not been selected on Current Address page");
		}
	}
	
	/***
	 * function to set Address Move in Year and Month for Second Applicant
	 * 
	 * @param testCaseData
	 */
	public void setAddressMoveInYearAndMonthSecondApplicant(LinkedHashMap<String, String> testCaseData) {
		try {
			Thread.sleep(4000);
			browserAction.selectFromDD(SecondApplicantAdddressYearDropdown, testCaseData.get("AddressYearSecondApplicant"), imgPath, "Adddress Year for Second Applicant has been selected");
			browserAction.selectFromDD(SecondApplicantAdddressMonthDropdown, testCaseData.get("AdddressMonthSecondApplicant"), imgPath, "Adddress Month for Second Applicant has been selected");
		} catch (Exception e) {
			System.out.println("Address Move in Year and Month for Second Applicant has not been selected on Current Address Page");
		}
	}
	
	/***
	 * function to set Current Address Details
	 * 
	 * @param testCaseData
	 */
	public void setCurrentAddressDetails(LinkedHashMap<String, String> testCaseData) {
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				setResidentialStatusFirstApplicant(testCaseData);
				setPostCode(testCaseData);
				clickFindAddressButton();
				selectAddress(testCaseData);
				setAddressMoveInYearAndMonthFirstApplicant(testCaseData);
			}
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				setResidentialStatusFirstApplicant(testCaseData);
				setPostCode(testCaseData);
				clickFindAddressButton();
				selectAddress(testCaseData);
				setAddressMoveInYearAndMonthFirstApplicant(testCaseData);
				setResidentialStatusSecondApplicant(testCaseData);
				setAddressMoveInYearAndMonthSecondApplicant(testCaseData);
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
			clickContinueButton();
		} catch (Exception e) {
			System.out.println("Current Address Details has not been set successfully");
		}
	}
	
	/** 
	 * Click Continue button 
	 */
	public void clickContinueButton() {
		try {
			browserAction.waitForElement(ContinueButton);
			browserAction.click(ContinueButton, imgPath, "Continue button clicked on Current Address page");
		} catch (Exception e) {
			System.out.println("Continue button not clicked on Current Address page");
		}
	}
	
}
