package view;

import javax.swing.JButton;
import javax.swing.JPanel;

//This is a general frame that holds common GUI elements between
//the two chart screens for the immigration labour force sub-topic:
//area chart and histogram
public abstract class ImmigrationLabourChartFrame extends JobspectsChartFrame {
	
	//Fields
	private JButton[] chartNavButtons;
	private JPanel filterPanel;
	
	//Reference to the chart filter section (selects sex, employment type, etc.)
	private ImmigrationLabourChartFilterPanel chartFilterSection;
	
	//Constructor
	public ImmigrationLabourChartFrame() {
		
		
		
	}
	
	//Necessary getters for GUI elements
	public JButton[] getChartNavButtons() {
		return chartNavButtons;
	}
	
	public ImmigrationLabourChartFilterPanel getChartFilterSection() {
		return chartFilterSection;
	}
	
	//This method adds the buttons that navigate between the two charts
	//(area chart and histogram), above the filter panel
	private void setUpChartNavButtons() {
		
		
		
	}
	
	//This method adds the empty white panel that holds all the chart filters
	//and features (e.g. filter by education level, calculate average employment).
	//The contents of this panel will be added in the concrete classes.
	private void addFilterPanel() {
		
		
		
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
