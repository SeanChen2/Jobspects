package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

//This is a general frame that holds common GUI elements between
//the two chart screens for the immigration labour force sub-topic:
//area chart and histogram
public abstract class ImmigrationLabourChartFrame extends JobspectsChartFrame {
	
	//An array of navigation buttons between the area chart and histogram frames
	private JButton[] chartNavButtons = new JButton[2];
	
	//A panel that holds all the filter sections which customize the chart
	private JPanel filterPanel = new JPanel();
	
	//Reference to the chart filter section (selects sex, employment type, etc.)
	private ImmigrationLabourChartFilterPanel chartFilterSection;
	
	//Reference to the date picker (selects the year to display data for, with an 
	//optional choice to display all years at once (only applies to area chart)
	private ImmigrationLabourDatePickerPanel datePickerSection;
	
	//Constructor: set the title of the chart, then set up the common elements between the area chart and histogram
	public ImmigrationLabourChartFrame() {
		
		//Set the frame title label
		getScreenTitleLabel().setText("    Are Canadian immigrants disproportionally affected by the unemployment crisis?");
		
		//Shift the chart panel down to make room for the navigation buttons
		JPanel chartPanel = getChartPanelTemplate();
		getChartPanelTemplate().setBounds(chartPanel.getX(), chartPanel.getY() + 50, chartPanel.getWidth(), chartPanel.getHeight() - 50);
		
		//Add the navigation buttons and panel of filters to the frame
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
	
	public ImmigrationLabourDatePickerPanel getDatePickerSection() {
		return datePickerSection;
	}

	public void setDatePickerSection(ImmigrationLabourDatePickerPanel datePickerSection) {
		this.datePickerSection = datePickerSection;
	}

	//This method adds the buttons that navigate between the two charts
	//(area chart and histogram), above the filter panel
	private void setUpChartNavButtons() {
		
		//Set up the area chart and histogram navigation buttons, positioning them above the chart
		chartNavButtons[0] = new JButton("Area chart (time)");
		chartNavButtons[0].setBounds(30, 150, 250, 60);
		
		chartNavButtons[1] = new JButton("Histogram (age)");
		chartNavButtons[1].setBounds(290, 150, 250, 60);
		
		//Style both buttons with a light purple background and dark purple text, and a size 30 font
		for (JButton navButton : chartNavButtons) {
			navButton.setBackground(new Color(196, 153, 188));
			navButton.setForeground(JobspectsFrame.DARK_PURPLE);
			navButton.setFont(new Font("Sans Serif", Font.BOLD, 24));
			navButton.setFocusPainted(false);
			
			//Add the navigation button to the frame
			add(navButton);
		}
		
	}
	
	//This method adds the empty white panel that holds all the chart filters
	//and features (e.g. filter by education level, calculate average employment).
	//The contents of this panel will be added in the concrete classes.
	private void addFilterPanel() {
		
		//Display the filter "sections" vertically using a box layout
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		
		//Make the filter panel vertically scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Position the scrollable filter panel on the right side of the screen with a white background
		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterScrollPane.setBackground(Color.WHITE);
		add(filterScrollPane);
		
	}
	
	//This abstract method requires concrete classes to define how to set up
	//a section of chart filters that allows the user to
	//choose which demographics the area chart represents
	protected abstract void setUpChartFilterSection();
	
	//This abstract method requires concrete classes to define how to set up
	//the date picker section, which allows the user to pick a year to display
	//data for
	protected abstract void setUpDatePickerSection();
	
	//This abstract method requires concrete classes to define how to set up
	//the last section of the filter panel, which calculates the average
	//employment figure for a certain demographic
	protected abstract void setUpAverageSection();
	
}
