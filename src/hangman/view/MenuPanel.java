package hangman.view;

import javax.swing.*;
import hangman.controller.HangmanController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;

public class MenuPanel extends JPanel
{
	private HangmanController baseController;
	private HangmanFrame baseFrame;
	private SpringLayout baseLayout;
	//private ImageIcon titlePicture;
	private ImageIcon settingsIcon;
	private JButton quitButton;
	private JButton goToGamesButton;
	private JButton goToSettingsButton;
	private JLabel titleLabel;
	
	
	public MenuPanel(HangmanController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		//this.titlePicture = new ImageIcon(getClass().getResource("images/ .png"));
		this.settingsIcon = new ImageIcon(getClass().getResource("images/cog.png"));
		this.quitButton = new JButton("Quit");
		this.goToGamesButton = new JButton("Play");
		this.goToSettingsButton = new JButton(settingsIcon);
		this.titleLabel = new JLabel("Hangman the Game");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		titleLabel.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		
		this.add(goToSettingsButton);
		this.add(quitButton);
		this.add(goToGamesButton);
		this.add(titleLabel);
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, goToSettingsButton, -110, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, goToSettingsButton, -110, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, goToSettingsButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, goToSettingsButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, goToGamesButton, 0, SpringLayout.WEST, quitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, goToGamesButton, -6, SpringLayout.NORTH, quitButton);
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 375, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, quitButton, -369, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 274, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, -7, SpringLayout.NORTH, goToGamesButton);
	}
	
	public void setupListeners()
	{
		goToGamesButton.addActionListener(new ActionListener()
		{		
			public void actionPerformed(ActionEvent click)
			{

				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToHangman();
			}			
		});
		
		goToSettingsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToSettings();
			}
		});
		
		quitButton.addActionListener(new ActionListener()
		{		
			public void actionPerformed(ActionEvent click)
			{
				System.exit(0);
			}			
		});
	}
}
