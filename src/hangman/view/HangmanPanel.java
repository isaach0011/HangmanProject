package hangman.view;

import javax.swing.*;
import hangman.controller.HangmanController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class HangmanPanel extends JPanel
{
	private HangmanController baseController;
	private HangmanFrame baseFrame;
	private SpringLayout baseLayout;
	private JTextArea guessesDisplay;
	private JTextArea wordDisplay;
	private JTextField hangmanInput;
	private JButton exitButton;
	private JButton submitButton;
	private JLabel gameLabel;
	private JLabel guessesLabel;
	private JLabel wordLabel;
	private JLabel guessLabel;
	private JLabel livesLabel;
	private JLabel dynamicLivesLabel;
	private String word;
	
	public HangmanPanel(HangmanController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		//this.gallowsIcon = new ImageIcon(getClass().getResource("images/ .png");
		this.guessesDisplay = new JTextArea(5, 25);
		this.wordDisplay = new JTextArea(1, 20);
		this.hangmanInput = new JTextField(25);
		this.exitButton = new JButton("Exit Game");
		this.submitButton = new JButton("Submit");
		this.gameLabel = new JLabel("Hangman");

		this.guessesLabel = new JLabel("Your Guesses");
		this.wordLabel = new JLabel("Word");
		this.guessLabel = new JLabel("Enter Guessed Letter Here");
		this.livesLabel = new JLabel("Lives:");

		this.dynamicLivesLabel = new JLabel("6");

		this.word = "";
		//this.gallowsLabel = new JLabel(gallowsIcon);
		
		setupHangmanGame();
		setupGuessesDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupHangmanGame()
	{
		word = baseController.getRandomWord();
		
	}
	
	private void setupGuessesDisplay()
	{
		guessesDisplay.setEditable(false);
		guessesDisplay.setEnabled(false);
		guessesDisplay.setLineWrap(true);
		guessesDisplay.setWrapStyleWord(true);
		wordDisplay.setEditable(false);
		wordDisplay.setEnabled(false);
		wordDisplay.setLineWrap(true);
		wordDisplay.setWrapStyleWord(true);
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		gameLabel.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		livesLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		dynamicLivesLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		
		this.add(guessesDisplay);
		this.add(wordDisplay);
		this.add(hangmanInput);
		this.add(exitButton);
		this.add(gameLabel);
		this.add(submitButton);
		this.add(guessesLabel);
		this.add(wordLabel);
		this.add(guessLabel);
		this.add(livesLabel);
		this.add(dynamicLivesLabel);
		//this.add(gallowsLabel);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, exitButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, exitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, hangmanInput, -75, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, hangmanInput, -244, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, hangmanInput);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -365, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, guessesDisplay, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, guessesDisplay, 0, SpringLayout.SOUTH, hangmanInput);
		baseLayout.putConstraint(SpringLayout.WEST, guessLabel, 37, SpringLayout.EAST, guessesDisplay);
		baseLayout.putConstraint(SpringLayout.SOUTH, guessLabel, -6, SpringLayout.NORTH, hangmanInput);
		baseLayout.putConstraint(SpringLayout.EAST, wordLabel, -509, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, wordDisplay, 8, SpringLayout.EAST, wordLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, wordLabel, 0, SpringLayout.NORTH, guessesDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, guessesLabel, 0, SpringLayout.WEST, guessesDisplay);
		baseLayout.putConstraint(SpringLayout.SOUTH, guessesLabel, -6, SpringLayout.NORTH, guessesDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, wordDisplay, 0, SpringLayout.NORTH, guessesDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, gameLabel, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gameLabel, 44, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, livesLabel, 142, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, livesLabel, -339, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, dynamicLivesLabel, 6, SpringLayout.SOUTH, livesLabel);
		baseLayout.putConstraint(SpringLayout.EAST, dynamicLivesLabel, -380, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				playTheGame();
			}
		});
		
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToMenu();
			}
		});
		
		hangmanInput.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent pressedEnter)
			{
				playTheGame();
			}
		});
	}
	
	public void playTheGame()
	{
		String guessedLetter = hangmanInput.getText();
		baseController.playgame(guessedLetter);
		guessesDisplay.setText(baseController.getGuessedLetters());
		wordDisplay.setText(baseController.getHiddenWord());
		dynamicLivesLabel.setText(baseController.getLives());
		hangmanInput.setText("");
	}
}
