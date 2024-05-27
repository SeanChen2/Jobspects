package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HelpFrame extends JobspectsFrame {

	private HelpFrame helpFrame = this;
	private JScrollPane scrollPane;
	private JButton backButton;
	private JPanel filterPanel = new JPanel();
	private JLabel filterExplained;

	public HelpFrame() {
		setSize(1920, 1080);
		
		setTitle("Jobspects😎");
		// Create the background
        JLabel background = new JLabel(new ImageIcon("images/MainFrame.png"));
        scrollPane = new JScrollPane(background);
        scrollPane.setBounds(0, 0, 1405, 1080);
        
        // Create the button
        Icon bb = new ImageIcon("./images/BackButton.png");
        backButton = new JButton(bb);
        backButton.setBounds(41, 64, 52, 52);
        backButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backButton.setOpaque(false);
		background.add(backButton);
        
        setUpFilterPanel();
        //setVisible(true);
	}
	
	private void setUpFilterPanel() {
		// Display the filter "sections" vertically using a box layout
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		// a yellow so light that it just looks white
		filterPanel.setBackground(Color.decode("#fffef7"));
		
		filterExplained = new JLabel();
		filterExplained.setText("This panel will contain radio buttons and text\n "
				+ "boxes, allowing you to filter information being displayed on the graph!");
		filterExplained.setFont(new Font("Sans Serif", Font.BOLD, 13));
		filterPanel.add(filterExplained);
		

		// Make the filter panel vertically scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterScrollPane.setBackground(Color.WHITE);
		
		
		add(filterScrollPane);
		


	}

}
