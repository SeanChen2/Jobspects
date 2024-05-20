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

public class JobspectsMenuFrame extends JFrame {
	
	// Attributes
    private JScrollPane scrollPane;
	
	public JobspectsMenuFrame() {
		
		// Create the background
        JLabel background = new JLabel(new ImageIcon("images/MainFrame.png"));
        scrollPane = new JScrollPane(background);
        scrollPane.setBounds(0, 0, 1405, 875);
        
        // Create a panel on top
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1405, 1365);
        panel.setLayout(null);
        
        // Add a scroll panel on top of the panel
        panel.add(scrollPane);
        add(panel);
        
		// Create the button
        Icon bb = new ImageIcon("./images/BackButton.png");
        JButton backButton = new JButton(bb);
        backButton.setBounds(41, 64, 52, 52);
        backButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backButton.setOpaque(false);
		background.add(backButton);

		// If button is clicked
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new JobspectsTitleFrame();
				// Close current frame
				dispose();
			}
		});
		
		// Create the buttons for users to go into our individual frames
        Icon lm1 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore1 = new JButton(lm1);
        learnMore1.setBounds(380, 324, 142, 34);
        learnMore1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore1);

		// If button is clicked
		learnMore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new OccupationLabourBarChartFrame();
				// Close current frame
				dispose();

			}
		});
		
        Icon lm2 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore2 = new JButton(lm2);
        learnMore2.setBounds(380, 547, 142, 34);
        learnMore2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore2);

		// If button is clicked
		learnMore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new ImmigrationLabourAreaChartFrame();
				// Close current frame
				dispose();
			}
		});
        
        Icon lm3 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore3 = new JButton(lm3);
        learnMore3.setBounds(378, 767, 142, 34);
        learnMore3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore3);

		// If button is clicked
		learnMore3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new UnemploymentDurationLineChartFrame();
				// Close current frame
				dispose();
				
			}
		});
		
        Icon lm4 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore4 = new JButton(lm4);
        learnMore4.setBounds(378, 995, 142, 34);
        learnMore4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore4);

		// If button is clicked
		learnMore4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new WagesByEducationScatterplotFrame();
				// Close current frame
				dispose();
			}
		});

        Icon lm5 = new ImageIcon("./images/LearnMore.png");
        JButton learnMore5 = new JButton(lm5);
        learnMore5.setBounds(379, 1216, 142, 34);
        learnMore5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(learnMore5);

		// If button is clicked
		learnMore5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create a new frame
				new TourismEmploymentPieChartFrame();
				// Close current frame
				dispose();
			}
		});
		
        Icon hb = new ImageIcon("./images/HelpButton.png");
        JButton helpButton = new JButton(hb);
        helpButton.setBounds(1281, 71, 34, 34);
        helpButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		background.add(helpButton);
		
		// If button is clicked
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Create the help frame
				new HelpFrame();
				// Close current frame 
				dispose();
			}
		});
		
		// Set the size of the frame
		setSize(1405, 1365);
		
		// Don't allow the user to resize the screen
		setResizable(false);
		
		// Make the JFrame visible
		setVisible(true);
	}
}
