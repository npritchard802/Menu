import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class chekkersTryhard extends gameIO {

	public static void main(String[] args) throws IOException {
		//create frame
		JFrame chekkers = new JFrame();
		
		//create ArrayList for saving?
		ArrayList<JLabel> chekkerBits = new ArrayList<JLabel>();
		
		//populate frame background with gameboard pic
		chekkers.setLayout(new BorderLayout());
		chekkers.setContentPane(insertBackground(chekkers));
			
		savebutton(chekkers,chekkerBits);
		//populate the JFrame with chekkerBits
		chekkers.setLayout(new GridBagLayout());
		printRedPieces(chekkers);
		printBlackPieces(chekkers);
		printBlankPieces(chekkers);
		
		//display stuff		
		chekkers.setExtendedState(JFrame.MAXIMIZED_BOTH);
		chekkers.setUndecorated(true);
		chekkers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		chekkers.setVisible(true);
	}
	
	//find the image for the gameBoard pic
	//Dans "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/checkerboard.jpg";
	public static JLabel insertBackground(JFrame jf) throws IOException {
		String backPic = "D:/Java Class/KPT/src/checkerboard.jpg";
		BufferedImage image = ImageIO.read(new File(backPic));
		JLabel jl = new JLabel(new ImageIcon(image));
		return jl;
	}
	
	public static void addDragListener(JLabel jl){
		DragListenerTryhard dList = new DragListenerTryhard();
		jl.addMouseListener(dList);
		jl.addMouseMotionListener(dList);
	}

	public static Dimension getScreenDimension(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static void printRedPieces(JFrame jf) throws IOException{
		//Dans "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/redChecker.png"
		String rBit = "D:/Java Class/KPT/src/redChecker.png";
		GridBagConstraints gbc = new GridBagConstraints();
		int x = 0, y = 0;
		double weight = 0.5;
		JLabel jl = new JLabel();
		
		gbc.weightx = weight;
		gbc.weighty = weight;

		
		//Loop to place red doodads
		for(int i = 0; i < 3; i++){
			
			
			
			if(x%2==0){
				y=0;
			}
			else{
				y=1;
			}
			
			int count = 0;
			while(count < 4){
				//Create a DoodadTryHard
				DoodadTryhard dth = new DoodadTryhard(x,y,rBit);
				
				//Convert that to a JLabel
				jl = dthToJLabel(dth);
				addDragListener(jl);
				gbc.gridx = x;
				gbc.gridy = y;
				//Add the JLabel and the GridBag
				jf.add(jl,gbc);
					
				y+=2;
				count+=1;
			}
				x+=1;
		}
	}

	public static void printBlackPieces(JFrame jf) throws IOException{
		//dans "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/blackChecker.png"
		String rBit = "D:/Java Class/KPT/src/blackChecker.png";	
		GridBagConstraints gbc = new GridBagConstraints();
		int x = 5, y = 1;
		double weight = 0.5;
		JLabel jl = new JLabel();
		
		gbc.weightx = weight;
		gbc.weighty = weight;

		
		//Loop to place red doodads
		for(int i = 0; i < 3; i++){
			
			
			
			if(x%2==0){
				y=0;
			}
			else{
				y=1;
			}
			
			int count = 0;
			while(count < 4){
				//Create a DoodadTryHard
				DoodadTryhard dth = new DoodadTryhard(x,y,rBit);
				
				//Convert that to a JLabel
				jl = dthToJLabel(dth);
				addDragListener(jl);
				gbc.gridx = x;
				gbc.gridy = y;
				//Add the JLabel and the GridBag
				jf.add(jl,gbc);
					
				y+=2;
				count+=1;
			}
				x+=1;
		}
	}
	
	public static void printBlankPieces(JFrame jf) throws IOException{
		//Dans "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/blackChecker.png"
		String rBit = "D:/Java Class/KPT/src/blackChecker.png";	
		GridBagConstraints gbc = new GridBagConstraints();
		int x=3,y=0;
		double weight = 0.5;
		JLabel jl = new JLabel();
		
		gbc.weightx = weight;
		gbc.weighty = weight;
		
		int count = 0;
		while(count < 2){
			//Create a DoodadTryHard
			DoodadTryhard dth = new DoodadTryhard(x,y,rBit);
			
			//Convert that to a JLabel
			jl = dthToJLabel(dth);
			addDragListener(jl);
			gbc.gridx = x;
			gbc.gridy = y;
			//Add the JLabel and the GridBag
			jf.add(jl,gbc);
			
			x+=1;
			count+=1;
		}
	}
	public static void savebutton(JFrame jf, ArrayList<JLabel>chekkerBits)
	{
		 class ClickListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) {
				try {
					saveIO(chekkerBits);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		JButton save = new JButton("Save");
		ActionListener listener = new ClickListener();
		save.addActionListener(listener);
		GridBagConstraints gbc = new GridBagConstraints();
		int x = 5, y = 1;
		gbc.gridx = x;
		gbc.gridy = y;
		jf.add(save,gbc);
	}
	
	public static JLabel dthToJLabel(DoodadTryhard dth) throws IOException{
		BufferedImage image = ImageIO.read(new File(dth.getName()));
		JLabel jl = new JLabel(new ImageIcon(image));
		jl.setLocation(dth.getxAxis(),dth.getyAxis() );
		
		return jl;
	}
	
}