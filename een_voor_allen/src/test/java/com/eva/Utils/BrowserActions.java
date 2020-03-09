package com.eva.Utils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eva.Reports.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserActions {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report;
	public WebDriverWait wait;
	public Actions action;
	
	public BrowserActions(WebDriver driver, Reporting report) {
		
		this.driver 	= driver;
		this.report 	= report;
		action 			= new Actions(driver);
		jse 			= (JavascriptExecutor)driver;
		
	}

	// Wait for Page Load
	
	public void WaittoPageLoad() {
		
		Boolean readyStateComplete 				= false;
		
		try {
			
			while (!readyStateComplete) {
				JavascriptExecutor executor 	= (JavascriptExecutor) driver;
				readyStateComplete 				= ((String) executor.executeScript("return document.readyState")).equals("complete");
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
		}
	}

	// Click on Web Element
	
	public void click(WebElement element) {

		try {			
			element.click();
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Click", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
		
	}

	// Click on Web Element and log step in report
	
	public void click(WebElement element, String imagePath, String message) {

		try {
			
			element.click();
			
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath, element);
			
			System.out.println(message);
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Click", message, imagePath, element);
			
			//e.printStackTrace();
		}
	}

	// Click on Web Element using JavaScriptExecuter and log step in report
		
	public void clickJS(WebElement element, String imagePath, String message) {

		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath, element);
			
			System.out.println(message);
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Click", message, imagePath, element);
			//e.printStackTrace();
		}		
	}

	// Click on Web Element using JavaScriptExecuter
	
	public void clickJS(WebElement element) {

		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Click", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
	}

	// Scroll to WebElement using JavaScriptExecuter
	
	public void scrollToElement(WebElement element) {
		
		try {
			
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
			
		} catch(Exception e){
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
	}

	// Get text of Web element
	
	public String getText(WebElement element) {

		String elementText 					= null;

		try {
			elementText 					= element.getText();
		} catch(Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}

		return elementText;
	}

	// Set Text of Web element
	
	public void setText(WebElement element, String value) {
		
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
	}

	// Set Text of Web element using java script executor
	
	public void setTextJS(WebElement element, String value) {
		
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
			
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
	}
	
	// Set Text of Web element using java script executor and log step in report
	
	public void setTextJS(WebElement element, String value, String imagePath, String message) {
		
		try {
			
			setTextJS(element, value);
			
			report.logStepToReport(LogStatus.INFO, "Text Entered", message, imagePath, element);
			
			System.out.println(message);
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Text Entered", message, imagePath, element);
			
			//e.printStackTrace();
		}
	}
	
	// Set Text of Web element and log step in report
	
	public void setText(WebElement element, String value, String imagePath, String message) {
		
		try {
			
			element.click();
			
			element.clear();
			
			element.sendKeys(value);
			
			report.logStepToReport(LogStatus.INFO, "Text Entered", message, imagePath, element);
			
			System.out.println(message);
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Text Entered", message, imagePath, element);
			
			//e.printStackTrace();
		}
	}

	// Clear text from the field
	
	public void clearText(WebElement element) {
		
		try {
			element.clear();
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}
		
	}

	// Wait for Web Element visibility and log step in report if element is not visible
	
	public void waitForElementVisibility(WebElement element) {
		
		try {
			
			wait	= new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Exception e) {
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			//e.printStackTrace();
		}

	}

	// Wait for Web element Clickable
	
	public void waitForElement(WebElement element) {
		
		try {
			
			wait	= new WebDriverWait(driver,120);
	
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			
			//e.printStackTrace();
		}
		
	}

	// Scroll and Click on Web Element using JavaScriptExecuter and log step in report
	
	public void ScrollAndClickOnElement(WebElement element, String imgPath, String message) {
		
		try {
		
			scrollToElement(element);
			clickJS(element, imgPath, message);
			
		}  catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			
			//e.printStackTrace();
		}
		
	}

	// Scroll and set text on Web Element and log step in report
	
	public void ScrollAndSetText(WebElement element, String value, String imgPath, String message) {
		
		try {
		
			scrollToElement(element);
			setText(element, value , imgPath, message);
			
		}  catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			
			//e.printStackTrace();
		}
		
	}

	// Scroll and set text on Web Element using javascript executor and log step in report
	
	public void ScrollAndSetTextJS(WebElement element, String value, String imgPath, String message) {
		
		try {
		
			scrollToElement(element);
			
			setTextJS(element, value, imgPath, message);
			
		}  catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			
			//e.printStackTrace();
		}
		
	}
	
	// Select value from Drop Down & log step in report
	
	public void selectFromDD(WebElement element, String value, String imagePath, String message) {
		
		try {
			
			
			System.out.println("Value to be selected  - " + value);
			
			// Code fixed for MAC Safari browser issue
			
			String s = ((RemoteWebDriver) driver).getCapabilities().getPlatform().toString();
			
			if(s.toUpperCase().contains("MAC") || s.toUpperCase().contains("APPLE")) {
				selectFromDDJS(element, value, imagePath, message);
				return;
			}
			
			Select select = new Select(element);
			
			select.selectByVisibleText(value);
			
			report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, imagePath, element);
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Value Selected from Drop Down", message, imagePath, element);
			//e.printStackTrace();
		}

	}

	// Select value from Drop Down using Java script executor & log step in report
	
	public void selectFromDDJS(WebElement element, String value, String imagePath, String message) {
		
		try {

			System.out.println("Value to be selected  - " + value);
			
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", element, value);
		
			report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, imagePath, element);
			
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Value Selected from Drop Down", message, imagePath, element);
			//e.printStackTrace();
		}

	}

	// Select value from Drop Down, based on index & log step in report
	
	public void selectByIndexFromDD(WebElement element, int index, String imagePath, String message) {
		
		try {

			System.out.println("Index to be selected  - " + index);
			
			Select s1 = new Select(element);
			
			s1.selectByIndex(index);
		
			report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, imagePath, element);
		
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Value Selected from Drop Down", message, imagePath, element);
			//e.printStackTrace();
		}

	}

	// Select value from Drop Down, based on value & log step in report
	
	public void selectByValueFromDD(WebElement element, String value, String imagePath, String message) {
		
		try {
			
			System.out.println("Value to be selected  - " + value);
			
			Select s1 = new Select(element);
			
			s1.selectByValue(value);
		
			report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, imagePath, element);
		
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Value Selected from Drop Down", message, imagePath, element);
			//e.printStackTrace();
		}

	}
	
	// Select value from Drop Down using Java script executor, based on index & log step in report
	
	public void selectByIndexFromDDJS(WebElement element, int index, String imagePath, String message) {
		
		try {

			System.out.println("Index to be selected  - " + index);
			
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; select.options[arguments[1]].selected = true; ", element, String.valueOf(index));
		
			report.logStepToReport(LogStatus.INFO, "Value Selected from Drop Down", message, imagePath, element);
		
		} catch (Exception e) {
			
			//report.logStepToReport(LogStatus.FAIL, "Value Selected from Drop Down", message, imagePath, element);
			//e.printStackTrace();
		}

	}
	
	// Verify Page Title
	
	public boolean verifyPageTitle(String title) {
		
		return driver.getTitle().trim().contains(title);
	}
	
	// Fluent wait function
	 	
	public void FluentWait(final By element) {
		
		Wait<WebDriver> wait 	= new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo 			= wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(element);
			}
		});
	}

	// Wait for expected Page Title
	 
	public void waitForExpectedTitle(String title) {
		
		long startTime 		= System.currentTimeMillis();
		long elapsedTime 	= 0;
		
		while(elapsedTime < 180) {
			
			if(driver.getTitle().equalsIgnoreCase(title))
				break;
			else
				elapsedTime = (new Date().getTime()/1000) - (startTime/1000);

		}

	}

	// Check for presence of alert on web page
	 
	public boolean isAlertPresent() { 
		
		try { 
			driver.switchTo().alert(); 
			return true;
		} catch (NoAlertPresentException Ex) { 
			return false;
		} catch (Exception Ex) { 
			return false;
		}
	}
	
	// Check for presence of web element 
	 
	public boolean isElementPresent(WebElement element, int timeout) { 
		
		boolean presence = false;
		
		for(int i=0 ; i<timeout ; i++) {
		
			try { 
				
				Thread.sleep(1000);
				
				presence = element.isEnabled();
				
				if(presence) {
					return presence;
				} 
				
			} catch (Exception Ex) { 
				
			}
		}
		
		return false;
		
	}

	
	// Select value from a list 

	public void selectValueFromList(List<WebElement> elements, String valueToBeSelected, String filenamePath , String details) {
		
		boolean IsValueSelected = false;
		WebElement element1		= elements.get(0);
		
		try {
		
			for(WebElement element : elements) {
				
				System.out.println(element.getText());
				
				if(element.getText().contains(valueToBeSelected)) {
				
					IsValueSelected = true;
				
					try {
						
						clickJS(element);
						
						report.logStepToReport(LogStatus.INFO, "Select Value from List", valueToBeSelected + " selected", filenamePath, element);
						
					} catch (Exception e2) {
						//report.logStepToReport(LogStatus.FAIL, "Select Value from List", valueToBeSelected + " not clickable", filenamePath, element1);
						break;
					}
				}
			}
			
			if(!IsValueSelected) {
				report.logStepToReport(LogStatus.FAIL, "Select Value from List", valueToBeSelected + " not found in list", filenamePath, element1);
			}
			
		} catch(Exception e) {
			
		}

	}

	public boolean IsElementVisible(WebElement element) {
		return element.isDisplayed();
	}
	
	public void waitForElement(WebElement element,int time) throws InterruptedException {
		waitForElement(element);
	}

	public void specificWait(int time) throws InterruptedException {
		Thread.sleep(time*1000);
	}

	public void mouseHoverOnElement(WebElement element) {
		
		try {
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}
	
}

