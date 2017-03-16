package kpt;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
	BufferedImage board;
		
	public JLabel fileToBoard(String name) throws IOException{		
		//take string, convert to file
		File file = new File(name);
		
		//take file, convert to image
		board = ImageIO.read(file);		
		
		//display image
		JLabel label = new JLabel(new ImageIcon(board));
		JFrame jf = new JFrame();
		jf.setUndecorated(true);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.getContentPane().add(label);
		jf.pack();
		jf.add(label);
		jf.setVisible(true);
		return label;
	}
	
	public void showOnScreenOne(String boardName) throws IOException{
	    
	    GraphicsDevice gd = gs[0];
	    JFrame frame = new JFrame(gd.getDefaultConfiguration());
	    frame.setTitle("Pieces!");
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    JLabel jl = fileToBoard(boardName);
	    frame.add(jl);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
	}
	
public void showOnScreenTwo(String boardName) throws IOException{
	    
	    GraphicsDevice gd = gs[1];
	    JFrame frame = new JFrame(gd.getDefaultConfiguration());
	    frame.setTitle("Pieces!");
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    JLabel jl = fileToBoard(boardName);
	    frame.add(jl);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
	}
}
