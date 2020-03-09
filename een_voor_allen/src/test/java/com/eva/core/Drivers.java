package com.eva.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.AndroidUtils;

//import cbt.testExecutors.Executor;
import io.appium.java_client.remote.MobileCapabilityType;
import problems.evaException;


//
//import java.net.URL;
//
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.UnexpectedAlertBehaviour;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import cbt.testExecutors.Executor;
//import eom.eva.enums.Browsers;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
public class Drivers {
	
	/* Queue of Strings to get all the connected devices */
//	static public AndroidUtils androidUtils 		= new AndroidUtils();
//	private static Queue<String> connectedDevices 	= new LinkedList<>(androidUtils.getConnectedDevices());
	public AndroidUtils androidUtils 		= new AndroidUtils();
	private Queue<String> connectedDevices 	= new LinkedList<>(androidUtils.getConnectedDevices());
	// ArrayList for Browsers and IP Ports 
//		static public ArrayList<String> browser 		= new ArrayList<String>();
//		static public ArrayList<String> ipPort 			= new ArrayList<String>();
//		public WebDriver driver;

//	public void ipBrowserConfig() {
//		
//		for (int counter = 0; counter < Integer.parseInt(RuntimeVals.configXML.get("NUMOFTHREADS")); counter++)
//		{
//			browser.add(Executor.xml.readTagVal("BROWSER" + (counter + 1)));
//			ipPort.add("http://" + Executor.xml.readTagVal("IPPORT"   + (counter + 1)) + "/wd/hub");
//		}
//	}
	
	public WebDriver createDriver() throws Exception
	{
		WebDriver driver = null;
		
//		String browserCode = RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName());
		
		String browserCode = RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1);
//		(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1).substring(1)).substring(0, RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1).substring(1).length()-1);
		
//		if(browserCode.contains("IE"))
//		{
//			browserCode = "IE";
//		}
//		else if(browserCode.contains("Firefox"))
//		{
//			browserCode = "FF";
//		}
//		else if(browserCode.contains("Chrome"))
//		{
//			browserCode = "GC";
//		}
//		else if(browserCode.contains("Android"))
//		{
//			
//		}
//		else if(browserCode.contains("MAC"))
//		{
//			
//		}
//		else if(browserCode.contains("IOS"))
//		{
//			
//		}
//		System.out.println(RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()));
//		System.out.println(RuntimeVals.configXML.get("IPPORT"+Thread.currentThread().getName()));
//		System.out.println("http://"+RuntimeVals.configXML.get("IPPORT"+Thread.currentThread().getName())+"/wd/hub");
//		Thread.sleep(100000);
		
		DesiredCapabilities capabilities;
		Thread.sleep(Integer.parseInt(Thread.currentThread().getName()+"000"));
		switch(browserCode) {
			
			case "IE":
				try {
					capabilities		= new DesiredCapabilities().internetExplorer();
//					capabilitiesie.internetExplorer();
					capabilities.setCapability("screen-resolution", "1920x1080");
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
					System.out.println("INFO     :     For current thread"+Thread.currentThread().getName()+"Browser -> "+browserCode);
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), capabilities);
//					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.configXML.get("IPPORT"+Thread.currentThread().getName())+"/wd/hub"), capabilities);
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for IE");
					e.printStackTrace();
				}
				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)), ieCapabilities);
//				CURRENT_BROWSER = 1;
				break;
				
			case "FF":
				try {
					capabilities		= new DesiredCapabilities().firefox();
//					capabilitiesFF.firefox();
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
					capabilities.setCapability("screen-resolution", "1920x1080");
//					System.out.println("INFO     :     Browser -> "+browserCode);
//					System.out.println("INFO     :     For current thread"+Thread.currentThread().getName());
					System.out.println("INFO     :     For current thread"+Thread.currentThread().getName()+"Browser -> "+browserCode);
//					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.configXML.get("IPPORT"+Thread.currentThread().getName())+"/wd/hub"), capabilities);
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), capabilities);
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for FF");
					e.printStackTrace();
				}
				
//				CURRENT_BROWSER = 2;
				break;
				
			case "GC":
				try {
					capabilities		= new DesiredCapabilities().chrome();
//					capabilitiesGC.chrome();
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
					capabilities.setCapability("screen-resolution", "1920x1080");
					System.out.println("INFO     :     For current thread"+Thread.currentThread().getName()+"Browser -> "+browserCode);
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), capabilities);
//					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.configXML.get("IPPORT"+Thread.currentThread().getName())+"/wd/hub"), capabilities);
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for GC");
					e.printStackTrace();
				}
//				CURRENT_BROWSER = 3;
				break;
				
//			
//			case "IOS_SAFARI":
//				CURRENT_BROWSER = 4;
//				break;	
//				
			case "Android":
//			case "ANDROIDCHROME1":
				try {
					DesiredCapabilities androidDesiredCapabilities 	= DesiredCapabilities.android();
					androidDesiredCapabilities.setCapability("screenResolution", "1080x1920");
					androidDesiredCapabilities.setCapability("unicodeKeyboard", true);
					androidDesiredCapabilities.setCapability("resetKeyboard", true);
					
					androidDesiredCapabilities.setCapability("newCommandTimeout", 60 * 3);
					androidDesiredCapabilities.setCapability("noReset", true);
					androidDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					androidDesiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//					androidDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HT4C3WV00232");  // It should be aparmeteriozed
					String devicName = connectedDevices.poll();
					//String devicName = "HT4C3WV00232";
					System.out.println("Driver created for + " + devicName);
					androidDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicName);  // It should be aparmeteriozed
					
					androidDesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
					//androidDesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
					
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), androidDesiredCapabilities);
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for Android");
					e.printStackTrace();
				}
				break;
//				
			case "MAC":
				try {
					DesiredCapabilities safariDesiredCapabilities 	= DesiredCapabilities.safari();
					safariDesiredCapabilities.setBrowserName("safari");
					safariDesiredCapabilities.setPlatform(Platform.MAC);
					safariDesiredCapabilities.setVersion("11.0.3");
//					safariDesiredCapabilities.setAcceptInsecureCerts(true);
					safariDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), safariDesiredCapabilities);
					//driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), safariDesiredCapabilities);
					driver.manage().window().maximize();
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for MAC");
					e.printStackTrace();
				}
				break;
//				
			case "Iphone":
				
				try {
					DesiredCapabilities iOSDesiredCapabilities 	= DesiredCapabilities.iphone();
					iOSDesiredCapabilities.setCapability("screenResolution", "750x1334");

					iOSDesiredCapabilities.setCapability("platformName", "iOS");
					iOSDesiredCapabilities.setCapability("automationName", "XCUITest");
					iOSDesiredCapabilities.setCapability("browserName", "Safari");
					iOSDesiredCapabilities.setCapability("newCommandTimeout", 60 * 3);
					iOSDesiredCapabilities.setCapability("noReset", true);
//					iOSDesiredCapabilities.setCapability("deviceName", Executor.propReader.getProperty("iOSDeviceName"));
					iOSDesiredCapabilities.setCapability("deviceName", "iPhone");
					
					//
					// Below capabilities are not required for simulator
//					if(!Executor.propReader.getProperty("IsIosSimulator").contains("true")) {
//						iOSDesiredCapabilities.setCapability(MobileCapabilityType.UDID,Executor.propReader.getProperty("IOSDeviceID"));
//						iOSDesiredCapabilities.setCapability("bundleId", "com.soprasteria123");
//					}
					iOSDesiredCapabilities.setCapability(MobileCapabilityType.UDID,"f8891b859feabe42832b5a2d486ed43a2fd37c98");
//					iOSDesiredCapabilities.setCapability("bundleId", "com.soprasteria123");
					driver = new RemoteWebDriver(new URL("http://"+RuntimeVals.ip.get(Integer.parseInt(Thread.currentThread().getName())-1)+":"+RuntimeVals.port.get(Integer.parseInt(Thread.currentThread().getName())-1)+"/wd/hub"), iOSDesiredCapabilities);
					
				}
				catch(Exception e)
				{
					System.out.println("Exception     :     Some problem while creating driver for IOS");
					e.printStackTrace();
				}
				break;
				//			
//			case "MAC_CHROME":
//				CURRENT_BROWSER = 8;
//				break;	
//			
//			case "EDGE":
//				CURRENT_BROWSER = 9;
//				break;		
			default:
				System.out.println("Nothing to execute");
				break;
				
			}
				return driver;
	}
}
//	
//	public WebDriver driver;
//	
//	public WebDriver drive()
//	{
//		
//		DesiredCapabilities capabilities 		= new DesiredCapabilities();
//		Browsers BrowserName = null;
//		
//		switch(BrowserName)
//		{
//		case INTERNET_EXPLORER:
//			
//			DesiredCapabilities ieCapabilities 	= DesiredCapabilities.internetExplorer();
//				
//			// If execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//				
//				ieCapabilities.setCapability("name", "CBT Automation Internet Explorer");
//				
//				ieCapabilities.setCapability("browserName", "Internet Explorer");
//				ieCapabilities.setCapability("version", "11");
//				ieCapabilities.setCapability("platform", "Windows 7 64-Bit");
//				ieCapabilities.setCapability("screenResolution", "1920x1080");
//				
//				ieCapabilities.setCapability("max_duration", "1200");
//				ieCapabilities.setCapability("record_video", "true");
//
//				driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),ieCapabilities);
//				
//			// If execution is on local and real devices
//				
//			} else {
//				
//				ieCapabilities.setCapability("screen-resolution", "1920x1080");
//				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)), ieCapabilities);
//				
//			}
//
//			driver.manage().window().maximize();
//			
//			break;
//
//		case FIREFOX:
//			
//			DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
//		
//			firefoxCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			firefoxCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//			
//			// If execution is on CBT
//			
////			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
////				
////				firefoxCapabilities.setCapability("name", "CBT Automation Firefox");
////				
////				firefoxCapabilities.setCapability("browserName", "Firefox");
////				firefoxCapabilities.setCapability("platform", "Windows 7 64-Bit");
////				firefoxCapabilities.setCapability("version", "58x64");
////				firefoxCapabilities.setCapability("screenResolution", "1920x1080");
////				
////				firefoxCapabilities.setCapability("max_duration", "1200");
////				firefoxCapabilities.setCapability("record_video", "true");
////					
////				driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),firefoxCapabilities);
////				
////			// If Execution is on local and real devices
////				
////			} else {
//				
//				firefoxCapabilities.setCapability("screen-resolution", "1920x1080");
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)), firefoxCapabilities);
//				
////			}
//
//			driver.manage().window().maximize();
//			break;
//
//		case CHROME:
//			
//			DesiredCapabilities chromeCapabilities 	= DesiredCapabilities.chrome();
//
//			// If Execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//				
//				chromeCapabilities.setCapability("name", "CBT Automation Chrome");
//				
//				chromeCapabilities.setCapability("browserName", "Chrome");
//				chromeCapabilities.setCapability("platform", "Windows 7 64-Bit");
//				chromeCapabilities.setCapability("version", "63x64");
//				chromeCapabilities.setCapability("screenResolution", "1920x1080");
//				
//				chromeCapabilities.setCapability("max_duration", "1200");
//				chromeCapabilities.setCapability("record_video", "true");
//				
//				driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),chromeCapabilities);
//				
//			// If execution is on local and real devices
//				
//			} else {
//				
//				chromeCapabilities.setCapability("screen-resolution", "1920x1080");
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)), chromeCapabilities);
//			}
//
//			driver.manage().window().maximize();
//			
//			break;
//
//		case ANDROIDCHROME1:
//			
//			DesiredCapabilities androidDesiredCapabilities 	= DesiredCapabilities.android();
//			
//			// If execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//					
//				androidDesiredCapabilities.setCapability("name", "CBT Automation Galaxy S6");
//				
//				androidDesiredCapabilities.setCapability("browserName", "Chrome");
//				androidDesiredCapabilities.setCapability("platformName", "Android");
//				androidDesiredCapabilities.setCapability("deviceName", "Galaxy S6");
//				androidDesiredCapabilities.setCapability("platformVersion", "5.0");
//				androidDesiredCapabilities.setCapability("deviceOrientation", "portrait");
//				
//				androidDesiredCapabilities.setCapability("max_duration", "1200");
//				androidDesiredCapabilities.setCapability("record_video", "true");
//				
//				driver = new AndroidDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),androidDesiredCapabilities);
//				
//			// If execution is on local and real devices
//					
//			} else {
//				
//				androidDesiredCapabilities.setCapability("screenResolution", "1080x1920");
//				androidDesiredCapabilities.setCapability("unicodeKeyboard", true);
//				androidDesiredCapabilities.setCapability("resetKeyboard", true);
//				
//				androidDesiredCapabilities.setCapability("newCommandTimeout", 60 * 3);
//				androidDesiredCapabilities.setCapability("noReset", true);
//				androidDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				androidDesiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//				androidDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Executor.propReader.getProperty("AndroidChrome1DeviceID"));
//				androidDesiredCapabilities.setCapability("platformName", "android");
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)),androidDesiredCapabilities);
//			}
//			
//			break;
//
//		case ANDROIDCHROME2:
//			
//			DesiredCapabilities android2DesiredCapabilities 	= DesiredCapabilities.android();
//			
//			// If execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//
//				android2DesiredCapabilities.setCapability("name", "CBT Automation NEXUS 6P");
//				
//				android2DesiredCapabilities.setCapability("browserName", "Chrome");
//				android2DesiredCapabilities.setCapability("deviceName", "Nexus 6P");
//				android2DesiredCapabilities.setCapability("platformName", "Android");
//				android2DesiredCapabilities.setCapability("platformVersion", "7.0");
//				android2DesiredCapabilities.setCapability("deviceOrientation", "portrait");
//				
//				android2DesiredCapabilities.setCapability("max_duration", "1200");
//				android2DesiredCapabilities.setCapability("record_video", "true");
//				
//				driver = new AndroidDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),android2DesiredCapabilities);
//				
//			// If execution is on local and real devices
//					
//			} else {
//				
//				android2DesiredCapabilities.setCapability("unicodeKeyboard", true);
//				android2DesiredCapabilities.setCapability("resetKeyboard", true);
//				
//				android2DesiredCapabilities.setCapability("newCommandTimeout", 60 * 3);
//				android2DesiredCapabilities.setCapability("noReset", true);
//				android2DesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				android2DesiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//				android2DesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Executor.propReader.getProperty("AndroidChrome2DeviceID"));
//				android2DesiredCapabilities.setCapability("platformName", "android");
//				android2DesiredCapabilities.setCapability("screenResolution", "1080x1915");
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)),android2DesiredCapabilities);
//			}
//			
//			break;
//			
//		case IOS:
//			
//			DesiredCapabilities iOSDesiredCapabilities 	= DesiredCapabilities.iphone();
//			
//			iOSDesiredCapabilities.setCapability("screenResolution", "750x1334");
//			
//			// If execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//				
//				iOSDesiredCapabilities.setCapability("name", "HFS Automation execution on iOS safari browser");
//				
//				iOSDesiredCapabilities.setCapability("browserName", "Safari");
//				iOSDesiredCapabilities.setCapability("deviceName", "iPhone 7 Simulator");
//				iOSDesiredCapabilities.setCapability("platformVersion", "10.0");
//				iOSDesiredCapabilities.setCapability("platformName", "iOS");
//				iOSDesiredCapabilities.setCapability("deviceOrientation", "portrait");
//				
//				iOSDesiredCapabilities.setCapability("max_duration", "1200");
//				iOSDesiredCapabilities.setCapability("record_video", "true");
//
//				driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),iOSDesiredCapabilities);
//
//			// If execution is on local and real devices
//					
//			} else {
//				
//				iOSDesiredCapabilities.setCapability("platformName", "iOS");
//				iOSDesiredCapabilities.setCapability("automationName", "XCUITest");
//				iOSDesiredCapabilities.setCapability("browserName", "Safari");
//				iOSDesiredCapabilities.setCapability("newCommandTimeout", 60 * 3);
//				iOSDesiredCapabilities.setCapability("noReset", true);
//				iOSDesiredCapabilities.setCapability("deviceName", Executor.propReader.getProperty("iOSDeviceName"));
//				
//				// Below capabilities are not required for simulator
//				
//				if(!Executor.propReader.getProperty("IsIosSimulator").contains("true")) {
//					
//					iOSDesiredCapabilities.setCapability(MobileCapabilityType.UDID,Executor.propReader.getProperty("IOSDeviceID"));
//					iOSDesiredCapabilities.setCapability("bundleId", "com.soprasteria123");
//					
//				}
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)),iOSDesiredCapabilities);
//			}
//
//			break;
//
//		case MAC:
//			
//			DesiredCapabilities safariDesiredCapabilities 	= DesiredCapabilities.safari();
//
//			// If execution is on CBT
//			
//			if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//				
//				safariDesiredCapabilities.setCapability("name", "VTB automationon MAC safari browser");
//				
//				safariDesiredCapabilities.setCapability("browserName", "Safari");
//				safariDesiredCapabilities.setCapability("version", "10");
//				safariDesiredCapabilities.setCapability("platform", "Mac OSX 10.12");
//				safariDesiredCapabilities.setCapability("screenResolution", "1920x1200");
//				
//				safariDesiredCapabilities.setCapability("record_video", "true");
//				
//				safariDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				
//				driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), safariDesiredCapabilities);
//				
//			// If execution is on local and real devices
//				
//			} else {
//				
//				safariDesiredCapabilities.setBrowserName("safari");
//				safariDesiredCapabilities.setPlatform(Platform.MAC);
//				safariDesiredCapabilities.setVersion("11.0.3");
//				safariDesiredCapabilities.setAcceptInsecureCerts(true);
//				safariDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				
//				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)),safariDesiredCapabilities);
//				
//				driver.manage().window().maximize();
//			}
//
//			break;
//			
//		case EDGE:
//			
//			DesiredCapabilities edgeCapabilities       = DesiredCapabilities.edge();
//
//            // If Execution is on CBT
//            
//            if (Executor.propReader.getProperty("isCBT").equalsIgnoreCase("true")) {
//                            
//                edgeCapabilities.setCapability("name", "HFS Automation Chrome");
//                edgeCapabilities.setCapability("browserName", "MicrosoftEdge");
//                edgeCapabilities.setCapability("platform", "Windows 10");
//                edgeCapabilities.setCapability("version", "16");
//                edgeCapabilities.setCapability("screenResolution", "1920x1080");
//                edgeCapabilities.setCapability("record_video", "true");
//                
//                driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),edgeCapabilities);
//                
//            // If execution is on local and real devices
//                            
//            } else {
//            	driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name) - 1)), edgeCapabilities);
//            }
//
//            driver.manage().window().maximize();
//
//			break;
//			
//		}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//	return driver;
//
//			
//				
//		}
//		
//	}
//
//}
