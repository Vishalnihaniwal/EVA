package com.eva.Business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eva.Reports.Reporting;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.FuncBank;
import com.relevantcodes.extentreports.LogStatus;

import problems.evaException;

public class GMAIL {
	FuncBank fb ;
	WebDriver driver; 
	Reporting repo;
	
	public GMAIL(WebDriver driver, Reporting repo)
	{
		System.out.println("In cosntructor");
		this.driver = driver;
		this.repo = repo;
		fb = new FuncBank(driver, repo);
	}
	public void LoginGmail() throws evaException, InterruptedException
	{
		System.out.println("Login Method to open Google site");
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
//		fb.performAction("verifyPageTitle", "", "", "", "", false);
////		fb.performAction("Click", "Xpath", "//a[text()='Login']", "", "Click on login button", false);
//		System.out.println("Sample method of gmail on browser" + RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()) );
////		System.out.println(Thread.currentThread().getName());
//		System.out.println("Click on Login");
////		 driver.findElement(By.linkText("Login")).click();
//		
//		driver.findElement(By.xpath("//input[@name='q']")).click();
//		
//		 System.out.println("Clear field");
//	    driver.findElement(By.id("jfHeader_username")).clear();
//	    System.out.println("Enter user name");
//	    driver.findElement(By.id("jfHeader_username")).sendKeys("test909142");
//	    System.out.println("Clear passwoerd field");
//	    driver.findElement(By.id("jfHeader_password")).clear();
//	    System.out.println("Enter password");
//	    driver.findElement(By.id("jfHeader_password")).sendKeys("test@2018");
//	    driver.findElement(By.id("signinButton")).click();
//	    driver.findElement(By.xpath("//ul[@id='jfHeader-userProfile']/li/a")).click();
//	    System.out.println("Click logout link");
//	    driver.findElement(By.linkText("Logout")).click();
	}
	
	public  void dellCase() throws InterruptedException, evaException
	{
        WebElement designedExclusivelyForYou = driver.findElement(By.xpath("//h4"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", designedExclusivelyForYou);
        repo.logStepToReport(LogStatus.PASS, "Scroll a bit down", "Scrolled down");
        
        fb.performAction("verifyPageTitle", "", "", "", "", false);
        
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//a[@href='/en-in/shop/laptops-2-in-1-pcs/sc/laptops']")));
//        driver.findElement(By.xpath("//a[@href='/en-in/shop/laptops-2-in-1-pcs/sc/laptops']")).click();
        System.out.println("Scroll done");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("(//a[@href='/en-in/shop/laptops-2-in-1-pcs/sc/laptops'])[2]")).click();
        System.out.println("Click on For Home image");
        WebElement series3000 = driver.findElement(By.xpath("//span[text()='3000 Series']")); 
        js.executeScript("arguments[0].scrollIntoView();", series3000);
        series3000.click();
        js.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//a[@href='/en-in/shop/laptops-2-in-1-pcs/inspiron-15-3000/spd/inspiron-15-3000-series-laptops']")));
//        driver.findElement(By.xpath("//a[@href='/en-in/shop/laptops-2-in-1-pcs/inspiron-15-3000/spd/inspiron-15-3000-series-laptops']")).click();
        System.out.println("Last click");
	}

	public void practo()
	{
		try {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        driver.get("https://www.practo.com");
        repo.logStepToReport(LogStatus.INFO, "Open URL", "'https://www.practo.com' opened.");
        driver.findElement(By.xpath("//div[contains(text(),'Pharmacy')]")).click();
        repo.logStepToReport(LogStatus.INFO, "Click on object", "Click on 'Pharm,acy link'");
        driver.findElement(By.xpath("//input[@placeholder='Search for medicines, health products and more']")).sendKeys("calpol tablet");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@placeholder='Search for medicines, health products and more']")));
        driver.findElement(By.xpath("//div[contains(text(),'Calpol Tablet')]")).click();
        driver.findElement(By.xpath("//span[@class='text-white heading-epsilon-bold']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'View Cart')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Checkout')]")).click();
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
	
	
	public void globalsqa() {
		try 
		{
			
//			fb.performAction("CLEARTEXT", "name", "dest-input", "", "clear on dest text box", false);
//			fb.performAction("SETTEXT", "name", "dest-input", "Berlin", "enter in dest text box", true);
			
			
			System.out.println("GlobalSQA starts here...");
			driver.get("http://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");	
			WebDriverWait wait=new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-lg' and text()='Customer Login' ]")));
			fb.performAction("Click", "xpath", "//button[@class='btn btn-primary btn-lg' and text()='Customer Login' ]", "", "Click on login button", true);
//			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg' and text()='Customer Login' ]")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("userSelect")));
			Select customer=new Select(driver.findElement(By.id("userSelect")));
			customer.selectByVisibleText("Harry Potter");
			fb.performAction("SELECTBYVALUEDD", "id", "userSelect", "Harry Potter", "Set Customer value", true);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and text()='Login']")));
			//driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
			fb.performAction("Click", "xpath", "//button[@type='submit' and text()='Login']", "", "Click on Login button", true);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-lg tab'and @ng-class='btnClass2']")));
			//driver.findElement(By.xpath("//button[@class='btn btn-lg tab'and @ng-class='btnClass2']")).click();
			fb.performAction("Click", "xpath", "//button[@class='btn btn-lg tab'and @ng-class='btnClass2']", "", "Click on Deposit button", true);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number' and @placeholder='amount']")));
			//driver.findElement(By.xpath("//input[@type='number' and @placeholder='amount']")).sendKeys("50000");
			fb.performAction("SetText", "xpath", "//input[@type='number' and @placeholder='amount']", "5000", "Set Deposit amount value", true);
			
			//driver.findElement(By.xpath("//button[@type='submit' and text()='Deposit']")).click();
			fb.performAction("Click", "xpath", "//button[@type='submit' and text()='Deposit']", "", "Click on Deposit button", true);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='error ng-binding' and @ng-show='message']")));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-lg tab'and @ng-class='btnClass1']")));
			//driver.findElement(By.xpath("//button[@class='btn btn-lg tab'and @ng-class='btnClass1']")).click();
			fb.performAction("Click", "xpath", "//button[@class='btn btn-lg tab'and @ng-class='btnClass1']", "", "Click on Transactions button", true);
			
			driver.navigate().refresh();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));
			//driver.findElement(By.xpath("//button[@ng-show='logout']")).click();
			fb.performAction("Click", "xpath", "//button[@ng-show='logout']", "", "Click on Logout button", true);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("userSelect")));
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.close();
			System.out.println("GlobalSQA starts ENDS here...");
		} 
		catch (Exception e) 
		{
			driver.navigate().refresh();
			e.printStackTrace();
		}
		
	}

	
	public void booking() 
	{
		try 
		{
			System.out.println("In booking method");
			driver.get("http://a.testaddressbook.com/");
			WebDriverWait wait=new WebDriverWait(driver, 300);
			repo.logStepToReport(LogStatus.INFO, "URL", "http://a.testaddressbook.com/ open");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in")));
//			driver.findElement(By.id("sign-in")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.id("sign-in")));
			}
			else
			{
				driver.findElement(By.id("sign-in")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click sign in");
//			Thread.sleep(5000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='sign-up']")));
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-test='sign-up']")));
			}
			else
			{
				driver.findElement(By.xpath("//a[@data-test='sign-up']")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click sign up");
//			driver.findElement(By.xpath("//a[@data-test='sign-up']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email' and @id='user_email']")));
			System.out.println("FOUND");
			driver.findElement(By.xpath("//input[@type='email' and @id='user_email']")).sendKeys(emailGenereation());
			repo.logStepToReport(LogStatus.INFO, "Enter ID", "Enter user id");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("iamironman123");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Enter password");
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.name("commit")));
			}
			else
			{
				driver.findElement(By.name("commit")).click();
			}

			repo.logStepToReport(LogStatus.INFO, "Click", "Click on commit button");
//			driver.findElement(By.name("commit")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='addresses']")));
//			driver.findElement(By.xpath("//a[@data-test='addresses']")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-test='addresses']")));
			}
			else
			{
				driver.findElement(By.xpath("//a[@data-test='addresses']")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "address");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='create']")));
//			driver.findElement(By.xpath("//a[@data-test='create']")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-test='create']")));
			}
			else
			{
				driver.findElement(By.xpath("//a[@data-test='create']")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click on create button");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("address_first_name")));
			driver.findElement(By.id("address_first_name")).sendKeys("Steve");
			repo.logStepToReport(LogStatus.INFO, "Enter", "First Name");
			driver.findElement(By.id("address_last_name")).sendKeys("Rogers");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Last name");
			driver.findElement(By.id("address_street_address")).sendKeys("Manhattan");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Address entered");
			driver.findElement(By.id("address_secondary_address")).sendKeys("New York");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Enter secondary address 'New York'");
			driver.findElement(By.id("address_city")).sendKeys("New York");
			Select country=new Select(driver.findElement(By.id("address_state")));
			country.selectByVisibleText("New York");
			repo.logStepToReport(LogStatus.INFO, "Select", "Country");
			driver.findElement(By.id("address_zip_code")).sendKeys("0771");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Pin number '0771' enetred");
			driver.findElement(By.id("address_country_us")).click();
			repo.logStepToReport(LogStatus.INFO, "Click", "Country");
			driver.findElement(By.id("address_birthday")).sendKeys("22-01-1987");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Date of Birth");
			driver.findElement(By.id("address_age")).sendKeys("112");
			repo.logStepToReport(LogStatus.INFO, "Enter", "age");
			driver.findElement(By.id("address_website")).sendKeys("https://www.google.com");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Enter web site");
			driver.findElement(By.id("address_phone")).sendKeys("9878098765");
			repo.logStepToReport(LogStatus.INFO, "Enter", "Phone number 9878098765");
//			driver.findElement(By.name("commit")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.name("commit")));
			}
			else
			{driver.findElement(By.name("commit")).click();
			
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click on commit button.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='list']")));
//			driver.findElement(By.xpath("//a[@data-test='list']")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-test='list']")));
			}
			else
			{
				driver.findElement(By.xpath("//a[@data-test='list']")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click on data list");
//			driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();
			if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-test='sign-out']")));
			}
			else
			{
				driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();
			}
			repo.logStepToReport(LogStatus.INFO, "Click", "Click on sign out");
			System.out.println("In booking method ENDS");
//			driver.close();
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void eCommerceTestCase()
	{
		System.out.println("Going to open URL");
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver, 120);
		System.out.println("After URL entered");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		boolean framedisplayed=false;
		System.out.println("URL opened for Automation Practice");
		
		if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("IE"))
		{
			System.out.println("In JS METHOD");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//li/a[text()='Women']")));
		}
		else
		{
			driver.findElement(By.xpath("//li/a[text()='Women']")).click();
		}
		WebElement womenLink	=	driver.findElement(By.xpath("//a[@title='Women']"));
		wait.until(ExpectedConditions.elementToBeClickable(womenLink));

//		Actions builder	=	new Actions(driver);
		
//		builder.moveToElement(womenLink).perform();
		repo.logStepToReport(LogStatus.INFO, "Click", "Selected Women link");
		System.out.println("Selected Women link");

//		WebElement tshirtLink	=	driver.findElement(By.xpath("//li/a[@title='Women']/../ul/li/a[@title='Tops']/../ul/li/a[@title='T-shirts']"));
		
//		wait.until(ExpectedConditions.elementToBeClickable(tshirtLink));
//		
//		tshirtLink.click();
		
		System.out.println("Selected Tshirt link");
		WebElement productImage	=	driver.findElement(By.xpath("//div[@class='product-image-container']/a/img"));
		wait.until(ExpectedConditions.elementToBeClickable(productImage));
		productImage.click();
		 repo.logStepToReport(LogStatus.INFO, "Click", "Selected the product");
		System.out.println("Selected the product");
		
		try{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("fancybox-iframe")));
			if(driver.findElement(By.className("fancybox-iframe")).isDisplayed()) {
				driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
				framedisplayed=true;
			}
		}catch(Exception e) {
			System.out.println("Frame not found");;
		}
		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("fancybox-iframe")));
//		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='exclusive']")));
		WebElement addToCartButton	=	driver.findElement(By.xpath("//button[@class='exclusive']"));
		addToCartButton.click();
		if(framedisplayed) {
			driver.switchTo().defaultContent();
		}
		
//		driver.switchTo().defaultContent();
		repo.logStepToReport(LogStatus.INFO, "Click", "Added to the cart");
		System.out.println("Added to the cart");
		
		WebElement proceedToCheckoutButton	=	driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
		
		proceedToCheckoutButton.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Proceeded to checkout");
		System.out.println("Proceeded to checkout");
		
		WebElement proceedToCheckoutButton2	=	driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton2));
		
		proceedToCheckoutButton2.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Proceeded to checkout");
		System.out.println("Proceeded to checkout");
		
		WebElement inputEmailAddress	=	driver.findElement(By.xpath("//input[@id='email_create']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(inputEmailAddress));
		String emailaddress = emailGenereation();
		inputEmailAddress.sendKeys(emailaddress);
		repo.logStepToReport(LogStatus.INFO, "Enter email", emailaddress+" Entered the email address");
		System.out.println("Entered the email address");

		WebElement createAccountButton	=	driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
		
		createAccountButton.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Clicked Create Account button");
		System.out.println("Clicked Create Account button");

//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_gender1")));
		try
		{
			WebElement genderRadioButton	=	driver.findElement(By.id("id_gender1"));		
			genderRadioButton.click();
			repo.logStepToReport(LogStatus.INFO, "Select gender", "Selected the gender");
			System.out.println("Selected the gender");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		WebElement firstNameInput	=	driver.findElement(By.id("customer_firstname"));
		
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
		
		firstNameInput.sendKeys("Albert");
		repo.logStepToReport(LogStatus.INFO, "Enter first name", "Albert");
		System.out.println("Entered first name");
		
		WebElement lastNameInput	=	driver.findElement(By.id("customer_lastname"));
		
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
		
		lastNameInput.sendKeys("Mathews");
		repo.logStepToReport(LogStatus.INFO, "Enter lastname", "Mathews");
		System.out.println("Entered last name");
		
		WebElement passwordInput	=	driver.findElement(By.id("passwd"));
		
		wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		
		passwordInput.sendKeys("a2z121");
		repo.logStepToReport(LogStatus.INFO, "Entered password", "a2z121");
		System.out.println("Entered password");
		
		WebElement daysSelect	=	driver.findElement(By.id("days"));
		Select days	=	new Select(daysSelect);
		
		days.selectByValue("10");
		repo.logStepToReport(LogStatus.INFO, "Select days", "10");
		WebElement monthSelect	=	driver.findElement(By.id("months"));
		Select month	=	new Select(monthSelect);
		
		month.selectByValue("4");
		repo.logStepToReport(LogStatus.INFO, "Select month", "4");
		WebElement yearSelect	=	driver.findElement(By.id("years"));
		Select year	=	new Select(yearSelect);
		
		year.selectByValue("1986");
		
		repo.logStepToReport(LogStatus.INFO, "Select year", "1986");
		System.out.println("Selected date of birth");
		
		WebElement addressInput	=	driver.findElement(By.id("address1"));
		
		wait.until(ExpectedConditions.elementToBeClickable(addressInput));
		
		addressInput.sendKeys("777 Brockton Avenue, Abington MA 2351");
		repo.logStepToReport(LogStatus.INFO, "Address", "777 Brockton Avenue, Abington MA 2351");
		System.out.println("Entered address");
		
		WebElement cityInput	=	driver.findElement(By.id("city"));
		
		wait.until(ExpectedConditions.elementToBeClickable(cityInput));
		
		cityInput.sendKeys("Abington");
		repo.logStepToReport(LogStatus.INFO, "Entered City", "Abington");
		System.out.println("Entered City");
		
		WebElement stateSelect	=	driver.findElement(By.id("id_state"));
		
		
		Select state	=	new Select(stateSelect);
		
		state.selectByVisibleText("Pennsylvania");
		repo.logStepToReport(LogStatus.INFO, "Selected state", "Pennsylvania");
		System.out.println("Selected state");
		
		WebElement postalInput	=	driver.findElement(By.id("postcode"));
		
		wait.until(ExpectedConditions.elementToBeClickable(postalInput));
		
		postalInput.sendKeys("19001");
		repo.logStepToReport(LogStatus.INFO, "Entered the postal code", "19001");
		System.out.println("Entered the postal code");
		
		WebElement countrySelect	=	driver.findElement(By.id("id_country"));
		
		
		Select country	=	new Select(countrySelect);
		
		country.selectByVisibleText("United States");
		repo.logStepToReport(LogStatus.INFO, "Selected the country", "United States");
		System.out.println("Selected the country");
		
		WebElement mobilePhoneInput	=	driver.findElement(By.id("phone_mobile"));
		
		wait.until(ExpectedConditions.elementToBeClickable(mobilePhoneInput));
		
		mobilePhoneInput.sendKeys("8855885588");
		repo.logStepToReport(LogStatus.INFO, "Entered mobile number", "8855885588");
		System.out.println("Entered mobile number");
		
		WebElement registerbutton	=	driver.findElement(By.id("submitAccount"));
		
		wait.until(ExpectedConditions.elementToBeClickable(registerbutton));
		
		registerbutton.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Entered Registered Button");
		System.out.println("Entered Registered Button");
		
		WebElement proceedToCheckout3button	=	driver.findElement(By.name("processAddress"));
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout3button));
		
		proceedToCheckout3button.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Processed the address");
		System.out.println("Processed the address");
		
		WebElement termsCheckbox	=	driver.findElement(By.id("cgv"));
		
		termsCheckbox.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Agreed with the terms and conditions");
		System.out.println("Agreed with the terms and conditions");
		
		WebElement proceedToCheckout4button	=	driver.findElement(By.name("processCarrier"));
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout4button));
		
		proceedToCheckout4button.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Process the carrier");
		System.out.println("Process the carrier");

		WebElement payByBankWireLink	=	driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(payByBankWireLink));
		
		payByBankWireLink.click();
		repo.logStepToReport(LogStatus.INFO, "Click", "Selected the payment option as Pay by bank wire");
		System.out.println("Selected the payment option as Pay by bank wire");
		
		WebElement confirmOrderButton	=	driver.findElement(By.xpath("//p[@id='cart_navigation']/button[@type='submit']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
		
		confirmOrderButton.click();
		repo.logStepToReport(LogStatus.INFO, "Order number", "Confirmed the order");
		System.out.println("Confirmed the order");
		
	}
	
	private String emailGenereation() 
	{
		String firstHalf="iamironman",secondHalf="@gmail.com";
		int i=4;
		double random=1;
		
		while(i!=0)
		{
			random=random*10+Math.random();
			i--;
		}
		String email=firstHalf+(int)random+secondHalf;
		return email;
	}
	
	public void waitForPageLoaded(WebDriver driver,long timeInSeconds) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(expectation);
        } catch (Exception e) {
             System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

}
