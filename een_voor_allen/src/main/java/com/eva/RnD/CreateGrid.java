package com.eva.RnD;

import java.awt.Component;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Genuine
 */
public class CreateGrid extends javax.swing.JFrame {

//    /**
//     * Creates new form AddDataToJTable
//     */
//    public CreateGrid() {
//        initComponents();
//        //Calling method/function to add column header to jtable
//        addTableHeader();
//    }
// 
//    ViewSelectedRowJFrame viewSelectedRow = new ViewSelectedRowJFrame();
// 
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // &amp;lt;editor-fold defaultstate="collapsed" desc="Generated Code"&amp;gt;                          
//    private void initComponents() {
// 
//        buttonGroup1 = new javax.swing.ButtonGroup();
//        buttonGroup2 = new javax.swing.ButtonGroup();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTable1 = new javax.swing.JTable();
//        jTextFieldName = new javax.swing.JTextField();
//        jLabel1 = new javax.swing.JLabel();
//        jRadioButtonMale = new javax.swing.JRadioButton();
//        jRadioButtonFemale = new javax.swing.JRadioButton();
//        jCheckBoxJava = new javax.swing.JCheckBox();
//        jCheckBoxPHP = new javax.swing.JCheckBox();
//        jComboBoxSubjects = new javax.swing.JComboBox();
//        jButton1 = new javax.swing.JButton();
//        jLabelImage = new javax.swing.JLabel();
//        jButtonBrowseImage = new javax.swing.JButton();
//        jButton2 = new javax.swing.JButton();
//        jButton3 = new javax.swing.JButton();
//        jButton4 = new javax.swing.JButton();
//        jButton5 = new javax.swing.JButton();
//        jButton6 = new javax.swing.JButton();
//        jButtonImportExcelToJtable = new javax.swing.JButton();
// 
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
// 
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
// 
//            },
//            new String [] {
//                "null"
//            }
//        ));
//        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTable1MouseClicked(evt);
//            }
//        });
//        jScrollPane1.setViewportView(jTable1);
// 
//        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextFieldNameActionPerformed(evt);
//            }
//        });
// 
//        jLabel1.setText("Name");
// 
//        buttonGroup1.add(jRadioButtonMale);
//        jRadioButtonMale.setText("Male");
// 
//        buttonGroup1.add(jRadioButtonFemale);
//        jRadioButtonFemale.setText("Female");
// 
//        buttonGroup2.add(jCheckBoxJava);
//        jCheckBoxJava.setText("Java");
// 
//        buttonGroup2.add(jCheckBoxPHP);
//        jCheckBoxPHP.setText("PHP");
// 
//        jComboBoxSubjects.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Computer Science", "Information Technology", "Business Information Technology" }));
// 
//        jButton1.setText("Add Data");
//        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jButton1MouseClicked(evt);
//            }
//        });
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
// 
//        jButtonBrowseImage.setText("Browse //");
//        jButtonBrowseImage.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButtonBrowseImageActionPerformed(evt);
//            }
//        });
// 
//        jButton2.setText("Move Up");
//        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jButton2MouseClicked(evt);
//            }
//        });
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
// 
//        jButton3.setText("Move Down");
//        jButton3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton3ActionPerformed(evt);
//            }
//        });
// 
//        jButton4.setText("Clear");
//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });
// 
//        jButton5.setText("View Selected Row");
//        jButton5.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton5ActionPerformed(evt);
//            }
//        });
// 
//        jButton6.setText("Export (Excel)");
//        jButton6.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton6ActionPerformed(evt);
//            }
//        });
// 
//        jButtonImportExcelToJtable.setText("Import (Excel)");
//        jButtonImportExcelToJtable.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButtonImportExcelToJtableActionPerformed(evt);
//            }
//        });
// 
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(jRadioButtonMale)
//                                    .addComponent(jCheckBoxJava))
//                                .addGap(18, 18, 18)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(jCheckBoxPHP)
//                                    .addComponent(jRadioButtonFemale)))
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(18, 18, 18)
//                                .addComponent(jLabel1)))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
//                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                    .addComponent(jComboBoxSubjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addComponent(jButtonImportExcelToJtable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
//                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                    .addComponent(jButtonBrowseImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                        .addContainerGap())))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jLabel1)))
//                            .addComponent(jButtonBrowseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                .addComponent(jRadioButtonMale)
//                                .addComponent(jRadioButtonFemale))
//                            .addComponent(jButtonImportExcelToJtable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(5, 5, 5)
//                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                .addComponent(jCheckBoxJava)
//                                .addComponent(jCheckBoxPHP)))))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jComboBoxSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
//                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(31, Short.MAX_VALUE))
//        );
// 
//        pack();
//        setLocationRelativeTo(null);
//    }// &amp;lt;/editor-fold&amp;gt;                        
// 
//    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {                                               
//        // TODO add your handling code here:
//    }                                              
//    DefaultTableModel model;
//    String name = "";
//    String gender = "";
//    String programmingLanguage = "";
//    String Subject = "";
//    String selectedImagePath = "";
//    String excelImagePath = "";
////    byte imageJtable = new Byte(1024);
// 
////Adding table headers
//    public void addTableHeader() {
//        model = (DefaultTableModel) jTable1.getModel();
//        Object[] newIdentifiers = new Object[]{"Name", "Gender", "Language", "Subject", "Image"};
//        model.setColumnIdentifiers(newIdentifiers);
//        //Get Image column and override  TableCellRenderer class component method (getTableCellRendererComponent)
//        jTable1.getColumn("Image").setCellRenderer(new myTableCellRenderer());
// 
//    }
// 
//    private void populateInputfields() {
//        //        Display data from jtable in input fields
//        int selectedRow = jTable1.getSelectedRow();
// 
//        jTextFieldName.setText(model.getValueAt(selectedRow, 0).toString());
//        String tableGender = model.getValueAt(selectedRow, 1).toString();
//        if (tableGender.equals("Male")) {
//            jRadioButtonMale.setSelected(true);
//        } else if (tableGender.equals("Female")) {
//            jRadioButtonFemale.setSelected(true);
//        }
//        String checkPLanguage = model.getValueAt(selectedRow, 2).toString();
// 
//        if (checkPLanguage.equals("Java")) {
//            jCheckBoxJava.setSelected(true);
//        } else if (checkPLanguage.equals("PHP")) {
//            jCheckBoxPHP.setSelected(true);
//        }
// 
//        String comboSub = model.getValueAt(selectedRow, 3).toString();
//        for (int i = 0; i <jComboBoxSubjects.getItemCount(); i++) {
//            if (jComboBoxSubjects.getItemAt(i).toString().equalsIgnoreCase(comboSub)) {
//                jComboBoxSubjects.setSelectedIndex(i);
//            }
//        }
// 
//        //The image is stored as ImageIcon in jlabel
//        //The image is stored in the fourth column
//        JLabel imageJl = (JLabel) model.getValueAt(selectedRow, 4);
//        //Retrieving image icon from jlabel
//        //Store image icon In ImageIcon type Variable
//        ImageIcon imageJLIcon = (ImageIcon) imageJl.getIcon();
//        //Resize image to fit to jlable
//        Image imageJLFit = imageJLIcon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
//        //Display selected image on jlabel
//        jLabelImage.setIcon(new ImageIcon(imageJLFit));
// 
//    }
// 
//    class myTableCellRenderer implements TableCellRenderer {
// 
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
// 
////            Change Image column minimum width and maximum width
//            TableColumn tb = jTable1.getColumn("Image");
//            tb.setMaxWidth(60);
//            tb.setMinWidth(60);
//            jTable1.setRowHeight(60);
//            return (Component) value;
// 
//        }
// 
//    }
// 
// 
//    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
//        // TODO add your handling code here:
// 
//    }                                     
// 
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        name = jTextFieldName.getText();
//        if (jRadioButtonMale.isSelected()) {
//            gender = "Male";
//        } else if (jRadioButtonFemale.isSelected()) {
//            gender = "Female";
//        }
// 
//        if (jCheckBoxJava.isSelected()) {
//            programmingLanguage = "Java";
//        } else if (jCheckBoxPHP.isSelected()) {
//            programmingLanguage = "PHP";
//        }
// 
//        Subject = jComboBoxSubjects.getSelectedItem().toString();
// 
//        JLabel imageLabel = new JLabel();
//        ImageIcon imageicon = new ImageIcon(selectedImagePath);
//        //Resize image to fixed dimensions 60 * 60 (width and height).
//        Image imageIc = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
// 
////        Set Description
//        ImageIcon excelSetDescription = new ImageIcon(imageIc);
//        excelSetDescription.setDescription(selectedImagePath);
//        //Storing imageicon in a jlabel
//        imageLabel.setIcon(excelSetDescription);
// 
//        //Checking if one or more field is empty
//        if (name.isEmpty() || gender.isEmpty() || programmingLanguage.isEmpty() || Subject.isEmpty() || imageIc == null) {
//            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
//        } else {
////            JOptionPane.showMessageDialog(null, "All Fields are filled");
//            //Adding entered data to jtable
// 
//            model.addRow(new Object[]{name, gender, programmingLanguage, Subject, imageLabel});
//            JOptionPane.showMessageDialog(null, "Data Inserted");
//            //clear fields after inserting the data
//            clearFields();
//        }
// 
//    }                                        
// 
//    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
//        // TODO add your handling code here:     
// 
//        //Display Selected row data in input field
//        populateInputfields();
// 
//    }                                    
// 
//    private void jButtonBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {                                                   
//        // TODO add your handling code here:
////        Setting default browser location
//        JFileChooser browseImageFile = new JFileChooser("C:\\Users\\Public\\Pictures\\Sample Pictures");
//        //Filter image extensions
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
//        browseImageFile.addChoosableFileFilter(fnef);
//        int showOpenDialogue = browseImageFile.showOpenDialog(null);
// 
//        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
//            File selectedImageFile = browseImageFile.getSelectedFile();
//            selectedImagePath = selectedImageFile.getAbsolutePath();
//            JOptionPane.showMessageDialog(null, selectedImagePath);
//            //Display image on jlable
//            ImageIcon ii = new ImageIcon(selectedImagePath);
////            Resize image to fit jlabel
//            Image image = ii.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
// 
//            jLabelImage.setIcon(new ImageIcon(image));
//        }
//    }                                                  
// 
//    //Move up button
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        //Get jtable selected row
//        int currentlySelectedRow = jTable1.getSelectedRow();
//        if (currentlySelectedRow > 0) {
////            Substact one (1) from current row to move upwards
//            model.moveRow(currentlySelectedRow, currentlySelectedRow, currentlySelectedRow - 1);
//            jTable1.getSelectionModel().setSelectionInterval(currentlySelectedRow - 1, currentlySelectedRow - 1);
// 
//        } else {
//            JOptionPane.showMessageDialog(null, "You have reached the end!! Click move down button - to move downwards");
//        }
// 
//    }                                        
// 
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
// 
//        //Get jtable selected row
//        int currentlySelectedRow = jTable1.getSelectedRow();
//        if (currentlySelectedRow > jTable1.getRowCount() - 1) {
////            Add one (1) To current row to move downwards
//            model.moveRow(currentlySelectedRow, currentlySelectedRow, currentlySelectedRow + 1);
//            jTable1.getSelectionModel().setSelectionInterval(currentlySelectedRow + 1, currentlySelectedRow + 1);
// 
//        } else {
//            JOptionPane.showMessageDialog(null, "You have reached the end!! Click move up button - to move upwards");
//        }
// 
// 
//    }                                        
// 
//    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
//        // TODO add your handling code here:
//        //Display Selected row data in input field
//    }                                     
// 
//    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        viewSelectedRow.setVisible(true);
//        //prevent the frame from closing the parent frame
//        viewSelectedRow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// 
////        Get selected row
//        int selectedRowForNewJframe = jTable1.getSelectedRow();
// 
////        check if the row is selected
//        if (selectedRowForNewJframe == -1) {
//            //display error message
//            viewSelectedRow.jLabel1NoselectedRowMessage.setText("No Row Selected !!..");
//        } else {
//            //Clear error message first
//            viewSelectedRow.jLabel1NoselectedRowMessage.setText(null);
//            System.out.println("selected row value  " + selectedRowForNewJframe);
// 
//            //Retrieving jtable selected row
//            String newName = model.getValueAt(selectedRowForNewJframe, 0).toString();
//            String newGender = model.getValueAt(selectedRowForNewJframe, 1).toString();
//            String newProgrammingLanguage = model.getValueAt(selectedRowForNewJframe, 2).toString();
//            String newsubject = model.getValueAt(selectedRowForNewJframe, 3).toString();
// 
//            JLabel newImageJL = (JLabel) model.getValueAt(selectedRowForNewJframe, 4);
//            ImageIcon newImageIcon = (ImageIcon) newImageJL.getIcon();
// 
//            //Resize image to fit new Jlabel
//            Image newImage = newImageIcon.getImage().getScaledInstance(viewSelectedRow.jLabelImageNewJframe.getWidth(), viewSelectedRow.jLabelImageNewJframe.getHeight(), Image.SCALE_SMOOTH);
// 
//            //Displaying selected row on new jframe input fields
//            viewSelectedRow.jTextFieldNameNewJframe.setText(newName);
//            viewSelectedRow.jTextFieldGenderNewJframe.setText(newGender);
//            viewSelectedRow.jTextFieldPLanguageNewJframe.setText(newProgrammingLanguage);
//            viewSelectedRow.jTextFieldSubjectNewJframe.setText(newsubject);
//            viewSelectedRow.jLabelImageNewJframe.setIcon(new ImageIcon(newImage));
// 
//        }
//    }                                        
// 
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        clearFields();
//    }                                        
// 
//    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
// 
//        FileOutputStream excelFOU = null;
//        BufferedOutputStream excelBOU = null;
//        XSSFWorkbook excelJTableExporter = null;
// 
//        //Choose Location For Saving Excel File
//        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Authentic\\Desktop");
////        Change Dilog Box Title
//        excelFileChooser.setDialogTitle("Save As");
////        Onliny filter files with these extensions "xls", "xlsx", "xlsm"
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
//        excelFileChooser.setFileFilter(fnef);
//        int excelChooser = excelFileChooser.showSaveDialog(null);
// 
////        Check if save button is clicked
//        if (excelChooser == JFileChooser.APPROVE_OPTION) {
// 
//            try {
//                //Import excel poi libraries to netbeans
//                excelJTableExporter = new XSSFWorkbook();
//                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
//                //            Loop to get jtable columns and rows
//                for (int i = 0; i< model.getRowCount(); i++) {
//                    XSSFRow excelRow = excelSheet.createRow(i);
//                    for (int j = 0; j <model.getColumnCount(); j++) {
//                        XSSFCell excelCell = excelRow.createCell(j);
// 
//                        //Now Get ImageNames From JLabel
//                        //get the last column
//                        if (j == model.getColumnCount() - 1) {
//                            JLabel excelJL = (JLabel) model.getValueAt(i, j);
//                            ImageIcon excelIMageIcon = (ImageIcon) excelJL.getIcon();
//                            //Before retrieving the description of the image first set it...
//                            excelImagePath = excelIMageIcon.getDescription();
//                        }
//                        excelCell.setCellValue(model.getValueAt(i, j).toString());
// 
////                        Change the values of the fourth column to image paths
//                        if (excelCell.getColumnIndex() == model.getColumnCount() - 1) {
//                            excelCell.setCellValue(excelImagePath);
//                        }
//                    }
//                }   //Append xlsx file extensions to selected files. To create unique file names
//                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
//                excelBOU = new BufferedOutputStream(excelFOU);
//                excelJTableExporter.write(excelBOU);
//                JOptionPane.showMessageDialog(null, "Exported Successfully !!!........");
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } finally {
//                try {
//                    if (excelBOU != null) {
//                        excelBOU.close();
//                    }
//                    if (excelFOU != null) {
//                        excelFOU.close();
//                    }
//                    if (excelJTableExporter != null) {
//                        excelJTableExporter.close();
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
// 
//        }
// 
//    }                                        
// 
//    private void jButtonImportExcelToJtableActionPerformed(java.awt.event.ActionEvent evt) {                                                           
//        // TODO add your handling code here:
// 
//        File excelFile;
//        FileInputStream excelFIS = null;
//        BufferedInputStream excelBIS = null;
//        XSSFWorkbook excelImportToJTable = null;
//        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
//        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
//        excelFileChooser.setDialogTitle("Select Excel File");
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
//        excelFileChooser.setFileFilter(fnef);
//        int excelChooser = excelFileChooser.showOpenDialog(null);
//        if (excelChooser == JFileChooser.APPROVE_OPTION) {
//            try {
//                excelFile = excelFileChooser.getSelectedFile();
//                excelFIS = new FileInputStream(excelFile);
//                excelBIS = new BufferedInputStream(excelFIS);
//                excelImportToJTable = new XSSFWorkbook(excelBIS);
//                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
// 
//                for (int row = 0; row <excelSheet.getLastRowNum(); row++) {
//                    XSSFRow excelRow = excelSheet.getRow(row);
// 
//                    XSSFCell excelName = excelRow.getCell(0);
//                    XSSFCell excelGender = excelRow.getCell(1);
//                    XSSFCell excelProgrammingLanguage = excelRow.getCell(2);
//                    XSSFCell excelSubject = excelRow.getCell(3);
//                    XSSFCell excelImage = excelRow.getCell(4);
// 
//                    JLabel excelJL = new JLabel(new ImageIcon(new ImageIcon(excelImage.getStringCellValue()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
//                    model.addRow(new Object[]{excelName, excelGender, excelProgrammingLanguage, excelSubject, excelJL});
//                }
//                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
//            } catch (IOException iOException) {
//                JOptionPane.showMessageDialog(null, iOException.getMessage());
//            } finally {
//                try {
//                    if (excelFIS != null) {
//                        excelFIS.close();
//                    }
//                    if (excelBIS != null) {
//                        excelBIS.close();
//                    }
//                    if (excelImportToJTable != null) {
//                        excelImportToJTable.close();
//                    }
//                } catch (IOException iOException) {
//                    JOptionPane.showMessageDialog(null, iOException.getMessage());
//                }
//            }
//        }
//    }                                                          
// 
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //&amp;lt;editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "&amp;gt;
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CreateGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreateGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreateGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreateGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //&amp;lt;/editor-fold&amp;gt;
// 
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateGrid().setVisible(true);
//            }
//        });
//    }
// 
//    // Variables declaration - do not modify                     
//    private javax.swing.ButtonGroup buttonGroup1;
//    private javax.swing.ButtonGroup buttonGroup2;
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JButton jButton4;
//    private javax.swing.JButton jButton5;
//    private javax.swing.JButton jButton6;
//    private javax.swing.JButton jButtonBrowseImage;
//    private javax.swing.JButton jButtonImportExcelToJtable;
//    private javax.swing.JCheckBox jCheckBoxJava;
//    private javax.swing.JCheckBox jCheckBoxPHP;
//    private javax.swing.JComboBox jComboBoxSubjects;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabelImage;
//    private javax.swing.JRadioButton jRadioButtonFemale;
//    private javax.swing.JRadioButton jRadioButtonMale;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JTable jTable1;
//    private javax.swing.JTextField jTextFieldName;
//    // End of variables declaration                   
// 
//    private void clearFields() {
//        jTextFieldName.setText("");
//        buttonGroup1.clearSelection();
//        buttonGroup2.clearSelection();
//        jComboBoxSubjects.setSelectedIndex(0);
//        jLabelImage.setIcon(null);
//    }
// 

	 // frame 
    JFrame f; 
    // Table 
    JTable j; 
  
    // Constructor 
    CreateGrid() 
    { 
        // Frame initiallization 
        f = new JFrame(); 
  
        // Frame Title 
        f.setTitle("JTable Example"); 
  
        // Data to be displayed in the JTable 
        String[][] data = { 
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
  
        // Column Names 
        String[] columnNames = { "Name", "Roll Number", "Department" }; 
  
        // Initializing the JTable 
        j = new JTable(data, columnNames); 
        j.setBounds(30, 40, 200, 300); 
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        // Frame Size 
        f.setSize(500, 200); 
        // Frame Visible = true 
        f.setVisible(true); 
    } 
  
    // Driver  method 
    public static void main(String[] args) 
    { 
        new CreateGrid(); 
    } 
	
	
}








