package view;

//This concrete class is a frame that displays the histogram for the immigration
//labour force sub-topic. All the specific chart filters/features will be added to
//the filter panel in this class.
public class ImmigrationLabourHistogramFrame extends ImmigrationLabourChartFrame {
	
	//Reference to a GUI panel for the "section" of chart filters
	private ImmigrationLabourChartFilterPanel chartFilterPanel;
	
	//Constructor
	public ImmigrationLabourHistogramFrame() {
		
		setVisible(true);
		
	}
	
	//This method adds a section of chart filters that allows the user to
	//choose which demographics the area chart represents: 
	//sex, employment type, education level, and immigrant status
	@Override
	protected void setUpChartFilterSection() {
		
		
		
	}
	
	//This method adds the last section to the filter panel, which calculates the average
	//figure (number of immigrant employees) over all age groups, with the current filters applied
	@Override
	protected void setUpAverageSection() {
		
		
		
	}
	
}
