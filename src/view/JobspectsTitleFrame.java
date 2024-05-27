package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	// This method sets up the the frame
	public void displayScreen() {
			
			// Create the frame
			
			
			// Load the background image
			ImageIcon backgroundImage = new ImageIcon("./images/TitleFrame.png");
			
			// Create the button
	        Icon gs = new ImageIcon("./images/GetStarted.png");
	        startButton = new JButton(gs);
	        startButton.setBounds(44, 650, 301, 70);
	        startButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			add(startButton);
			
			// Create a JLabel to hold the background image
			JLabel backgroundLabel = new JLabel(backgroundImage);
	        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
	       
	        // Add background to frame
	        add(backgroundLabel);
	        
			// Set the size of the frame
			setSize(1405, 875);
			
			// Terminate the program when the user chooses to exit/quit
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// Don't allow the user to resize the screen
			setResizable(false);
			
			setVisible(false);
	}

	@Override
	public String toString() {
		return "JobspectsTitleFrame [startButton=" + startButton + "]";
	}
	
	
	
}
