package com.eva.Business;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eva.Pages.ThinkMoney_AccountPage;
import com.eva.Pages.ThinkMoney_ApplicationIdPage;
import com.eva.Pages.ThinkMoney_ApplyProcessHomePage;
import com.eva.Pages.ThinkMoney_ContactDetailsPage;
import com.eva.Pages.ThinkMoney_CurrentAddressPage;
import com.eva.Pages.ThinkMoney_HomePage;
import com.eva.Pages.ThinkMoney_HowToContactPage;
import com.eva.Pages.ThinkMoney_LegalStuffPage;
import com.eva.Pages.ThinkMoney_MoreAboutYouPage;
import com.eva.Pages.ThinkMoney_YourIncomePage;
import com.eva.Pages.ThinkMoney_YourNamePage;
import com.eva.Reports.Reporting;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.FuncBank;
import com.relevantcodes.extentreports.LogStatus;

import problems.evaException;

public class THINK_MONEY {

	FuncBank fb ;
	WebDriver driver;
	Reporting report;
	
	ThinkMoney_HomePage 			objThinkMoney_HomePage;
	ThinkMoney_AccountPage 			objThinkMoney_AccountPage;
	ThinkMoney_ApplyProcessHomePage objThinkMoney_ApplyProcessHomePage;
	ThinkMoney_YourNamePage 		objThinkMoney_YourNamePage;
	ThinkMoney_ContactDetailsPage	objThinkMoney_ContactDetailsPage;
	ThinkMoney_HowToContactPage 	objThinkMoney_HowToContactPage;
	ThinkMoney_MoreAboutYouPage 	objThinkMoney_MoreAboutYouPage;
	ThinkMoney_CurrentAddressPage 	objThinkMoney_CurrentAddressPage;
	ThinkMoney_YourIncomePage 		objThinkMoney_YourIncomePage;
	ThinkMoney_LegalStuffPage 		objThinkMoney_LegalStuffPage;
	ThinkMoney_ApplicationIdPage 	objThinkMoney_ApplicationIdPage;
	
	public THINK_MONEY(WebDriver driver, Reporting report)
	{
		System.out.println("In THINK_MONEY Constructor");
		this.driver 	= driver;
		this.report 	= report;
		fb 				= new FuncBank(driver, report);
		
		// Initializing Page Objects for Think Money pages
		objThinkMoney_HomePage				= new ThinkMoney_HomePage(driver, report);
		objThinkMoney_AccountPage			= new ThinkMoney_AccountPage(driver, report);
		objThinkMoney_ApplyProcessHomePage	= new ThinkMoney_ApplyProcessHomePage(driver, report);
		objThinkMoney_YourNamePage			= new ThinkMoney_YourNamePage(driver, report);
		objThinkMoney_ContactDetailsPage	= new ThinkMoney_ContactDetailsPage(driver, report);
		objThinkMoney_HowToContactPage		= new ThinkMoney_HowToContactPage(driver, report);
		objThinkMoney_MoreAboutYouPage		= new ThinkMoney_MoreAboutYouPage(driver, report);
		objThinkMoney_CurrentAddressPage	= new ThinkMoney_CurrentAddressPage(driver, report);
		objThinkMoney_YourIncomePage		= new ThinkMoney_YourIncomePage(driver, report);
		objThinkMoney_LegalStuffPage		= new ThinkMoney_LegalStuffPage(driver, report);
		objThinkMoney_ApplicationIdPage		= new ThinkMoney_ApplicationIdPage(driver, report);
	}
	
	private LinkedHashMap<String, String> getDataForSingleAccount()
	{
		// Initializing Test Data for Single Account
		LinkedHashMap<String, String> testData = new LinkedHashMap<String, String>();
		testData.put("AccountType", "Single Account");
		testData.put("AccountUsagePurpose", "Income and bills");
		testData.put("Title", "Mr");
		testData.put("FirstName", "Ankit");
		testData.put("MiddleName", "");
		testData.put("Surname", "Gupta");
		testData.put("DateOfBirth", "05/11/1951");
		testData.put("TitleSecondApplicant", "");
		testData.put("FirstNameSecondApplicant", "");
		testData.put("MiddleNameSecondApplicant", "");
		testData.put("SurnameSecondApplicant", "");
		testData.put("DateOfBirthSecondApplicant", "");
		testData.put("EmailAddress", "agupta@abc.com");
		testData.put("ContactNumber", "073123456789");
		testData.put("EmailAddressSecondApplicant", "");
		testData.put("ContactNumberSecondApplicant", "");
		testData.put("ContactEmail", "Yes");
		testData.put("ContactTextMessage", "No");
		testData.put("ContactTelephone", "No");
		testData.put("PreviousSurname", "No");
		testData.put("UKNational", "Yes");
		testData.put("OnlyNationality", "Yes");
		testData.put("PreviousSurnameValue", "");
		testData.put("Nationality", "");
		testData.put("OtherNationality", "");
		testData.put("PreviousSurnameSecondApplicant", "");
		testData.put("UKNationalSecondApplicant", "");
		testData.put("OnlyNationalitySecondApplicant", "");
		testData.put("PreviousSurnameValueSecondApplicant", "");
		testData.put("NationalitySecondApplicant", "");
		testData.put("OtherNationalitySecondApplicant", "");
		testData.put("ResidentialStatus", "Homeowner");
		testData.put("PostCode", "DD30NX");
		testData.put("Address", "7 Heather Gardens, DUNDEE, Angus, DD3 0NX");
		testData.put("AddressYear", "2009");
		testData.put("AdddressMonth", "April");
		testData.put("ResidentialStatusSecondApplicant", "");
		testData.put("AddressYearSecondApplicant", "");
		testData.put("AdddressMonthSecondApplicant", "");
		testData.put("MonthlyIncome", "500");
		testData.put("HowPaid", "Cash");
		testData.put("HowOftenPaid", "Monthly");
		testData.put("EmploymentStatus", "Benefits");
		testData.put("JobTitle", "");
		testData.put("BusinessName", "");
		testData.put("WorkplaceLocation", "");
		testData.put("MonthlyIncomeSecondApplicant", "");
		testData.put("HowPaidSecondApplicant", "");
		testData.put("HowOftenPaidSecondApplicant", "");
		testData.put("EmploymentStatusSecondApplicant", "");
		testData.put("JobTitleSecondApplicant", "");
		testData.put("BusinessNameSecondApplicant", "");
		testData.put("WorkplaceLocationSecondApplicant", "");
		
		return testData;
	}
	
	private LinkedHashMap<String, String> getDataForJointAccount()
	{
		// Initializing Test Data for Single Account
		LinkedHashMap<String, String> testData = new LinkedHashMap<String, String>();
		testData.put("AccountType", "Joint Account");
		testData.put("AccountUsagePurpose", "Spending money");
		testData.put("Title", "Mr");
		testData.put("FirstName", "Sachin");
		testData.put("MiddleName", "");
		testData.put("Surname", "Khanna");
		testData.put("DateOfBirth", "23/05/1959");
		testData.put("TitleSecondApplicant", "Mrs");
		testData.put("FirstNameSecondApplicant", "Prakshi");
		testData.put("MiddleNameSecondApplicant", "");
		testData.put("SurnameSecondApplicant", "Khanna");
		testData.put("DateOfBirthSecondApplicant", "12/12/1959");
		testData.put("EmailAddress", "skhanna@def.com");
		testData.put("ContactNumber", "073541265235");
		testData.put("EmailAddressSecondApplicant", "pkhanna@ghi.com");
		testData.put("ContactNumberSecondApplicant", "073541265245");
		testData.put("ContactEmail", "Yes");
		testData.put("ContactTextMessage", "No");
		testData.put("ContactTelephone", "No");
		testData.put("PreviousSurname", "No");
		testData.put("UKNational", "Yes");
		testData.put("OnlyNationality", "Yes");
		testData.put("PreviousSurnameValue", "");
		testData.put("Nationality", "");
		testData.put("OtherNationality", "");
		testData.put("PreviousSurnameSecondApplicant", "No");
		testData.put("UKNationalSecondApplicant", "Yes");
		testData.put("OnlyNationalitySecondApplicant", "Yes");
		testData.put("PreviousSurnameValueSecondApplicant", "");
		testData.put("NationalitySecondApplicant", "");
		testData.put("OtherNationalitySecondApplicant", "");
		testData.put("ResidentialStatus", "Homeowner");
		testData.put("PostCode", "DD30NX");
		testData.put("Address", "9 Heather Gardens, DUNDEE, Angus, DD3 0NX");
		testData.put("AddressYear", "2005");
		testData.put("AdddressMonth", "May");
		testData.put("ResidentialStatusSecondApplicant", "Other");
		testData.put("AddressYearSecondApplicant", "2005");
		testData.put("AdddressMonthSecondApplicant", "May");
		testData.put("MonthlyIncome", "800");
		testData.put("HowPaid", "Bank transfer");
		testData.put("HowOftenPaid", "Weekly");
		testData.put("EmploymentStatus", "Benefits");
		testData.put("JobTitle", "");
		testData.put("BusinessName", "");
		testData.put("WorkplaceLocation", "");
		testData.put("MonthlyIncomeSecondApplicant", "400");
		testData.put("HowPaidSecondApplicant", "Bank transfer");
		testData.put("HowOftenPaidSecondApplicant", "Weekly");
		testData.put("EmploymentStatusSecondApplicant", "Benefits");
		testData.put("JobTitleSecondApplicant", "");
		testData.put("BusinessNameSecondApplicant", "");
		testData.put("WorkplaceLocationSecondApplicant", "");
		
		return testData;
	}
	
	public void SingleAccount() throws evaException
	{
		LinkedHashMap<String, String> testCaseData = getDataForSingleAccount();
		
		driver.get("https://www.thinkmoney.co.uk/");
		objThinkMoney_HomePage.clickOpenAnAccountButton();
		objThinkMoney_AccountPage.clickOpenAnAccountButton();
		objThinkMoney_ApplyProcessHomePage.setAccountDetails(testCaseData);
		objThinkMoney_YourNamePage.setDetailsOfYourName(testCaseData);
		objThinkMoney_ContactDetailsPage.setContactDetails(testCaseData);
		objThinkMoney_HowToContactPage.setHowToContactDetails(testCaseData);
		objThinkMoney_MoreAboutYouPage.setMoreAboutDetails(testCaseData);
		objThinkMoney_CurrentAddressPage.setCurrentAddressDetails(testCaseData);
		objThinkMoney_YourIncomePage.setYourIncomeDetails(testCaseData);
		objThinkMoney_LegalStuffPage.setTermsAndCondition();
		objThinkMoney_ApplicationIdPage.getApplicationIdNumber(testCaseData);
	}
	
	public void JointAccount() throws evaException
	{
		LinkedHashMap<String, String> testCaseData = getDataForJointAccount();
		
		driver.get("https://www.thinkmoney.co.uk/");
		objThinkMoney_HomePage.clickOpenAnAccountButton();
		objThinkMoney_AccountPage.clickOpenAnAccountButton();
		objThinkMoney_ApplyProcessHomePage.setAccountDetails(testCaseData);
		objThinkMoney_YourNamePage.setDetailsOfYourName(testCaseData);
		objThinkMoney_ContactDetailsPage.setContactDetails(testCaseData);
		objThinkMoney_HowToContactPage.setHowToContactDetails(testCaseData);
		objThinkMoney_MoreAboutYouPage.setMoreAboutDetails(testCaseData);
		objThinkMoney_CurrentAddressPage.setCurrentAddressDetails(testCaseData);
		objThinkMoney_YourIncomePage.setYourIncomeDetails(testCaseData);
		objThinkMoney_LegalStuffPage.setTermsAndCondition();
		objThinkMoney_ApplicationIdPage.getApplicationIdNumber(testCaseData);
	}
	
}
