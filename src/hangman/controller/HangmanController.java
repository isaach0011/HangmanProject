package hangman.controller;

import javax.swing.JOptionPane;
import hangman.model.*;
import hangman.view.*;


public class HangmanController
{
	private HangmanFrame baseFrame;
	private Hangman hangman;
	private HangmanPanel hangmanPanel;
	private String word;
	private StringBuffer hiddenWord;
	private String guessedLetters;
	private int lives;
	
	public HangmanController()
	{
		hangman = new Hangman();
		word = hangman.randomWord();
		hiddenWord = this.createHiddenWord(word);
		guessedLetters = "";
		baseFrame = new HangmanFrame(this);
		hangmanPanel = new HangmanPanel(this);
		lives = 6;
	}
	
	public void start()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//startComplexity
	public void playgame(String guessedPhrase)
	{
		if(guessedPhrase.length() > 1)
		{
			if(guessedPhrase.equals(word))
			{
				baseFrame.switchScreenToWin();
			}
			else
			{
				lives--;
				
				if(lives == 0)
				{
					baseFrame.switchScreenToLose();
				}
			}
		}
		else
		{
			if(guessedPhrase.equals(""))
			{
				JOptionPane.showMessageDialog(baseFrame, "Please enter the word or a SINGLE letter.");
			}
			else
			{
				char guessedLetter = guessedPhrase.charAt(0);
				guessedLetters += guessedLetter + " ";
		
				if(word.indexOf(guessedLetter) < 0)
				{
					lives--;
				}
				else
				{
					this.matchLetter(guessedLetter);
				}
				
				if(lives == 0)
				{
					baseFrame.switchScreenToLose();
				}
				if(word.equals(hiddenWord.toString()))
				{
					baseFrame.switchScreenToWin();
				}
			}
		}
	}
	//endComplexity
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//startAbstraction
	public void matchLetter(char guessedLetter)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == guessedLetter)
			{
				hiddenWord.setCharAt(i, guessedLetter);
			}
		}
	}
	//endAbstraction
	
	
	public void addWord(String word)
	{
		if(word.contains(" ") || word.contains(".") || word.contains("-") || word.contains(","))
		{
			JOptionPane.showMessageDialog(baseFrame, "Please type in a valid word.");
		}
		else
		{
			hangman.addWordToFile(word);
			JOptionPane.showMessageDialog(baseFrame, "Added " + word + " to word list.");
			JOptionPane.showMessageDialog(baseFrame, "Note: All words you add will be deleted after ending the program.");
		}
	}
	
	public StringBuffer createHiddenWord(String word)
	{
		StringBuffer hidden = new StringBuffer(word.length());
		for(int i = 0; i < word.length(); i ++)
		{
			hidden.append('-');
		}
		return hidden;
	}

	public HangmanFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	public Hangman getHangman()
	{
		return hangman;
	}
	
	public String getRandomWord()
	{
		return word;
	}
	
	public String getGuessedLetters()
	{
		return guessedLetters;
	}
	
	public String getLives()
	{
		return Integer.toString(lives);
	}
	
	public String getHiddenWord()
	
	{
		return hiddenWord.toString();
	}
}