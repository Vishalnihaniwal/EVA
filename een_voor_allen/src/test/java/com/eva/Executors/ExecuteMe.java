package com.eva.Executors;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.eva.SomePojos.RuntimeVals;
import com.eva.UI.EVA_UI;
import com.eva.Utils.UtilityFunctionBank;
import com.eva.commonFileBank.ExcelUtil;
import com.eva.commonFileBank.PropertyUtil;
import com.eva.commonFileBank.XmlUtil;

import problems.ErrorType;

public class ExecuteMe {
	
	public static String uniqueID 					= null;
	public static RuntimeVals rtv = new RuntimeVals();
	
//	public static void main(String[] args) throws IOException, InterruptedException {
//		EVA_UI ui= new EVA_UI();
//		ui.progressBar();
//	}	
//	
	public void startExecutionMethod()
	{
		try {
		uniqueID 			= "UI_Test_Automation_Report_" + new SimpleDateFormat("ddMMMyy_hhmmss").format(new Date());
		try {
			
			System.out.println(rtv.getReportsFolderLocation());
			// Check TimeStamp folder
			File file 				= new File(rtv.getReportsFolderLocation()+ "\\Reports");// + File.separator + uniqueID);
			//File file 				= new File(new File("").getAbsolutePath() + File.separator + "Reports");// + File.separator + uniqueID);
			UtilityFunctionBank.createFolder(file);
			} catch(Exception e) 
			{
				System.out.println(ErrorType.FILE_CREATE);
				e.printStackTrace();
			}
		
		
//		try {
//		    Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
//		    Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
//		    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//		    
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
		
		XmlUtil xu= new XmlUtil(RuntimeVals.XmlFilePath);
//		XmlUtil xu= new XmlUtil(UtilityFunctionBank.getAbsolutePath("config.xml"));
		try {
			ExcelUtil excel = new ExcelUtil(RuntimeVals.tTestCasesFile, "Master");
//			ExcelUtil excel = new ExcelUtil(UtilityFunctionBank.getAbsolutePath(xu.getTagVal("MASTEREXCELPATH")), "Master");
			/******************************************************
			 * Load property file
			 */try {
				 PropertyUtil prop = new PropertyUtil(UtilityFunctionBank.getAbsolutePath("SetUp.properties"));
				 rtv.setProp(prop.getAsMap());
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 /******************************************************/
			 
			/*******************************************************
			 * Will add all data of Master sheet in HashMap
			 ******************************************************/
//			new UtilityFunctionBank().setMasterSheetData(excel);
//			HashMap<String, ArrayList<String>> Mastersheetdata = RuntimeVals.MasterSheetData;
			
			
//			System.out.println(excel.getCol("Execute").stream().filter(line -> line.trim().equalsIgnoreCase("Yes") || line.trim().equalsIgnoreCase("Y")).count());
			
			/*
			 * Will check if Yes is available in Execute column then initiate threads
			 */
			if(excel.getCol(2).stream().filter(line -> line.trim().equalsIgnoreCase("Yes") || line.trim().equalsIgnoreCase("Y")).count()>0)
			{
				extractTestData();
				try {
					rtv.setConfigXML();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				ThreadCreator CreateThread = new ThreadCreator();
				CreateThread.threadInitialize();
			}
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception in 'startExecutionMethod'" + e.getMessage());
		}
	}
	
	public void extractTestData() throws IOException
	{
		// Following code will extract all the data from Master and TestCase file, and this data will be stored in LinkedHashMap for further use.
			XmlUtil xu          = new XmlUtil(RuntimeVals.XmlFilePath);
			ExcelUtil excel 	= new ExcelUtil(RuntimeVals.tTestCasesFile, "Master");
//            ExcelUtil excel 	= new ExcelUtil(UtilityFunctionBank.getAbsolutePath(xu.getTagVal("MASTEREXCELPATH")), "Master");
             
             /* Following code will read and store data in HashMap for reference during execution */
            new RuntimeVals().setMasterSheetData(new UtilityFunctionBank().setExcelSheetDataToHashMap(excel));
             
            LinkedHashMap<String, ArrayList<String>> Mastersheetdata = RuntimeVals.MasterSheetData;
            LinkedHashMap<String, ArrayList<String>> TestCasesData = new LinkedHashMap<>();
             
             //Fetching all the test cases data of all the sheets in LinkeHashMap
             for(Entry<String, ArrayList<String>> MastersheetLoop : Mastersheetdata.entrySet())
             {
                   List<String> testCasesFromMaster = MastersheetLoop.getValue();
                   if(testCasesFromMaster.get(1).equalsIgnoreCase("Y")||testCasesFromMaster.get(1).equalsIgnoreCase("Yes"))
                   {
                          ExcelUtil testSheetData = null ;
                          //Following will get the test case file path as specified in MasterFile
                          testSheetData = new ExcelUtil(testCasesFromMaster.get(4), testCasesFromMaster.get(0).toString());
//                          testSheetData = new ExcelUtil(UtilityFunctionBank.getAbsolutePath(xu.getTagVal("TESTCASESEXCELPATH")), testCasesFromMaster.get(0).toString());
                          LinkedHashMap<String, ArrayList<String>> testCasesFileData = new LinkedHashMap<>();
                          testCasesFileData = new UtilityFunctionBank().setExcelSheetDataToHashMap(testSheetData);
                          
                          for(Entry<String, ArrayList<String>> TestsheetLoop : testCasesFileData.entrySet())
                          {
                                 ArrayList<String> testCasesFromModule = TestsheetLoop.getValue();
                                 if(testCasesFromModule.get(1).equalsIgnoreCase("Y")||testCasesFromModule.get(1).equalsIgnoreCase("Yes"))
                                 {
                                        TestCasesData.put(testCasesFromMaster.get(0) + "~" + testCasesFromModule.get(0), testCasesFromModule);
                                 }
                          }
                   }
             }
             RuntimeVals.TestCasesData = TestCasesData;
	}
}

