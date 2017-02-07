import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame 
{
	
	private JPanel cardPanel;
	private JPanel cardPanel2;
	private JLabel loadLabel;
	private JLabel startLabel;
	//Main Menu Panel
	private JPanel mainPanel;
	private JLabel kptLabel;
	private JButton startButton;
	private JButton loadButton;
		
	// Load and Start panel
	private JPanel gamePanel;
	private JList<?> gameList;
	private JLabel titleOfPanel;
	
	//********************************************************************
	//Will be replaced with code that receives game file names
	private String [] startGame = {"Checkers", "Chess", "Battleship"};
	private String [] loadGame = {"Game1", "Game2", "Game23"};
	//********************************************************************
	
	private JButton playButton;
	private JButton backButton;
	
	
	public static void main(String[] args)
	{
		MainMenu Frame = new MainMenu();
	}
	
	public MainMenu()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		constructMainPanel();
		constructGamePanel();
		
		cardPanel = new JPanel(new CardLayout());
		cardPanel.add(mainPanel);
		cardPanel.add(gamePanel);
		add(cardPanel);
		
		StartOrLoadClick listener = new StartOrLoadClick();
		startButton.addActionListener(listener);
		loadButton.addActionListener(listener);
		backButton.addActionListener(listener);
		playButton.addActionListener(listener);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void constructMainPanel()
	{
		startButton = new JButton ("Start");
		startButton.setPreferredSize(new Dimension (350,50));
		loadButton = new JButton ("Load");
		loadButton.setPreferredSize(new Dimension (350,50));
		kptLabel = new JLabel ("Knightly Party Table");
		kptLabel.setFont(new Font("Serif",Font.PLAIN,44));
		//kptLabel.setForeground(Color.white);
		mainPanel = new JPanel();
		
		//GridBagLayout helps with the formating of the panels.
		mainPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		b.insets= new Insets(0,0,300,0);
		b.fill = GridBagConstraints.HORIZONTAL;
		b.gridx = 0;
		b.gridy = 0;
		mainPanel.add(kptLabel,b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets (0,0,100,0);
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
		c.gridy = 1;
		mainPanel.add(startButton,c);
		
		b.fill = GridBagConstraints.HORIZONTAL;
		b.gridx = 0;
		b.gridy = 2;
		mainPanel.add(loadButton,b);
		
		
	}
	
	private void constructGamePanel() {
		
		titleOfPanel = new JLabel ();
		titleOfPanel.setFont(new Font("Serif",Font.PLAIN,42));
		gameList = new JList<Object>();
		gameList.setVisibleRowCount(3);
		gameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(gameList));
		
		//In both load and start
		playButton = new JButton("Play");
		playButton.setPreferredSize(new Dimension (350,50));
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension (350,50));
		gamePanel = new JPanel();
		
		GridBagConstraints b = new GridBagConstraints();
		gamePanel.setLayout(new GridBagLayout());
		b.insets= new Insets(-400,400,200,0);
		b.fill = GridBagConstraints.HORIZONTAL;
		b.gridx = 1;
		b.gridy = 0;
		gamePanel.add(titleOfPanel,b);
		
		GridBagConstraints d = new GridBagConstraints();
		d.insets = new Insets(0,0,0,0);
		d.fill = GridBagConstraints.VERTICAL;
		d.gridx = 0;
		d.gridy = 1;
		gamePanel.add(gameList,d);
				
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets (100,0,0,0);
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
		c.gridy = 3;
		gamePanel.add(playButton,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		gamePanel.add(backButton,c);
		//In both load and start
		
	}
	
	class StartOrLoadClick implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			Object source = arg0.getSource();
			
			
			if (source == startButton)
			{				
				titleOfPanel.setText("Start Game");
				gamePanel.remove(gameList);
				gameList = new JList<Object> (startGame);
				gameList.setPreferredSize(new Dimension(300,300));
				;
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.last(cardPanel);				
			} 
			else if (source == loadButton) 
			{
				titleOfPanel.setText("Load Game");
				gamePanel.remove(gameList);
				gameList = new JList<Object> (loadGame);
				gameList.setPreferredSize(new Dimension(300,300));
				
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.last(cardPanel);
				
			} 
			else if (source == backButton) 
			{
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.first(cardPanel);
			} 
			else if (source == playButton)
			{
				selectedGame();
				
				/*
				 * 
				 * 
				 * Code that will open game to be played 
				 * 
				 * 
				 * 
				 */
			}
			else {
			System.out.println("You done messed up");
			}
			gamePanel.updateUI();
			gamePanel.add(gameList);
		
		
		}
	}
		
		public Object selectedGame()
		{ 
			Object selected = gameList.getSelectedValue();
			Object selectedGame = selected;
			System.out.println(selectedGame);
			return selectedGame;
		}
		
	}
