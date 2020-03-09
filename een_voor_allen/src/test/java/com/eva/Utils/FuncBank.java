package com.eva.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

//import com.eva.Logger.Log;
import com.eva.Reports.Reporting;
import com.relevantcodes.extentreports.LogStatus;

import problems.ErrorType;
import problems.evaException;

/* 
 * http://robotframework.org/Selenium2Library/Selenium2Library.html#Wait%20Until%20Page%20Does%20Not%20Contain%20Element
 * 
Add Cookie 
 Add Location Strategy 
 Alert Should Be Present 
 Alert Should Not Be Present 
 Assign Id To Element 
 Capture Page Screenshot 
 Checkbox Should Be Selected 
 Checkbox Should Not Be Selected 
 Choose Cancel On Next Confirmation 
 Choose File 
Choose Ok On Next Confirmation 
 Clear Element Text 
 Click Button 
 Click Element 
 Click Element At Coordinates 
 Click Image 
 Click Link 
 Close All Browsers 
 Close Browser 
 Close Window 
 Confirm Action 
 Create Webdriver 
 Current Frame Contains 
 Current Frame Should Contain 
Current Frame Should Not Contain 
 Delete All Cookies 
 Delete Cookie 
 Dismiss Alert 
 Double Click Element 
 Drag And Drop 
 Drag And Drop By Offset 
 Element Should Be Disabled 
 Element Should Be Enabled 
 Element Should Be Focused 
 Element Should Be Visible 
Element Should Contain 
 Element Should Not Be Visible 
 Element Should Not Contain 
 Element Text Should Be 
 Execute Async Javascript 
 Execute Javascript 
 Focus 
 Frame Should Contain 
 Get Alert Message 
 Get All Links 
 Get Cookie 
 Get Cookie Value 
 Get Cookies 
Get Element Attribute 
 Get Element Count 
 Get Element Size 
 Get Horizontal Position 
 Get List Items 
 Get Location 
 Get Locations 
 Get Matching Xpath Count 
 Get Selected List Label 
 Get Selected List Labels 
 Get Selected List Value 
 Get Selected List Values 
 Get Selenium Implicit Wait 
Get Selenium Speed 
 Get Selenium Timeout 
 Get Source 
 Get Table Cell 
 Get Text 
 Get Title 
 Get Value 
 Get Vertical Position 
 Get WebElement 
 Get WebElements 
 Get Window Handles 
 Get Window Identifiers 
 Get Window Names 
 Get Window Position 
 Get Window Size 
Get Window Titles 
 Go Back 
 Go To 
 Handle Alert 
 Input Password 
 Input Text 
 Input Text Into Alert 
 Input Text Into Prompt 
 List Selection Should Be 
 List Should Have No Selections 
 List Windows 
 Location Should Be 
 Location Should Contain 
 Locator Should Match X Times 
Log Location 
 Log Source 
 Log Title 
 Maximize Browser Window 
 Mouse Down 
 Mouse Down On Image 
 Mouse Down On Link 
 Mouse Out 
 Mouse Over 
 Mouse Up 
 Open Browser 
 Open Context Menu 
 Page Should Contain 
 Page Should Contain Button 
Page Should Contain Checkbox 
 Page Should Contain Element 
 Page Should Contain Image 
 Page Should Contain Link 
 Page Should Contain List 
 Page Should Contain Radio Button 
 Page Should Contain Textfield 
 Page Should Not Contain 
 Page Should Not Contain Button 
Page Should Not Contain Checkbox 
 Page Should Not Contain Element 
 Page Should Not Contain Image 
 Page Should Not Contain Link 
 Page Should Not Contain List 
 Page Should Not Contain Radio Button 
 Page Should Not Contain Textfield 
 Press Key 
 Radio Button Should Be Set To 
Radio Button Should Not Be Selected 
 Register Keyword To Run On Failure 
 Reload Page 
 Remove Location Strategy 
 Select All From List 
 Select Checkbox 
 Select Frame 
 Select From List 
 Select From List By Index 
 Select From List By Label 
 Select From List By Value 
Select Radio Button 
 Select Window 
 Set Browser Implicit Wait 
 Set Focus To Element 
 Set Screenshot Directory 
 Set Selenium Implicit Wait 
 Set Selenium Speed 
 Set Selenium Timeout 
 Set Window Position 
 Set Window Size 
 Simulate 
 Simulate Event 
 Submit Form 
 Switch Browser 
Table Cell Should Contain 
 Table Column Should Contain 
 Table Footer Should Contain 
 Table Header Should Contain 
 Table Row Should Contain 
 Table Should Contain 
 Textarea Should Contain 
 Textarea Value Should Be 
 Textfield Should Contain 
 Textfield Value Should Be 
Title Should Be 
 Unselect All From List 
 Unselect Checkbox 
 Unselect Frame 
 Unselect From List 
 Unselect From List By Index 
 Unselect From List By Label 
 Unselect From List By Value 
 Wait For Condition 
 Wait Until Element Contains 
 Wait Until Element Does Not Contain 
Wait Until Element Is Enabled 
 Wait Until Element Is Not Visible 
 Wait Until Element Is Visible 
 Wait Until Page Contains 
 Wait Until Page Contains Element 
 Wait Until Page Does Not Contain 
 Wait Until Page Does Not Contain Element 
 Xpath Should Match X Times
*/

public class FuncBank {
	
	public static WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report;
//	public Log logger ;
	
	public FuncBank(WebDriver driver, Reporting report) {
		this.driver 	= driver;
		this.report 	= report;
		jse 			= (JavascriptExecutor)driver;
//		logger 			= new Log();
		
	}

	public WebElement getElement(WebDriver driver, String objectType, String objectNameProperty) throws evaException
	{
		WebElement ele = null;
		try {
				if(objectType.equalsIgnoreCase("ID"))
				{
					ele = driver.findElement(By.id(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("XPATH"))
				{
					ele = driver.findElement(By.xpath(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("className"))
				{
					ele = driver.findElement(By.className(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("cssSelector"))
				{
					ele = driver.findElement(By.cssSelector(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("linkText"))
				{
					ele = driver.findElement(By.linkText(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("name"))
				{
					ele = driver.findElement(By.name(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("partialLinkText"))
				{
					ele = driver.findElement(By.partialLinkText(objectNameProperty));	
				}
				else if(objectType.equalsIgnoreCase("tagName"))
				{
					ele = driver.findElement(By.tagName(objectNameProperty));	
				}
		}
		catch(Exception e)
		{
//			logger.LogMessage("FAIL", String.format(ErrorType.ELEMENT_IDENTIFICATION_FAILURE, new Object() {}.getClass().getEnclosingMethod().getName().toString(), objectType, objectNameProperty));
			throw new evaException(String.format(ErrorType.ELEMENT_IDENTIFICATION_FAILURE, new Object() {}.getClass().getEnclosingMethod().getName().toString(), objectType, objectNameProperty));
		}
		return ele;
	}
	
	public boolean booleanPerformAction(String action, String objectType, String objectNameProperty, String value, String message, boolean takescreenshot) throws evaException
	{
		WebElement element = null;
		boolean result = false;
		try
		{
			element = getElement(driver, objectType, objectNameProperty);
			try
			{
				switch(action.toUpperCase())
				{
					case "ElementExists" 					: Exists(element, message, takescreenshot);
						break;
				}
			}
			catch(Exception e1)
			{
				
			}
		}
		catch(Exception e)
		{
		}
		return result;
	}
	
	
	public String performAction(String action, String objectType, String objectNameProperty, String value, String message, boolean takescreenshot) throws evaException
	{
		String returnValue = "";
		WebElement element = null;
		try {
			element = getElement(driver, objectType, objectNameProperty);
		}
		catch(evaException eva)
		{
			report.logStepToReport(LogStatus.FAIL, "Locate element", eva.getMessage(), true, null);
			return returnValue;
		}
		try
		{
			switch(action.toUpperCase())
			{
//				case "VERIFYPAGETITLE"				: verifyPageTitle("title");
//					break;	
				case "CLICK" 					: returnValue = Click(element, message, takescreenshot);
					break;
				case "CLICKJS" 					: returnValue = clickJS(element, message, takescreenshot);
					break;
				case "SCROLLTOELEMENT"			: returnValue = scrolltoElement(element, message, takescreenshot);
					break;
				case "SETTEXT"					: returnValue = setText(element, message, takescreenshot, value);
					break;
				case "SETTEXTJS"				: returnValue = setTextJS(element, message, takescreenshot, value);
					break;
				case "CLEARTEXT"				: returnValue = clearText(element, message, takescreenshot);
					break;
				case "SELECTBYVALUEDD"			: returnValue = selectByValueDD(element, message, takescreenshot, value);
					break;
				case "SELECTBYVALUEDDJS"		: returnValue = selectByValueDDJS(element, message, takescreenshot, value);
					break;
				case "SELECTBYINDEXFROMDDJS"	: returnValue = selectByIndexFromDDJS(element, message, takescreenshot, value);
					break;
				case "GETTEXT"					: returnValue = getText(element, message, takescreenshot);
					break;
				case "GETOBJECTPROPERTYVALUE"	: returnValue = getObjectPropertyValue(element, message, takescreenshot, value);
					break;
				case "VERIFYTEXT"				: returnValue = verifyText(element, message, takescreenshot, value);
					break;
				case "VERIFYOBJECTPROPERTY"		: returnValue = verifyObjectProperty(element, message, takescreenshot, value);
					break;
				default 						:  throw new evaException(String.format(ErrorType.UNSUPPORTED_ACTION, action.toUpperCase(), new Object() {}.getClass().getEnclosingMethod().getName().toString()));
			}
		}
		catch(evaException eva)
		{
			report.logStepToReport(LogStatus.FAIL, action.toUpperCase(), eva.getMessage(), true, element);
		}
		return returnValue;
	}
	
	public String Exists(WebElement ele, String message, boolean takescreenshot)
	{
		try
		{
			ele.isDisplayed();
		}
		catch(Exception e)
		{
			
		}
		return "";
	}
	
	public String Click(WebElement ele, String message, boolean takescreenshot) throws evaException
	{
		String actionStatus = "False";
		try
		{
			ele.click();
//			logger.LogMessage("INFO", "Click method performed");
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Click", message, takescreenshot, ele);
			}
			actionStatus = "True";
		}
		catch(Exception e)
		{
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	
	// Click on Web Element using JavaScriptExecuter and log step in report
	public String clickJS(WebElement element, String message,  boolean takescreenshot) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Click", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch(Exception e)
		{
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}	
		return actionStatus;
	}

	// Scroll to WebElement using JavaScriptExecuter
	public String scrolltoElement(WebElement ele, String message, boolean takescreenshot) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",ele);
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Scroll To Element", message, takescreenshot, ele);
			}
			actionStatus = "True";
		} catch(Exception e){
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}

	// Set Text of Web element
	public String setText(WebElement element, String message,  boolean takescreenshot, String value) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			element.clear();
			element.sendKeys(value);
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Set Text", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}

	// Set Text of Web element using java script executor
	public String setTextJS(WebElement element, String message,  boolean takescreenshot, String value) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Set Text", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	
	public String clearText(WebElement element, String message,  boolean takescreenshot) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			element.clear();
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Clear Text", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}

	
	public static void WaittoPageLoad(WebDriver driver) {
		
		Boolean readyStateComplete 				= false;
		try {
			while (!readyStateComplete) {
				JavascriptExecutor executor 	= (JavascriptExecutor) driver;
				readyStateComplete 				= ((String) executor.executeScript("return document.readyState")).equals("complete");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public void ScrollAndClickOnElement(WebElement element, String imgPath, String message) {
//		
//		try {
//			scrollToElement(WebElement ele, String message, boolean takescreenshot);
//			clickJS(element, imgPath, message);
//		}  catch (Exception e) 
//		{
//	logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//		}
//		
//	}
//
//	// Scroll and set text on Web Element and log step in report
//	
//	public void ScrollAndSetText(WebElement element, String value, String imgPath, String message) {
//		
//		try {
//			scrolltoElement(element);
//			setText(element, value , imgPath, message);
//		}  catch (Exception e) {
//			
//			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//		}
//		
//	}
//
//	// Scroll and set text on Web Element using javascript executor and log step in report
//	
//	public void ScrollAndSetTextJS(WebElement element, String value, String imgPath, String message) {
//		
//		try {
//			scrolltoElement(element);
//			setTextJS(element, value, imgPath, message);
//		}  catch (Exception e) {
//			
//			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//		}
//		
//	}
	
	
	public String selectByValueDD(WebElement element, String message,  boolean takescreenshot, String value) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			System.out.println("value to be selected  - " + value);
			// Code fixed for MAC SAFARI browser issue
			String s = ((RemoteWebDriver) driver).getCapabilities().getPlatform().toString();
			if(s.toUpperCase().contains("MAC") || s.toUpperCase().contains("APPLE")) {
				selectByValueDDJS(element, value, takescreenshot, message);
			}
			else
			{
				Select select = new Select(element);
				select.selectByVisibleText(value);
				if(!message.equalsIgnoreCase("")) {
					report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, takescreenshot, element);
				}
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}

	// Select value from Drop Down using Java script executor & log step in report
	public String selectByValueDDJS(WebElement element, String message, boolean takescreenshot, String value) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", element, value);
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	// Select value from Drop Down using Java script executor, based on index & log step in report
	public String selectByIndexFromDDJS(WebElement element, String message, boolean takescreenshot, String value) throws SecurityException, evaException {
		String actionStatus = "False";
		try {
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; select.options[arguments[1]].selected = true; ", element, String.valueOf(value));
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, takescreenshot, element);
			}
			actionStatus = "True";
		} catch (Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	
	public String getText(WebElement element, String message, boolean takescreenshot) throws SecurityException, evaException {

		String elementText 					= null;
		try {
			elementText 					= element.getText();
			if(!message.equalsIgnoreCase("")) {
				report.logStepToReport(LogStatus.PASS, "Get text", message, takescreenshot, element);
			}
		} catch(Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return elementText;
	}
	
	public String getObjectPropertyValue(WebElement element, String message, boolean takescreenshot, String value) throws SecurityException, evaException
	{
		String ObjectProperty = null;
		try {
			 ObjectProperty = element.getAttribute(value);
			 if(!message.equalsIgnoreCase("")) {
					report.logStepToReport(LogStatus.PASS, "Get property value", "Object :"+element+"<br />, Property : "+value+"<br />, Value :"+ObjectProperty+"<br />. "+message, takescreenshot, element);
				}
		}
		catch(Exception e) {
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return ObjectProperty;
	}
	
	public String verifyText(WebElement element, String message,  boolean takescreenshot, String value) throws SecurityException, evaException
	{
		String actionStatus = "False";
		try {
			String ActualText = getText(element, "", takescreenshot).trim();
			if(ActualText.equalsIgnoreCase(value.trim()))
			{
				report.logStepToReport(LogStatus.PASS, "VerifyText :", "Expected: " + value + "<br /> Actual: <b><strong>" + ActualText, takescreenshot, element);
			}
			else
			{
				report.logStepToReport(LogStatus.FAIL, "VerifyText :", "Expected: " + value + "<br /> Actual: <b><font color=\"red\">" + ActualText, takescreenshot, element);
			}
			actionStatus = "True";
		}
		catch(Exception e)
		{
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	
	public String verifyObjectProperty(WebElement element, String message,  boolean takescreenshot, String value) throws SecurityException, evaException
	{
		String actionStatus = "False";
		try {
			String ObjectPropertyValue = getObjectPropertyValue(element, message, takescreenshot, value);
			if(ObjectPropertyValue.equalsIgnoreCase(value.trim()))
			{
				report.logStepToReport(LogStatus.PASS, "Verify Object Property Value:", "Expected: " + value + "<br /> Actual: <b><strong>" + ObjectPropertyValue, takescreenshot, element);
			}
			else
			{
				report.logStepToReport(LogStatus.FAIL, "Verify Object Property Value:", "Expected: " + value + "<br /> Actual: <b><font color=\"red\">" + ObjectPropertyValue, takescreenshot, element);
			}
			actionStatus = "True";
		}
		catch(Exception e)
		{
//			logger.LogMessage("FAIL", String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
			throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
		}
		return actionStatus;
	}
	
	public boolean verifyPageTitle(String title) {
		System.out.println(driver.getTitle().trim());
		return driver.getTitle().trim().contains(title);
	}
	
	// Fluent wait function
	 	
//	public void FluentWait(final By element) {
//		
//		Wait<WebDriver> wait 	= new FluentWait<WebDriver>(driver)
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//
//		WebElement foo 			= wait.until(new Function<WebDriver, WebElement>() {
//			
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(element);
//			}
//		});
//	}
//
//	// Wait for expected Page Title
//	 
//	public void waitForExpectedTitle(String title) {
//		
//		System.out.println("ExpectedTittle-" + title +"-");
//		
//		long startTime 		= System.currentTimeMillis();
//		long elapsedTime 	= 0;
//		
//		while(elapsedTime < 180) {
//			
//			System.out.println("Tittle-" + driver.getTitle() + "-");
//			
//			if(driver.getTitle().equalsIgnoreCase(title))
//				break;
//			else
//				elapsedTime = (new Date().getTime()/1000) - (startTime/1000);
//
//		}
//
//	}
//
//	// Check for presence of alert on web page
//	 
//	public boolean isAlertPresent() { 
//		
//		try { 
//			driver.switchTo().alert(); 
//			return true;
//		} catch (NoAlertPresentException Ex) { 
//			return false;
//		} catch (Exception Ex) { 
//			return false;
//		}
//	}
//	
//	// Check for presence of web element 
//	 
//	public boolean isElementPresent(WebElement element, int timeout) { 
//		
//		boolean presence = false;
//		
//		for(int i=0 ; i<timeout ; i++) {
//		
//			try { 
//				Thread.sleep(1000);
//				presence = element.isEnabled();
//				return presence;
//				
//			} catch (Exception Ex) { 
//				
//			}
//		}
//		
//		return false;
//		
//	}
//	
//	// Select value from a list 
//
//	public void selectValueFromList(List<WebElement> elements, String valueToBeSelected, String filenamePath , String details) {
//		
//		boolean IsValueSelected = false;
//		WebElement element1		= elements.get(0);
//		
//		try {
//		
//			for(WebElement element : elements) {
//				
//				System.out.println(element.getText());
//				
//				if(element.getText().contains(valueToBeSelected)) {
//				
//					IsValueSelected = true;
//				
//					try {
//						
//						clickJS(element, details, IsValueSelected);
//						
//						report.logStepToReport(LogStatus.INFO, "Select Value from List", valueToBeSelected + " selected", filenamePath, element);
//						
//					} catch (Exception e2) {
//						break;
//					}
//				}
//			}
//			
//			if(!IsValueSelected) {
//				report.logStepToReport(LogStatus.FAIL, "Select Value from List", valueToBeSelected + " not found in list", filenamePath, element1);
//			}
//			
//		} catch(Exception e) {
//			
//		}
//
//	}
//
//	public void specificWait(int t) {
//		try {		
//			Thread.sleep(t*1000);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public boolean IsElementVisible(WebElement element) {
//		return element.isDisplayed();
//	}
//
//	public void waitForElement(WebElement element,int time) throws InterruptedException, SecurityException, evaException {
//        waitForElement(element);
//	 }
//	 
//	 public int getNumberOfFrames()
//	 {
//	        return driver.findElements(By.tagName("iframe")).size();
//	 }
//	 
//	 public void switchFrame(String frameName)
//	 {      
//	        try {
//	               driver.switchTo().frame(frameName);
//	        }
//	        catch(Exception e)
//	        {
//	               report.logStepToReport(LogStatus.FAIL, "Exception : Swtich to frame", "Some exception while switching to frame '"+frameName+"', due to exception - " + e.getLocalizedMessage()); 
//	         }
//	 }
//	 
//	 public void switchDefaultFrame()
//	 {
//	        try {
//	               driver.switchTo().defaultContent();
//	        }
//	        catch(Exception e)
//	        {
//	               report.logStepToReport(LogStatus.FAIL, "Exception : Swtich to default frame", "Some exception while switching to frame, due to exception - " + e.getLocalizedMessage()); 
//	         }
//	 }
//	 
//	 public ArrayList<String> getAllWindows()
//	 {
//	        ArrayList<String> windows = null;
//	        try
//	        {
//	               windows = new ArrayList<String>(driver.getWindowHandles());
//	        }
//	        catch(Exception e)
//	        {
//	               report.logStepToReport(LogStatus.FAIL, "Exception : Get number of tabs", "Some exception while getting number of tab, due to exception - " + e.getLocalizedMessage());
//	        }
//	        return windows;
//	 }
//	 
//	 public void switchToWindow(ArrayList<String> listOfWindows, int windowIndex)
//	 {
//	        try
//	        {
//	               driver.switchTo().window(listOfWindows.get(windowIndex));
//	        }
//	        catch(Exception e)
//	        {
//	               report.logStepToReport(LogStatus.FAIL, "Exception : Switch to tabs", "Some exception while switching tab, due to exception - " + e.getLocalizedMessage());
//	        }
//	 }
//
//	 public void WaittoPageLoad(int maxTime) {
//			
//			Boolean readyStateComplete 				= false;
//			try {
//				
//				while (!readyStateComplete) {
//					if(maxTime==0) {
//						return;
//					}
//					JavascriptExecutor executor 	= (JavascriptExecutor) driver;
//					readyStateComplete 				= ((String) executor.executeScript("return document.readyState")).equals("complete");
//					Thread.sleep(1000);
//					maxTime--;
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//				report.logStepToReport(LogStatus.FAIL, "Wait for Page load", "Failed in page load due to exception - " + e.getLocalizedMessage());
//			}
//		}
//
//		// Get text of Web element
//		
//		
//
//		public void waitForElementVisibility(WebElement element) throws SecurityException, evaException {
//			try {
//				
//				Thread.sleep(5000);
//				/*wait	= new WebDriverWait(driver,300);
//				wait.until(ExpectedConditions.visibilityOf(element));*/
//				
//			} catch (Exception e) {
//				throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//			}
//		}
//
//		public void waitForElement(WebElement element) throws SecurityException, evaException {
//			
//			try {
//				
//				Thread.sleep(5000);
//				/*wait	= new WebDriverWait(driver,120);
//				wait.until(ExpectedConditions.elementToBeClickable(element));*/
//				
//			} catch (Exception e) {
//				throw new evaException(String.format(ErrorType.PROBLEM_IN_BUSINESSFUNCTIONS, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e.getMessage()));
//			}
//			
//		}
	
}
