package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

//This concrete class is a frame that displays the area chart for the immigration
//labour force sub-topic. All the specific chart filters/features will be added to
//the filter panel in this class.
public class ImmigrationLabourAreaChartFrame extends ImmigrationLabourChartFrame {
	
	//Reference to a GUI panel that allows the user to select which data category each "area" on the chart represents
	private ImmigrationLabourCompareCategoryPanel compareCategorySection = new ImmigrationLabourCompareCategoryPanel(getFilterPanel());
	
	//Label above the area chart that warns the user of the artificial adjustments made to 2006 and 2020.
	//Only displays when the chart is displaying aggregate data for all 15 years.
	private JLabel adjustmentWarningLabel = new JLabel("<html>**The years 2006 and 2020 are missing data for a few months,"
			+ "<br/>so the aggregated data has been artificially adjusted for those years.</html>");

	//Constructor: set up all the filter sections of the area chart frame, as well as the adjustment warning label
	public ImmigrationLabourAreaChartFrame() {
		
		//Use an average calculation panel with a combo box to select which data 
		//category to calculate the average for (UNFINISHED)
		setAverageCalculationPanel(new AverageCalculationPanel(true));
		
		//Brighten the area chart navigation button to show that this is the current frame
		getChartNavButtons()[0].setBackground(new Color(232, 192, 225));
		getChartNavButtons()[1].setBackground(new Color(196, 153, 188));
		
		//Add all the sections of filters to the filter panel
		setUpCompareCategorySection();
		setUpChartFilterSection();
		setUpDatePickerSection();
		setUpAverageSection();
		
		//Add a label to warn the user of the artificial adjustments to the data
		setUpAdjustmentWarningLabel();
		
	}
	
	//Getters for all the sections of filters, and the adjustment warning label
	
	public ImmigrationLabourCompareCategoryPanel getCompareCategorySection() {
		return compareCategorySection;
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
		
		//Create a section of chart filters that only includes sex and employment type
		setChartFilterSection(new ImmigrationLabourChartFilterPanel(getFilterPanel(), true, true, false, false));
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		getChartFilterSection().setPreferredSize(new Dimension(1600, 400));
		getChartFilterSection().setMaximumSize(new Dimension(1600, 400));
		
		//Adjust the height of the container that holds all the chart filters
		JPanel filterSectionContainer = getChartFilterSection().getFilterSectionContainer();
		filterSectionContainer.setSize(new Dimension(filterSectionContainer.getWidth(), 400));
		
		//Add the section of chart filters to the filter panel
		getFilterPanel().add(getChartFilterSection());
		
	}
	
	//This method adds a section of radio buttons and a slider to allow the user to
	//select which dates (years or months) to display
	@Override
	protected void setUpDatePickerSection() {
		
		//Set up and add the section of radio buttons and a slider to allow the user to pick the date range
		setDatePickerSection(new ImmigrationLabourDatePickerPanel(getFilterPanel(), true));
		getFilterPanel().add(getDatePickerSection());
		
	}
	
	//This method adds the last section to the filter panel, which calculates the average
	//figure (number of immigrant employees) over the years for a user-specified
	//education level OR immigrant status, with the current filters applied
	@Override
	protected void setUpAverageSection() {
		
		//UNFINISHED
		
	}
	
	//This method sets up a label above the area chart that warns the user of the artificial adjustments 
	//made to 2006 and 2020. Only displays when the chart is displaying aggregated data for all 15 years.
	private void setUpAdjustmentWarningLabel() {
		
		//Position the label above the area chart with white text and size 14 font
		adjustmentWarningLabel.setBounds(580, 130, 1000, 100);
		adjustmentWarningLabel.setForeground(Color.WHITE);
		adjustmentWarningLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
		
		//Add the label to the frame
		add(adjustmentWarningLabel);
		
	}
	
}
