package com.eva.commonFileBank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileUtil {
	
	public String createFolder(String folderName)
	{
		String basePath 	= new File("").getAbsolutePath();
		File file 		= new File(basePath + File.separator + folderName);
		try {
			if (!file.exists()) { 
				if (file.mkdir()) {} }	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return file.toString();
	}
	
	public String createFile(String FilePath, String fileName) throws IOException
	{
		File file = new File(FilePath+File.separator+fileName);
		//Create the file
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		} else {
		    System.out.println("File already exists.");
		}
		return file.toString();
	}
	
	public void writeinTxtFile(String fileName, String ContentToWrite)
	{
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(fileName);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile+".txt", false)); // if want do not want to over write file then make boolean to TRUE
            writer.write(ContentToWrite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
	}
	
	public void writeinBatchFile(String fileName, String ContentToWrite)
	{
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(fileName);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile+".bat", false)); // if want do not want to over write file then make boolean to TRUE
            writer.write(ContentToWrite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
	}
	
}

