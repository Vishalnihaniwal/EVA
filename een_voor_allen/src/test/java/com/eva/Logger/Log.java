//package com.eva.Logger;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.log4j.ConsoleAppender;
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PatternLayout;
//
//import com.eva.commonFileBank.TxtFileUtil;
//import com.eva.enums.LoggingLevel;
//
//
//public class Log {
//
//private  Logger log = Logger.getLogger(Log.class);
//	
//	public Log() {
//		try {
//			String filePath = null;
//			try {
//				TxtFileUtil txtFileObj = new TxtFileUtil();
//				
//				filePath = txtFileObj.createFile(txtFileObj.createFolder("Log"), "Logger"+new SimpleDateFormat("ddMMMyy_hhmmss").format(new Date())+".log");
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			// creates pattern layout
//	        PatternLayout layout = new PatternLayout();
//	        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
//	        layout.setConversionPattern(conversionPattern);
//	 
//	        // creates console appender
//	        ConsoleAppender consoleAppender = new ConsoleAppender();
//	        consoleAppender.setLayout(layout);
//	        consoleAppender.activateOptions();
//	 
//	        // creates file appender
//	        FileAppender fileAppender = new FileAppender();
//	        fileAppender.setFile(filePath);
//	        fileAppender.setLayout(layout);
//	        fileAppender.activateOptions();
//	 
//	        // configures the root logger
//	        Logger rootLogger = Logger.getRootLogger();
//	        rootLogger.setLevel(Level.DEBUG);
//	        rootLogger.addAppender(consoleAppender);
//	        rootLogger.addAppender(fileAppender);
//	        
////	        LogMessage(Level.DEBUG, "This ");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * Log Message with level
//	 */
//	
//	public void LogMessage(String level, String message) {
//		
//		try {
////			String strLevel = level.toString();
//			switch(level)
//			{
//				case "ALL":
//					log.info(message);
//					break;
//			
//				case "DEBUG":
//					log.debug(message);
//					break;
//					
//				case "ERROR":
//					log.error(message);
//					break;
//					
//				case "FATAL":
//					log.debug(message);
//					break;
//					
//				case "INFO":
//					log.info(message);
//					break;
//				
//				case "OFF":
//					log.info(message);
//					break;
//					
//				case "TRACE":
//					log.debug(message);
//					break;
//					
//				case "WARN":
//					log.debug(message);
//					break;	
//				
//				default:
//					log.info(message);
//			}
//						
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/**
//	 * Log Message without level
//	 */
//	
//	public void LogMessage(String message) {
//		
//		try {
//			log.info(message);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
