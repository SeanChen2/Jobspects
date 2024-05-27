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

import controller.ImmigrationLabourChartController;
import controller.WagesByEducationChartController;

//TODO: use a panel for each dataset, OR just an array of "learn more buttons" so that
//the functionality can be done in the controller class
public class JobspectsMenuFrame extends JobspectsFrame {
	
	// Attributes
	private JobspectsMenuFrame menuFrame = this;
    private JScrollPane scrollPane;
    private JButton[] selectionButtons = new JButton[5];
    private JButton backButton;
    private JButton helpButton;

    
    //Field: JButton array for learn more buttons: selectionButtons
    //Getter: getSelectionButtons() for the array
    //Don't add any action listeners to any of the buttons
	
	public JobspectsMenuFrame() {
		
		// Create the background
        JLabel background = new JLabel(new ImageIcon("images/MainFrame.png"));
        scrollPane = new JScrollPane(background);
        scrollPane.setBounds(0, 0, 1405, 1080);
        
        // Create a panel on top
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1405, 1365);
        panel.setLayout(null);
        
        // Add a scroll panel on top of the panel
        panel.add(scrollPane);
        add(panel);
        
		// Create the button
        Icon bb = new ImageIcon("./images/BackButton.png");
        backButton = new JButton(bb);
        backButton.setBounds(41, 64, 52, 52);
        backButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backButton.setOpaque(false);
		background.add(backButton);
		
		// Create the buttons for users to go into our individual frames
        Icon lm1 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore1 = new JButton(lm1);
        learnMore1.setBounds(380, 324, 142, 34);
        learnMore1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore1);
		selectionButtons[0] = learnMore1;
		
		
        Icon lm2 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore2 = new JButton(lm2);
        learnMore2.setBounds(380, 547, 142, 34);
        learnMore2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore2);
		selectionButtons[1] = learnMore2;
        
        Icon lm3 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore3 = new JButton(lm3);
        learnMore3.setBounds(378, 767, 142, 34);
        learnMore3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore3);
		selectionButtons[2] = learnMore3;
		
        Icon lm4 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore4 = new JButton(lm4);
        learnMore4.setBounds(378, 995, 142, 34);
        learnMore4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore4);
		selectionButtons[3] = learnMore4;

        Icon lm5 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore5 = new JButton(lm5);
        learnMore5.setBounds(379, 1216, 142, 34);
        learnMore5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore5);
		selectionButtons[4] = learnMore5;
		
        Icon hb = new ImageIcon("./images/HelpButton.png");
        helpButton = new JButton(hb);
        helpButton.setBounds(1281, 71, 34, 34);
        helpButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(helpButton);
		
		// Set the size of the frame
		setSize(1405, 1365);
		
		// Don't allow the user to resize the screen
		setResizable(false);
	}

	// Getters and Setters
	public JobspectsMenuFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(JobspectsMenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton[] getSelectionButtons() {
		return selectionButtons;
	}

	public void setSelectionButtons(JButton[] selectionButtons) {
		this.selectionButtons = selectionButtons;
	}

	public JButton getHelpButton() {
		return helpButton;
	}

	public void setHelpButton(JButton helpButton) {
		this.helpButton = helpButton;
	}
	
	
	
	
}
