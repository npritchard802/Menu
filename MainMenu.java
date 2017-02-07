import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame 
{
	
	private JPanel cardPanel;
	
	//Main Menu Panel
	private JPanel mainPanel;
	private JLabel kptLabel;
	private JButton startButton;
	private JButton loadButton;
	private JLabel backGround;
	private Image img;
	
	// Load and Start panel
	private JPanel gamePanel;
	private static JList<?> gameList;
	private static JLabel titleOfPanel;
	private static String [] startGame = {"Checkers", "Chess", "Battleship"};
	private static String [] loadGame = {"Game1", "Game2", "Game23"};
	
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
		
		JLabel titleOfPanel = new JLabel("empty");
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
		b.insets= new Insets(0,0,0,0);
		b.fill = GridBagConstraints.HORIZONTAL;
		b.gridx = 1;
		b.gridy = 0;
		gamePanel.add(titleOfPanel,b);
		
		
		b.fill = GridBagConstraints.HORIZONTAL;
		b.gridx = 0;
		b.gridy = 2;
		gamePanel.add(gameList,b);
				
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
				gamePanel.remove(gameList);
				//gamePanel.remove(titleOfPanel);
				gamePanel.updateUI();
				//titleOfPanel = new JLabel ("Start Game");
				gameList = new JList<Object> (startGame);
				gameList.setPreferredSize(new Dimension(300,300));
				gamePanel.add(gameList);
				//gamePanel.add(titleOfPanel);
				CardLayout cl = (CardLayout) cardPanel.getLayout();
				cl.last(cardPanel);				
			} 
			else if (source == loadButton) 
			{
				gamePanel.remove(gameList);
				//gamePanel.remove(titleOfPanel);
				titleOfPanel = new JLabel ("Load Game");
				gamePanel.updateUI();
				//gamePanel.add(titleOfPanel);
				//gameList = new JList<Object> (loadGame);
				gameList.setPreferredSize(new Dimension(300,300));
				gamePanel.add(gameList);
				
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
			
		}
		}
	
		
		public static Object selectedGame()
		{ 
			Object selected = gameList.getSelectedValue();
			Object selectedGame = selected;
			System.out.println(selectedGame);
			return selectedGame;
		}
		
	}
