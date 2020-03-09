package com.eva.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.eva.Executors.ExecuteMe;
import com.eva.SomePojos.RuntimeVals;
import com.eva.Utils.UtilityFunctionBank;
import com.eva.commonFileBank.TxtFileUtil;
import com.mongodb.connection.ChangeEvent;
import com.mongodb.connection.ChangeListener;

import problems.ErrorType;
import problems.evaException;

public class EVA_UI implements ActionListener
{

	static JFrame frame;
	static JProgressBar bar;
	public JFrame frame1;
	private static JPanel executionPanel;
	private JPanel configPanel;
	public static JTextField tConfigFilePath, tsyncTime, tTestCasesFile;
	public JButton BrowseConfigFile, bttnStop, bttnStart, browseResultLoc, BrowseTestCasesFile, helpButton;
	public JFileChooser chooser, resultChooser;	
	public static String XML_FILE="";
	public static String XLS_FILE="";
	static String FOLDER_PATH="";
	public static String selectedNumberOfSystems = "1";
	
	public  PPPanel panel1;
	public  JProgressBar prg1;
	public JProgressBar aJProgressBar; 

	public static ButtonGroup group1, group2, group3, group4, group5, group6, group7, groupExecution;
	
	public JComboBox combobox;
	public boolean RememberMe;
	
	JPanel browserPanel, startAndStopPanel, featuresPanel, controlsPanel;
	
	ArrayList<String> ip;
	ArrayList<String> port;
	ArrayList<String> browser, browserNames;
	
	public String tempBrowser1, tempBrowser2, tempBrowser3, tempBrowser4, tempBrowser5, tempBrowser6, defaultText; // need to remove if it has not been used
	
	
	public JLabel systemRequired, ConfigFile, TestCasesFile, ParallelExecution, SequentialExecution;
	
	JLabel system1, system2, system3, system4, system5, system6, system7, system8, system9;
    JLabel lblip1, lblip2, lblip3, lblip4, lblip5, lblip6, lblip7, lblip8, lblip9;
    public static JTextField tfip1, tfip2, tfip3, tfip4, tfip5, tfip6, tfip7, tfip8, tfip9;
    JLabel lblport1, lblport2, lblport3, lblport4, lblport5, lblport6, lblport7, lblport8, lblport9;
    public static JTextField tfport1, tfport2,tfport3,tfport4,tfport5,tfport6,tfport7,tfport8,tfport9,
    							resultLocation;
    
    public static JSONObject JsonObj;
    
    public static JCheckBox imageComparison, chkRememberMe, startServer, startLocalNodes;
    
    public JRadioButton 

    rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, 
    rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2,
    rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3,
    rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4,
    rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5,
    rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, 
    rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, rSequential, rParallel;
    
    public JLabel lblImageComparison,
    lblie1,lblmozilla1,lblchrome1,lblMac1,lblandroid1,lbliphone1,
    lblie2,lblmozilla2,lblchrome2,lblMac2,lblandroid2,lbliphone2,
    lblie3,lblmozilla3,lblchrome3,lblMac3,lblandroid3,lbliphone3,
    lblie4,lblmozilla4,lblchrome4,lblMac4,lblandroid4,lbliphone4,
    lblie5,lblmozilla5,lblchrome5,lblMac5,lblandroid5,lbliphone5,
    lblie6,lblmozilla6,lblchrome6,lblMac6,lblandroid6,lbliphone6,
    lblie7,lblmozilla7,lblchrome7,lblMac7,lblandroid7,lbliphone7;
    
//    String desiredReportLocation;
    
	 public static void main(String[] args) throws IOException, InterruptedException {
		 
		 
//	
//		 System.out.println(new File("EVAimages\\SSLogo1.png").getAbsolutePath().toString());
//		 EVA_UI ui= new EVA_UI();
//		 ui.progressBar();
	      }

	 public EVA_UI() throws evaException
	 {
		 ip 	= new ArrayList<String>();
		 port	= new ArrayList<String>();
		 try {
			 RememberMe = Boolean.parseBoolean(readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "REMEMBERME_OPTION"));
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 browserNames = new ArrayList<>();
	 }
	 
	 public void getUI() throws IOException, evaException
	 {
		 frame1=new JFrame();
         frame1.setTitle("EVA Automation Framework");
//         (new ImageIcon(getClass().getResource("/com/home/images/Automation4.png")));
         frame1.setIconImage(new ImageIcon(ImageIO.read(new File(new File("src\\test\\resources\\EVAimages\\SSLogo1.png").getAbsolutePath().toString()))).getImage());
//         frame1.setIconImage(new ImageIcon(getClass().getResource("D:\\Users\\vnihaniwal\\Desktop\\Noctuline-Wall-E-Auto.ico")).getImage());
         frame1.setLayout(null);
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         frame1.setLocation(dim.width/4-frame1.getSize().width/4, dim.height/10-frame1.getSize().height/2 +10);
         
         frame1.setSize(715, 750);
         frame1.setResizable(true);
         frame1.addWindowListener(new java.awt.event.WindowAdapter() {
	         @Override
	         public void windowClosing(java.awt.event.WindowEvent windowEvent)
	         {
	            System.exit(0);
	         }
         });
         executionPanel=new JPanel();
         executionPanel.setLayout(null);
//         executionPanel.add(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\Users\\vnihaniwal\\Desktop\\EVAimages\\automation-process.jpg")))));
         configPanel=new JPanel();
         configPanel.setLayout(null);
         

 		/***************************JPanel for Start and Stop button*************************************/
 		startAndStopPanel = new JPanel();
 		startAndStopPanel.setBounds(10, 570, 660, 75);
 		startAndStopPanel.setLayout(null);
 		TitledBorder SSborder = new TitledBorder("COMMAND CENTER"); 
 		SSborder.setTitleFont(new Font("Comic Sans MS", Font.BOLD,12));
 		SSborder.setTitleJustification(TitledBorder.CENTER);
 		SSborder.setTitlePosition(TitledBorder.TOP);	
 		startAndStopPanel.setBorder(SSborder);
 		/*******************************JPanel for features *****************************************************************/
 		featuresPanel = new JPanel();
 		featuresPanel.setBounds(10, 390, 660, 100);
 		featuresPanel.setLayout(null);
 		TitledBorder featuresPanelborder = new TitledBorder("FEATURES");
 		featuresPanelborder.setTitleFont(new Font("Comic Sans MS", Font.BOLD,12));
 		featuresPanelborder.setTitleJustification(TitledBorder.CENTER);
 		featuresPanelborder.setTitlePosition(TitledBorder.TOP);
 		featuresPanel.setBorder(featuresPanelborder);
         /***********************************************************************
     * 	/*******************************JPanel for features *****************************************************************/
 		controlsPanel = new JPanel();
 		controlsPanel.setBounds(10, 500, 660, 70);
 		controlsPanel.setLayout(null);
 		TitledBorder controlsPanelborder = new TitledBorder("CONTROLS");
 		controlsPanelborder.setTitleFont(new Font("Comic Sans MS", Font.BOLD,12));
 		controlsPanelborder.setTitleJustification(TitledBorder.CENTER);
 		controlsPanelborder.setTitlePosition(TitledBorder.TOP);
 		controlsPanel.setBorder(controlsPanelborder);
         /***********************************************************************
          * Adding items in respective panes
          ***********************************************************************/
         
         systemRequired=new JLabel("SYSTEMS REQUIRED");
         systemRequired.setFont(new Font("Comic Sans MS", Font.BOLD,12));
         systemRequired.setBounds(15,25,150,20);
         systemRequired.setVisible(true);
         executionPanel.add(systemRequired);
       
         String combodata2[]={"0","1","2","3","4", "5", "6", "7"};
         combobox=new JComboBox(combodata2);
         if(RememberMe)
         {
 			combobox.setSelectedIndex(Integer.parseInt(readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "NUMBER_OF_SYSTEM")));
         }
         else
         {
        	 combobox.setSelectedIndex(0);
         }
         combobox.setBounds(175,25,40,20);
         combobox.setToolTipText("SELECT DESIRED NUMBER OF SYSTEMS.");
         selectedNumberOfSystems = Integer.toString(combobox.getSelectedIndex());
         combobox.addActionListener(this);
         combobox.setVisible(true);
        
         executionPanel.add(combobox);
         
//         createHelpIcon(218, 22, 13, 22);
         
         ConfigFile = new JLabel("SELECT CONFIG FILE");
         ConfigFile.setFont(new Font("Comic Sans MS", Font.BOLD,12));
         ConfigFile.setBounds(15, 50, 150, 20);
         ConfigFile.setVisible(true);
         
         executionPanel.add(ConfigFile);
         
         TestCasesFile = new JLabel("SELECT TESTCASE FILE");
         TestCasesFile.setFont(new Font("Comic Sans MS", Font.BOLD,12));
         TestCasesFile.setBounds(15, 79, 180, 20);
         TestCasesFile.setVisible(true);
         executionPanel.add(TestCasesFile);
         
         tConfigFilePath =  createTextField(175, 50, 300, 25, true, "SELECT CONFIGURATION FILE PATH.", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "CONFIG_FILE_PATH"), executionPanel, RememberMe, "");
         tTestCasesFile =  createTextField(175, 79, 300, 25, true, "CHOOSE MASTER TEST CASE FILE", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "TESTCASE_FILE_PATH"), executionPanel, RememberMe, "");
         
         
//         JButton helpButton = new JButton(new ImageIcon("D:\\TestAutothon\\final_code\\een_voor_allen\\src\\test\\resources\\EVAimages\\QuestionMark.png"));
//         helpButton.setBounds(661, 50, 13, 22);
//         helpButton.setToolTipText("HELP");
//         helpButton.setVisible(true);
//         helpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//         helpButton.setBackground(null);
//         helpButton.addActionListener(this);
//         executionPanel.add(helpButton);
         
         createHelpIcon(635,3,40,20);
//       JButton BrowseConfigFile = new JButton(new ImageIcon("D:\\Users\\vnihaniwal\\Desktop\\EVAimages\\Browse1.png"));
         JButton BrowseConfigFile = new JButton("BROWSE CONFIG FILE");
         BrowseConfigFile.setBounds(480, 50, 180, 25);
         BrowseConfigFile.setToolTipText("BROWSE CONFIGURATION FILE");
         BrowseConfigFile.setVisible(true);		
         BrowseConfigFile.addActionListener(this);
         executionPanel.add(BrowseConfigFile);
         
         JButton BrowseTestCaseFile = new JButton("BROWSE TEST CASES");
         BrowseTestCaseFile.setBounds(480, 79, 180, 25);
         BrowseTestCaseFile.setToolTipText("BROWSE MASTER TEST SHEET");
         BrowseTestCaseFile.setVisible(true);		
         BrowseTestCaseFile.addActionListener(this);
         executionPanel.add(BrowseTestCaseFile);
         
//         for(int counter =1; counter <=7; counter ++)
//         {
//        	 int anotherCounter = 160;
//        	 createJLabel("NODE "+counter, 20, anotherCounter, 150, 25, false, executionPanel); 
//        	 anotherCounter = anotherCounter+40;
//         }
         
         
         
         system1 = createJLabel("NODE 1", 20, 120, 150, 25, false, executionPanel); 
         system2 = createJLabel("NODE 2", 20, 160, 150, 25, false, executionPanel); 
         system3 = createJLabel("NODE 3", 20, 200, 150, 25, false, executionPanel);
         system4 = createJLabel("NODE 4", 20, 240, 150, 25, false, executionPanel);
         system5 = createJLabel("NODE 5", 20, 280, 150, 25, false, executionPanel);
         system6 = createJLabel("NODE 6", 20, 320, 150, 25, false, executionPanel);
         system7 = createJLabel("NODE 7", 20, 360, 150, 25, false, executionPanel);
        /************************************/
         lblip1 = createJLabel("IP", 80, 120, 150, 25, false, executionPanel);
         lblip2 = createJLabel("IP", 80, 160, 150, 25, false, executionPanel);
         lblip3 = createJLabel("IP", 80, 200, 150, 25, false, executionPanel);
         lblip4 = createJLabel("IP", 80, 240, 150, 25, false, executionPanel);
         lblip5 = createJLabel("IP", 80, 280, 150, 25, false, executionPanel);
         lblip6 = createJLabel("IP", 80, 320, 150, 25, false, executionPanel);
         lblip7 = createJLabel("IP", 80, 360, 150, 25, false, executionPanel);
//     	/************************************/
         lblport1 = createJLabel("Port1", 240, 120, 150, 25, false, executionPanel);
         lblport2 = createJLabel("Port2", 240, 160, 100, 25, false, executionPanel);
 		 lblport3 = createJLabel("Port3", 240, 200, 100, 25, false, executionPanel);
 		 lblport4 = createJLabel("Port4", 240, 240, 100, 25, false, executionPanel);
 		 lblport5 = createJLabel("Port5", 240, 280, 100, 25, false, executionPanel);
 		 lblport6 = createJLabel("Port6", 240, 320, 100, 25, false, executionPanel);
 		 lblport7 = createJLabel("Port7", 240, 360, 100, 25, false, executionPanel);
//        /************************************/
// 		 
 		tfip1 =  createTextField(135, 120, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM1IP"), executionPanel, RememberMe, "localhost");
 		tfip2 =  createTextField(135, 160, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM2IP"), executionPanel, RememberMe, "");
 		tfip3 =  createTextField(135, 200, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM3IP"), executionPanel, RememberMe, "");
 		tfip4 =  createTextField(135, 240, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM4IP"), executionPanel, RememberMe, "");
 		tfip5 =  createTextField(135, 280, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM5IP"), executionPanel, RememberMe, "");
 		tfip6 =  createTextField(135, 320, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM6IP"), executionPanel, RememberMe, "");
 		tfip7 =  createTextField(135, 360, 100, 25, false, "ENTER DESIRED MACHINE IP", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM7IP"), executionPanel, RememberMe, "");
//   /************************************/
 		tfport1 =  createTextField(280, 120, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM1PORT"), executionPanel, RememberMe, "", 4);
 		tfport2 =  createTextField(280, 160, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM2PORT"), executionPanel, RememberMe, "", 4);
 		tfport3 =  createTextField(280, 200, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM3PORT"), executionPanel, RememberMe, "", 4);
 		tfport4 =  createTextField(280, 240, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM4PORT"), executionPanel, RememberMe, "", 4);
 		tfport5 =  createTextField(280, 280, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM5PORT"), executionPanel, RememberMe, "", 4);
 		tfport6 =  createTextField(280, 320, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM6PORT"), executionPanel, RememberMe, "", 4);
 		tfport7 =  createTextField(280, 360, 50, 25, false, "ENTER DESIRED MACHINE PORT", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "SYSTEM7PORT"), executionPanel, RememberMe, "", 4);
//		/*******************JPanel for Browser radio buttons and images***************************************/
		browserPanel = new JPanel();
		browserPanel.setBounds(330, 110, 340, 285);
		browserPanel.setLayout(null);
		TitledBorder border = new TitledBorder("Browsers");
		border.setTitleFont(new Font("Comic Sans MS", Font.BOLD,12));
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitlePosition(TitledBorder.TOP);
		browserPanel.setBorder(border);
//		browserPanel.setBackground(Color.WHITE);
		/**********************************************************/
		/******************************First system Radio button****************************/
		rIE1 		= createJRadioButton("rIE1", 5, 15, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF1 		= createJRadioButton("rFF1", 55, 15, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC1 		= createJRadioButton("rGC1", 105, 15, 20, 15, "CHROME  BROWSER", false, false, browserPanel);
		rMac1 		= createJRadioButton("rMAC1", 155, 15, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid1 	= createJRadioButton("rAndroid1", 225, 15, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone1 	= createJRadioButton("rIphone1", 280, 15, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group1 = new ButtonGroup();
		group1.add(rIE1);
		group1.add(rFF1);
		group1.add(rGC1);
		group1.add(rMac1);
		group1.add(rAndroid1);
		group1.add(rIphone1);
		/******************************Second system Radio button****************************/
		rIE2 		= createJRadioButton("rIE2", 5, 55, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF2 		= createJRadioButton("rFF2", 55, 55, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC2 		= createJRadioButton("rGC2", 105, 55, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac2 		= createJRadioButton("rMAC2", 155, 55, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid2 	= createJRadioButton("rAndroid2", 225, 55, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone2 	= createJRadioButton("rIphone2", 280, 55, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group2 = new ButtonGroup();
		group2.add(rIE2);
		group2.add(rFF2);
		group2.add(rGC2);
		group2.add(rMac2);
		group2.add(rAndroid2);
		group2.add(rIphone2);
		/******************************Third system Radio button****************************/
		rIE3 		= createJRadioButton("rIE3", 5, 95, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF3 		= createJRadioButton("rFF3", 55, 95, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC3 		= createJRadioButton("rGC3", 105, 95, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac3 		= createJRadioButton("rMAC3", 155, 95, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid3 	= createJRadioButton("rAndroid3", 225, 95, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone3 	= createJRadioButton("rIphone3", 280, 95, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group3 = new ButtonGroup();
		group3.add(rIE3);
		group3.add(rFF3);
		group3.add(rGC3);
		group3.add(rMac3);
		group3.add(rAndroid3);
		group3.add(rIphone3);
		/******************************Fourth system Radio button****************************/
		rIE4 		= createJRadioButton("rIE4", 5, 135, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF4 		= createJRadioButton("rFF4", 55, 135, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC4 		= createJRadioButton("rGC4", 105, 135, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac4 		= createJRadioButton("rMAC4", 155, 135, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid4 	= createJRadioButton("rAndroid4", 225, 135, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone4 	= createJRadioButton("rIphone4", 280, 135, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group4 = new ButtonGroup();
		group4.add(rIE4);
		group4.add(rFF4);
		group4.add(rGC4);
		group4.add(rMac4);
		group4.add(rAndroid4);
		group4.add(rIphone4);
		/******************************Fifth system Radio button****************************/
		rIE5 		= createJRadioButton("rIE5", 5, 175, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF5 		= createJRadioButton("rFF5", 55, 175, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC5 		= createJRadioButton("rGC5", 105, 175, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac5 		= createJRadioButton("rMAC5", 155, 175, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid5 	= createJRadioButton("rAndroid5", 225, 175, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone5 	= createJRadioButton("rIphone5", 280, 175, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group5 = new ButtonGroup();
		group5.add(rIE5);
		group5.add(rFF5);
		group5.add(rGC5);
		group5.add(rMac5);
		group5.add(rAndroid5);
		group5.add(rIphone5);
		/******************************Sixth system Radio button****************************/
		rIE6 		= createJRadioButton("rIE6", 5, 215, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF6 		= createJRadioButton("rFF6", 55, 215, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC6 		= createJRadioButton("rGC6", 105, 215, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac6 		= createJRadioButton("rMAC6", 155, 215, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid6 	= createJRadioButton("rAndroid6", 225, 215, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone6 	= createJRadioButton("rIphone6", 280, 215, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group6 = new ButtonGroup();
		group6.add(rIE6);
		group6.add(rFF6);
		group6.add(rGC6);
		group6.add(rMac6);
		group6.add(rAndroid6);
		group6.add(rIphone6);
		/******************************Seventh system Radio button****************************/
		rIE7 		= createJRadioButton("rIE7", 5, 255, 20, 15, "IE BROWSER",false, false, browserPanel);
		rFF7 		= createJRadioButton("rFF7", 55, 255, 20, 15, "FF BROWSER",false, false, browserPanel);
		rGC7 		= createJRadioButton("rGC7", 105, 255, 20, 15, "CHROME  BROWSER",false, false, browserPanel);
		rMac7 		= createJRadioButton("rMAC7", 155, 255, 20, 15, "MAC BROWSER",false, false, browserPanel);
		rAndroid7 	= createJRadioButton("rAndroid7", 225, 255, 20, 15, "ANDROID BROWSER",false, false, browserPanel);
		rIphone7 	= createJRadioButton("rIphone7", 280, 255, 20, 15, "IPHONE BROWSER",false, false, browserPanel);
		
		//Group the radio buttons.
		group7 = new ButtonGroup();
		group7.add(rIE7);
		group7.add(rFF7);
		group7.add(rGC7);
		group7.add(rMac7);
		group7.add(rAndroid7);
		group7.add(rIphone7);

		/******************************First system browser images****************************/
		lblie1 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 15, 22, 25, false, browserPanel);
		lblmozilla1 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 15, 22, 25, false, browserPanel);
		lblchrome1 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 15, 22, 25, false, browserPanel);	
 		lblMac1 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 15, 50, 25, false, browserPanel);	
 		lblandroid1 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 15, 22, 25, false, browserPanel);	
 		lbliphone1 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 15, 22, 25, false, browserPanel);	
 		/******************************Second system browser images****************************/
 		lblie2 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 55, 22, 25, false, browserPanel);
		lblmozilla2 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 55, 22, 25, false, browserPanel);
		lblchrome2	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 55, 22, 25, false, browserPanel);	
 		lblMac2 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 55, 50, 25, false, browserPanel);	
 		lblandroid2 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 55, 22, 25, false, browserPanel);	
 		lbliphone2 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 55, 22, 25, false, browserPanel);
 		/******************************Third system browser images****************************/
 		lblie3 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 95, 22, 25, false, browserPanel);
		lblmozilla3 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 95, 22, 25, false, browserPanel);
		lblchrome3	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 95, 22, 25, false, browserPanel);	
 		lblMac3 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 95, 50, 25, false, browserPanel);	
 		lblandroid3 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 95, 22, 25, false, browserPanel);	
 		lbliphone3 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 95, 22, 25, false, browserPanel);
 		/******************************Fourth system browser images****************************/
 		lblie4 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 135, 22, 25, false, browserPanel);
		lblmozilla4 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 135, 22, 25, false, browserPanel);
		lblchrome4	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 135, 22, 25, false, browserPanel);	
 		lblMac4 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 135, 50, 25, false, browserPanel);	
 		lblandroid4 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 135, 22, 25, false, browserPanel);	
 		lbliphone4 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 135, 22, 25, false, browserPanel);
 		/******************************Fifth system browser images****************************/
 		lblie5 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 175, 22, 25, false, browserPanel);
		lblmozilla5 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 175, 22, 25, false, browserPanel);
		lblchrome5	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 175, 22, 25, false, browserPanel);	
 		lblMac5 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 175, 50, 25, false, browserPanel);	
 		lblandroid5 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 175, 22, 25, false, browserPanel);	
 		lbliphone5 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 175, 22, 25, false, browserPanel);
 		/******************************Sixth system browser images****************************/
 		lblie6 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 215, 22, 25, false, browserPanel);
		lblmozilla6 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 215, 22, 25, false, browserPanel);
		lblchrome6	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 215, 22, 25, false, browserPanel);	
 		lblMac6 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 215, 50, 25, false, browserPanel);	
 		lblandroid6 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 215, 22, 25, false, browserPanel);	
 		lbliphone6 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 215, 22, 25, false, browserPanel);
 		/******************************Seventh system browser images****************************/
 		lblie7 		= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\IE.png").getAbsolutePath().toString()), 25, 255, 22, 25, false, browserPanel);
		lblmozilla7 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\FF.png").getAbsolutePath().toString()), 72, 255, 22, 25, false, browserPanel);
		lblchrome7	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\GC.png").getAbsolutePath().toString()), 125, 255, 22, 25, false, browserPanel);	
 		lblMac7 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Mac.png").getAbsolutePath().toString()), 173, 255, 50, 25, false, browserPanel);	
 		lblandroid7 = createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Android.png").getAbsolutePath().toString()), 245, 255, 22, 25, false, browserPanel);	
 		lbliphone7 	= createJLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\Apple1.png").getAbsolutePath().toString()), 300, 255, 22, 25, false, browserPanel);
		
 		/**********************************************************/
						 		
 		/****************************************Features objects****************************************************/
 		imageComparison = new JCheckBox("IMAGE COMPARISON");
 		imageComparison.setBounds(15, 18, 160, 30);
 		imageComparison.setToolTipText("IMAGE CHECKPOINT");
 		imageComparison.setFont(new Font("Comic Sans MS", Font.BOLD,12));
 		imageComparison.setVisible(true); 
 		if(RememberMe)
 		{
 			boolean b_imageComparison= false;
 			try {
 				b_imageComparison = Boolean.parseBoolean(readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "IMAGE_COMPARISON"));
 			}
 			catch(Exception e)
 			{
 				
 			}
 			if(b_imageComparison)
 			{
 				imageComparison.setSelected(true);
// 				RuntimeVals.imageComparison=true;
 			}
 		}
 		featuresPanel.add(imageComparison);
 		
 		
 		startServer = new JCheckBox("START SERVER");
 		startServer.setBounds(175, 18, 120, 30);
 		startServer.setToolTipText("START SELENIUM SERVER");
//		imageComparison.addActionListener(new chkListener());
 		startServer.setFont(new Font("Comic Sans MS", Font.BOLD,12));
 		startServer.addItemListener(new chkListener());
 		startServer.setVisible(true);
 		featuresPanel.add(startServer);
 		
 		startLocalNodes = new JCheckBox("START BROWSER NODES");
 		startLocalNodes.setBounds(300, 18, 200, 30);
 		startLocalNodes.setToolTipText("START LOCAL NODES");
 		startLocalNodes.setFont(new Font("Comic Sans MS", Font.BOLD,12));
//		imageComparison.addActionListener(new chkListener());
 		startLocalNodes.addItemListener(new chkListener());
 		startLocalNodes.setVisible(true);
 		featuresPanel.add(startLocalNodes);
 		
 		
 		
//		Radio button
 		lblImageComparison = createJLabel("EXECUTION RESULT LOCATION", 15, 58, 220, 20, true, featuresPanel);

 		browseResultLoc = new JButton("BROWSE LOCATION");
 		browseResultLoc.setBounds(490, 58, 155, 25);
 		browseResultLoc.setToolTipText("BROWSE DESIRED RESULT LOCATION");
 		browseResultLoc.setVisible(true);
 		browseResultLoc.addActionListener(this);
 		featuresPanel.add(browseResultLoc);
 		
 		resultLocation =  createTextField(215,58,270,25, true, "ENTER NEW REPORT LOCATION", readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "REPORT_PATH"), featuresPanel, RememberMe, new File(new File("").getAbsolutePath() + File.separator).toString());

//						 		Result location
		
			/***************************Parallel / Sequential execution***********************/
 		ParallelExecution 	= createJLabel("Parallel Execution", 55, 15, 150, 20, true, controlsPanel);
 		SequentialExecution = createJLabel("Customized Execution", 55, 35, 150, 20, true, controlsPanel);
 		
//						 		rParallel 		= createJRadioButton("rParallel", 20, 20, 20, 15, true, true, controlsPanel);
 		rParallel = new JRadioButton("Parallel");
 		rParallel.setBounds(20, 20, 20, 15);
 		rParallel.setVisible(true);
 		rParallel.setSelected(true);
		controlsPanel.add(rParallel);
		
//						 		rSequential 		= createJRadioButton("rSequential", 20, 40, 20, 15, true, false, controlsPanel);
		rSequential = new JRadioButton("Sequential");
		rSequential.setBounds(20, 40, 20, 15);
		rSequential.setVisible(true);
		controlsPanel.add(rSequential);
		
		groupExecution = new ButtonGroup();
		groupExecution.add(rSequential);
		groupExecution.add(rParallel);
		/***************************Remember Me*********************************/
//		JLabel RememberMe = new JLabel("REMEBER MY CHOICE");
//		RememberMe.setBounds(405, 13, 150, 20);
//		RememberMe.setVisible(true);
//		controlsPanel.add(RememberMe);
		
		chkRememberMe = new JCheckBox("REMEMBER MY CHOICE");
		chkRememberMe.setBounds(405, 13, 190, 30);
		chkRememberMe.setToolTipText("REMEMBER MY CHOICE");
		chkRememberMe.setFont(new Font("Comic Sans MS", Font.BOLD,12));
		chkRememberMe.setVisible(true);
		if(RememberMe)
        {
			chkRememberMe.setSelected(true);
        }								
		chkRememberMe.addActionListener(this);
		controlsPanel.add(chkRememberMe);
		
		
		
		/************************************************************* IP and PORT config display****************************************************************************************************************************/		
		// Following code will display number of Node, IP and PORT according to the drop down value which is coming from JSON file
		 if(combobox.getSelectedIndex()==1)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, false);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, false);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==2)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, false);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==3)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==4)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==5)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==6)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, true);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
         }else if(combobox.getSelectedIndex()==7)
         {
             displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
    		 displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
    		 displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
    		 displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
    		 displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
    		 displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, true);
    		 displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, true);
         }
		 /*****************************************************************************************************************************************************************************************/
		 
		 
		 
		 /***************************Start and Stop button*********************************/
		bttnStart = new JButton("START EXECUTION");
		bttnStart.setBounds(10, 18, 300, 45);
		bttnStart.setToolTipText("CLICK TO START EXECUTION");
		bttnStart.setVisible(true);	
		bttnStart.setEnabled(true);
		bttnStart.addMouseListener(new MouseListener() {
				
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Following will fetch the value of parallel radio button from UI and set to RuntimeVal variable [for parallel or sequential execution.]
				
				RuntimeVals.parallelExecution 	= rParallel.isSelected();
				RuntimeVals.imageComparison 	= imageComparison.isSelected();
				RuntimeVals.tTestCasesFile 		= tTestCasesFile.getText(); 
				/*******************************************************/ 
				try {
					browser = new ArrayList<String>();
//					(RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1).substring(1)).substring(0, RuntimeVals.browsers.get(Integer.parseInt(Thread.currentThread().getName())-1).substring(1).length()-1);
					browser.add(getSelectedRadioBttnTxtFromGroup(group1));
					browser.add(getSelectedRadioBttnTxtFromGroup(group2));
					browser.add(getSelectedRadioBttnTxtFromGroup(group3));
					browser.add(getSelectedRadioBttnTxtFromGroup(group4));
					browser.add(getSelectedRadioBttnTxtFromGroup(group5));
					browser.add(getSelectedRadioBttnTxtFromGroup(group6));
					browser.add(getSelectedRadioBttnTxtFromGroup(group7));
					
					for(int i = 0; i<=browser.size()-1; i++)
					{
						if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("IE"))
						{
							RuntimeVals.browserNames.add("IE");
						}
						else if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("FF"))
						{
							RuntimeVals.browserNames.add("FF");
						}
						else if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("GC"))
						{
							RuntimeVals.browserNames.add("GC");
						}
						else if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("MAC"))
						{
							RuntimeVals.browserNames.add("MAC");
						}
						else if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("Android"))
						{
							RuntimeVals.browserNames.add("Android");
						}
						else if((browser.get(i).substring(1)).substring(0, (browser.get(i).substring(1).length()-1)).contains("Iphone"))
						{
							RuntimeVals.browserNames.add("Iphone");
						}
					}
//					browserNames.add((getSelectedRadioBttnTxtFromGroup(group6).substring(1)).substring(0, (getSelectedRadioBttnTxtFromGroup(group6).substring(1).length()-1)));
				}
				catch(Exception e)
				{
					System.out.println("There is some problem in adding browser in array");
				}
				System.out.println(browser);
				ip.clear();
				ip.add(tfip1.getText());
				ip.add(tfip2.getText());
				ip.add(tfip3.getText());
				ip.add(tfip4.getText());
				ip.add(tfip5.getText());
				ip.add(tfip6.getText());
				ip.add(tfip7.getText());
				
				port.clear();
				port.add(tfport1.getText());
				port.add(tfport2.getText());
				port.add(tfport3.getText());
				port.add(tfport4.getText());
				port.add(tfport5.getText());
				port.add(tfport6.getText());
				port.add(tfport7.getText());
				
				RuntimeVals.ip.clear(); // clear ip arraylist before loop
				RuntimeVals.port.clear(); // clear port arraylist before loop
				RuntimeVals.browsers.clear(); // Will clear all the elements for further use.
				
				if(RememberMe)
				{
					for(int i =0; i<=Integer.parseInt(selectedNumberOfSystems)-1;i++)
					{
//						System.out.println(browser.get(i)+" added in global browser arraylist");
//						readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "REMEMBERME_OPTION")
//						RuntimeVals.browsers.add(readJson(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"), "Browser"+(i)));
						if(ip.get(i).equals("") || port.get(i).equals(""))
						{
							JOptionPane.showMessageDialog(tfip1, "Port and IP is mandatory");
							aJProgressBar.setVisible(false);
							frame1.remove(aJProgressBar);
							return;
						}
						else
						{
							RuntimeVals.ip.add(ip.get(i));
							RuntimeVals.port.add(port.get(i));
						}
					}
				}
				else
				{
					for(int i =0; i<=Integer.parseInt(selectedNumberOfSystems)-1;i++)
					{
						System.out.println(browser.get(i)+" added in global browser arraylist");
						RuntimeVals.browsers.add(browser.get(i));
						if(ip.get(i).equals("") || port.get(i).equals(""))
						{
							JOptionPane.showMessageDialog(tfip1, "Port and IP is mandatory");
							aJProgressBar.setVisible(false);
							frame1.remove(aJProgressBar);
							return;
						}
						else
						{
							RuntimeVals.ip.add(ip.get(i));
							RuntimeVals.port.add(port.get(i));
						}
					}
				}
				 
				if(RuntimeVals.browsers.contains(null))
				{
					JOptionPane.showMessageDialog(rIE1, "All the radio buttons should be selected");
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 return;
				}
			
				if(combobox.getSelectedIndex()==0)
				{
					combobox.setBackground(Color.RED);
					JOptionPane.showMessageDialog(rIE1, "Number of Selected system cannot be ZERO");
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 return;
				}
				
//				if(ip.contains("") || port.contains(""))
//				{
//					JOptionPane.showMessageDialog(tfip1, "IP and PORT is required");
//					bttnStart.setEnabled(false);
//					 aJProgressBar.setVisible(false);
//					 frame1.remove(aJProgressBar);
//				}

				if(RuntimeVals.tTestCasesFile.length()<1)
				{
					tTestCasesFile.setBackground(Color.RED);
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 return;

				}

				if(tConfigFilePath.getText().length()<1)
				{
					tConfigFilePath.setBackground(Color.RED);
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 return;

				}
				else if(resultLocation.getText().length()<1)
				 {
					 resultLocation.setBackground(Color.RED);
					 bttnStart.setEnabled(false);
					 System.out.println("Removing progressbar");
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 return;

				 }
				else
//				else if(UtilityFunctionBank.VerifyHubnNodeConnection())
				 {
					// If Remember Me check box is selected then below method will write all choices in JSON file else only it will update remember me choice in file.
					 rememberMe_WriteInJson();
					 System.out.println("Removing progressbar");
					 aJProgressBar.setVisible(false);
					 frame1.remove(aJProgressBar);
					 bttnStop.setEnabled(true);
//					 RuntimeVals.tTestCasesFile 			= tTestCasesFile.getText();
					 RuntimeVals.setReportsFolderLocation 	= resultLocation.getText();
					 ExecuteMe xCuteMe 						= new ExecuteMe();
					 xCuteMe.startExecutionMethod();
					 bttnStart.setEnabled(false);
					 bttnStop.setEnabled(true);
				 }
				aJProgressBar.setVisible(false);
				 System.out.println("********** Execution Ends ***********");
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				addProgressBar();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		} );
//		bttnStart.addActionListener(this);
		
        startAndStopPanel.add(bttnStart);
        
        bttnStop = new JButton("STOP EXECUTION");
		bttnStop.setBounds(350, 18, 300, 45);
		bttnStop.setToolTipText("CLICK TO STOP EXECUTION");
		bttnStop.setVisible(true);		
		bttnStop.setEnabled(false);
		bttnStop.addActionListener(this);
        startAndStopPanel.add(bttnStop);
		
         /********************************All above items added in pane****************************/
        /**********************************************************/
 		executionPanel.add(startAndStopPanel);
 		executionPanel.add(browserPanel);
 		executionPanel.add(featuresPanel);
 		executionPanel.add(controlsPanel);

 		/**********************************************************/
 		
         // Created tab in UI
         JTabbedPane tabbedPane = new JTabbedPane();
         
         tabbedPane.add("CBT", executionPanel);
      //   tabbedPane.add("APIPanel", configPanel);    	//%%%%%%%%%%%%%%%%%%%%%%%%%%% Uncomment if show API tab in UI %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//         tabbedPane.add("NATIVE APP", configPanel);	%%%%%%%%%%%%%%%%%%%%%%%%%%% Uncomment if show Native tab in UI %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
         tabbedPane.setIconAt(0, new ImageIcon(ImageIO.read(new File(new File("src\\test\\resources\\EVAimages\\logo13.png").getAbsolutePath().toString()))));
         
         tabbedPane.setBounds(10, 10, 680, 680);
         frame1.add(tabbedPane);
         frame1.setVisible(true);
         
	 }

	 public void actionPerformed(ActionEvent ae) 
      {
		 
		 if(ae.getActionCommand()=="STOP EXECUTION")
		 {
			 int stopExecutionChoice = JOptionPane.showConfirmDialog((Component) null, "Do you want to stop the execution?","alert", JOptionPane.YES_NO_OPTION);
	     		if(stopExecutionChoice==0)
	     		{
	     			RuntimeVals.stopExecution=true;
	     			System.out.println("Initiating Stop Execution");
	     		}
	     		if(stopExecutionChoice==1)
	     		{
	     			System.out.println("No Selected. So Execution is not being Stopped!");
	     		}
			 
			 
//			 for (Thread t : Thread.getAllStackTraces().keySet()) 
//			 {
//				 if(t.getName()=="1")
//				 {
//					 t.interrupt();
//					 System.out.println("Stopping thread :--"+t.getName().toString());
//					 t.stop();
//				 }
//				 if(t.getName()=="2")
//				 {
//					 t.interrupt();
//					 System.out.println("Stopping thread :--"+t.getName().toString());
//					 t.stop();
//				 }
//				 if(t.getName()=="3")
//				 {
//					 t.interrupt();
//					 System.out.println("Stopping thread :--"+t.getName().toString());
//					 t.stop();
//				 }
//				 
//			 }
			/*
			 * for (Thread t : Thread.getAllStackTraces().keySet()) { if
			 * (t.getState()==Thread.State.RUNNABLE) t.interrupt(); }
			 */
			
			//Thread.getAllStackTraces().keySet().;
			 
			/*
			 * for (Thread t : Thread.getAllStackTraces().keySet()) {
			 * System.out.println(t.toString());
			 * 
			 * try {
			 * 
			 * System.out.println("Thread Found :--"+t.getName().toString()); t.sleep(5000);
			 * if(t.getName().equals("1")||t.getName().equals("2")||t.getName().equals("3"))
			 * { System.out.println("Stopping Thread :--"+t.getName().toString()); t.stop();
			 * } } catch (Exception e) { e.printStackTrace(); }
			 * 
			 * }
			 */
			 
		 }
//		 How to get radio button values
//		 if(ae.getActionCommand()=="Group1Browser")
//		 { 
////			 browser.add(ae.getActionCommand().toString());
////			 System.out.println(ae.getSource());
////			 String abc = group.getSelection().getActionCommand();
////			 System.out.println(abc);
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser1 = jr.getText();
//			 browser.set(0,jr.getText());
//		 }
//		 if(ae.getActionCommand()=="Group2Browser")
//		 { 
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser2 = jr.getText();
//			 browser.set(1,jr.getText());
//		 }
//		 if(ae.getActionCommand()=="Group3Browser")
//		 { 
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser3 = jr.getText();
//			 browser.set(2,jr.getText());
//		 }
//		 if(ae.getActionCommand()=="Group4Browser")
//		 { 
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser4 = jr.getText();
//			 browser.set(3,jr.getText());
//		 }
//		 if(ae.getActionCommand()=="Group5Browser")
//		 { 
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser5 = jr.getText();
//			 browser.set(4,jr.getText());
//		 }
//		 if(ae.getActionCommand()=="Group6Browser")
//		 { 
//			 JRadioButton jr = new JRadioButton();
//			 jr = (JRadioButton) ae.getSource();
//			 System.out.println(jr.getText());
//			 tempBrowser6 = jr.getText();
//			 browser.set(5,jr.getText());
//		 }
		 
		 if(ae.getActionCommand()=="RESULT LOC")
		 {
			 resultChooser = new JFileChooser();
			 resultChooser.setCurrentDirectory(new java.io.File("."));
			 resultChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			 resultChooser.setVisible(true);
			 if(resultChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			 {
				 resultLocation.setText("");
				 resultLocation.setText(resultChooser.getSelectedFile().getAbsolutePath());
			 }
			 if(resultLocation.getText().length()>1)
			 {
				 resultLocation.setBackground(Color.WHITE);
				 bttnStart.setEnabled(true);
			 }
			 else
			 {
				 bttnStart.setEnabled(false);
				 resultLocation.setToolTipText("REPORTS LOCATION IS MUST");
				 resultLocation.setBackground(Color.RED);
			 }
		 }
		 if(ae.getActionCommand()=="START EXECUTION")
		 {
//			 addProgressBar();
			 
			 // Following method will open hub and after that open browser to verufy the hub is able to communicate with nodes
//			 if(VerifyHubnNodeConnection());
//			 {
//				 System.out.println("Removing progressbar");
//				 frame1.remove(aJProgressBar);
//			 if(resultLocation.getText().length()<1)
//			 {
//				 resultLocation.setBackground(Color.RED);
//				 bttnStart.setEnabled(false);
//			 }
//			 else
//			 {
//				 RuntimeVals.setReportsFolderLocation = resultLocation.getText();
//				 ExecuteMe xCuteMe = new ExecuteMe();
//				 xCuteMe.startExecutionMethod();
//			 }
//			 }System.out.println("Out of start execution");
		 }
		  if(ae.getSource() instanceof JComboBox)
		  {
			  combobox.setBackground(null);
			  JComboBox cb = new JComboBox();
			  cb = (JComboBox) ae.getSource();
			  selectedNumberOfSystems = cb.getSelectedItem().toString();
			  System.out.println(selectedNumberOfSystems);
			 browser 		= new ArrayList<String>();
			  
			  if(cb.getSelectedItem().toString().equalsIgnoreCase("0"))
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, false);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, false);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, false);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
				  
				  JOptionPane.showMessageDialog(cb, "Invalid number of systems selected.");
			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("1")) 
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, false);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, false);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);

			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("2"))
			  {
				
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, false);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);
			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("3"))
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, false);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);

			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("4"))
			  {
				// System 1
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, false);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);

			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("5"))
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, false);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);

			  }
			  else if(cb.getSelectedItem().toString().equalsIgnoreCase("6"))
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, true);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, false);

			  }else if(cb.getSelectedItem().toString().equalsIgnoreCase("7"))
			  {
				  displayNodeSystem(system1, lblip1, tfip1, lblport1, tfport1, rIE1, rFF1, rGC1, rMac1, rAndroid1, rIphone1, lblie1, lblmozilla1, lblchrome1, lblMac1, lblandroid1, lbliphone1, true);    
				  displayNodeSystem(system2, lblip2, tfip2, lblport2, tfport2, rIE2, rFF2, rGC2, rMac2, rAndroid2, rIphone2, lblie2, lblmozilla2, lblchrome2, lblMac2, lblandroid2, lbliphone2, true);
				  displayNodeSystem(system3, lblip3, tfip3, lblport3, tfport3, rIE3, rFF3, rGC3, rMac3, rAndroid3, rIphone3, lblie3, lblmozilla3, lblchrome3, lblMac3, lblandroid3, lbliphone3, true);
				  displayNodeSystem(system4, lblip4, tfip4, lblport4, tfport4, rIE4, rFF4, rGC4, rMac4, rAndroid4, rIphone4, lblie4, lblmozilla4, lblchrome4, lblMac4, lblandroid4, lbliphone4, true);
				  displayNodeSystem(system5, lblip5, tfip5, lblport5, tfport5, rIE5, rFF5, rGC5, rMac5, rAndroid5, rIphone5, lblie5, lblmozilla5, lblchrome5, lblMac5, lblandroid5, lbliphone5, true);
				  displayNodeSystem(system6, lblip6, tfip6, lblport6, tfport6, rIE6, rFF6, rGC6, rMac6, rAndroid6, rIphone6, lblie6, lblmozilla6, lblchrome6, lblMac6, lblandroid6, lbliphone6, true);
				  displayNodeSystem(system7, lblip7, tfip7, lblport7, tfport7, rIE7, rFF7, rGC7, rMac7, rAndroid7, rIphone7, lblie7, lblmozilla7, lblchrome7, lblMac7, lblandroid7, lbliphone7, true);
			  }
		  }
		  /************************* XML file chooser **********************************/
		  if(ae.getActionCommand()=="BROWSE CONFIG FILE")
		  {
			  chooser=new JFileChooser();
			  chooser.setCurrentDirectory(new java.io.File("."));
			  chooser.setDialogTitle("Choose Configuration File");
			  chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			  FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
			  chooser.setFileFilter(xmlfilter);
			  chooser.setAcceptAllFileFilterUsed(false);
			  chooser.setVisible(true);
			  if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			  {
				  String selectedFile=chooser.getSelectedFile().getAbsolutePath();
				  tConfigFilePath.setText(chooser.getSelectedFile().getParent());
				  XML_FILE=chooser.getSelectedFile().getAbsolutePath().toString();
				  FOLDER_PATH=chooser.getSelectedFile().getAbsolutePath().toString().replace("\\", "/");
//				  FOLDER_PATH=chooser.getCurrentDirectory().toString().replace("\\", "/");
				  tConfigFilePath.setText(FOLDER_PATH);
				  tConfigFilePath.setBackground(Color.WHITE);
				  bttnStart.setEnabled(true);
			  }
			  else if(tConfigFilePath.getText().length()>1)
			  {
				  
			  }
			  else
			  {
				  tConfigFilePath.setBackground(Color.RED);
				  JOptionPane.showMessageDialog(chooser, "No File Chosen");
			  }
		  }
          /*********************************XML chooser ends here*****************************************/
		  
		  
		  if(ae.getActionCommand()=="BROWSE TEST CASES")
		  {
			  chooser=new JFileChooser();
			  chooser.setCurrentDirectory(new java.io.File("."));
			  chooser.setDialogTitle("Choose Master File");
			  chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			  FileNameExtensionFilter xlsfilter = new FileNameExtensionFilter("Excel files only", "xlsx", "xls");
			  chooser.setFileFilter(xlsfilter);
			  chooser.setAcceptAllFileFilterUsed(false);
			  chooser.setVisible(true);
			  if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			  {
//				  String selectedFile=chooser.getSelectedFile().getAbsolutePath();
//				  tTestCasesFile.setText(chooser.getSelectedFile().getAbsolutePath().toString());
//				  tTestCasesFile.setText(chooser.getSelectedFile().getParent());
				  XLS_FILE=chooser.getSelectedFile().getAbsolutePath().toString();

//				  FOLDER_PATH=chooser.getCurrentDirectory().toString().replace("\\", "/");
				  tTestCasesFile.setText(chooser.getSelectedFile().getAbsolutePath().toString().replace("\\", "/"));
				  XLS_FILE=chooser.getSelectedFile().getAbsolutePath().toString();
				  tTestCasesFile.setBackground(Color.WHITE);
				  bttnStart.setEnabled(true);
			  }
			  else if(tTestCasesFile.getText().length()>1)
			  {
			  }
			  else
			  {
				  tTestCasesFile.setBackground(Color.RED);
				  JOptionPane.showMessageDialog(chooser, "No File Chosen");
			  }
		  }
		  
		  if(ae.getActionCommand()=="REMEMBER MY CHOICE")
		  {
			  if(chkRememberMe.isSelected())
			  {
				  
			  }
		  }
      }
	 
	 public LinkedList<String> storeBrowserInObject()
	 {
		 LinkedList<String> browserName = new LinkedList<>();
		 LinkedList<String> BrowserNames = new LinkedList<>();
		 
			try {
				browserName.add(getSelectedRadioBttnTxtFromGroup(group1));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group2));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group3));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group4));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group5));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group6));
				browserName.add(getSelectedRadioBttnTxtFromGroup(group7));
				
				for(int i = 0; i<=browserName.size()-1; i++)
				{
					if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("IE"))
					{
						BrowserNames.add("ie");
					}
					else if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("FF"))
					{
						BrowserNames.add("gecko");
					}
					else if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("GC"))
					{
						BrowserNames.add("chrome");
					}
					else if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("MAC"))
					{
						BrowserNames.add("MAC");
					}
					else if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("Android"))
					{
						BrowserNames.add("Android");
					}
					else if((browserName.get(i).substring(1)).substring(0, (browserName.get(i).substring(1).length()-1)).contains("Iphone"))
					{
						BrowserNames.add("Iphone");
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("There is some problem in adding browser in LinkedList");
			}
			return BrowserNames;
	 }
	 public LinkedList<String> storeNodeIPInObject()
	 {
		 LinkedList<String> NodeIP = new LinkedList<>();
		 try {
			 NodeIP.clear();
			 NodeIP.add(tfip1.getText());
			 NodeIP.add(tfip2.getText());
			 NodeIP.add(tfip3.getText());
			 NodeIP.add(tfip4.getText());
			 NodeIP.add(tfip5.getText());
			 NodeIP.add(tfip6.getText());
			 NodeIP.add(tfip7.getText());

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 return NodeIP;
	 }
	 
	 
	 public void executeNodeCommand(String NodePort, String DriverType, String driverExecutablePath, String BatchFilename) throws InterruptedException
	 {
		 
		 
		 TxtFileUtil txFileUtilObj = new TxtFileUtil();
	
//		 String driverExecutablePath 	= UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\drivers\\chromedriver.exe");
		 String FolderPath 				= UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\SeleniumJar");
		 String jarFileName 			= UtilityFunctionBank.getFileNameFromFolder(FolderPath, "jar");
		 String SeleniumJarFilePath  	= FolderPath+"\\"+jarFileName;
		 
		 String nodeCommand = "java -Dwebdriver."+DriverType+".driver="+driverExecutablePath+" -jar "+SeleniumJarFilePath+" -role node -hub http://localhost:4444/wd/register -port "+NodePort;
		 System.out.println(nodeCommand);

		 String textToWrite = nodeCommand;
		 txFileUtilObj.writeinBatchFile(UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\"+BatchFilename), textToWrite);
		 
		 Thread.sleep(5000);

		 Process p;
		 try {
			 p = Runtime.getRuntime().exec("cmd.exe /c start " + UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\"+BatchFilename)+".bat");
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public LinkedList<String> storeNodePortInObject()
	 {
		 	LinkedList<String> NodePort = new LinkedList<>();
		 	try {
		 		NodePort.clear();
		 		NodePort.add(tfport1.getText());
		 		NodePort.add(tfport2.getText());
		 		NodePort.add(tfport3.getText());
		 		NodePort.add(tfport4.getText());
		 		NodePort.add(tfport5.getText());
		 		NodePort.add(tfport6.getText());
		 		NodePort.add(tfport7.getText()); 
		 	}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 	return NodePort;
	 }
	 
	 public void displayNodeSystem(JLabel NodeLabel, JLabel IPLabel, JTextField ipTextField, 
			 JLabel	 PortLabel, JTextField PortTxtField, JRadioButton RadioBttnIE, JRadioButton	 RadioBttnFF, 
			 JRadioButton	 RadioBttnGC, JRadioButton	 RadioBttnMac, JRadioButton	 RadioBttnAndroid, JRadioButton	 RadioBttnIphone, 
			 JLabel LabelIE, JLabel LabelFF, JLabel LabelGC, JLabel LabelMac, JLabel LabelAndroid, JLabel LabelIphone, boolean flag)
	 {
		 NodeLabel.setVisible(flag);
		 IPLabel.setVisible(flag);
		 ipTextField.setVisible(flag);
		 PortLabel.setVisible(flag);
		 PortTxtField.setVisible(flag);
		 RadioBttnIE.setVisible(flag);
		 RadioBttnFF.setVisible(flag);
		 RadioBttnGC.setVisible(flag);
		 RadioBttnMac.setVisible(flag);
		 RadioBttnAndroid.setVisible(flag);
		 RadioBttnIphone.setVisible(flag);
		 LabelIE.setVisible(flag);
		 LabelFF.setVisible(flag);
		 LabelGC.setVisible(flag);
		 LabelMac.setVisible(flag);
		 LabelAndroid.setVisible(flag);
		 LabelIphone.setVisible(flag);
		 

	 }
	 
	 public void setRadioButtonOnOrOff(JRadioButton jr, JSONObject JsonObj)
	 {
		 try {
		 if(JsonObj.containsValue(jr.getText()))  // It will ON/OFF radio button according to the REMEMBERME.JSON file  
			{
			 jr.setSelected(true);
			}
		 }
		 catch(Exception e)
		 {
			 System.out.println("Json Object return null, probably nothing is in Json file.");
		 }
	 }
	 
	 public void progressBar() throws IOException, InterruptedException, evaException
	    {
	    	
//	        BufferedImage img=ImageIO.read(new File("D:\\Users\\vnihaniwal\\Desktop\\EVAimages\\EVA.png"));
	        JFrame frame=new JFrame();
	        frame.setLayout(null);
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setLocation((dim.width/4-frame.getSize().width/4)+ 150, (dim.height/10-frame.getSize().height/2)+150);
//	        new ImageIcon(new File("src\\test\\resources\\EVAimages\\EVA.png").getAbsolutePath().toString())
	        panel1 = new PPPanel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\SSAutomation.png").getAbsolutePath().toString()));
	        
	        prg1 = new JProgressBar(0,100);
	        prg1.setStringPainted(true);
	        prg1.setBackground(Color.WHITE);
	        prg1.setForeground(Color.BLUE);
            panel1.add(prg1);
            prg1.setBounds(1,368,599,30);
            frame.add(panel1);
            frame.setSize(600, 400);
            frame.setUndecorated(true);
            frame.setVisible(true);
            prg1.setValue(0);
            int value=1;
            while(value<101)
            {
               Thread.sleep(30);
               value++;
               prg1.setValue(value);
            }
            frame.hide();
            getUI();
	    }
	 
	 public void addProgressBar()
	 {
		 // add waiting progress bar 
		 aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
		 aJProgressBar.setStringPainted(true);
		 aJProgressBar.setIndeterminate(true);
		 aJProgressBar.setBounds(10, 690, 680, 20);
		 aJProgressBar.setString("WAITING TO CONNECT EXECUTION NODE(S)");
		 frame1.add(aJProgressBar, BorderLayout.NORTH);
	 }
	 
	public static void createHelpIcon(int x, int y, int w, int h)
	{
//		   JLabel HelpImage = new JLabel(new ImageIcon(new File("src\\test\\resources\\EVAimages\\QuestionMark.png").getAbsolutePath().toString()));
			JLabel HelpLink = new JLabel("HELP");
//         HelpImage.setBounds(661, 50, 13, 22);
			HelpLink.setBounds(x, y, w, h);
			HelpLink.setToolTipText("HELP");
			HelpLink.setForeground(Color.BLUE);
			HelpLink.setVisible(true);
			HelpLink.setFont(new Font("Comic Sans MS", Font.BOLD,12));
			HelpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			HelpLink.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().open(new File("src\\test\\resources\\HELP\\help.html"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
         executionPanel.add(HelpLink);
	}

	 public static String readJson(String file, String key) throws evaException
		{
			String Value = null;
			JSONParser jsonparser = new JSONParser();
			try(FileReader reader = new FileReader(file))
			{
				Object obj = jsonparser.parse(reader);
				JSONObject Jobj = (JSONObject) obj;
				JsonObj = Jobj;  // will copy  Json Object values to global JsonObj for further use.
				Value = Jobj.get(key).toString();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (NullPointerException ne)
			{
				System.out.println("Json Object return null, probably nothing is in Json file." + ne.getMessage());
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			} catch (ParseException e2) {
//				throw new evaException(String.format(ErrorType.NULL_JSONOBJECT, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e2.getMessage()));
				System.out.println("Json Object return null, probably nothing is in Json file." + e2.getMessage());
				e2.printStackTrace();
			}
			catch(Exception e3){
//				throw new evaException(String.format(ErrorType.NULL_JSONOBJECT, new Object() {}.getClass().getEnclosingMethod().getName().toString(), e3.getMessage()));
				System.out.println("Json Object return null, probably nothing is in Json file." + e3.getMessage());
				e3.printStackTrace();
			}
			return Value;
		}
	 
	 public JRadioButton createJRadioButton(String radioButtonName, int x, int y, int w, int h, String ToolTipText, boolean setVisible, boolean setSelected, JPanel panelName) 
	 {
		 JRadioButton radioButton = null;
		 try {
			 radioButton = new JRadioButton(radioButtonName);
			 radioButton.setBounds(x, y, w, h);
			 radioButton.setVisible(setVisible);
			 radioButton.setSelected(setSelected);
			 radioButton.setToolTipText(ToolTipText);
			 setRadioButtonOnOrOff(radioButton, JsonObj);// It will ON/OFF radio button according to the REMEMBERME.JSON file
//			 radioButton.setActionCommand("Group1Browser");
//			 radioButton.addActionListener(this);
			 panelName.add(radioButton);
		 }
		 catch(Exception e)
		 {
			 
		 }
		 return radioButton;
	 }
	 
	 public JTextField createTextField(int x, int y, int w, int h, boolean setVisible, String TooltipText, String defaultText1, JPanel panelName, boolean RememberMe, String defaultText2)
	 {
		 JTextField textfield = null;
		 try {
			 textfield=new JTextField();
			 textfield.setBounds(x, y, w, h);
			 textfield.setVisible(setVisible);
//			 textfield.setDocument(new JTextFieldLimit(15));
			 textfield.setToolTipText(TooltipText);
//			 textfield.addActionListener(this);
			 if(RememberMe)
			 {
				 if(defaultText1.equalsIgnoreCase(""))
				 {
					 textfield.setText(defaultText2);
				 }
				 else
				 {
					 textfield.setText(defaultText1);
				 }
			 }
			 else
			 {
			 	textfield.setText(defaultText2);
			 }
			 panelName.add(textfield);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Unable to create text field ");
		 }
		 return textfield;
	 }
	 
	 public JTextField createTextField(int x, int y, int w, int h, boolean setVisible, String TooltipText, String defaultText1, JPanel panelName, boolean RememberMe, String defaultText2, int textFieldLimit )
	 {
		 JTextField textfield = null;
		 try {
			 textfield=new JTextField();
			 textfield.setBounds(x, y, w, h);
			 textfield.setVisible(setVisible);
			 textfield.setToolTipText(TooltipText);
			 textfield.setDocument(new JTextFieldLimit(textFieldLimit));
			 if(RememberMe)
			 {
				 textfield.setText(defaultText1);
			 }
			 else
			 {
			 	textfield.setText(defaultText2);
			 }
			 panelName.add(textfield);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Unable to create text field ");
		 }
		 return textfield;
	 }
		
	 
	 public JPanel createPanel(int x, int y, int w, int h, String TitledBorderName)
	 {
		 JPanel panel =null;
		 try {
			 panel = new JPanel();
			 panel.setBounds(x,y,w,h);
			 panel.setLayout(null);
	 		TitledBorder featuresPanelborder = new TitledBorder(TitledBorderName);
	 		featuresPanelborder.setTitleFont(new Font("Comic Sans MS", Font.BOLD,12));
	 		featuresPanelborder.setTitleJustification(TitledBorder.CENTER);
	 		featuresPanelborder.setTitlePosition(TitledBorder.TOP);
	 		panel.setBorder(featuresPanelborder);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 return panel;
	 }
	 
	 public JLabel createJLabel(ImageIcon JlableName, int x, int y, int w, int h, boolean setVisible, JPanel panelName)
	 {
		 JLabel label = null;
		 try {
			 label = new JLabel(JlableName);
			 label.setFont(new Font("Comic Sans MS", Font.BOLD,12));
			 label.setBounds(x, y, w, h);
			 label.setVisible(setVisible);
		     panelName.add(label);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Unable to create JLabel "+ JlableName);
			 e.printStackTrace();
		 }
		     return label;
	 }
	 
	 
	 
	 public JLabel createJLabel(String JlableName, int x, int y, int w, int h, boolean setVisible, JPanel panelName)
	 {
		 JLabel label = null;
		 try {
			 label = new JLabel(JlableName);
			 label.setFont(new Font("Comic Sans MS", Font.BOLD,12));
			 label.setBounds(x, y, w, h);
			 label.setVisible(setVisible);
		     panelName.add(label);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Unable to create JLabel "+ JlableName);
			 e.printStackTrace();
		 }
		     return label;
	 }
	 
	 public String getSelectedRadioBttnTxtFromGroup(ButtonGroup buttonGroup)
	 {
		        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();

		            if (button.isSelected()) {
		                return button.getText();
		            }
		        }
		        return null;
	 }
	 public void rememberMe_WriteInJson()
	 {
		 	JSONObject obj = new JSONObject();
			obj.put("REMEMBERME_OPTION", chkRememberMe.isSelected());
			if(chkRememberMe.isSelected())
			{
				obj.put("NUMBER_OF_SYSTEM", selectedNumberOfSystems);
				obj.put("CONFIG_FILE_PATH", tConfigFilePath.getText());
				obj.put("TESTCASE_FILE_PATH", RuntimeVals.tTestCasesFile);
				obj.put("SYSTEM1IP", tfip1.getText());
				obj.put("SYSTEM2IP", tfip2.getText());
				obj.put("SYSTEM3IP", tfip3.getText());
				obj.put("SYSTEM4IP", tfip4.getText());
				obj.put("SYSTEM5IP", tfip5.getText());
				obj.put("SYSTEM6IP", tfip6.getText());
				obj.put("SYSTEM7IP", tfip7.getText());
				obj.put("SYSTEM1PORT", tfport1.getText());
				obj.put("SYSTEM2PORT", tfport2.getText());
				obj.put("SYSTEM3PORT", tfport3.getText());
				obj.put("SYSTEM4PORT", tfport4.getText());
				obj.put("SYSTEM5PORT", tfport5.getText());
				obj.put("SYSTEM6PORT", tfport6.getText());
				obj.put("SYSTEM7PORT", tfport7.getText());
				obj.put("REPORT_PATH", resultLocation.getText());
				obj.put("IMAGE_COMPARISON", imageComparison.isSelected());
				obj.put("PARALLEL_EXECUTION", rParallel.isSelected());

				for(int i=0; i<=Integer.parseInt(selectedNumberOfSystems)-1;i++)
				{
					obj.put("Browser"+i, browser.get(i).toString());
				}
			}
			writeInJSONFile(obj);
//				try (FileWriter file = new FileWriter(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"))) {
//					file.write(obj.toJSONString());
//					System.out.println("Successfully Copied JSON Object to File...");
//					System.out.println("\nJSON Object: " + obj);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
			
	 }
	 
	 public JSONObject writeKeyValueinJSONObj(String key, String value)
	 {
		 JSONObject obj = null;
		 try {
			 obj = new JSONObject();
			 obj.put(key, value);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return obj;
	 }
	 
	 
	 public void writeInJSONFile(JSONObject obj)
	 {
			try (FileWriter file = new FileWriter(UtilityFunctionBank.getAbsolutePath("src\\test\\java\\com\\eva\\UI\\RememberMe.json"))) {
				file.write(obj.toJSONString());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + obj);
			} catch (IOException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	 }
}


	
//		class checkRButtonListener implements ItemListener
//		{
//
//			@Override
//			public void itemStateChanged(ItemEvent il) {
//				System.out.println("Item state changed "+il.getStateChange());
////				System.out.println("get ITem ="+il.getItem());
////				System.out.println("get source"+il.getSource());
////				JRadioButton jr = new JRadioButton();
////				jr = (JRadioButton) il.getSource();
////				System.out.println("Radio button name" + jr.getText());
////				jr = null;
//			}
//			
//		}


		class chkListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent ie) {
				JCheckBox jc = new JCheckBox();
				jc = (JCheckBox) ie.getSource();
				System.out.println(jc.getActionCommand());
				if(jc.getActionCommand()=="START SERVER")
				{
					if(ie.getStateChange()==ie.SELECTED)
					{
						 // run hub bat file
						 killJavaProcess();
					}
					else
					{
						System.out.println("start server selectection Not selected");
					}
				}
				if(jc.getActionCommand()=="START BROWSER NODES")
				{
					if(ie.getStateChange()==ie.SELECTED)
					{
						try {
							startLocalNodes();
						} catch (evaException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			
			public void startSeleniumHUB()
			{
    			// New server session started
				 Process p;
				 try {
					p = Runtime.getRuntime().exec("cmd.exe /c start " + new File("").getAbsolutePath() + "\\GridBatchFiles\\" + "Hub.bat");
					p.waitFor();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			public void startLocalNodes() throws evaException, InterruptedException
			{
				EVA_UI EvaObject 				= new EVA_UI();
				LinkedList<String> IP			= null ;
				LinkedList<String> Port 		= null ;
				LinkedList<String> BrowserNames	= null ; 
				try {
					BrowserNames 	= EvaObject.storeBrowserInObject();
					IP				= EvaObject.storeNodeIPInObject();
					Port			= EvaObject.storeNodePortInObject();
					System.out.println(IP);
					System.out.println(Port);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				for(int SystemCounter =0; SystemCounter <=Integer.parseInt(EVA_UI.selectedNumberOfSystems)-1; SystemCounter++)
				{
					System.out.println(Port.get(SystemCounter));
					System.out.println(IP.get(SystemCounter));
					System.out.println(BrowserNames.get(SystemCounter));
					
					if(BrowserNames.get(SystemCounter).equalsIgnoreCase("chrome"))
					{
						EvaObject.executeNodeCommand(Port.get(SystemCounter), "chrome", UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\drivers\\chromedriver.exe"), "chrome"+SystemCounter);					
					}
					else if(BrowserNames.get(SystemCounter).equalsIgnoreCase("ie"))
					{
						EvaObject.executeNodeCommand(Port.get(SystemCounter), "ie", UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\drivers\\IEDriverServer.exe"), "ie"+SystemCounter);					
					}
					else if(BrowserNames.get(SystemCounter).equalsIgnoreCase("gecko"))
					{
						EvaObject.executeNodeCommand(Port.get(SystemCounter), "gecko", UtilityFunctionBank.getAbsolutePath("GridBatchFiles\\drivers\\geckodriver.exe"), "gecko"+SystemCounter);					
					}
				}
				
				// get number of systems from drop down
				//get value from ip from textbox
				//get port number from text files
				// if required update port number in bat files
				// Run loop and get selected radio button value 
				//according to radio button start nodes batch files
				
				
				// If node batch file is runing then do not run batch file
				//
			}
			
			public void killJavaProcess()
			{
				boolean isServerRuning = false;
				try {
					Runtime runtime = Runtime.getRuntime();
			        String cmds[] = {"cmd", "/c", "tasklist"};
			        Process proc = runtime.exec(cmds);
			        InputStream inputstream = proc.getInputStream();
			        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			        String line;
			        while ((line = bufferedreader.readLine()) != null) {
			        	if(line.contains("java.exe"))
			        	{
//			        		Implement code which can read text from console so that it can close only hub not all cmd windows. 
			        		
			        		isServerRuning = true;
			        		int serverKillChoice = JOptionPane.showConfirmDialog((Component) null, "SELENIUM SERVER IS ALREADY RUNING, DO YOU WANT TO KILL CURRENT PROCESS","alert", JOptionPane.YES_NO_CANCEL_OPTION);
			        		if(serverKillChoice==0)
			        		{
			        			Runtime.getRuntime().exec("taskkill /F /IM java.exe");
			        			System.out.println("java.exe process killed");
			        			startSeleniumHUB();
			        		}
			        		else if(serverKillChoice==1)
			        		{
			        			System.out.println("NO clicked hence Do not kill runing server");
			        		}
			        		else
			        		{
			        			System.out.println("CANCEL button clicked hence Do nothing");
			        		}
			        		break;
			        	}
			        }
			        if(!isServerRuning)
			        {
			        	startSeleniumHUB();
			        }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		
		}


class PPPanel extends JPanel {

	  private Image img;

	  public PPPanel(String img) 
	  {
	    this(new ImageIcon(img).getImage());
	  }

	  public PPPanel(Image img) 
	  {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	  public PPPanel(ImageIcon img1) {
	      this(img1.getImage());
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}


class JTextFieldLimit extends PlainDocument {
	  private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}
