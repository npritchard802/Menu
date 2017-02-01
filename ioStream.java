import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ioStream extends MainMenu {
		
	public static void main(String[] args)
	{
		MainMenu menu = new MainMenu();
		Object result =selectedGame();
		getGame(result);
		System.out.println(result + "This is what result is");
	}
	
	public static void getGame(Object choice)
	{	
		String filename = null;
	
		if (choice == "Chess")
		{
			filename = "Chess.txt";
			System.out.println("Loading Chess");
		}
		else if (choice == "Checkers")
		{	filename = "Checkers.txt";
			System.out.println("Loading Checkers");
		}
		else if (choice == "Battleship")
		{
			filename = "Battleship.txt";
			System.out.println("Loading Battleship");
		}
		else
		{			
			System.out.println("Whoops");
		}
	}
}
