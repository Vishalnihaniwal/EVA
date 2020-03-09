package com.eva.Business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eva.Reports.Reporting;
import com.eva.Utils.FuncBank;

public class Google {

	FuncBank fb ;
	WebDriver driver; 
	Reporting repo;
	
	public Google(WebDriver driver, Reporting repo)
	{
		System.out.println("In cosntructor");
		this.driver = driver;
		this.repo = repo;
		fb = new FuncBank(driver, repo);
	}
	
	public void booking()
	{
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.className("login-button")).click();
			
			driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();
			driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("cart_checkout_link")));
			driver.findElement(By.className("cart_checkout_link")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-test='firstName']")));
			driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys("Tony");
			driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("Stark");
			driver.findElement(By.xpath("//input[@data-test='postalCode']")).sendKeys("201014");
			driver.findElement(By.className("cart_checkout_link")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("cart_checkout_link")));
			driver.findElement(By.className("cart_checkout_link")).click();
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img")));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
