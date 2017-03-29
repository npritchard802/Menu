import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.io.IOException;
public class gameIO {
private int x,y;
private String name;
private static Scanner fileName;
	public static  void saveIO(ArrayList<JLabel> chekkerBits) throws IOException 
	{
		
		try{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh_mm_ss");
			String timeStamp = dateFormat.format(date).toString();
			PrintWriter fileWriter = new PrintWriter("D:/KPT/SavedGames/FileName "+timeStamp+ ".csv","UTF-8");
			 
			for (int i=0;i<chekkerBits.size(); i++)
			{
				fileWriter.print(chekkerBits.get(i).getX());
				fileWriter.print(',');
				fileWriter.print(chekkerBits.get(i).getY());
				fileWriter.print(',');
				//fileWriter.print(chekkerBits.get(i).getName());
				//fileWriter.print(',');
			}
			fileWriter.close();
			} catch (IOException e)
		{
				//Open GUI that displays Error Message
				System.out.println("Error Opening FilePath");
		}		
	}
	
	public static void loadIO(ArrayList<DoodadTryhard> array,int x,int y,String name)
	{
		
			try{
			Scanner scanner = new Scanner (new File("D:/KPT/SaveGame1.csv"));
			scanner.useDelimiter(",");
			while(scanner.hasNext())
			{
				x=scanner.nextInt();
				y=scanner.nextInt();
				DoodadTryhard doodad = new DoodadTryhard(x,y,name);
				array.add(doodad);
			}
			scanner.close();
			
		} catch(IOException d)
		{
			System.out.println("Error Opening File Path");
		}
	}
	
	
}
