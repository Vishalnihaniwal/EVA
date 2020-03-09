package com.eva.Business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eva.Reports.Reporting;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.FuncBank;
import com.eva.Utils.ImageComparator;


public class Travels {
	FuncBank fb ;
	WebDriver driver; 
	Reporting repo;
	ImageComparator img;
	
	public Travels(WebDriver driver, Reporting repo)
	{
		this.driver = driver;
		this.repo 	= repo;
		
		fb 			= new FuncBank(driver, repo);
	}

	public void booking() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean check=checkExecution();
		
		System.out.println(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
		img			= new ImageComparator();
		imageComparison(driver, "Home Page", repo);
		try {
			if(check==false)
			{
				WebDriverWait wait=new WebDriverWait(driver, 300);
				try {
					driver.get("http://10.135.155.170:8080/AdventureTravels/ServerPages/index.jsp");
				} catch (Exception e) {
					try {
						driver.get("http://10.135.155.170:8080/AdventureTravels/ServerPages/index.jsp");
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fromCity"))));
					} catch (Exception e1) {
						try {
							driver.get("http://10.135.155.170:8080/AdventureTravels/ServerPages/index.jsp");
							wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fromCity"))));
						} catch (Exception e2) {
							driver.get("http://10.135.155.170:8080/AdventureTravels/ServerPages/index.jsp");
							wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fromCity"))));
						}
					}
				}
				
				
				
				try {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fromCity"))));
				}
				catch (Exception e) {
					
				}
				
				check=checkExecution();
				if(check==false)
				{
				
					try {
						fb.selectByValueDD(driver.findElement(By.id("fromCity")), "Selecting From City", true, "Delhi");
					} catch (Exception e4) {
						try {
							fb.selectByValueDDJS(driver.findElement(By.id("fromCity")), "Selecting From City", true, "Delhi");
						} catch (Exception e) {
							try {
								fb.selectByValueDD(driver.findElement(By.xpath("//select[@id='fromCity']")), "Selecting From City", true, "Delhi");
							} catch (Exception e1) {
								try {
									fb.selectByValueDDJS(driver.findElement(By.xpath("//select[@id='fromCity']")), "Selecting From City", true, "Delhi");
								} catch (Exception e2) {
									fb.selectByValueDDJS(driver.findElement(By.xpath("//select[@id='fromCity']")), "Selecting From City", true, "Delhi");
								}
							}
						}
					}
					
					
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toCity"))));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						fb.selectByValueDD(driver.findElement(By.id("toCity")), "Selecting Destination City", false, "Bangalore");
					} catch (Exception e4) {
						try {
							fb.selectByValueDDJS(driver.findElement(By.id("toCity")), "Selecting Destination City", false, "Bangalore");
						} catch (Exception e) {
							try {
								fb.selectByValueDDJS(driver.findElement(By.xpath("//select[@id='toCity']")), "Selecting Destination City", false, "Bangalore");
							} catch (Exception e1) {
								try {
									fb.selectByValueDD(driver.findElement(By.xpath("//select[@id='toCity']")), "Selecting Destination City", false, "Bangalore");
								} catch (Exception e2) {
									e2.printStackTrace();
									Select dcity=new Select(driver.findElement(By.id("toCity")));
									dcity.selectByVisibleText("Bangalore");
								}
							}
						}
					}
					
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(By.id("departure_date")));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						fb.clickJS(driver.findElement(By.id("departure_date")), "Clicking On Date", false);
					} catch (Exception e4) {
						try {
							fb.Click(driver.findElement(By.id("departure_date")), "Clicking On Date", false);
						} catch (Exception e) {
							try {
								fb.Click(driver.findElement(By.xpath("//input[@id='departure_date']")), "Clicking On Date", true);
							} catch (Exception e1) {
								fb.clickJS(driver.findElement(By.xpath("//input[@id='departure_date']")), "Clicking On Date", true);
							}
						}
					}
					try {
						fb.setText(driver.findElement(By.id("departure_date")), "Entering Date", false, "7/20/2019");
					} catch (Exception e3) {
						try {
							fb.setTextJS(driver.findElement(By.id("departure_date")), "Entering Date", false, "7/20/2019");
						} catch (Exception e) {
							try {
								fb.setTextJS(driver.findElement(By.xpath("//input[@id='departure_date']")), "Entering Date", false, "7/20/2019");
							} catch (Exception e1) {
								try {
									fb.setText(driver.findElement(By.xpath("//input[@id='departure_date']")), "Entering Date", false, "7/20/2019");
								} catch (Exception e2) {
									e.printStackTrace();
									driver.findElement(By.id("departure_date")).sendKeys("7/20/2019");
								}
							}
							
						}
						
					}
					
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Search']")));
					}
					catch (Exception e) {
					}
					
					try {
						fb.Click(driver.findElement(By.xpath("//input[@value='Search']")), "Clicking On Search", false);
					} catch (Exception e2) {
						try {
							fb.clickJS(driver.findElement(By.xpath("//input[@class='form-control btn btn-primary']")), "Clicking On Search", false);
						} catch (Exception e) {
							try {
								fb.Click(driver.findElement(By.xpath("//input[@class='form-control btn btn-primary']")), "Clicking On Search", false);
							} catch (Exception e1) {
								try {
									fb.Click(driver.findElement(By.xpath("//input[@value='Search']")), "Clicking On Search", false);
								} catch (Exception e3) {
									driver.findElement(By.xpath("//input[@value='Search']")).sendKeys(Keys.ENTER);
								}
							}
						}
					}
					
					
					try {
						if(!driver.findElements(By.xpath("//input[@value='Search']")).isEmpty())
						{
							driver.findElement(By.xpath("//input[@value='Search']")).sendKeys(Keys.ENTER);
						}
					}
					catch (Exception e) {
						
					}
					
					check=checkExecution();
					if(check==false)
					{
					
						try {
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Book Now']")));
						}
						catch (Exception e) {
						}
						
						try {
							fb.clickJS(driver.findElement(By.xpath("//button[text()='Book Now']")), "Selecting Flight", false);
						} catch (Exception e1) {
							try {
								fb.clickJS(driver.findElement(By.xpath("(//button[text()='Book Now'])[2]")), "Selecting Flight", false);
							} catch (Exception e) {
								try {
									fb.Click(driver.findElement(By.xpath("(//button[text()='Book Now'])[3]")), "Selecting Flight", false);
								} catch (Exception e2) {
									try {
										fb.Click(driver.findElement(By.xpath("//div[@class='flightsDisplay']//div[2]//div[1]//div[6]//button[1]")), "Selecting Flight", false);
									} catch (Exception e3) {
										try {
											fb.clickJS(driver.findElement(By.xpath("//div[@class='flightsDisplay']//div[2]//div[1]//div[6]//button[1]")), "Selecting Flight", false);
										} catch (Exception e4) {
											fb.clickJS(driver.findElement(By.xpath("(//button[text()='Book Now'])[3]")), "Selecting Flight", false);
										}
									}
									
								}
							}
						}
						
						try {
							if(!driver.findElements(By.xpath("(//button[text()='Book Now'])[3]")).isEmpty())
							{
								driver.findElement(By.xpath("(//button[text()='Book Now'])[3]")).sendKeys(Keys.ENTER);
							}
							
							
						}
						catch (Exception e) {
							}
						
						check=checkExecution();
						if(check==false)
						{
						
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("firstNameUser")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("firstNameUser")), "Clicking on First Name", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("firstNameUser")), "Clicking on First Name", false);
							}
							
							try {
								fb.setText(driver.findElement(By.id("firstNameUser")), "Entering First Name", true, "Test");
							} catch (Exception e1) {
								try {
									fb.setTextJS(driver.findElement(By.id("firstNameUser")), "Entering First Name", true, "Test");
								} catch (Exception e) {
									try {
										fb.setTextJS(driver.findElement(By.xpath("//input[@id='firstNameUser']")), "Entering First Name", true, "Test");
									} catch (Exception e2) {
										try {
											fb.setText(driver.findElement(By.xpath("//input[@id='firstNameUser']")), "Entering First Name", true, "Test");
										} catch (Exception e3) {
											
											driver.findElement(By.id("firstNameUser")).sendKeys("Test");
										}
									}
									
								}
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("lastNameUser")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("lastNameUser")), "Entering Last Name", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("lastNameUser")), "Entering Last Name", true);
							}
							
							try {
								fb.setText(driver.findElement(By.id("lastNameUser")), "Entering Last Name", true, "Test");
							} catch (Exception e1) {
								driver.findElement(By.id("lastNameUser")).sendKeys("Test");
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("phoneNumber")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("phoneNumber")), "Entering Phone Number", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("phoneNumber")), "Entering Phone Number", true);
							}
							
							try {
								fb.setText(driver.findElement(By.id("phoneNumber")), "Entering Phone Number", true, "0011223345");
							} catch (Exception e1) {
								driver.findElement(By.id("phoneNumber")).sendKeys("0011223345");
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("email")), "Entering Email", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("email")), "Entering Email", true);
							}
							
							try {
								fb.setText(driver.findElement(By.id("email")), "Entering Email", true, "example@example.com");
							} catch (Exception e1) {
								driver.findElement(By.id("email")).sendKeys("example@example.com");
							}
							
							try {
								wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("selectCountry"))));
							}
							catch (Exception e) {
							}
							
							try {
								fb.selectByValueDD(driver.findElement(By.id("selectCountry")), "Entering Country", false, "India");
							} catch (Exception e1) {
								try {
									fb.selectByValueDDJS(driver.findElement(By.id("selectCountry")), "Entering Country", false, "India");
								} catch (Exception e) {
									Select country=new Select(driver.findElement(By.id("selectCountry")));
									country.selectByVisibleText("India");
								}
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("city")), "Entering City", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("city")), "Entering City", true);
							}
							
							try {
								fb.setText(driver.findElement(By.id("city")), "Entering City", true, "Delhi");
							} catch (Exception e1) {
								driver.findElement(By.id("city")).sendKeys("Delhi");
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.id("address")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.id("address")), "Entering Address", true);
							} catch (Exception e1) {
								fb.Click(driver.findElement(By.id("address")), "Entering Address", true);
							}
							
							try {
								fb.setText(driver.findElement(By.id("address")), "Entering Address", true, "Delhi, India.");
							} catch (Exception e1) {
								driver.findElement(By.id("address")).sendKeys("Delhi, India.");
							}
							
							try {
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='ContinueBooking']")));
							}
							catch (Exception e) {
							}
							
							try {
								fb.clickJS(driver.findElement(By.xpath("//input[@value='ContinueBooking']")), "Clicking On Continue Booking", false);
							} catch (Exception e) {
								try {
									fb.Click(driver.findElement(By.xpath("//input[@value='ContinueBooking']")), "Clicking On Continue Booking", false);
								} catch (Exception e1) {
									try {
										fb.Click(driver.findElement(By.xpath("//input[@class='btn btn-large btn-success']")), "Clicking On Continue Booking", false);
									} catch (Exception e2) {
										try {
											fb.clickJS(driver.findElement(By.xpath("//input[@class='btn btn-large btn-success']")), "Clicking On Continue Booking", false);
										} catch (Exception e3) {
											driver.findElement(By.xpath("//input[@value='ContinueBooking']")).sendKeys(Keys.ENTER);
										}
									}
									
								}
							}
							
							try {
								if(!driver.findElements(By.xpath("//input[@value='ContinueBooking']")).isEmpty())
								{
									driver.findElement(By.xpath("//input[@value='ContinueBooking']")).sendKeys(Keys.ENTER);
								}
								
							}
							catch (Exception e) {
								// TODO: handle exception
							}
							
							check=checkExecution();
							if(check==false)
							{
							
								try {
									wait.until(ExpectedConditions.elementToBeClickable(By.id("cardNumber")));
								}
								catch (Exception e) {
								}
								
								try {
									fb.clickJS(driver.findElement(By.id("cardNumber")), "Entering Card Number", true);
								} catch (Exception e1) {
									fb.Click(driver.findElement(By.id("cardNumber")), "Entering Card Number", true);
								}
								
								fb.setText(driver.findElement(By.id("cardNumber")), "Entering Card Number", true, "1234123412341234");
								
								try {
									wait.until(ExpectedConditions.elementToBeClickable(By.id("cvvNumber")));
								}
								catch (Exception e) {
								}
								
								try {
									fb.clickJS(driver.findElement(By.id("cvvNumber")), "Entering CVV Number", true);
								} catch (Exception e1) {
									fb.Click(driver.findElement(By.id("cvvNumber")), "Entering CVV Number", true);
								}
								fb.setText(driver.findElement(By.id("cvvNumber")), "Entering CVV Number", true, "123");
								
								try {
									wait.until(ExpectedConditions.elementToBeClickable(By.id("expiryDate")));
								}
								catch (Exception e) {
								}
								
								try {
									fb.clickJS(driver.findElement(By.id("expiryDate")), "Entering Expiry Date", true);
								} catch (Exception e1) {
									fb.Click(driver.findElement(By.id("expiryDate")), "Entering Expiry Date", true);
								}
								fb.setText(driver.findElement(By.id("expiryDate")), "Entering Expiry Date", true, "12-02-2019");
								
								try {
									wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Confirm Payment']")));
								}
								catch (Exception e) {
								}
								
								check=checkExecution();
								if(check==false)
								{
								
									try {
										fb.clickJS(driver.findElement(By.xpath("//input[@value='Confirm Payment']")), "Clicking On Confirm Payment", false);
									} catch (Exception e) {
										try {
											fb.clickJS(driver.findElement(By.xpath("//input[@value='Confirm Payment']")), "Clicking On Confirm Payment", false);
										} catch (Exception e1) {
											try {
												fb.Click(driver.findElement(By.xpath("//input[@value='Confirm Payment']")), "Clicking On Confirm Payment", false);
											} catch (Exception e2) {
												try {
													fb.Click(driver.findElement(By.xpath("//input[@class='btn btn-large btn-success']")), "Clicking On Confirm Payment", false);
												} catch (Exception e3) {
													try {
														fb.clickJS(driver.findElement(By.xpath("//input[@class='btn btn-large btn-success']")), "Clicking On Confirm Payment", false);
													} catch (Exception e4) {
														driver.findElement(By.xpath("//input[@value='Confirm Payment']")).sendKeys(Keys.ENTER);
													}
												}
												
											}
										}
									}
									
									try {
										if(!driver.findElements(By.xpath("//input[@value='Confirm Payment']")).isEmpty())
										{
											driver.findElement(By.xpath("//input[@value='Confirm Payment']")).sendKeys(Keys.ENTER);
										}
									} catch (Exception e) {
										
									}
								}
							}
						}
					}
				}
			}
			
			check=checkExecution();
			if(check==false)
			{
			
				String status= fb.getText(driver.findElement(By.xpath("//b[contains(text(),'Confirmed')]")), "Getting Confirmation", true);
				String bookingRef=fb.getText(driver.findElement(By.xpath("(//div[@class='displayInfo']//div[@class='value'])[3]")), "Getting Reference Number", true);
				
				System.out.println(status+" "+bookingRef);
				fb.verifyText(driver.findElement(By.xpath("//b[contains(text(),'Confirmed')]")), "Status Verified", true, status);
				fb.verifyText(driver.findElement(By.xpath("(//div[@class='displayInfo']//div[@class='value'])[3]")), "Booking Refrence Number Verified", true, bookingRef);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}finally {
			driver.quit();
		}
		
		
		
	}
	public void booking2()
	{
		try {
			
			try {
				driver.get("http://10.135.155.170:8080/AdventureTravels/ServerPages/Input.jsp");
			} catch (Exception e) {
			}
			
			fb.selectByValueDD(driver.findElement(By.name("destination16")), "Entering Destination", true, "Mumbai");
			
			fb.Click(driver.findElement(By.id("checkIn18")), "Clicking on Check In Date", true);
			fb.setText(driver.findElement(By.id("checkIn18")), "Entering Check In date", true,"2019-07-17");
			
			fb.Click(driver.findElement(By.id("checkOut20")), "Clicking on Check In Date", true);
			fb.setText(driver.findElement(By.id("checkOut20")), "Entering Check In date", true,"2019-07-20");
			
			fb.Click(driver.findElement(By.xpath("//input[@value='SUBMIT']")), "Clicking Submit", false);
			
			fb.Click(driver.findElement(By.xpath("//input[@value='BOOKNOW']")), "Clicking Book Now Button", false);
			
			fb.Click(driver.findElement(By.id("fname")), "Selecting First Name", true);
			fb.setText(driver.findElement(By.id("fname")), "Entering First Name", true, "Test");
			
			fb.Click(driver.findElement(By.id("mailid")), "Selecting Email Id", true);
			fb.setText(driver.findElement(By.id("mailid")), "Entering Email Id", true, "example@example.com");
			
			fb.Click(driver.findElement(By.id("mobile")), "Selecting Mobile Number", true);
			fb.setText(driver.findElement(By.id("mobile")), "Entering Mobile Number", true, "9765432123");
			
			fb.clickJS(driver.findElement(By.xpath("//input[@value='Submit']")), "Clicking Submit", false);
			
			fb.clickJS(driver.findElement(By.xpath("//input[@value='BOOK']")), "Clicking BOOK", false);
			
			fb.Click(driver.findElement(By.name("Cardholder")), "Clicking on Cardholder name", true);
			fb.setText(driver.findElement(By.name("Cardholder")), "Entering Cardholder Name", true, "garima");
			
			fb.Click(driver.findElement(By.name("mobile")), "Clicking on Mobile Number", true);
			fb.setText(driver.findElement(By.name("mobile")), "Entering Mobile Number", true, "9519941994");
			
			fb.Click(driver.findElement(By.name("cardNo")), "Clicking on Number Number", true);
			fb.setText(driver.findElement(By.name("cardNo")), "Entering Number Number", true, "123412341234123");
			
			fb.selectByValueDD(driver.findElement(By.id("month")), "Selecting Expiry Month", true, "July");
			
			fb.selectByValueDD(driver.findElement(By.id("year")), "Selecting Expiry Year", true, "2025");
			
			fb.Click(driver.findElement(By.name("Cvv")), "Clicking on cvv Number", true);
			fb.setText(driver.findElement(By.name("Cvv")), "Entering cvv Number", true, "123");
			
			fb.clickJS(driver.findElement(By.xpath("//input[@value='BOOK']")), "Clicking BOOK", false);
			
			String confirm=fb.getText(driver.findElement(By.xpath("//label[@for='hotelName']")), "Getting Confirmation", true);
			fb.verifyText(driver.findElement(By.xpath("//label[@for='hotelName']")), "Getting Confirmation", true, confirm);
			String bookingRef=fb.getText(driver.findElement(By.xpath("//label[@for='Booking-ID']")), "Getting Booking Refrence Id", true);
			fb.verifyText(driver.findElement(By.xpath("//label[@for='Booking-ID']")), "Getting Booking Refrence Id", true, bookingRef);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			driver.quit();
		}
	}
	
	public boolean checkExecution()
	{
		if(RuntimeVals.stopExecution==true)
		{
			System.out.println("Stopping Execution::::::");
			return true;
		}
		return false;
	}
	
	public void imageComparison(WebDriver driver,String pageName,Reporting report)
	{
		if(RuntimeVals.imageComparison)
		{
			System.out.println("Comaparing Image");
			
			//img.checkVisual4Page(driver, pageName, report);
		}
	}

}
