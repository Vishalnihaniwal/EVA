package com.eva.RnD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;



public class JSONFILEWriter {

	public static void main(String[] args) throws IOException {
		 
		System.out.println(readJson("D:\\TestAutothon\\final_code\\een_voor_allen\\src\\test\\java\\com\\eva\\UI\\RememberMe.json", "REMEMBERME_OPTION"));
		
		JSONObject obj = new JSONObject();
		obj.put("Name", "crunchify.com");
		obj.put("Author", "App Shah");
 
		JSONArray company = new JSONArray();
		company.add("Compnay: eBay");
		company.add("Compnay: Paypal");
		company.add("Compnay: Google");
		obj.put("Company List", company);
 
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("D:/file1.json")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
	}
	
	public static String readJson(String file, String key)
	{
		String Value = null;
		JSONParser jsonparser = new JSONParser();
		try(FileReader reader = new FileReader(file))
		{
			Object obj = jsonparser.parse(reader);
			JSONObject Jobj = (JSONObject) obj;
			Value = Jobj.get(key).toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Value;
	}
}
