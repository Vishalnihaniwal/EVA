package com.eva.SomePojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.eva.UI.EVA_UI;
import com.eva.Utils.UtilityFunctionBank;
import com.eva.commonFileBank.XmlUtil;

public class RuntimeVals {
	
	public static LinkedHashMap<String, ArrayList<String>> MasterSheetData; // remove this static at the time final delivery
	public static LinkedHashMap<String, String> configXML; 
	public static LinkedHashMap<String, String> property;
	public static LinkedHashMap<String, ArrayList<String>> TestCasesData = new LinkedHashMap<>();
	String ExcelFilePath;
	public static String XmlFilePath = EVA_UI.tConfigFilePath.getText();
//	public static String MasterXLSFilePath = EVA_UI.XLS_FILE;
	public static String setReportsFolderLocation ;
	public static String NumberOfThreads 	= EVA_UI.selectedNumberOfSystems;
	public static String tTestCasesFile;
	public static boolean parallelExecution;
	public static boolean imageComparison=false;
	public static boolean stopExecution=false;
	public static ReentrantLock re = new ReentrantLock(); 
	
	public static ArrayList<String> browsers = new ArrayList<>();
	public static ArrayList<String> browserNames = new ArrayList<>();
	public static ArrayList<String> ip 		= new ArrayList<>();
	public static ArrayList<String> port = new ArrayList<>();
//	public static boolean ThreadLockState;
	
	
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//	
//		RuntimeVals obj = new RuntimeVals();
//		obj.setConfigXML();
//	}
	
	public String getReportsFolderLocation()
	{
		return setReportsFolderLocation;
	}
	
	public void setConfigXML() throws ParserConfigurationException, SAXException, IOException
	{
		XmlUtil xu= new XmlUtil(XmlFilePath);
//		XmlUtil xu= new XmlUtil(UtilityFunctionBank.getAbsolutePath("config.xml"));
		configXML = xu.getTagArray("*");
		
	}
	
	public void setMasterSheetData(LinkedHashMap<String, ArrayList<String>> MasterSheetData)
	{
		this.MasterSheetData = MasterSheetData;
	}
	
	public HashMap<String, ArrayList<String>>  getMasterSheetData()
	{
		return MasterSheetData;
	}
	
	public void setConfigXmlData()
	{
		
	}
	
	public String getExcelFilePath() {
		return ExcelFilePath;
	}
	public void setExcelFilePath(String excelFilePath) {
		ExcelFilePath = excelFilePath;
	}
	public String getXmlFilePath() {
		return XmlFilePath;
	}
		
	
	public void setProp(LinkedHashMap<String, String> propData)
	{
		property =propData;
	}
	

}
