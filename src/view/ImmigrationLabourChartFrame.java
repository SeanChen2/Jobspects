package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

//This is a general frame that holds common GUI elements between
//the two chart screens for the immigration labour force sub-topic:
//area chart and histogram
public abstract class ImmigrationLabourChartFrame extends JobspectsChartFrame {
	
	//Fields
	private JButton[] chartNavButtons = new JButton[2];
	private JPanel filterPanel = new JPanel();
	
	//Reference to the chart filter section (selects sex, employment type, etc.)
	private ImmigrationLabourChartFilterPanel chartFilterSection;
	
	//Constructor
	public ImmigrationLabourChartFrame() {
		
		//Set the frame title label
		getScreenTitleLabel().setText("    Are Canadian immigrants disproportionally affected by the unemployment crisis?");
		
		setUpChartNavButtons();
		addFilterPanel();
		
	}
	
	//Necessary getters and setters for GUI elements
	public JPanel getFilterPanel() {
		return filterPanel;
	}
	
	public JButton[] getChartNavButtons() {
		return chartNavButtons;
	}
	
	public ImmigrationLabourChartFilterPanel getChartFilterSection() {
		return chartFilterSection;
	}
	
	public void setChartFilterSection(ImmigrationLabourChartFilterPanel chartFilterSection) {
		this.chartFilterSection = chartFilterSection;
	}
	
	//This method adds the buttons that navigate between the two charts
	//(area chart and histogram), above the filter panel
	private void setUpChartNavButtons() {
		
		//Set up and add the back button
		chartNavButtons[0] = new JButton("Area chart (time)");
		chartNavButtons[0].setBounds(30, 150, 250, 60);
		chartNavButtons[0].setBackground(new Color(232, 192, 225));
		chartNavButtons[0].setForeground(JobspectsFrame.DARK_PURPLE);
		chartNavButtons[0].setFont(new Font("Sans Serif", Font.BOLD, 24));
		chartNavButtons[0].setFocusPainted(false);
		add(chartNavButtons[0]);
		
		chartNavButtons[1] = new JButton("Histogram (age)");
		chartNavButtons[1].setBounds(290, 150, 250, 60);
		chartNavButtons[1].setBackground(new Color(232, 192, 225));
		chartNavButtons[1].setForeground(JobspectsFrame.DARK_PURPLE);
		chartNavButtons[1].setFont(new Font("Sans Serif", Font.BOLD, 24));
		chartNavButtons[1].setFocusPainted(false);
		add(chartNavButtons[1]);
		
	}
	
	//This method adds the empty white panel that holds all the chart filters
	//and features (e.g. filter by education level, calculate average employment).
	//The contents of this panel will be added in the concrete classes.
	private void addFilterPanel() {
		
		filterPanel.setLayout(new BoxLayout(filterPanel, SwingConstants.VERTICAL));
		
		//Make the filter panel scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel);
		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 230, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 300);
		filterScrollPane.setBackground(Color.WHITE);
		add(filterScrollPane);
		
	}
	
	//This abstract method requires concrete classes to define how to set up
	//a section of chart filters that allows the user to
	//choose which demographics the area chart represents
	protected abstract void setUpChartFilterSection();
	
	//This abstract method requires concrete classes to define how to set up
	//the last section of the filter panel, which calculates the average
	//employment figure for a certain demographic
	protected abstract void setUpAverageSection();
	
}
