package com.eva.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eva.Reports.Reporting;
import com.eva.Utils.BrowserActions;

public class ThinkMoney_ApplicationIdPage {

	WebDriver driver 				= null;
	Reporting report 				= null;
	BrowserActions browserAction 	= null;
	String imgPath 					= "";
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor 		- Initialize driver and report
	 * @param driver 	- WebDriver object  
	 * @param report 	- Instance of defined Report class
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ThinkMoney_ApplicationIdPage(WebDriver driver,Reporting report) {
		
		this.driver 	= driver;
        this.report 	= report;
        
        PageFactory.initElements(driver, this);
        
        browserAction 	= new BrowserActions(driver, report);
        imgPath 		= report.imagePath;
   }

	/** *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 *   Think Money Application Id PAGE Locators
	 *  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* */
	
	@FindBy(how = How.XPATH, using = "(//div[@class='Heading2'])[1]")
	private WebElement NameHeading;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your application ID is:')]//span")
	private WebElement ApplicationIdText;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='Heading2'])[2]")
	private WebElement SecondApplicantNameHeading;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'Your application ID is:')]//span)[2]")
	private WebElement SecondApplicantApplicationIdText;
	
	
	/***
	 * function to get Application Id
	 * 
	 * @return
	 */
	public void getApplicationIdNumberFirstApplicant() {
		browserAction.WaittoPageLoad();
		try {
			String applicationIdNumber = browserAction.getText(ApplicationIdText);
			report.verifyCondition(!(applicationIdNumber.equals("") | applicationIdNumber.equals(null)),"Application Id number : " + applicationIdNumber + " generated successfully","Application Id number has not been generated successfully");
		} catch (Exception e) {
			report.assertThat(false, "Application Id number has been generated successfully", "Application Id number could not be generated due to some error");
		}
	}
	
	/***
	 * function to get Application Id for Second Applicant
	 * 
	 * @return
	 */
	public void getApplicationIdNumberSecondApplicant() {
		try {
			String applicationIdNumber = browserAction.getText(SecondApplicantApplicationIdText);
			report.verifyCondition(!(applicationIdNumber.equals("") | applicationIdNumber.equals(null)),"Application Id number : " + applicationIdNumber + " generated successfully for Second Applicant","Application Id number has not been generated successfully for Second Applicant");
		} catch (Exception e) {
			report.assertThat(false, "Application Id number has been generated successfully for Second Applicant", "Application Id number could not be generated for Second Applicant due to some error");
		}
	}
	
	/***
	 * function to get Application Id
	 * 
	 * @return
	 */
	public void getApplicationIdNumber(LinkedHashMap<String, String> testCaseData) {
		try {
			if (testCaseData.get("AccountType").equalsIgnoreCase("Single Account")) 
			{
				getApplicationIdNumberFirstApplicant();
			}
			else if (testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")) 
			{
				getApplicationIdNumberFirstApplicant();
				getApplicationIdNumberSecondApplicant();
			}
			else
			{
				System.out.println("Account Type is wrong. Please enter the valid account type.");
			}
		} catch (Exception e) {
			System.out.println("Application Id(s) has not been generated successfully");
		}
	}
	
}
