package hangman.view;

import javax.swing.*;
import hangman.controller.HangmanController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class WinPanel extends JPanel
{
	private HangmanController baseController;
	private HangmanFrame baseFrame;
	private SpringLayout baseLayout;
	private ImageIcon winPicture;
	private JLabel winPictureLabel;
	private JLabel winLabel;
	private JLabel wordLabel;
	private JButton quitButton;
	
	public WinPanel(HangmanController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		this.winPicture = new ImageIcon(getClass().getResource("images/youdidit.jpeg"));
		this.winLabel = new JLabel("You Win!");
		this.wordLabel = new JLabel("The word was " + baseController.getRandomWord() + ".");
		this.quitButton = new JButton("Quit");
		this.winPictureLabel = new JLabel(winPicture);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		winLabel.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		
		this.add(winPictureLabel);
		this.add(winLabel);
		this.add(wordLabel);
		this.add(quitButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, winLabel, 38, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, winLabel, 366, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, winPictureLabel, 77, SpringLayout.SOUTH, winLabel);
		baseLayout.putConstraint(SpringLayout.WEST, winPictureLabel, 296, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, quitButton, 39, SpringLayout.SOUTH, winPictureLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, wordLabel, -30, SpringLayout.NORTH, winPictureLabel);
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 398, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, wordLabel, 0, SpringLayout.WEST, winLabel);
	}
	
	public void setupListeners()
	{
		
		quitButton.addActionListener(new ActionListener()
		{		
			public void actionPerformed(ActionEvent click)
			{
				System.exit(0);
			}			
		});
	}
}
