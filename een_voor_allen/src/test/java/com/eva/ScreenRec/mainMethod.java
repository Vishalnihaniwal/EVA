package com.eva.ScreenRec;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainMethod {

@SuppressWarnings("null")
public static void main(String[] args) {
		
		WebDriver driver = null;
		
		String url = "https://www.ihg.com/";
		
		try {

			// Initialize Browser
			driver.findElement(TestSomeCode.id("")).click();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "driver"+ File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Navigate to URL
			driver.navigate().to(url);
			// Wait for page load and Enter destination
			Thread.sleep(2000);
			driver.findElement(By.name("dest-input")).click();
			driver.findElement(By.name("dest-input")).clear();
			driver.findElement(By.name("dest-input")).sendKeys("Berlin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
