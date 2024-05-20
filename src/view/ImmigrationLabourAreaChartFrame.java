package view;

import java.awt.Color;

//This concrete class is a frame that displays the area chart for the immigration
//labour force sub-topic. All the specific chart filters/features will be added to
//the filter panel in this class.
public class ImmigrationLabourAreaChartFrame extends ImmigrationLabourChartFrame {
	
	//References to GUI panels for the "sections" of chart filters
	private ImmigrationLabourCompareCategoryPanel compareCategorySection = new ImmigrationLabourCompareCategoryPanel(getFilterPanel());

	//Constructor
	public ImmigrationLabourAreaChartFrame() {
		
		//Use an average calculation panel with a combo box to select which data 
		//category to calculate the average for
		setAverageCalculationPanel(new AverageCalculationPanel(true));
		
		setUpCompareCategorySection();
		setUpChartFilterSection();
		setUpAverageSection();
		
	}
	
	//Getter for the section of radio buttons that chooses what category
	//each "area" on the chart represents
	public ImmigrationLabourCompareCategoryPanel getCompareCategorySection() {
		return compareCategorySection;
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
		getFilterPanel().add(getChartFilterSection());
		
	}
	
	//This method adds the last section to the filter panel, which calculates the average
	//figure (number of immigrant employees) over the years for a user-specified
	//education level OR immigrant status, with the current filters applied
	@Override
	protected void setUpAverageSection() {
		
		
		
	}
	
}
