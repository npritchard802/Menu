package kpt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class clickListener implements ActionListener{
	
	public void actionPerformed(ActionEvent arg0)
	{
	Object source = arg0.getSource();
	if (source == Menu.chekkers)
	{
		try {
			chekkersTryhard.main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(source == Menu.chess)
	{
		
	}
	else if(source == Menu.shaddlebips)
	{
		
	}
	/*else if(source==Menu.Stratego)
	{
		
	}
	*/
	else if(source==Menu.load)
	{
		
		JList list = new JList();
		JPanel pnl = new JPanel();
		JFrame frame = new JFrame();
		JButton btn = new JButton("Load");
        String path="C:/KPT/SavedGames";
        File folder=new File(path);
        String[]listOfFiles=folder.list();
        list=new JList(listOfFiles);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
		         
		        pnl.add(list);
		        pnl.add(btn);
		        frame.setSize(250,300);
		        frame.setVisible(true);
		        frame.add(pnl);
		    
		     
		
	}
	else
	{
		JFrame errorFrame = new JFrame();
		
		errorFrame.pack();
		errorFrame.setSize(225,150);
		errorFrame.setLocationRelativeTo(null);
		JLabel error = new JLabel("There was an error. Please try again");
		errorFrame.add(error);
		errorFrame.setVisible(true);
	}
	}
}