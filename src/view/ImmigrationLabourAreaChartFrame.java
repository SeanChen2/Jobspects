package view;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

//This concrete class is a frame that displays the area chart for the immigration
//labour force sub-topic. All the specific chart filters/features will be added to
//the filter panel in this class.
public class ImmigrationLabourAreaChartFrame extends ImmigrationLabourChartFrame {
	
	//References to GUI panels for the "sections" of chart filters
	private ImmigrationLabourCompareCategoryPanel compareCategorySection = new ImmigrationLabourCompareCategoryPanel(getFilterPanel());
	private ImmigrationLabourDatePickerPanel datePickerSection = new ImmigrationLabourDatePickerPanel(getFilterPanel());
	
	//Label above the area chart that warns the user of the artificial adjustments made to 2006 and 2020.
	//Only displays when the chart is displaying aggregated data for all 15 years.
	private JLabel adjustmentWarningLabel = new JLabel("<html>**The years 2006 and 2020 are missing data for a few months,"
			+ "<br/>so the aggregated data has been artificially adjusted for those years.</html>");

	//Constructor
	public ImmigrationLabourAreaChartFrame() {
		
		//Use an average calculation panel with a combo box to select which data 
		//category to calculate the average for
		setAverageCalculationPanel(new AverageCalculationPanel(true));
		
		setUpCompareCategorySection();
		setUpChartFilterSection();
		setUpDatePickerSection();
		setUpAverageSection();
		
		setUpAdjustmentWarningLabel();
		
	}
	
	//Getters for all the sections of filters, and the adjustment warning label
	
	public ImmigrationLabourCompareCategoryPanel getCompareCategorySection() {
		return compareCategorySection;
	}
	
	public ImmigrationLabourDatePickerPanel getDatePickerSection() {
		return datePickerSection;
	}
	
	public JLabel getAdjustmentWarningLabel() {
		return adjustmentWarningLabel;
	}

	//This method adds a section of category filters that allows the user to
	//choose which data category each "area" on the chart displays:
	//education level or immigrant status
	private void setUpCompareCategorySection() {
		
		getFilterPanel().add(compareCategorySection);
		
	}
	
	//This method adds a section of chart filters that allows the user to
	//choose which demographics the area chart represents: sex and employment type
	@Override
	protected void setUpChartFilterSection() {
		
		setChartFilterSection(new ImmigrationLabourChartFilterPanel(getFilterPanel(), true, true, false, false));
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		getChartFilterSection().setPreferredSize(new Dimension(1600, 400));
		getChartFilterSection().setMaximumSize(new Dimension(1600, 400));
		
		getFilterPanel().add(getChartFilterSection());
		
	}
	
	//This method adds a section of radio buttons and a slider to allow the user to
	//select which dates (years or months) to display
	private void setUpDatePickerSection() {
		
		getFilterPanel().add(datePickerSection);
		
	}
	
	//This method adds the last section to the filter panel, which calculates the average
	//figure (number of immigrant employees) over the years for a user-specified
	//education level OR immigrant status, with the current filters applied
	@Override
	protected void setUpAverageSection() {
		
		
		
	}
	
	//This method sets up a label above the area chart that warns the user of the artificial adjustments 
	//made to 2006 and 2020. Only displays when the chart is displaying aggregated data for all 15 years.
	private void setUpAdjustmentWarningLabel() {
		
		adjustmentWarningLabel.setBounds(580, 130, 1000, 100);
		adjustmentWarningLabel.setForeground(Color.WHITE);
		adjustmentWarningLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
		
		add(adjustmentWarningLabel);
		
	}
	
}
