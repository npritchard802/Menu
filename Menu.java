import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame
{	
	JFrame Mframe = new JFrame(); //Main Frame
	JPanel Tpanel = new JPanel(); //Title Panel
	JPanel Bpanel = new JPanel(); //Button Panel
	JPanel SPanel = new JPanel(); //Panel that opens after hitting start button
	
	JPanel main = new JPanel();
	JButton startbtn = new JButton();
	JButton loadbtn = new JButton();
	JLabel Title = new JLabel();
	
	public static void main(String[] args)
	{
		Menu Frame = new Menu();
		
	}
	
	public Menu()
	{
		constructor();
		setTitle("Knightly Party Table");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void constructor()
	{
		Title = new JLabel ("Knightly Party Table");
		
		startbtn = new JButton("Start");
		ActionListener listener = new StartListener();
		startbtn.addActionListener(listener);
		
		loadbtn = new JButton("Load");
		ActionListener listener2 = new LoadListener();
		loadbtn.addActionListener(listener2);
		Bpanel = new JPanel (new BorderLayout());
						
		Tpanel = new JPanel (new GridBagLayout());
		Tpanel.add(Title);
		Tpanel.add(startbtn);
		Tpanel.add(loadbtn);
		
		Tpanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		c.insets= new Insets(200,0,150,0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx =0;
		c.gridy =1;
		
		Tpanel.add(Title,c);
		
		d.insets = new Insets(50,10,50,10);	
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx =0;
		d.gridy =2;
		Tpanel.add(startbtn,d);
				
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx =0;
		d.gridy =3;
		
		Tpanel.add(loadbtn,d);
		
		Bpanel.add(Tpanel);
		
		main.add(Bpanel);
		add(main);
	
		
	}
	public class StartListener implements ActionListener //Start Button Action
	{
		public void actionPerformed(ActionEvent event)
		{
			
			JFrame SFrame = new JFrame();
			SFrame.setSize(500,500);
			JPanel SmPanel = new JPanel(); //Panel for the whole start menu
			JTextArea Start_GameList = new JTextArea(20,30); //List of available games to play
			//JPanel Format = new JPanel(new BorderLayout());
			Start_GameList.setEditable(false);
						
			JButton Playbtn = new JButton("Play");
			JButton Backbtn = new JButton("Back");
						
			
			SmPanel.setSize(300,400);
			//Format.add(Start_GameList, BorderLayout.NORTH);
			SmPanel.setLayout(new GridBagLayout());
			GridBagConstraints e = new GridBagConstraints();
			e.insets = new Insets(0,0,0,0);
			e.fill = GridBagConstraints.HORIZONTAL;
			e.gridx = 1;
			e.gridy = 1;
			SmPanel.add(Start_GameList,e);
			
			GridBagConstraints f = new GridBagConstraints();
			f.insets = new Insets(10,0,0,0);
			f.fill = GridBagConstraints.HORIZONTAL;
			f.gridx =1;
			f.gridy =2;
			SmPanel.add(Playbtn,f);
			f.fill = GridBagConstraints.HORIZONTAL;
			f.gridx =1;
			f.gridy =3;
			SmPanel.add(Backbtn,f);
			//Format.add(SmPanel,BorderLayout.SOUTH);
			
			//SFrame.add(Format);
			SFrame.add(SmPanel);
			
			
			SFrame.setVisible(true);
			SFrame.setTitle("Start Game");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	
	public class LoadListener implements ActionListener //Load Button Action
	{
		public void actionPerformed(ActionEvent event)
		{
			
			JFrame LFrame = new JFrame();
			LFrame.setSize(500,500);
			JPanel LmPanel = new JPanel(); //Panel for the whole Load menu
			JTextArea Load_GameList = new JTextArea(20,30); //List of available games to play
			
			Load_GameList.setEditable(false);
			
			
			
			JButton Loadbtn = new JButton("Play");
			JButton Backbtn2 = new JButton("Back");
			
			
			
			
			LmPanel.setSize(MAXIMIZED_HORIZ,MAXIMIZED_VERT);
			LmPanel.setLayout(new GridBagLayout());
			GridBagConstraints e = new GridBagConstraints();
			e.insets = new Insets(0,0,0,0);
			e.fill = GridBagConstraints.HORIZONTAL;
			e.gridx = 1;
			e.gridy = 1;
			LmPanel.add(Load_GameList,e);
			
			e.fill= GridBagConstraints.HORIZONTAL;
			e.gridx = 0;
			e.gridy = 0;
			
			
			GridBagConstraints f = new GridBagConstraints();
			f.insets = new Insets(15,0,0,0);
			f.fill = GridBagConstraints.HORIZONTAL;
			f.gridx =1;
			f.gridy =2;
			LmPanel.add(Loadbtn,f);
			f.fill = GridBagConstraints.HORIZONTAL;
			f.gridx =1;
			f.gridy =3;
			LmPanel.add(Backbtn2,f);
			
			
			
			LFrame.add(LmPanel);
			
			
			LFrame.setVisible(true);
			LFrame.setTitle("Load Game");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	
}
