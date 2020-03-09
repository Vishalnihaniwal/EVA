package com.eva.Module;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.WebDriver;

import com.eva.Reports.Reporting;
import com.eva.ScreenRec.VideoReord;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.UtilityFunctionBank;
import com.eva.commonFileBank.ExcelUtil;
import com.eva.commonFileBank.XmlUtil;
import com.eva.core.Drivers;

import problems.evaException;

public class Controller {
	
	static int counterForEachthread;
	UtilityFunctionBank utility = new UtilityFunctionBank();
	public WebDriver driver;
	VideoReord videoReord = new VideoReord();
	static AtomicInteger counter = new AtomicInteger(0);
	
	
	
	public void heartMethod() throws IOException, Exception
	{
		try {
			System.out.println(Thread.currentThread().getName()+" is In heart");
			try {
				this.driver = new Drivers().createDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			/****************************************************/
			// Try code for logger
	//		Log logger = new Log();
	//		logger.LogMessage("DEBUG", "Try logger");
			
			
			/****************************************************/
			if(!RuntimeVals.parallelExecution)  // If Sequential execution radio button selected from UI.
			{
					while(counter.get() <=RuntimeVals.TestCasesData.size()-1)
					{
						Reporting repo = null;
						String testSheetName = "";
						String testcaseName="";
						
						
						System.out.println("Get Hold count 1 " + RuntimeVals.re.getHoldCount());
						
						System.out.println("Lock for thread "+(Integer.parseInt(Thread.currentThread().getName())-1) +"is "+ RuntimeVals.re.getHoldCount()+ "and Thread browser name "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
						while(RuntimeVals.re.getHoldCount()>0)
						{
							System.out.println("Lock is "+RuntimeVals.re.getHoldCount()+" .... "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1) + " is waiting for lock to release");
							Thread.sleep(2000);
//							ans = RuntimeVals.re.tryLock();
							System.out.println("Get Hold count 2 " + RuntimeVals.re.getHoldCount());
						}
						
						// if lock is not implemented then it will lock the resources and increment lock count by 1.
//						boolean ans = RuntimeVals.re.tryLock();
//						if(ans)
						//synchronized(this)
//						{
							RuntimeVals.re.lock();
							System.out.println("Get Hold count 3 " + RuntimeVals.re.getHoldCount());
//							System.out.println("Lock for thread "+(Integer.parseInt(Thread.currentThread().getName())-1) +"is "+ RuntimeVals.re.tryLock()+ "and Thread browser name "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
							
							System.out.println("~~~~~~~~ Thread name is ~~~"+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
							System.out.println("Wait statement"+Integer.parseInt(Thread.currentThread().getName()+"000"));
							Thread.sleep(Integer.parseInt(Thread.currentThread().getName()+"000"));
							counter.getAndIncrement();
							
								testSheetName= ((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[0]);
								System.out.println("Test case sheet name for thread :- "+ testSheetName);
								testcaseName= ((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1]);
								System.out.println("Test case name for thread :- "+ testcaseName);
//							System.out.println("Test sheet name is :- "+((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[0]) +"~~~~~~~~ Thread name is ~~~"+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
//							System.out.println("Test case name is :- "+((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1]) +"~~~~~~~~ Thread name is ~~~"+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
								repo = new Reporting(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
								repo.setDriver(driver);
								repo.test = repo.extentReports.startTest("<b> <font color='DarkBlue'> " + (RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1] + "<font color='DarkBlue'> - " + (RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1] + " <br> <font color='Orange'> <small> ' OS Name' | ' Browser Name' </small>");
								System.out.println("Test sheet name is :- "+((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[0]) +"~~~~~~~~ Thread name is ~~~"+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
								System.out.println("Test case name is :- "+((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1]) +"~~~~~~~~ Thread name is ~~~"+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
								
							driver.get(RuntimeVals.configXML.get("URL"));
							
							// driver.manage does not supported by Android hence following code is conditional
							if(!(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("Android") || RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("Iphone")))
							{
								driver.manage().window().maximize();
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							}
							
							
//							System.out.println("@@@@@@@@   Before unlock statement "+ RuntimeVals.re.tryLock());
							while(RuntimeVals.re.getHoldCount()>0)
							{
								RuntimeVals.re.unlock();	
							}
							System.out.println("Get Hold count 4 " + RuntimeVals.re.getHoldCount());
//							System.out.println("@@@@@@@@   After unlock statement "+ RuntimeVals.re.tryLock());
							
							try {
	//							System.out.println((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[0]);
	//							System.out.println((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1]);
								System.out.println("Test sheet name for "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1) +" for "+testSheetName);
								System.out.println("Test case name for "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1) +" for "+testcaseName);
								utility.executeMethod(testSheetName, testcaseName, driver, repo);
	//							utility.executeMethod((RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[0], (RuntimeVals.TestCasesData.keySet().toArray()[counter.get()-1].toString()).split("~")[1], driver, repo);  
							}
							catch(evaException eva)
							{
								System.out.println(eva.getMessage());
							}
							catch(Exception e1)
							{	
								System.out.println("in 'SEQUENTIAL' catch");
								e1.printStackTrace();	
							}
							finally {
								System.out.println("###################"+repo.test.getRunStatus());
								repo.endTestCase();
							}
//						}
//						counter.incrementAndGet();
					}
//					counter.incrementAndGet();
//				}
				
				
//				RuntimeVals.MasterSheetData.size();
//				RuntimeVals.TestCasesData.size();
//				
//				System.out.println("Mastersheet Size is :- "+RuntimeVals.MasterSheetData.size());
//				System.out.println("Test data sheet is :- "+RuntimeVals.TestCasesData.size());
//				
//				System.out.println(RuntimeVals.MasterSheetData);
//				System.out.println(RuntimeVals.TestCasesData);
//				System.out.println("Temp pause in heart method");
			}
			else
			{
						/***************Following code will get CLASS NAME FROM mASTER FILE*******************************************************/
						XmlUtil xu= new XmlUtil(RuntimeVals.XmlFilePath);
				//		XmlUtil xu= new XmlUtil(UtilityFunctionBank.getAbsolutePath("config.xml"));
						ExcelUtil excel = new ExcelUtil(RuntimeVals.tTestCasesFile, "Master");
//						ExcelUtil excel = new ExcelUtil(UtilityFunctionBank.getAbsolutePath(xu.getTagVal("MASTEREXCELPATH")), "Master");
				//		excel.getCol(2).stream().filter(line -> line.trim().equalsIgnoreCase("Yes") || line.trim().equalsIgnoreCase("Y")).collect(Collectors.toList());
				////		System.out.println(excel.getCol(2).stream().filter(line -> line.trim().equalsIgnoreCase("Yes") || line.trim().equalsIgnoreCase("Y")).collect(Collectors.toList()));
						/* Following code will read and store data in HashMap for reference during execution */
						new RuntimeVals().setMasterSheetData(new UtilityFunctionBank().setExcelSheetDataToHashMap(excel));
						LinkedHashMap<String, ArrayList<String>> Mastersheetdata = RuntimeVals.MasterSheetData;
						for(Entry<String, ArrayList<String>> MastersheetLoop : Mastersheetdata.entrySet())
						{
							List<String> testCasesFromMaster = MastersheetLoop.getValue();
							if(testCasesFromMaster.get(1).equalsIgnoreCase("Y")||testCasesFromMaster.get(1).equalsIgnoreCase("Yes"))
							{
								ExcelUtil testSheetData = null ;
								try {
									testSheetData = new ExcelUtil(testCasesFromMaster.get(4), testCasesFromMaster.get(0).toString());
//									testSheetData = new ExcelUtil(UtilityFunctionBank.getAbsolutePath(xu.getTagVal("TESTCASESEXCELPATH")), testCasesFromMaster.get(0).toString());
									LinkedHashMap<String, ArrayList<String>> testCasesFileData = new LinkedHashMap<>();
									testCasesFileData = new UtilityFunctionBank().setExcelSheetDataToHashMap(testSheetData);
									//					List<List> list = testCasesFileData.entrySet().stream().filter(
									/************************************************************************************
									 * per thread separate test case
									 ************************************************************************************/
				//					if(RuntimeVals.configXML.get("SEQUENTIAL").trim().equalsIgnoreCase("True"))
			//						if(!RuntimeVals.parallelExecution)  // If Sequential execution radio button selected from UI.
			//						{
			//							List synchronizedTestCases = new ArrayList<>(testCasesFileData.keySet());
			//							while(counterForEachthread <= synchronizedTestCases.size()-1)
			//							{
			//								counterForEachthread++;
			//								if(testCasesFileData.get(synchronizedTestCases.get(counterForEachthread -1)).get(1).trim().equalsIgnoreCase("Y") || testCasesFileData.get(synchronizedTestCases.get(counterForEachthread-1)).get(1).trim().equalsIgnoreCase("Yes"))
			//								{
			//									String testcase = testCasesFileData.get(synchronizedTestCases.get(counterForEachthread-1)).get(0);
			//									String ExcelSheetName = testCasesFromMaster.get(0);
			//	//								System.out.println(testCasesFileData.get(synchronizedTestCases.get(counterForEachthread -1)).get(2).trim()); 
			//	//								if(Arrays.asList(testCasesFileData.get(synchronizedTestCases.get(counterForEachthread -1)).get(2).trim()).contains(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1)) || testCasesFileData.get(synchronizedTestCases.get(counterForEachthread -1)).get(2).trim().equalsIgnoreCase(""))
			//	//								{
			//	//									Reporting repo = new Reporting(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1));
			//										Reporting repo = new Reporting(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
			//		//								Reporting repo = new Reporting(RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()));
			//										repo.setDriver(driver);
			//		//								Log log = new Log(new File("").getAbsolutePath());	// This should be move to temp folder
			//										try {
			//		//									repo.test = repo.extentReports.startTest("<b> <font color='DarkBlue'> " + synchronizedTestCases.get(counterForEachthread) + "<font color='DarkBlue'> - " + testCasesFileData.get(synchronizedTestCases.get(counterForEachthread)).get(0) + " <br> <font color='Orange'> <small>" + os.toUpperCase() +" | " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toUpperCase() + " </small>");
			//											repo.test = repo.extentReports.startTest("<b> <font color='DarkBlue'> " + synchronizedTestCases.get(counterForEachthread-1) + "<font color='DarkBlue'> - " + testCasesFileData.get(synchronizedTestCases.get(counterForEachthread-1)).get(0) + " <br> <font color='Orange'> <small> ' OS Name' | ' Browser Name' </small>");
			//		//									repo.extentReports.flush();
			//											driver.get(RuntimeVals.configXML.get("URL"));
			//											driver.manage().window().maximize();
			//											driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//			//								System.out.println(Thread.currentThread().getName() +"is going to execute method");
			//											
			//											utility.executeMethod(ExcelSheetName, testcase, driver, repo);  
			//										}
			//										catch(evaException eva)
			//										{
			//											System.out.println(eva.getMessage());
			//										}
			//										catch(Exception e1)
			//										{	
			//											System.out.println("in 'SEQUENTIAL' catch");
			//											e1.printStackTrace();	
			//										}
			//										finally {
			//											System.out.println("###################"+repo.test.getRunStatus());
			//											repo.endTestCase();
			//										}
			//	//								}
			//								}
			//	//							counterForEachthread++;
			//	//							driver.close();
			//							}
			//						}
			//						/************************************************************************************/
			//				else {
									for(Entry<String, ArrayList<String>> testcases : testCasesFileData.entrySet())
									{
										if(testcases.getValue().get(1).equalsIgnoreCase("Y") ||testcases.getValue().get(1).equalsIgnoreCase("Yes"))
										{
				//								System.out.println("INFO     :     Test case going to start is -> "+testcases.getKey());
											// Split and Get browser name 
				//							if(Arrays.asList(testcases.getValue().get(2).split("#")).contains(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1)) || testcases.getValue().get(2).equalsIgnoreCase(""))
											if(Arrays.asList(testcases.getValue().get(2).split("#")).contains(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1)) || testcases.getValue().get(2).equalsIgnoreCase(""))
				//							if(Arrays.asList(testcases.getValue().get(2).split("#")).contains(RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName())) || testcases.getValue().get(2).equalsIgnoreCase(""))
											{
												Reporting repo = new Reporting(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1));
				//								Reporting repo = new Reporting(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1));
												
				//								Reporting repo = new Reporting(RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()));
												repo.setDriver(driver);
												File VideoFile = new File(new File(repo.imagePath).getParentFile()+File.separator+"Videos");
													try {
//														repo.test = repo.extentReports.startTest("<b> <font color='DarkBlue'> " + testcases.getValue().get(0) + "<font color='DarkBlue'> - " + testcases.getValue().get(0) + " <br> <font color='Orange'> <small> ' OS Name' | ' Browser Name' </small>");
														repo.test = repo.extentReports.startTest("<b> <font color='DarkBlue'> " + testcases.getValue().get(0) + "<font color='DarkBlue'> - " + testcases.getValue().get(0) + " <br> <font color='Orange'> <small> ' OS Name' | ' "+RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1)+"' </small>");
														driver.get(RuntimeVals.configXML.get("URL"));
														
														//Following will start recording if 'Flag' is 'Yes' in 'SetUp.properties' file
														if(RuntimeVals.property.get("VideoRecording").equalsIgnoreCase("Yes"))
														{
															// Following code will create folder for Videos in report folder.
															UtilityFunctionBank.createFolder(VideoFile);
															videoReord.startRecording(VideoFile);
														}
														
														// driver.manage does not supported by Android hence following code is conditional
														System.out.println("Before going to executeMethod .......");
														if(!(RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("Android") || RuntimeVals.browserNames.get(Integer.parseInt(Thread.currentThread().getName())-1).equalsIgnoreCase("Iphone")))
														{
															driver.manage().window().maximize();
															driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
														}
				//											System.out.println(RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()) +"is going to execute method");
														utility.executeMethod(testCasesFromMaster.get(0), testcases.getValue().get(0), driver, repo);  // Will return browser name
				//											driver.close();
														if(RuntimeVals.property.get("VideoRecording").equalsIgnoreCase("Yes"))
														{
															videoReord.stopRecording();
														}
													}
													catch(Exception e1)
													{	
														e1.printStackTrace();	
													}
													finally 
													{
														if(repo.test.getRunStatus().equals("pass"))
														{
															System.out.println("Deleting video file as test case is pass");
															VideoFile.delete();
														}
														repo.endTestCase();
													}
											}
											else 
											{
				//								System.out.println("Current browser name is "+RuntimeVals.configXML.get("BROWSER"+Thread.currentThread().getName()) + "Required browser name is "+testcases.getValue().get(2));
											}
										}
									}
			//					} end if here
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							}
						} // For loop ends here
			}
			System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*  Execution Completed ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
		}
		catch(Exception e)
		{
			System.out.println("Problem in method 'heartMethod'. "+ e.getMessage());
		}
		/***************************************************************************/
	}
	
}
