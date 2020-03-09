package com.eva.RnD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestWriteFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 Process process = null;
		 ProcessBuilder pb = new ProcessBuilder("adb", "devices");
		 process = pb.start();
		 process.waitFor();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.print(line+"\n");
	        }
		
//		writeinTxtFile("D:\\TestAutothon\\final_code\\een_voor_allen\\RememberMe", "ContentToWrite");
    }
	
	public static void writeinTxtFile(String fileName, String ContentToWrite)
	{
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(fileName);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile+".txt", true));
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
