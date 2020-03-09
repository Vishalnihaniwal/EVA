package com.eva.commonFileBank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


public class PropertyUtil {

	private Properties properties;

	/* Constructor Started */
	public PropertyUtil() {

	}

	/**
	 * @author roaggarwal
	 * Used to Initialize the properties object for the specified file 	
	 * @param pathofPropertyFile
	 * @throws Exception
	 */
	public PropertyUtil(String pathofPropertyFile) throws Exception {

		if (!pathofPropertyFile.endsWith(".properties"))
			throw new RuntimeException("Please Enter Proper File with proper extention");

		setProperties(pathofPropertyFile);

	}

	/**
	 * @author roaggarwal
	 * Used to Load the content of File To properties oject
	 * @param pathofPropertyFile
	 * @throws Exception
	 */
	private void setProperties(String pathofPropertyFile) throws Exception {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(pathofPropertyFile));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found at " + pathofPropertyFile);
		}
	}

	/**
	 * @author roaggarwal
	 * Used to Retrieve the value of the key passed
	 * @param propertyName
	 * @return
	 */
	public String readProperties(String propertyName) {
		String content = properties.getProperty(propertyName);
		if (content != null)
			return content;
		else
			throw new RuntimeException(propertyName + " Is not specified in File");
	}

	
	/**
	 * @author roaggarwal
	 * Returns the entire Properties object as Hashmap
	 * @return
	 */
	public LinkedHashMap<String, String> getAsMap() {
		LinkedHashMap<String, String> myMap = new LinkedHashMap<String, String>();
		for (String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			myMap.put(key, value);
		}

		return myMap;

	}

}
