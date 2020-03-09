package com.eva.Business;

import org.openqa.selenium.WebDriver;
import com.eva.Reports.Reporting;
import com.eva.Utils.FuncBank;

import problems.evaException;

public class IHG {
	FuncBank fb ;
	WebDriver driver; 
	Reporting repo;
	
	public IHG(WebDriver driver, Reporting repo)
	{
		this.driver = driver;
		this.repo = repo;
		fb = new FuncBank(driver, repo);
	}

	public void booking() throws evaException, InterruptedException
	{
		String url = "https://www.ihg.com/";
		driver.navigate().to(url);
		fb.WaittoPageLoad(driver);
		Thread.sleep(2000);
		
		fb.performAction("Click", "name", "dest-input", "", "Click on dest text box", false);
		fb.performAction("CLEARTEXT", "name", "dest-input", "", "clear on dest text box", false);
		fb.performAction("SETTEXT", "name", "dest-input", "Berlin", "enter in dest text box", true);
//		driver.findElement(By.name("dest-input")).click();
//		driver.findElement(By.name("dest-input")).clear();
//		driver.findElement(By.name("dest-input")).sendKeys("Berlin");
		
		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//li[@class='ui-menu-item']/a)[1]")).click();			// Select First Option from suggestions
		fb.performAction("Click", "xpath", "(//li[@class='ui-menu-item']/a)[1]", "", "Select First Option from suggestions", true);
//		// Enter Check In Date		
//		
		Thread.sleep(2000);
		
		
		fb.performAction("Click", "xpath", "//input[@class='form-control check-in hasDatepicker']", "", "Click on checkin", true);
		fb.performAction("CLEARTEXT", "xpath", "//input[@class='form-control check-in hasDatepicker']", "", "clear on checkin", false);
		fb.performAction("SETTEXT", "xpath", "//input[@class='form-control check-in hasDatepicker']", "11/09/2018", "enter in checkin", true);
//		driver.findElement(By.xpath("//input[@class='form-control check-in hasDatepicker']")).click();
//		driver.findElement(By.xpath("//input[@class='form-control check-in hasDatepicker']")).clear();
//		driver.findElement(By.xpath("//input[@class='form-control check-in hasDatepicker']")).sendKeys("11/09/2018");
//		
//		// Enter Check Out Date		
		
		Thread.sleep(2000);
		fb.performAction("Click", "xpath", "//input[@class='form-control check-out hasDatepicker']", "", "Click on checkin", true);
		fb.performAction("CLEARTEXT", "xpath", "//input[@class='form-control check-out hasDatepicker']", "", "clear on checkin", false);
		fb.performAction("SETTEXT", "xpath", "//input[@class='form-control check-out hasDatepicker']", "12/09/2018", "enter in checkin", true);
//		driver.findElement(By.xpath("//input[@class='form-control check-out hasDatepicker']")).click();
//		driver.findElement(By.xpath("//input[@class='form-control check-out hasDatepicker']")).clear();
//		driver.findElement(By.xpath("//input[@class='form-control check-out hasDatepicker']")).sendKeys("12/09/2018");
//		
//		// Click Search		
//		
		Thread.sleep(2000);
		fb.performAction("Click", "xpath", "//div[@class='more-less-opt']", "", "Click on More option", true);
//		driver.findElement(By.xpath("//div[@class='form-group adults']/label")).click();			// click on adult label 
//		
		Thread.sleep(2000);
		fb.performAction("Click", "xpath", "//div[@class='htl-search desktop']", "", "Click on search", true);
//		driver.findElement(By.xpath("//div[@class='htl-search desktop']")).click();
//		
//		// Wait for Page Load and Select Hotel
//		
		fb.WaittoPageLoad(driver);
		
		Thread.sleep(2000);
//		
//		WebDriverWait wait	= new WebDriverWait(driver,300);
//		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'SELECT HOTEL')])[1]"))));
//		
//		driver.findElement(By.xpath("(//div[contains(text(),'SELECT HOTEL')])[1]")).click();
//		
//		// Select Room Type
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[@class='tab ng-isolate-scope firstTab']/div[3]/div[3]/div/div/span")).click();
//		
//		// Wait for Page Load and Select Room
//		
//		fb.WaittoPageLoad(driver);
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//room-details/div/div[1]/div[2]/aside/div/div[6]/div/span)[1]")).click();
//		
//		// Select Rate
//		
//		fb.WaittoPageLoad(driver);
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//div[contains(text(),'SELECT RATE')])[1]")).click();
//		
//		// Check Yes Sign me up Check Box
//		
//		fb.WaittoPageLoad(driver);
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//span[@class='checkBox singUpCheckbox fa-stack fa-lg themeFill']")).click();
//		
//		// Enter First Name
//		
//		Thread.sleep(5000);
//		
//		driver.findElement(By.id("firstName")).click();
//		driver.findElement(By.id("firstName")).clear();
//		driver.findElement(By.id("firstName")).sendKeys("Test");
//		
//		// Enter Last Name
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("lastName")).click();
//		driver.findElement(By.id("lastName")).clear();
//		driver.findElement(By.id("lastName")).sendKeys("User");
//		
//		// Enter Email
//
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("emailAddress")).click();
//		driver.findElement(By.id("emailAddress")).clear();
//		driver.findElement(By.id("emailAddress")).sendKeys("Test321@gmail.com");
//		
//		// Select Country
//		
//		Thread.sleep(2000);
//		
//		Select select = new Select(driver.findElement(By.id("country")));
//		
//		select.selectByValue("Germany");
//		
//		
//		// Enter Address
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("addressTextBox")).click();
//		driver.findElement(By.id("addressTextBox")).clear();
//		driver.findElement(By.id("addressTextBox")).sendKeys("Test Address");
//		
//		// Enter City
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("city")).click();
//		driver.findElement(By.id("city")).clear();
//		driver.findElement(By.id("city")).sendKeys("Berlin");
//		
//		// Enter Postal Code
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("postalCode")).click();
//		driver.findElement(By.id("postalCode")).clear();
//		driver.findElement(By.id("postalCode")).sendKeys("10117");
//		
//		// Select Phone Country Code
//		
//		Thread.sleep(2000);
//		
//		select = new Select(driver.findElement(By.id("phoneCountryCode")));
//		
//		select.selectByValue("Germany +49");
//		
//		// Enter Phone Number
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("phoneNumber")).click();
//		driver.findElement(By.id("phoneNumber")).clear();
//		driver.findElement(By.id("phoneNumber")).sendKeys("9764976421");
//		
//		// Select Payment Card Type
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("paymentCard")).click();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//li[contains(text(),'VISA')]")).click();
//		
//		// Enter Payment Card Number
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.id("cardNumber")).click();
//		driver.findElement(By.id("cardNumber")).clear();
//		driver.findElement(By.id("cardNumber")).sendKeys("4111111111111111");
//		
//		// Select Payment Card expiry Month
//		
//		Thread.sleep(2000);
//		
//		select = new Select(driver.findElement(By.id("cardExpirationMonth")));
//		
//		select.selectByValue("01 (January)");
//		
//		// Select Payment Card expiry Year
//		
//		Thread.sleep(2000);
//		
//		select = new Select(driver.findElement(By.id("cardExpirationYear")));
//		
//		select.selectByValue("2025");
//		
//		// Click Accept Terms and Condition Check Box
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//span[@class='checkBox fa-stack fa-lg themeFill'])[2]")).click();
//					
//		// Click Book Reservation Button
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//button[@class='form-control themeBG hThree']")).click();
//		
//		// Click Cancel Order Button
//		
//		fb.WaittoPageLoad(driver);
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//a[@class='hNine ng-binding'])[4]")).click();
//		
//		// Wait for page load and Accept terms and condition
//		
//		fb.WaittoPageLoad(driver);
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//span[@class='checkBox fa-stack fa-lg themeFill']")).click();
//		
//		// Cancel Order
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[@class='hThree cancel-res-button themeBG text-center']")).click();
//		
//		// Wait for page load and Verify Cancellation message and display cancellation number
//		
//		fb.WaittoPageLoad(driver);
		
		Thread.sleep(2000);
		
		System.out.println("ORDER CANCELLED");		
	}
}
