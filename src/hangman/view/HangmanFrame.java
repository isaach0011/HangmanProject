package hangman.view;

import javax.swing.JFrame;
import hangman.controller.HangmanController;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HangmanFrame extends JFrame
{
	private HangmanController baseController;
	private HangmanFrame baseFrame;
	private MenuPanel menuPanel;
	private HangmanPanel hangmanPanel;
	private SettingsPanel settingsPanel;
	private WinPanel winPanel;
	private LosePanel losePanel;
	
	public HangmanFrame(HangmanController baseController)
	{
		super();
		this.baseController = baseController;
		menuPanel = new MenuPanel(baseController);
		hangmanPanel = new HangmanPanel(baseController);
		settingsPanel = new SettingsPanel(baseController);
		winPanel = new WinPanel(baseController);
		losePanel = new LosePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(menuPanel);
		this.setTitle("Hangman");
		this.setSize(new Dimension(900,600));
		this.setResizable(false);
		this.setVisible(true);	
	}

	public HangmanFrame getHangmanFrame()
	{
		return baseFrame;
	}
	
	public MenuPanel getMenuPanel()
	{
		return menuPanel;
	}

	public HangmanPanel getHangmanPanel()
	{
		return hangmanPanel;
	}

	public void setHangmanPanel(HangmanPanel hangmanPanel)
	{
		this.hangmanPanel = hangmanPanel;
	}
	
	public void setMenuPanel(MenuPanel menuPanel)
	{
		this.menuPanel = menuPanel;
	}


	public void switchScreenToMenu()
	{
		this.getContentPane();
		this.setContentPane(menuPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToHangman()
	{
		this.getContentPane();
		this.setContentPane(hangmanPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToSettings()
	{
		this.getContentPane();
		this.setContentPane(settingsPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToWin()
	{
		this.getContentPane();
		this.setContentPane(winPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToLose()
	{
		this.getContentPane();
		this.setContentPane(losePanel);
		this.validate();
		this.repaint();
	}
	
}
