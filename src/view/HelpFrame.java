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
import javax.swing.JTextArea;

public class HelpFrame extends JobspectsFrame {
	
	private HelpFrame helpFrame = this;
	private JScrollPane scrollPane;
	private JButton backButton;
	private JPanel filterPanel = new JPanel();
	private JLabel filterExplained;
	private JPanel chartPanel = new JPanel();
	private JLabel TitleLabel = new JLabel("     How to Navigate this Application");


	public HelpFrame() {
		setSize(1920, 1080);

		setTitle("Jobspects😎");
		// Create the background\

		// Create the back button with image and adjust values, positioning it in top left corner
		//allows user to return to menu frame
		Icon bb = new ImageIcon("./images/BackButton.png");
		backButton = new JButton(bb);
		backButton.setBounds(41, 64, 52, 52);
		backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		backButton.setOpaque(false);
		//add to frame
		add(backButton);
		
		
		//Set up the title label with a white background and purple text, and position it at the
		//top of the screen. Use a bold, size 30 font.
		TitleLabel.setBounds(120, 64, FRAME_WIDTH - 180, 70);
		TitleLabel.setBackground(Color.WHITE);
		TitleLabel.setForeground(DARK_PURPLE);
		TitleLabel.setOpaque(true);
		TitleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
		//add to frame
		add(TitleLabel);
		
		//Set up filter Panel on right side of screen and ChartPanel on left/mid section of screen
		setUpFilterPanel();
		setUpChartPanel();

	}

	public HelpFrame getHelpFrame() {
		return helpFrame;
	}

	public void setHelpFrame(HelpFrame helpFrame) {
		this.helpFrame = helpFrame;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JPanel getFilterPanel() {
		return filterPanel;
	}

	public void setFilterPanel(JPanel filterPanel) {
		this.filterPanel = filterPanel;
	}

	public JLabel getFilterExplained() {
		return filterExplained;
	}

	public void setFilterExplained(JLabel filterExplained) {
		this.filterExplained = filterExplained;
	}
	
	
	//Set up filterpanel on right side of screen
	private void setUpFilterPanel() {
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		// a yellow so light that it just looks white
		filterPanel.setBackground(Color.decode("#fffef7"));

		// Create and add JTextArea, explaining the purpose of the panel and how to navigate it
		JTextArea filterExplainedTextArea = new JTextArea();
		filterExplainedTextArea.setFont(new Font("Serif", Font.PLAIN, 24));
		filterExplainedTextArea.setForeground(Color.BLACK);
		filterExplainedTextArea.setBackground(Color.WHITE); // Set the same color as the middle gradient color
		filterExplainedTextArea.setBounds(100, 400, 300, 700);
		filterExplainedTextArea.setLineWrap(true);
		filterExplainedTextArea.setWrapStyleWord(true);
		filterExplainedTextArea.setText("On each Frame, this Panel will hold a set of Filters.\n"
				+ "Filters will vary based on the information displayed by the graph, \n"
				+ "Select a Button to activate a filter, enter a number into a text box and pull on a slider with our cursor");
		//Add textarea to filter panel
		filterPanel.add(filterExplainedTextArea);

		// Make the filter panel vertically scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterScrollPane.setBackground(Color.WHITE);
		
		//add scroll panel to frame
		add(filterScrollPane);

	}

	//set up chart Panel on left & center part of screen
	public void setUpChartPanel() {
		
		//Adjust values
		chartPanel.setBounds(30, 180, FRAME_WIDTH / 2 + 100, FRAME_HEIGHT - 300);
		chartPanel.setBackground(Color.decode("#fffef7"));

		// Create and add JTextArea explaining how to read information off of chart on panel
		JTextArea chartExplainedTextArea = new JTextArea();
		chartExplainedTextArea.setFont(new Font("Serif", Font.PLAIN, 26));
		chartExplainedTextArea.setForeground(Color.BLACK);
		chartExplainedTextArea.setBackground(Color.WHITE); // Set the same color as the middle gradient color
		chartExplainedTextArea.setBounds(150, 300, 700, 300);
		chartExplainedTextArea.setLineWrap(true);
		chartExplainedTextArea.setWrapStyleWord(true);
		chartExplainedTextArea.setText("On each Frame, this Panel will hold a Chart.\n"
				+ "Every frame will contain a different type of Chart based on real data! \n\n"
				+ "Above the Chart will be a title, to the left will be a y-axis label, and to the right will be an x-axis label.");
		
		//add textarea to contentpane
		getContentPane().add(chartExplainedTextArea);
		
		//add to frame
		add(chartPanel);

	}

}
