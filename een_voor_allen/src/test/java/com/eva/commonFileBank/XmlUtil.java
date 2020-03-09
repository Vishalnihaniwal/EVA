package com.eva.commonFileBank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import problems.evaException;

public class XmlUtil {
	String filePath;
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	private Document getxmlDoc() {
		Document doc=null;
		String filePath = this.getFilePath();
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc= dBuilder.parse(xmlFile);
        }catch(Exception e) {
        	
        }
		return doc;
	}

	/******************************************************************************************************
	 * Some samples to help how to use
	 ******************************************************************************************************/
//	public static void main(String[] args) {
//		xmlUtil xu= new xmlUtil();
//		xu.setFilePath("src\\test\\java\\Resource\\config.xml");
//		System.out.println(xu.getTagVal("HOST"));
//		System.out.println(xu.getTagVal("HOST", 0));
//		String expression = "/Configuration/Network/PWD";
//		System.out.println(xu.getXPathVal(expression));
//		System.out.println(xu.getXPathVal(expression,0));
//		
//		ArrayList al= xu.getTagValArray("PWD");
//		for (int i=0;i<al.size();i++) {
//			System.out.println(al.get(i).toString());
//		}
//		
//		ArrayList al1= xu.getXPathArray("/Configuration/Network/PWD");
//		for (int i=0;i<al1.size();i++) {
//			System.out.println(al1.get(i).toString());
//		}
//    }

	public XmlUtil() {
		
	}
	public XmlUtil(String filePath) {
		
		this.setFilePath(filePath);
	}
	public String getTagVal(String tagName) {
		this.getxmlDoc().getDocumentElement().normalize();
		return this.getxmlDoc().getElementsByTagName(tagName).item(0).getTextContent();
		
	}
	
	
	
	public String getTagVal(String tagName, int index) {
		String tagVal="";
		
			this.getxmlDoc().getDocumentElement().normalize();
			NodeList nodeList = this.getxmlDoc().getElementsByTagName(tagName);
			if (index<nodeList.getLength())
				tagVal= this.getxmlDoc().getElementsByTagName(tagName).item(index).getTextContent();
			else {
//				new problems.evaException();
			}
			return tagVal;
	}
	
	public ArrayList getTagValArray(String tagName) {
		ArrayList tagValArray=new ArrayList<String>();
		this.getxmlDoc().getDocumentElement().normalize();
		NodeList nodeList = this.getxmlDoc().getElementsByTagName(tagName);
		for (int i=0;i<nodeList.getLength();i++)
			tagValArray.add(this.getxmlDoc().getElementsByTagName(tagName).item(i).getTextContent());
		return tagValArray;
	}
	
	public LinkedHashMap<String, String> getTagArray(String tagName) {
		LinkedHashMap<String, String> tagValArray=new LinkedHashMap<String, String>();
		this.getxmlDoc().getDocumentElement().normalize();
		NodeList nodeList = this.getxmlDoc().getElementsByTagName(tagName);
		for (int i=1;i<nodeList.getLength();i++)
			tagValArray.put(this.getxmlDoc().getElementsByTagName(tagName).item(i).getNodeName().toString(), this.getxmlDoc().getElementsByTagName(tagName).item(i).getTextContent().toString());
		return tagValArray;
	}
	
	public int getTagCount(String tagName) {
		int tagLength=0;
		this.getxmlDoc().getDocumentElement().normalize();
		NodeList nodeList = this.getxmlDoc().getElementsByTagName(tagName);
		for (int i=0;i<nodeList.getLength();i++)
			tagLength= this.getxmlDoc().getElementsByTagName(tagName).getLength();
		return tagLength;
	}
	
	public String getXPathVal(String expression){
		String tagVal="";
		try {
		 XPath xPath =  XPathFactory.newInstance().newXPath();
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
         this.getxmlDoc(), XPathConstants.NODESET);
         tagVal= nodeList.item(0).getTextContent();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tagVal;
	}
	
	public String getXPathVal(String expression, int index){
		String tagVal="";
		try {
		 XPath xPath =  XPathFactory.newInstance().newXPath();
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
         this.getxmlDoc(), XPathConstants.NODESET);
         tagVal= nodeList.item(index).getTextContent();
		}catch(Exception e) {
//			new FrameworkException().driverException();
		}
		return tagVal;
	}
	
	public ArrayList getXPathArray(String expression){
		ArrayList tagValArrayList=new ArrayList<String>();
		try {
		 XPath xPath =  XPathFactory.newInstance().newXPath();
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
         this.getxmlDoc(), XPathConstants.NODESET);
         for(int i=0; i<nodeList.getLength();i++)
        	 tagValArrayList.add(nodeList.item(i).getTextContent());
         
		}catch(Exception e) {
//			new FrameworkException().driverException();
		}
		return tagValArrayList;
	}
	
	public int getXPathTagCount(String expression){
		int tagCount=0;
		try {
		 XPath xPath =  XPathFactory.newInstance().newXPath();
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
         this.getxmlDoc(), XPathConstants.NODESET);
         for(int i=0; i<nodeList.getLength();i++)
        	 tagCount= nodeList.getLength();
         
		}catch(Exception e) {
//			new FrameworkException().driverException();
		}
		return tagCount;
	}
//tag count
	

}
