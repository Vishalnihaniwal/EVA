package com.eva.Utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.eva.Executors.ExecuteMe;
import com.eva.Reports.Reporting;
import com.eva.SomePojos.RuntimeVals;
//import com.b22222.app.ImageCompareState;
import com.relevantcodes.extentreports.LogStatus;


public class ImageComparator 
{

	public String osName 								= "";
	public String screeenResolution 					= "";
	public String deviceName 							= "";
	public String browserName 							= "";
	public Boolean resultStatus 						= false;
	//public String Browserip 							= Executor.xml.readTagVal("BROWSER" + Thread.currentThread().getName());  //RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName());
	public String Browserip 							= RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1);//RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName());
	
	public void init() {
		
		if(Browserip.contains("FF")) {
			
			osName 				= "WINDOWS";
			browserName 		= "FIREFOX";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
		} else if(Browserip.contains("IE")) {
			
			osName 				= "WINDOWS";
			browserName 		= "INTERNET_EXPLORER";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
		} else if(Browserip.contains("GC")){
			
			osName 				= "WINDOWS";
			browserName 		= "CHROME";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
		} else if(Browserip.contains("ANDROIDCHROME1")){
			
			osName 				= "ANDROID";
			browserName 		= "CHROME";
			deviceName 			= "LE_S2";
			screeenResolution 	= "1080x1920";
			
		} else if(Browserip.contains("ANDROIDCHROME2")){
			
			osName 				= "ANDROID";
			browserName 		= "CHROME";
			deviceName 			= "NEXUS 9";
			screeenResolution 	= "1536x2048";
			
		} else if(Browserip.contains("IOS_SAFARI")){
			
			osName 				= "IOS";
			browserName 		= "SAFARI";
			deviceName 			= "I_PHONE_7";
			screeenResolution 	= "750X1334";
			
		} else if(Browserip.contains("MAC_SAFARI")){
			
			osName 				= "MAC";
			browserName 		= "SAFARI";
			deviceName 			= "";
			screeenResolution 	= "2880X1800";
			
		} else if(Browserip.contains("MAC_CHROME")){
			
			osName 				= "MAC";
			browserName 		= "CHROME";
			deviceName 			= "";
			screeenResolution 	= "2880X1800";
			
		} else if(Browserip.contains("EDGE")){
			
			osName 				= "WINDOWS";
			browserName 		= "EDGE";
			deviceName 			= "";
			screeenResolution 	= "1920x1080";
			
		}
	
	}
	
	/**
	 * Function 	- To get difference image where different part is highlighted in red
	 * @param img1	- image
	 * @param img2	- image
	 */
	
	public BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2) {
		
		BufferedImage outImg 		= null;
		int resultFlag 				= 0;
		
		try {
	    
	    	int width1 				= img1.getWidth(); 					// Change - getWidth() and getHeight() for BufferedImage
		    //int width2 				= img2.getWidth(); 					// Take no arguments
		    int height1 			= img1.getHeight();
		    //int height2 			= img2.getHeight();
		    
		    // NEW - Create output Buffered image of type RGB
		    
		    outImg 					= new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB); // outImg is third buffered image so that we can write the difference between current and baseline images
	    
		    int diff;
		    int result; 												// Stores output pixel
		    
		    for (int i = 0; i < height1; i++) {

		        for (int j = 0; j < width1; j++) {
		        	
		        	int rgb1 		= img1.getRGB(j, i);
		            int rgb2 		= img2.getRGB(j, i);
		            
		            // for ref :- https://www.geeksforgeeks.org/image-processing-java-set-14-comparison-two-images/
		            
		            int r1 			= (rgb1 >> 16) & 0xff; // red color
		            int g1 			= (rgb1 >> 8) & 0xff; // green color
		            int b1 			= (rgb1) & 0xff; // blue color
		            
		            int r2 			= (rgb2 >> 16) & 0xff;
		            int g2 			= (rgb2 >> 8) & 0xff;
		            int b2 			= (rgb2) & 0xff;
		            /****************************************************
		             * Rahul will look into this their is some ambiguity in it
		             */
		            diff 			= 0 ;
		            diff 			= Math.abs(r1 - r2); 				// it is comparing red color among the RGB
		            
		            if(diff == 0) {
		            	
			            result 			= rgb1;
			            
		            } else {
		            
		            	diff += Math.abs(g1 - g2);
			            diff += Math.abs(b1 - b2);
			            diff /= 3; 										// Change - Ensure result is between 0 - 255
			            
			            // Make the difference as red
			            resultFlag = 1;
			            result 			= 16737380;
		            }
		            /*********************************************************/
		            //Following will write the image one pixel to output image if there is no difference.
		            // if there is any difference then red pixel will be written in output image.
		            outImg.setRGB(j, i, result); // Set result 
		            
		        }
		    }
		    
		    if(resultFlag == 0) {
		    	resultStatus = true;
		    }
		    
	    } catch (Exception e) {
	    	//e.printStackTrace();
	    }
		
	    // Now return
	    return outImg;
	}

	
	public String getDiffImage(String image1FilePath, String image2FilePath, String resultImgFilePath) {
		
		try {
			
			File image1File 			= new File(image1FilePath);
			File image2File 			= new File(image2FilePath);
			
			if(image1File.exists() && image2File.exists()) {
			
				BufferedImage image1 	= ImageIO.read(image1File);
				BufferedImage image2 	= ImageIO.read(image2File);
				BufferedImage image3 	= getDifferenceImage(image1, image2);
				File resultImage 		= new File(resultImgFilePath + ".png");
				Boolean resultval 		= ImageIO.write(image3, "png", resultImage);
				
				if(!resultval) {
					return "Image not saved";
				}
				System.out.println("success");
				return "Success";
				
			} else {
				
				Reporting.copyFile(image2FilePath, image1FilePath);
				return "Baseline image not exist...new baseline image created";
				
			}
			
		} catch (Exception e1) {
			//e1.printStackTrace();
			return "Exception - " + e1.getMessage();
		}		
	}
	
	public Boolean createBaseline(WebDriver driver, String pageImageName) {
		
		try {
			
			String basePath 	= new File("").getAbsolutePath(); 
			basePath 			= basePath + File.separator + "TestData" + File.separator + "BaseLines";
			File file 			= new File(basePath);
			
			if (!file.exists()) {
				if (file.mkdir()) {
				} 
			}
			
			basePath 			= basePath + File.separator + osName;
			file 				= new File(basePath);
			
			if (!file.exists()) {
				if (file.mkdir()) {
				} 
			}
			
			basePath 			= basePath + File.separator + screeenResolution;
			file 	 			= new File(basePath);
			
			if (!file.exists()) {
				if (file.mkdir()) {
				} 
			}
			
			captureFullPageScreenshot(driver, basePath + File.separator + pageImageName);
			
			return true;
			
		} catch(Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public void captureFullPageScreenshot(WebDriver driver, String filePath) {
		
		try {
			
		    JavascriptExecutor jexec 	= (JavascriptExecutor)driver;
		    int fileIndex 				= 1;
		    int imageheight 			= (int)(long)jexec.executeScript("return document.body.scrollHeight");
		    
		    boolean isScrollBarPresent 	= (boolean)jexec.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		    
		    Thread.sleep(2000);
		    
		    if(isScrollBarPresent) {
		    	
		    	jexec.executeScript("window.scrollTo(0,0)"); 							// will scroll to (0,0) position
		    	
		    	long scrollHeight 		= (long)jexec.executeScript("return document.documentElement.scrollHeight");
			    long clientHeight 		= (long)jexec.executeScript("return document.documentElement.clientHeight");
			    int height 				= (int)scrollHeight;
			    imageheight				= height;
			    
			    Thread.sleep(2000);
			    
			    while(scrollHeight > 0) {
	            	
			    	Thread.sleep(5000); 		// Temporary wait need to be conditional
			    	
	                File srcFile 		= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                FileUtils.copyFile(srcFile, new File(new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + Browserip + String.valueOf(fileIndex) + ".png"));
	                jexec.executeScript("window.scrollTo(0,"+clientHeight*fileIndex +")");
	                scrollHeight 		= scrollHeight - clientHeight;
	                fileIndex++;
	            }
			    
		    } else {
		    	try {
		    		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(filePath + ".png"));
		    		return;
		    	} catch(Exception e) {
		    		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(filePath + ".png"));
		    		return;
		    	}
	        }
	    
		    // Combine all the .png file to single file
	    	
	    	int browserWidth 			= 1920;  // this browser width [ upto maximum level]
	    	
	    	if(Browserip.contains("FF") || Browserip.contains("IE") || Browserip.contains("GC") || Browserip.contains("ANDROIDCHROME2")) {
	    		browserWidth 			= 1920;
	    	} else if(Browserip.contains("IOS_SAFARI")){
	    		browserWidth 			= 750;
			} else if(Browserip.contains("ANDROIDCHROME1")){
				browserWidth 			= 1080;
			} else if(Browserip.contains("MAC_SAFARI")){
				browserWidth 			= 2880;
			}
	    	
	    	int width 					= 0;
	    	int height 					= 0;
	    	
	    	BufferedImage result 		= new BufferedImage(browserWidth, imageheight, BufferedImage.TYPE_INT_RGB);
	    	Graphics g 					= result.getGraphics();
	    	
	    	
    	   for(int currIndex = 1 ; currIndex < fileIndex ; currIndex++) {
    		   
    		    String image 			= new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + Browserip + String.valueOf(currIndex) + ".png";
    		    File imgFile 			= new File(image);
    		    
    		    BufferedImage bi 		= null;
    		    
    		    if(Browserip.contains("IOS_SAFARI")) {
    		    	bi 					= ImageIO.read(imgFile);
    		    	bi 					= bi.getSubimage(0, 140, bi.getWidth(), bi.getHeight() - 230);  // IOS was taking header and footer hence subtract that portion so that actual image should reflect.
    		    } else {
    		    	bi 					= ImageIO.read(imgFile);  //other then IOS, consider as it is image.
    		    }
    		    
    	        g.drawImage(bi, width, height, null);  // This method will buffer all small images and after that it will club all images to one full image. [bi = is having image
    	            	        
    	        height 					= height + bi.getHeight();  // it will add height of image. It will increase hiegth of image and at last will become full image height.
    	        width 					= 0;
    	    }
	    	
    	   // Write merged image in file path
    	   
    	   ImageIO.write(result,"png",new File(filePath +  ".png"));
    	   
	    	// Delete all screenshot parts [ small images because now we have one merged image for complete one page]
	    	for(int currIndex = 1 ; currIndex < fileIndex ; currIndex++) {
    		    
	    		String image 			= new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + Browserip + String.valueOf(currIndex) + ".png";
    		    File imgFile 			= new File(image);
    		    
    		    imgFile.delete();
    	    }
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File currFile = new File(filePath + ".png");
		
		if(!currFile.exists()) {
			System.out.println("Full screen not captured at - " + filePath + ".png");
		}
	}
	
	public void checkVisual4Page(WebDriver driver, String pageName , Reporting report) {
		
		// If is visual check flag is false return
		if(RuntimeVals.property.get("isVisualCheck").equalsIgnoreCase("false"))
		{
//		if(Executor.propReader.getProperty("isVisualCheck").equalsIgnoreCase("false")) {
			return;
		}
		
		// Initialize OS Name , Browser Name, Device Name and Browser version
		
		init();
		
		// Initiate string file path for take current image, compare with baseline image and store difference image in screenshot folder
		
		String result 					= "";
		String currImagefilePath		= "";
		String diffImagefilePath		= "";
		String baseImagefilePath 		= "";
		
		try {
			
			if(deviceName.equals("")) {
			
//				currImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + Executor.uniqueID + File.separator + osName + File.separator + browserName + File.separator + "Screenshots" + File.separator + pageName;
//				diffImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + Executor.uniqueID + File.separator + osName + File.separator + browserName + File.separator + "Screenshots" + File.separator + pageName + "visualDiff";
				currImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + ExecuteMe.uniqueID + File.separator + osName + File.separator + browserName + File.separator + "Screenshots" + File.separator + pageName;
				diffImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + ExecuteMe.uniqueID + File.separator + osName + File.separator + browserName + File.separator + "Screenshots" + File.separator + pageName + "visualDiff";
				
				baseImagefilePath = new File("").getAbsolutePath() + File.separator + "TestData\\BaseLines\\" + osName + File.separator + browserName + File.separator + screeenResolution + File.separator + pageName + ".png";
				
			} else {
				
				currImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + ExecuteMe.uniqueID + File.separator + osName + File.separator + deviceName + "_" + browserName + File.separator + "Screenshots" + File.separator + pageName;
				diffImagefilePath = new File("").getAbsolutePath() + File.separator + "Reports" + File.separator + ExecuteMe.uniqueID + File.separator + osName + File.separator + deviceName + "_" + browserName + File.separator + "Screenshots" + File.separator + pageName + "visualDiff";
				baseImagefilePath = new File("").getAbsolutePath() + File.separator + "TestData\\BaseLines\\" + osName + File.separator + browserName + File.separator + screeenResolution + File.separator + pageName + ".png";
			}
			
//			Thread.sleep(5000);
			
			// Take full page screenshot in current file path
			
			captureFullPageScreenshot(driver, currImagefilePath);
		
			// Initialize baseline image file
			
			File baseimgfile 						= new File(baseImagefilePath);  // create file object using 'baseImagefilePath' [ baseImagefilePath = contains only path for baseline image] 
			
			// If base line image file exist go for image comparison. 
			
			if(baseimgfile.exists()) {
				result 						= getDiffImage(baseImagefilePath, currImagefilePath+".png", diffImagefilePath);
			
			// Copy current image as baseline image				
				
			} else {
				FileUtils.copyFile(new File(currImagefilePath + ".png"), new File(baseImagefilePath));
			}
			
			// Report in Extent report
			
			// Replace space with %20
			
			baseImagefilePath 				= baseImagefilePath.replace(" ", "%20");
			currImagefilePath 				= currImagefilePath.replace(" ", "%20");
			diffImagefilePath 				= diffImagefilePath.replace(" ", "%20");
			String stepname 				= "<b> <font color=#A74AFF> Visual Test for Page - " + pageName; 
			
			// find relative path for current image and differ image
			
			int pos 						= currImagefilePath.indexOf("Screenshots");
			currImagefilePath 				= currImagefilePath.substring(pos, currImagefilePath.length());
			diffImagefilePath 				= diffImagefilePath.substring(pos, diffImagefilePath.length());
			
			// find relative path for base line image.
			
			pos 							= baseImagefilePath.indexOf("BaseLines");
			baseImagefilePath				= baseImagefilePath.substring(pos, baseImagefilePath.length());
			baseImagefilePath				= "..\\..\\..\\..\\TestData\\" + baseImagefilePath;
			
			if(result.toLowerCase().contains("success") && resultStatus) {
			
				String details 	= "<b> <font color='green'> Visual Test Pass";
				details 		= details + "<br> <b> Expected Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				details 		= details + "<br> <b> <font color='green'> Actual Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + "href=" + currImagefilePath+".png" + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.PASS, stepname, details);
				
			} else if((result.toLowerCase().contains("success") && !resultStatus)) {
				
				String details 	= "<font color='red'> <b> Visual Test Failed";
				details 		= details + "<br> <b> Expected Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				details 		= details + "<br> <b> <font color='red'> Actual Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href=" + currImagefilePath+".png" + ">Screenshot</a></div>";
				details 		= details + " <br> <b> <font color='blue'> Difference(Highlighted in Red) <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href=" + diffImagefilePath+".png" + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.FAIL, stepname, details);
				
				/*String details 	= "<b> <font color='green'> Visual Test Pass";
				details 		= details + "<br> <b> Expected Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				details 		= details + "<br> <b> <font color='green'> Actual Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + "href=" + currImagefilePath+".png" + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.PASS, stepname, details);*/
				
				
			} else if(result.equals("")) {
				
				String details 	= "<br> <b> <font color='Blue'> Visual Test not performed as baseline image does not exist";
				details 		= details + "<br> new image copied as baseline" + "<div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.INFO, stepname, details);
				
			} else {
								
				String details 	= "<font color='red'> <b> Visual Test Failed";
				details 		= details + "<br> <b> Expected  - <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				details 		= details + "<br> <b> <font color='red'> Actual - <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href=" + currImagefilePath+".png" + ">Screenshot</a></div>";
				details 		= details + " <br> <b> <font color='blue'> Difference - <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href=" + diffImagefilePath+".png" + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.FAIL, stepname, details);
				
				/*String details 	= "<b> <font color='green'> Visual Test Pass";
				details 		= details + "<br> <b> Expected Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + " href="+ baseImagefilePath + ">Screenshot</a></div>";
				details 		= details + "<br> <b> <font color='green'> Actual Page Image <div align='right' style='float:right'><a " + Reporting.NewWindowPopUpHTMLCode() + "href=" + currImagefilePath+".png" + ">Screenshot</a></div>";
				
				report.logStepToReport(LogStatus.PASS, stepname, details);*/
				
			}
		} catch (Exception e) {
			System.out.println("exception occured for - " +  currImagefilePath + diffImagefilePath + baseImagefilePath);
			//e.printStackTrace();
		}
		
	}
	
	public String convertPNGtoJPG(String pngFilepath) {
		
		String convertedImageFilePath 		= pngFilepath.replaceAll(".png", ".jpg");
		
		BufferedImage bufferedImage;

		try {

		  //read image file
		  
			bufferedImage 					= ImageIO.read(new File(pngFilepath));

		  // create a blank, RGB, same width and height, and a white background
		  
		  BufferedImage newBufferedImage 	= new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		  
		  newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

		  // write to jpg file
		  
		  ImageIO.write(bufferedImage, "jpg", new File(convertedImageFilePath));

		} catch (IOException e) {
		  //e.printStackTrace();
		}
		
		return convertedImageFilePath;
		
	}

	
	public String convertJPGtoPNG(String jpgFilepath) {
		
		String convertedImageFilePath 		= jpgFilepath.replaceAll(".jpg", ".png");
		
		try {
	
			File file 						= new File(jpgFilepath);
		    BufferedImage bi 				= ImageIO.read(file);
		 
		    ImageIO.write(bi, "png", new File(convertedImageFilePath));
		    		    
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return convertedImageFilePath;
	}
	
}

