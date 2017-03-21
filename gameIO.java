import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class gameIO {
	private static ArrayList<DoodadTryhard> array;
	private static int x;
	private static int y;
	private static String name;
	public static  void saveIO(ArrayList<DoodadTryhard> array) 
	{
		
		//Opens GUI with keyboard that allows users to enter a file name
		
		try{
			PrintWriter fileWriter = new PrintWriter("D:/KPT/SaveGame1.csv","UTF-8");
			 
			for (int i=0;i<array.size(); i++)
			{
				fileWriter.print(array.get(i).getxAxis());
				fileWriter.print(',');
				fileWriter.print(array.get(i).getyAxis());
				fileWriter.print(',');
				fileWriter.print(array.get(i).getName());
				fileWriter.print(',');
				
				
			}
			fileWriter.close();
			} catch (IOException e)
		{
				//Open GUI that displays Error Message
		}
		
		
	}
	
	public static void loadIO(ArrayList<DoodadTryhard> array)
	{
		
			try{
			Scanner scanner = new Scanner (new File("D:/KPT/SaveGame1.csv"));
			scanner.useDelimiter(",");
			int m=0;
			while(scanner.hasNext())
			{
				x=scanner.nextInt();
				//System.out.println("x is " + x);
				y=scanner.nextInt();
				//System.out.println("y is " + y);
				name=scanner.next();
				//System.out.println("name is " + name);
				DoodadTryhard doodad = new DoodadTryhard(x,y,name);
				
				array.add(doodad);
				
				
			}
			scanner.close();
			
		} catch(IOException d)
		{
			System.out.println("RIP");
		}
	}
	
	
}
