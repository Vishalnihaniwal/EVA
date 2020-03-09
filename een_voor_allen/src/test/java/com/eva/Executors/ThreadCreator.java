package com.eva.Executors;

import java.io.File;

import org.xml.sax.XMLReader;

import com.eva.Module.Controller;
import com.eva.SomePojos.RuntimeVals;
import com.eva.commonFileBank.XmlUtil;



public class ThreadCreator {
	
//	public 	XmlUtil xml = new XmlUtil(new File("config.xml").getAbsolutePath());
	public 	XmlUtil xml = new XmlUtil(RuntimeVals.XmlFilePath);
	public void threadInitialize()
	{
//		try {
			for (int counter = 0; counter < Integer.parseInt(RuntimeVals.NumberOfThreads); counter++)
	//		for (int counter = 0; counter < Integer.parseInt(xml.getTagVal("NUMOFTHREADS")); counter++) 
			{
				ImplementsRunnable target 			= new ImplementsRunnable();
				Thread thread 						= new Thread(target, String.valueOf(counter + 1));
				System.out.println("NEW THREAD STARTED -**" + String.valueOf(counter + 1)+ "**");
				thread.start();
//				System.out.println("Browser :- "+RuntimeVals.browsers.get(counter)+" ###IP :- "+RuntimeVals.ip.get(counter)+" ###Port :- "+RuntimeVals.port.get(counter));
				System.out.println("Browser :- "+RuntimeVals.browserNames.get(counter)+" ###IP :- "+RuntimeVals.ip.get(counter)+" ###Port :- "+RuntimeVals.port.get(counter));
			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Issue in 'threadInitialize' method." +e.getMessage());
//		}
	}
}

class ImplementsRunnable implements Runnable {

	public void run() {
		
		try {
				Controller objController 			= new Controller();
				Thread.sleep(Integer.parseInt(Thread.currentThread().getName())+000);
				System.out.println("Thread Name: " + Thread.currentThread().getName());
				objController.heartMethod();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}