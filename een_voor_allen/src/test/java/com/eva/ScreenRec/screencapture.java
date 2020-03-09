package com.eva.ScreenRec;

import java.awt.Dimension; 
import java.awt.Rectangle; 
import java.awt.Robot; 
import java.awt.Toolkit; 
import java.awt.image.BufferedImage; 
import java.io.File; 
import javax.imageio.ImageIO;


public class screencapture {

	public static void main(String args[])
	{
			// TODO Auto-generated method stub
			try 
			{	
				Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
				Robot robot = new Robot(); 
				BufferedImage img = robot.createScreenCapture(new Rectangle(size)); 
				File save_path=new File("D:\\Users\\vnihaniwal\\Desktop\\screen.jpg");
				ImageIO.write(img, "JPG", save_path); 
			} 
			catch(Exception e) { }

		}
}
