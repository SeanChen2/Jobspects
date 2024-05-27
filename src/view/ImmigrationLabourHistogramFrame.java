package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//This concrete class is a frame that displays the histogram for the immigration
//labour force sub-topic. All the specific chart filters/features will be added to
//the filter panel in this class.
public class ImmigrationLabourHistogramFrame extends ImmigrationLabourChartFrame {
	
	//Constructor: set up all the filter sections of the histogram frame
	public ImmigrationLabourHistogramFrame() {
		
		//Use an average calculation panel without the combo box, since the histogram
		//only displays data based on age ranges (UNFINISHED)
		setAverageCalculationPanel(new AverageCalculationPanel(false));
		
		//Brighten the histogram navigation button to show that this is the current frame
		getChartNavButtons()[0].setBackground(new Color(196, 153, 188));
		getChartNavButtons()[1].setBackground(new Color(232, 192, 225));
		
		//Add all the sections of filters to the filter panel
		setUpChartFilterSection();
		setUpDatePickerSection();
		setUpAverageSection();
		
	}
	
	//This method adds a section of chart filters that allows the user to
	//choose which demographic the area chart represents: 
	//sex, employment type, education level, or immigrant status
	@Override
	protected void setUpChartFilterSection() {
		
		//Create a section of chart filters that includes sex and employment type, education level, and immigrant status
		setChartFilterSection(new ImmigrationLabourChartFilterPanel(getFilterPanel(), true, true, true, true));
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		getChartFilterSection().setPreferredSize(new Dimension(1600, 1100));
		getChartFilterSection().setMaximumSize(new Dimension(1600, 1100));
		
		//Adjust the height of the container that holds all the chart filters
		JPanel filterSectionContainer = getChartFilterSection().getFilterSectionContainer();
		filterSectionContainer.setSize(new Dimension(filterSectionContainer.getWidth(), 1100));

		//Add the section of chart filters to the filter panel
		getFilterPanel().add(getChartFilterSection());
		
	}
	
	//This method adds a section that contains a slider, which allows the user to
	//select which year to display the data for
	@Override
	protected void setUpDatePickerSection() {
		
		//Set up and add a section with a slider to allow the user to pick the year
		setDatePickerSection(new ImmigrationLabourDatePickerPanel(getFilterPanel(), false));
		getFilterPanel().add(getDatePickerSection());
		
	}
	
	//This method adds the last section to the filter panel, which calculates the average
	//figure (number of immigrant employees) over all age groups, with the current filters applied
	@Override
	protected void setUpAverageSection() {
		
		//UNFINISHED
		
	}
	
}
