package com.eva.Utils;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.eva.Module.Controller;
import com.eva.Reports.Reporting;
import com.eva.SomePojos.RuntimeVals;
import com.eva.UI.EVA_UI;
import com.eva.commonFileBank.ExcelUtil;

import problems.ErrorType;
import problems.evaException;

public class UtilityFunctionBank {

	public static String getAbsolutePath(String filePath) {
		String AbsolutePath = filePath;
		File f = new File(filePath);
		if(!f.isAbsolute())
		{
			AbsolutePath = f.getAbsolutePath().toString();
		}
		return AbsolutePath;
	}
	
	
	public static String getFileNameFromFolder(String FolderPath, String fileExtension)
	{
		String FileName = null;
		File file = new File(FolderPath);
		String[] files = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.toLowerCase().endsWith("."+fileExtension)){
					return true;
				} else {
					return false;
				}
			}
		});
		for(String f:files){
			System.out.println(f);
			FileName = f;
		}
		return FileName;
	}
	
	
	public static void createFolder(File file)
	{
		if(!file.exists()) {
			if (file.mkdir()) {	} }
	}
	
	public LinkedHashMap<String, ArrayList<String>> setExcelSheetDataToHashMap(ExcelUtil excel)
	{
		LinkedHashMap<String, ArrayList<String>> SheetData = new LinkedHashMap<>();
		try
		{
			for(int rowCntr = 1; rowCntr <= excel.getRowCount(); rowCntr ++)
			{
				ArrayList<String> temp = new ArrayList<>();
				for(int counter = 1 ;counter <= excel.getColCount(rowCntr); counter ++)
				{
					temp.add(excel.getCellData(rowCntr, counter));
				}
				SheetData.put(excel.getCellData(rowCntr, 0), temp);
			}
			/***********************************************************************/
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return SheetData;
	}
	
	public void executeMethod(String className, String methodName, WebDriver driver, Reporting repo) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, evaException
	{
		Object clsObj = null ;
		ClassLoader classLoader = Controller.class.getClassLoader();
		try {
			Class clasz = Class.forName("com.eva.Business."+className);
			Constructor constructor = clasz.getConstructor(new Class[] {WebDriver.class, Reporting.class});
//			try {
////				Method method1 = constructor.newInstance(driver, repo).getClass().getMethod(methodName, new Class[] {WebDriver.class, Reporting.class});
//				constructor.newInstance(driver, repo);
//				Method method1 = clasz.getDeclaredMethod(methodName, new Class[] {WebDriver.class, Reporting.class});
//				method1.invoke(clasz.newInstance(),driver, repo);
			
			Class aclassLoader = classLoader.loadClass("com.eva.Business."+className);
			clsObj = aclassLoader.getConstructor(new Class[] {WebDriver.class, Reporting.class}).newInstance(driver, repo);  // created obj to invoke contructor of class with parameter webdriver and reporting object
//			clsObj = aclassLoader.newInstance();
			Method methodObj = null;
			try {
				//Calling method with parameters
//				methodObj = aclassLoader.getDeclaredMethod(methodName, new Class[] {WebDriver.class, Reporting.class});
				
				// Calling method without parameters
				methodObj = aclassLoader.getDeclaredMethod(methodName, null);
				//Following line can be having parameter [classobject, paramter1, parameter2]
				methodObj.invoke(clsObj);
			}
			catch(NoSuchMethodException e)
			{
				e.printStackTrace();
				throw new evaException(String.format(ErrorType.NO_SUCH_METHOD_FOUND, methodName));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("In 'execute Method' catch.");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	 
	 
	 public static boolean VerifyHubnNodeConnection() 
	 {
			int counter =0;
			boolean success = false;
			//Creating a driver object referencing WebDriver interface
			WebDriver driver;
			//Setting webdriver.gecko.driver property
			System.setProperty("webdriver.chrome.driver", new File("GridBatchFiles\\chromedriver.exe").getAbsolutePath().toString());
			//Instantiating driver object and launching browser
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			do {
				 try {
				        driver = new ChromeDriver(chromeOptions);
				        //Using get() method to open a webpage
				        driver.get("http://localhost:4444/grid/console");
				        Thread.sleep(2000);
				        try {
				        	
				        	//***************** need to parametrized following ip and port with ui ****************
				        	WebElement firstinstance = driver.findElement(By.xpath("//p[contains(text(),'id : http://')]"));
		//			        WebElement firstinstance = driver.findElement(By.xpath("//p[contains(text(),'id : http://10.224.30.73:5570')]"));
					        if(firstinstance.equals(null))
					        {
					        	System.out.println("Page not openend");
					        }
					        else
					        {
					        	success = true;
					        	System.out.println("Successfully communicated with node(s)");
					        	break;
					        }
				        }
				        catch (Exception e) {
							// TODO: handle exception
//				        	e.printStackTrace();
				        	System.out.println("Unable to communicate with node(s)"); 
				      
		//		        	 JOptionPane.showMessageDialog(aJProgressBar, "Unable to communicate with node(s)");
						}
				        //Closing the browser
				        driver.quit();
				        
				 }
				 catch(Exception e)
				 {
					 System.out.println("Can't communicated with node(s)");
		//			 JOptionPane.showMessageDialog(aJProgressBar, "Unable to initiate hub");
				 }
				 System.out.println(counter);
				 counter ++;
		}while(counter < 30);
		 return success;
	 }
	
//	public Method methodObj(Object classObj, Class clsInst, String methodName)
//	{
//		Method methodObj = null;
//		try {
//			methodObj = clsInst.getDeclaredMethod("sampleMethodOfGmail", null);
//			methodObj.invoke(clsInst, null);
//		}
//		catch(Exception e)
//		{
//			
//		}
//		return methodObj;
	//no paramater
	/************************************************************************************/
//		Class noparams[] = {};
//			
//		//String parameter
//		Class[] paramString = new Class[1];	
//		paramString[0] = String.class;
//			
//		//int parameter
//		Class[] paramInt = new Class[1];	
//		paramInt[0] = Integer.TYPE;
//			
//		try{
//		        //load the AppTest at runtime
//			Class cls = Class.forName("com.mkyong.reflection.AppTest");
//			Object obj = cls.newInstance();
//				
//			//call the printIt method
//			Method method = cls.getDeclaredMethod("printIt", noparams);
//			method.invoke(obj, null);
//				
//			//call the printItString method, pass a String param 
//			method = cls.getDeclaredMethod("printItString", paramString);
//			method.invoke(obj, new String("Somestringdaataa"));
//				
//			//call the printItInt method, pass a int param
//			method = cls.getDeclaredMethod("printItInt", paramInt);
//			method.invoke(obj, 123);
//				
//			//call the setCounter method, pass a int param
//			method = cls.getDeclaredMethod("setCounter", paramInt);
//			method.invoke(obj, 999);
//				
//			//call the printCounter method
//			method = cls.getDeclaredMethod("printCounter", noparams);
//			method.invoke(obj, null)
//	}

	
}
