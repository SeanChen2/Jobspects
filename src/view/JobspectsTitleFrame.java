package view;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Name: Kelvin Nguyen
 * JobspectsTitleFrame 
 * Group 1
 * Date: May 13th, 2024
 */

public class JobspectsTitleFrame extends JobspectsFrame {

	// Fields
	private JButton startButton;
	private JButton helpButton;
	
	// Constructor Methods
	public JobspectsTitleFrame() {
		displayScreen();
	}

	// Getters and Setters
	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JButton getHelpButton() {
		return helpButton;
	}

	public void setHelpButton(JButton helpButton) {
		this.helpButton = helpButton;
	}
	
	// This method sets up the the frame
	public void displayScreen() {
			
			// Load the background image
			ImageIcon backgroundImage = new ImageIcon("images/HomeFrame.png");

			// Create the buttons
	        Icon gs = new ImageIcon("images/GetStartedButton.png");
	        JButton getStartedButton = new JButton(gs);
	        getStartedButton.setBounds(44, 639, 301, 70);
	        getStartedButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			add(getStartedButton);
			
			// Create a JLabel to hold the background image
			JLabel backgroundLabel = new JLabel(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
			
	        add(backgroundLabel);
	        
			// Set the size of the frame
			setSize(1405, 875);
			
			// Terminate the program when the user chooses to exit/quit
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// Don't allow the user to resize the screen
			setResizable(false);
			
			// Make the JFrame visible
			setVisible(true);
	}

	@Override
	public String toString() {
		return "JobspectsTitleFrame [startButton=" + startButton + ", helpButton=" + helpButton + "]";
	}
	
	
	
}
