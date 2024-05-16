package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JobspectsMenuFrame extends JobspectsFrame {
	
	// Attributes
    private JScrollPane scrollPane;
	
	public JobspectsMenuFrame() {
		
		JFrame menuFrame = new JFrame();
		
        JLabel background = new JLabel(new ImageIcon("images/MainFrame.png"));
        scrollPane = new JScrollPane(background);
        scrollPane.setBounds(0, 0, 1405, 875);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1405, 1365);
        panel.setLayout(null);
        
        panel.add(scrollPane);
        menuFrame.add(panel);
        
		// Create the button
        Icon bb = new ImageIcon("./images/BackButton.png");
        JButton backButton = new JButton(bb);
        backButton.setBounds(41, 64, 52, 52);
        backButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// close this screen
				new JobspectsTitleFrame();
				dispose();
			}
		});
		
		// Create the buttons
        Icon lm1 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore1 = new JButton(lm1);
        learnMore1.setBounds(380, 324, 142, 34);
        learnMore1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore1);
		
		learnMore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
        Icon lm2 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore2 = new JButton(lm2);
        learnMore2.setBounds(380, 547, 142, 34);
        learnMore2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore2);
		
		learnMore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
        
        Icon lm3 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore3 = new JButton(lm3);
        learnMore3.setBounds(380, 770, 142, 34);
        learnMore3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore3);
		
		learnMore3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
        Icon lm4 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore4 = new JButton(lm4);
        learnMore4.setBounds(380, 994, 142, 34);
        learnMore4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore4);
		
		learnMore4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});

        Icon lm5 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore5 = new JButton(lm5);
        learnMore5.setBounds(380, 1218, 142, 34);
        learnMore5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore5);
		
		learnMore5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
        Icon hb = new ImageIcon("./images/HelpButton.png");
        JButton helpButton = new JButton(hb);
        helpButton.setBounds(1346, 1316, 34, 34);
        helpButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(helpButton);
		
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		
		// Set the size of the frame
		menuFrame.setSize(1405, 1365);
		
		// Don't allow the user to resize the screen
		menuFrame.setResizable(false);
		
		// Make the JFrame visible
		menuFrame.setVisible(true);
	}
}
