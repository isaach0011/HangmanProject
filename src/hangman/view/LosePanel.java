package hangman.view;

import javax.swing.*;
import hangman.controller.HangmanController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class LosePanel extends JPanel
{
	private HangmanController baseController;
	private HangmanFrame baseFrame;
	private SpringLayout baseLayout;
	private ImageIcon losePicture;
	private JLabel losePictureLabel;
	private JLabel loseLabel;
	private JLabel wordLabel;
	private JButton quitButton;
	
	public LosePanel(HangmanController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		this.losePicture = new ImageIcon(getClass().getResource("images/dontgiveup.jpeg"));
		this.loseLabel = new JLabel("You lose.");
		this.wordLabel = new JLabel("The word was " + baseController.getRandomWord() + ".");
		this.quitButton = new JButton("Quit");
		this.losePictureLabel = new JLabel(losePicture);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		loseLabel.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		
		this.add(losePictureLabel);
		this.add(loseLabel);
		this.add(wordLabel);
		this.add(quitButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, loseLabel, 38, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, loseLabel, 366, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, losePictureLabel, 77, SpringLayout.SOUTH, loseLabel);
		baseLayout.putConstraint(SpringLayout.WEST, losePictureLabel, 296, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, quitButton, 39, SpringLayout.SOUTH, losePictureLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, wordLabel, -30, SpringLayout.NORTH, losePictureLabel);
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 398, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, wordLabel, 0, SpringLayout.WEST, loseLabel);
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

