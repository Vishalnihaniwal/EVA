package com.eva.Reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
//import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eva.Executors.ExecuteMe;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.AndroidUtils;
import com.eva.Utils.UtilityFunctionBank;
import com.eva.core.Drivers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import cbt.testExecutors.Executor;

public class Reporting  {

	public String folderName;
	public String screenshotsFolder;
	public String folder;
	public String folderpath;
	WebDriver driver;
	public ExtentReports extentReports;
	public ExtentTest test;
	
	Date date 										= new Date();
	public String imagePath 						= "";
	DateFormat dateFormat 							= new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
	public String osName 					= "";
	public String screeenResolution 			= "";
	public String deviceName 				= "";
	public String browserName 				= "";
	static AtomicInteger Threadcounter = new AtomicInteger(1);
	
	/** Default Constructor - Initialized */
	
	public Reporting() {	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Parameterized Constructor  - Create folders for report and screenshots 
	 * @param driver			  - WebDriver i.e Internet Explorer, Firefox, Chrome etc.
	 * @param Browserip			  - Browser name from config file						
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	static AndroidUtils androidUtils 		= new AndroidUtils();
	
	public Reporting(String Browserip) throws Exception, InterruptedException {
		LinkedHashMap<String, String>androiddetails = (LinkedHashMap<String, String>) androidUtils.getConnectedDevicesDetails();
//		Thread.sleep(Integer.parseInt(Thread.currentThread().getName()+"000"));
		String browserCode = Browserip.toUpperCase();
		
		System.out.println(androiddetails.get("deviceID1"));
		if(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("Android"))
		{
			browserCode = "Android"+Threadcounter.getAndIncrement();
			System.out.println(browserCode);
		}
		switch(browserCode.toUpperCase()) {
			
		case "FF" :
			
			osName 				= "WINDOWS";
			browserName 		= "FIREFOX";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
			break;
			
		case "IE" :
			
			osName 				= "WINDOWS";
			browserName 		= "INTERNET_EXPLORER";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
			break;
			
		case "GC" :
			
			osName 				= "WINDOWS";
			browserName 		= "CHROME";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
			break;
			
		case "ANDROID" :
			
			osName 				= "ANDROID";
			browserName 		= "CHROME"; 
			deviceName 			= androiddetails.get("deviceID1");
			screeenResolution 	= "1080x1920";
			
			break;
			
		case "ANDROID2" :
			
			osName 				= "ANDROID";
			browserName 		= "CHROME";
			deviceName 			= androiddetails.get("deviceID2");
			screeenResolution 	= "1080x1915";
			
			break;	
			
		case "IPHONE" :
			
			osName 				= "IOS";
			browserName 		= "SAFARI";
			deviceName 			= "I_PHONE_7";
			screeenResolution 	= "750X1334";
			
			break;
			
		case "MAC" :
			
			osName 				= "MAC";
			browserName 		= "SAFARI";
			deviceName 			= "";
			screeenResolution 	= "2880X1800";
			
			break;
		
		case "MAC_CHROME" :
			
			osName 				= "MAC";
			browserName 		= "CHROME";
			deviceName 			= "";
			screeenResolution 	= "2880X1800";
			
			break;	
		
		case "EDGE" :
			
			osName 				= "WINDOWS";
			browserName 		= "EDGE";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
			break;		
		
		default :
			
			osName 				= "WINDOWS";
			browserName 		= "CHROME";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
			break;	
		}
				
		// Create folder for reports
		createFolder(osName, browserName, deviceName, ExecuteMe.uniqueID);
				
		// Initialize extent report HTML
		extentReports 			= new ExtentReports(folderpath + File.separator + osName + "_" + browserName + "_" + deviceName + "_Report.html", false);
		
		// Load Extent Configuration
		extentReports.loadConfig(new File("extent-config.xml"));
		
		// Copy Sopra Steria logo to report folder
		String basePath 		= new File("").getAbsolutePath();
		System.out.println(basePath + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "soprasterialogo.png");
		copyFile(basePath + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "soprasterialogo.png", folderpath + File.separator + "soprasterialogo.png");
		Path path 				= Paths.get(folderpath + File.separator + "soprasterialogo.png");
		
		// Hide logo image file
		DosFileAttributes dos 	= Files.readAttributes(path, DosFileAttributes.class);
		Files.setAttribute(path, "dos:hidden", true);		
		extentReports.flush();
		
	}

	public void setDriver(WebDriver driver) {
		
		try {
			this.driver 	= driver;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Function 			- Create Reporting and Screenshot folders 
	 * @param osName		- Name of operating system
	 * @param browserName	- Name of browser
	 * @param deviceName	- Name of device (empty if windows or MAC Laptop or desktop)
	 * @param Uniqueid		- Time stamp value						
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		
	public String createFolder(String osName, String browserName, String deviceName, String Uniqueid) {
		
		String basePath 	= new File("").getAbsolutePath();
		folderName 			= "";
		
		try {
			
			// Check Reports folder create if not created
			File file 		= new File(basePath + File.separator + "Reports");
			UtilityFunctionBank.createFolder(file);
//			if (!file.exists()) { 
//				if (file.mkdir()) {} }
			
			// Check TimeStamp folder create if not created
			
			folderName 		= basePath + File.separator + "Reports" + File.separator + Uniqueid;
			file 			= new File(folderName);
			UtilityFunctionBank.createFolder(file);
//			if(!file.exists()) {
//				if (file.mkdir()) {} }
			
			// Create OS folder
			
			folderName 		= folderName + File.separator + osName;
			file 			= new File(folderName);
			UtilityFunctionBank.createFolder(file);
//			if(!file.exists()) {
//				if (file.mkdir()) {	} }
			
			// Create browser folder
			
			System.out.println("browserName - " + browserName);
			
			if(deviceName.equals("")) {
				folderName 	= folderName + File.separator + browserName;
			} else {
				folderName 	= folderName + File.separator + deviceName + "_" + browserName;
			}
			
			file 			= new File(folderName);
			UtilityFunctionBank.createFolder(file);
//			if(!file.exists()) {
//				if (file.mkdir()) {	} }
			
			// Create Screenshots folder
			
			file 			= new File(folderName + File.separator + "Screenshots");
			
			if (file.mkdir()) {
				screenshotsFolder = folderName + File.separator + "Screenshots";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setFolderpath(folderName);
		setfolder(Uniqueid);
		return folderName;
		
	}
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Function 			- Set Reporting Folder Path 
	 * @param folderpath 	- folder path to set					
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public void setFolderpath(String folderpath) {
		
		this.folderpath = folderpath;
		imagePath 		= folderpath + File.separator + "Screenshots" + File.separator;
		
	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Function 			- Set Reporting Folder
	 * @param foldername 	- Folder name to set					
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public void setfolder(String foldername) {
		this.folder = foldername;
	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Function 			- Generate Current Date Number which can be used to create Reporting Folder
	 * @param foldername 	- Folder name to set					
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public static String generateCurrentDateNumber() {
		
		Date dNow 				= new Date();
		SimpleDateFormat sFrmt 	= new SimpleDateFormat("ddMMMyyyy_hhmmss_SSaa");
		String folderName 		= sFrmt.format(dNow);
		
		return folderName;
	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 * Function 		- Get screenshot from Screenshots folder
	 * @param fileName	- 
	 * @param element	- 
	 * @return				
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	public String getscreenshot(String fileName, WebElement element) {
		
		DateFormat dateFormat 	= new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
		Date date 				= new Date();
		String screenshotfile 	= dateFormat.format(date) + ".png";
		
		try  {
			
			if (element != null) {
				
				// Highlighting webElement has been commented due to some issues
				JavascriptExecutor javascript = (JavascriptExecutor) this.driver;
				javascript.executeScript("arguments[0].style.border='3px solid red'", element);
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE), new File(fileName+screenshotfile));
				//javascript.executeScript("arguments[0].style.border='3px solid red'", element);
			} else {
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE), new File(fileName+screenshotfile));
			}
			
		} catch (Exception e) {

			try {
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE), new File(fileName+screenshotfile));
			} catch(Exception e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		
		return "Screenshots/" + screenshotfile;
	}

	/** Overloaded function to get screenshot from Screenshots folder
	 * @param fileName
	 * @param element
	 * @return 	*/
	
	public String getscreenshot(String fileName) {
		
		DateFormat dateFormat 	= new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
		Date date 				= new Date();
		String screenshotfile 	= dateFormat.format(date) + ".png";
		
		try {
			FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE), new File(fileName+screenshotfile));			
		} catch(Exception e1) {
			e1.printStackTrace();
		}

		return "Screenshots/" + screenshotfile;
	}

	/** Function - Log step into the extent report
	 * @param status
	 * @param stepname
	 * @param Details
	 * @param filenamePath
	 * @param element
	 */
	
	public void logStepToReport(LogStatus status, String stepname, String Details, String filenamePath,WebElement element) {
		if(!filenamePath.equalsIgnoreCase("")) {
			try {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'><a "+ NewWindowPopUpHTMLCode() + " target='_blank' href="+ getscreenshot(filenamePath, element) + ">Screenshot</a></div>");
			} catch(Exception e) {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");
			}
		} else {
			test.log(status, stepname, Details);
		}
		extentReports.flush();
	}

	public void logStepToReport(LogStatus status, String stepname, String Details, boolean takeScreenShot, WebElement element) {
		//highlightWebElement(driver, element);
		if(takeScreenShot) {
			try {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'><a "+ NewWindowPopUpHTMLCode() + " target='_blank' href="+ getscreenshot(imagePath, element) + ">Screenshot</a></div>");
			} catch(Exception e) {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");
			}
		} else {
			test.log(status, stepname, Details);
		}
		extentReports.flush();
	}
	/** Function - Log step into the extent report
	 * @param status
	 * @param stepname
	 * @param Details
	 * @param filenamePath
	 * @param element
	 */
	
	public void logStepToReport(LogStatus status, String stepname, String Details, String filenamePath) {
	
		if(!filenamePath.equalsIgnoreCase("")) {
			
			try {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'><a "+ NewWindowPopUpHTMLCode() + " target='_blank' href="+ getscreenshot(filenamePath) + ">Screenshot</a></div>");
			} catch(Exception e) {
				test.log(status, "<font color=800080> <b> " + stepname, Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");
			}
			
		} else {
			test.log(status, stepname, Details);
		}
		
		extentReports.flush();
	}
	
	/** Function - Log step into the extent report
	 * @param status
	 * @param stepname
	 * @param Details
	 * @param filenamePath
	 * @param element
	 */
	
	public void logStepToReport(LogStatus status, String stepname, String Details) {
	
			try {
				test.log(status, "<font color=800080> <b> " + stepname, Details );
			} catch(Exception e) {
				
			}
		
		extentReports.flush();
	}
	
	/** Function - highlight Element
	 * @param driver
	 * @param element
	 */
	public void highlightWebElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js	=	(JavascriptExecutor)driver; 
		
		try {
			
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			
			Thread.sleep(100);
			
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	/** Function - highlight Element
	 * @param driver
	 * @param element
	 */
//	public void highlightWebElement(WebDriver driver, WebElement element) {
//		
//		JavascriptExecutor js	=	(JavascriptExecutor)driver; 
//		
//		try {
//			
//			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
//			
//			Thread.sleep(100);
//			
//			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//	}

	/** Function - Verify Condition and report in Extent Report
	 * @param conditionToCheck
	 * @param passMessage
	 * @param failMessage
	 */
	public void verifyCondition(boolean conditionToCheck, String passMessage, String failMessage) {
		if (conditionToCheck) {
			assertThat(true, passMessage, failMessage);
		} else {
			assertThat(false, passMessage, failMessage);
		}
	}
	

	/** Overloaded function to assert Expected condition with the Actual Condition
	 * @param status
	 * @param passMessage
	 * @param failMessage
	 */
	public void assertThat(boolean status,String passMessage, String failMessage) {
		
		if(!status) {
			
			String line2 = " Expected - " + passMessage + "<br> <b> <font color='red'> Actual - " + failMessage;
			
			test.log(LogStatus.FAIL, "<font color=800080> <b> Verification Point", line2 + "<div align='right' style='float:right'><a " + NewWindowPopUpHTMLCode() + " target='_blank' href="+ getscreenshot(imagePath) + ">Screenshot</a></div>");
			
		} else {
						
			String line2 = " Expected - " + passMessage + "<br> <b> <font color='green'> Actual - " + passMessage;
			
			test.log(LogStatus.PASS, "<font color=800080> <b> Verification Point", line2 + "<div align='right' style='float:right'><a " + NewWindowPopUpHTMLCode() + " target='_blank' href="+ getscreenshot(imagePath) + ">Screenshot</a></div>");
			
		}
		
		extentReports.flush();
		
	}
	
	/**	Function - End Test Cases	 */
	
	public void endTestCase()	{
		extentReports.endTest(test);
	}

	/**
	 * Function 			- To copy one file to other
	 * @param fromLocation	- Source file path
	 * @param toLocation	- Destination file path
	 */
	
	public static void copyFile(String fromLocation, String toLocation) throws Exception {
		
		FileInputStream instream 	= null;
		FileOutputStream outstream 	= null;
	 
    	try {
    		
    	    File infile 			= new File(fromLocation);
    	    File outfile 			= new File(toLocation);
    	    instream 				= new FileInputStream(infile);
    	    outstream 				= new FileOutputStream(outfile);
    	    byte[] buffer 			= new byte[1024];
 
    	    int length;
    	    
    	    // Copy contents from input stream to output stream using read and write methods
    	     
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    // Close input / output file streams
    	    
    	    instream.close();
    	    outstream.close();
 
    	}catch(Exception ioe){
    		ioe.printStackTrace();
    	}
	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  Function 				- Generate attribute tag to open mentioned file path in new pop up window 
	 *  @param filePath			- Source file path
	 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public static String NewWindowPopUpHTMLCode() {
		
//		return "onclick = \"window.open(this.href,'newwindow', 'width=" + ExecuteMe.propReader.getProperty("ReportPopUpWindowWidth") + ",height=" + Executor.propReader.getProperty("ReportPopUpWindowHeight") + "');return false;\"";
		return "onclick = \"window.open(this.href,'newwindow', 'width=1000,height=500');return false;\"";
	}
	
	
}
