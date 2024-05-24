package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.*;
import model.ImmigrationDatasetManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;

//This is the controller class for the immigration labour chart screens.
//This controller handles the navigation between the area chart and histogram frames,
//as well as the button presses for both frames.
public class ImmigrationLabourChartController extends ChartController implements ChangeListener {
	
	//Reference to the immigration labour dataset manager
	private ImmigrationDatasetManager datasetManager;
	
	//Constructor
	public ImmigrationLabourChartController(JobspectsMenuFrame menuFrame) {
		
		super(menuFrame);
		
		//This controller controls the area chart frame by default
		setChartFrame(new ImmigrationLabourAreaChartFrame());
		
	}
	
	//Overrided version of the superclass method that shows the chart frame.
	//To accommodate the long loading time when the data is read, only read the
	//CSV file data when the chart frame is opened.
	@Override
	public void showChartFrame() {
		
		//Finally, show the actual chart frame as usual
		super.showChartFrame();
		
		//Additionally, read in the file data by initializing the dataset manager and
		//adding default filters
		datasetManager = new ImmigrationDatasetManager();
		
		//By default, show the employment figures for the entire labour force in Canada
		datasetManager.setCategoryColumn("Year");
		datasetManager.addRowRestraint("Province", "Canada");
		datasetManager.addRowRestraint("Immigrant status", "Total");
		datasetManager.addRowRestraint("Employment type", "Labour force");
		datasetManager.addRowRestraint("Sex", "Both Sexes");
		datasetManager.addRowRestraint("Age", "15 Years +");
		
		//By default, the chart will display date for all 15 years
		datasetManager.setRequestedYear(-1);
		
		//By default, each area on the chart represents a different education level
		filterEducationLevelColumns();
		
		//Listen for when any of the buttons on the chart frame are pressed
		addActionListeners();
		
		//Automatically make the default chart filter buttons selected
		showDefaultFilters();
		
		//Post the initial chart onto the chart panel
		updateChart();
		
	}
	
	//This method adds action listeners to all the interactive elements on the chart frame
	private void addActionListeners() {
		
		//Downcast the chart frame to an immigration chart frame to access the nav buttons
		ImmigrationLabourChartFrame immigrationChartFrame = (ImmigrationLabourChartFrame) getChartFrame();
		
		//Add action listeners to the nav buttons (navigating between area chart and histogram)
		for (JButton chartNavButton : immigrationChartFrame.getChartNavButtons())
			chartNavButton.addActionListener(this);
		
		//AREA CHART EXCLUSIVE: add action listeners to the "compare category" buttons and the date type picker radio buttons.
		//Also, add a change listener to the year slider.
		if (immigrationChartFrame instanceof ImmigrationLabourAreaChartFrame) {
			
			//Downcast the chart frame to an area chart frame
			ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) immigrationChartFrame;
			
			//Add action listeners to the "compare category" buttons
			for (JRadioButton compareCategoryButton : areaChartFrame.getCompareCategorySection().getCompareCategoryButtons())
				compareCategoryButton.addActionListener(this);
			
			//Add action listeners to the date type picker radio buttons
			for (JRadioButton dateTypePickerButton : areaChartFrame.getDatePickerSection().getDateTypePickerButtons())
				dateTypePickerButton.addActionListener(this);
			
			//Add a change listener to the year slider
			areaChartFrame.getDatePickerSection().getYearSlider().addChangeListener(this);
				
		}
		
		//Add action listeners to the chart filter buttons, if they exist in this frame
		for (JRadioButton[] buttonArray : immigrationChartFrame.getChartFilterSection().getFilterButtons())
			for (JRadioButton filterButton : buttonArray)
				if (filterButton != null)
					filterButton.addActionListener(this);
	
	}
	
	//This method automatically "selects" the radio buttons for the default chart filters
	private void showDefaultFilters() {
		
		//Downcast to an immigration labour chart frame (area chart OR histogram) to access the
		//chart filter buttons
		ImmigrationLabourChartFrame immigrationChartFrame = (ImmigrationLabourChartFrame) getChartFrame();
		
		//Set all the default chart filters to selected
		immigrationChartFrame.getChartFilterSection().getSexButtons()[2].setSelected(true);	//Both sexes
		immigrationChartFrame.getChartFilterSection().getEmploymentTypeButtons()[2].setSelected(true);	//Entire labour force
		
		//Only the histogram chart frame has the education level and immigrant status filters
		if (immigrationChartFrame instanceof ImmigrationLabourHistogramFrame) {
			immigrationChartFrame.getChartFilterSection().getEducationLevelButtons()[5].setSelected(true);	//All education levels
			immigrationChartFrame.getChartFilterSection().getImmigrantStatusButtons()[5].setSelected(true);	//Total immigrants
		}
		
		//AREA CHART EXCLUSIVE: set the default compare category buttons and date picker buttons to selected
		if (immigrationChartFrame instanceof ImmigrationLabourAreaChartFrame) {
			
			//Downcast to the area chart frame to access its unique radio buttons
			ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) immigrationChartFrame;
			
			areaChartFrame.getCompareCategorySection().getCompareCategoryButtons()[0].setSelected(true);	//Compare education levels
			areaChartFrame.getDatePickerSection().getDateTypePickerButtons()[0].setSelected(true);	//Display all 15 years
			
		}
		
	}
	
	//This method handles what happens when a button in one of the immigration labour
	//chart frames is pressed
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Check the back button and the "calculate average" button in the superclass
		super.actionPerformed(event);
		
		//Handle navigation between the area chart frame and the histogram frame.
		//First, downcast the chart frame to an immigration chart frame to access the nav buttons.
		ImmigrationLabourChartFrame immigrationChartFrame = (ImmigrationLabourChartFrame) getChartFrame();
		
		//If we are on the histogram frame and want to navigate to the area chart, do so here
		if (immigrationChartFrame instanceof ImmigrationLabourHistogramFrame &&
				event.getSource() == immigrationChartFrame.getChartNavButtons()[0])
			switchToFrame(new ImmigrationLabourAreaChartFrame());
		
		//If we are on the area chart frame and want to navigate to the histogram, do so here
		else if (immigrationChartFrame instanceof ImmigrationLabourAreaChartFrame &&
				event.getSource() == immigrationChartFrame.getChartNavButtons()[1])
			switchToFrame(new ImmigrationLabourHistogramFrame());
		
		//AREA CHART EXCLUSIVE: handle the "compare by" buttons AND the date picker buttons/slider
		else if (immigrationChartFrame instanceof ImmigrationLabourAreaChartFrame) {
			
			//Downcast the chart frame to an area chart frame, then check all the "compare by" buttons
			ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) immigrationChartFrame;
			checkCompareCategoryButtons(areaChartFrame.getCompareCategorySection().getCompareCategoryButtons(), event);
			checkDatePickerElements(areaChartFrame, event);
			
		}
		
		//For both chart frames: handle the "filter by" buttons
		checkChartFilterButtons(event);
		
	}
	
	//This method is an extension of the actionPerformed() method. It performs actions for
	//all the "compare by" buttons, which are found only in the area chart frame.
	private void checkCompareCategoryButtons(JRadioButton[] compareCategoryButtons, ActionEvent event) {
		
		//If the "education level" radio button was pressed, and education level isn't already being compared,
		//filter the dataset so that it includes all the education level columns. Then, show the new chart.
		if (event.getSource() == compareCategoryButtons[0] && !datasetManager.getValueColumns().contains("High school graduate")) {
			filterEducationLevelColumns();
			updateChart();
		}
		
		//If the "immigrant status" radio button was pressed, and immigrant status isn't already being compared,
		//filter the dataset so that it includes all the available immigrant status rows. Then, show the new chart.
		else if (event.getSource() == compareCategoryButtons[1] && (datasetManager.getSeriesColumn() == null || 
				!datasetManager.getSeriesColumn().equals("Immigrant status"))) {
			filterImmigrantStatusRows();
			updateChart();
		}
		
	}
	
	//This method adds all the education level columns into the dataset
	private void filterEducationLevelColumns() {
		
		//Display data for all immigrant statuses
		datasetManager.setSeriesColumn(null);
		datasetManager.removeRowRestraint("Immigrant status");
		datasetManager.addRowRestraint("Immigrant status", "Total");
		
		//Retrieve the list of value columns from the dataset manager, and clear it
		ArrayList<String> valueColumns = datasetManager.getValueColumns();
		valueColumns.clear();
		
		valueColumns.add("No certifications");
		valueColumns.add("High school graduate");
		valueColumns.add("High school graduate, some post-secondary");
		valueColumns.add("Post-secondary certificate or diploma");
		valueColumns.add("Bachelor's degree");
		valueColumns.add("Above bachelor's degree");
		
	}
	
	//This method adds all the immigrant statuses as "series" in the dataset
	private void filterImmigrantStatusRows() {
		
		//Display data for all education levels (total)
		datasetManager.getValueColumns().clear();
		datasetManager.getValueColumns().add("All education levels");
		
		//Make the immigrant statuses define separate series on the area chart
		datasetManager.removeRowRestraint("Immigrant status");
		datasetManager.setSeriesColumn("Immigrant status");
		
		//Restrict which immigrant statuses are included as series
		datasetManager.addRowRestraint("Immigrant status", "Born in Canada");
		datasetManager.addRowRestraint("Immigrant status", "Very recent immigrants; 5 years or less");
		datasetManager.addRowRestraint("Immigrant status", "Recent immigrants; 5+ to 10 years");
		datasetManager.addRowRestraint("Immigrant status", "Established immigrants; 10+ years");
		datasetManager.addRowRestraint("Immigrant status", "Non-landed immigrants");
		
	}
	
	//This method is an extension of the actionPerformed() method. It performs actions for
	//all the chart filter buttons, which are found in both the area chart and histogram frames.
	private void checkChartFilterButtons(ActionEvent event) {
		
		//First, downcast the chart frame to an immigration chart frame to access the filter buttons
		ImmigrationLabourChartFrame immigrationChartFrame = (ImmigrationLabourChartFrame) getChartFrame();
		
		//If a sex selection button was pressed, filter the dataset so that it only displays data for that sex
		for (JRadioButton sexButton : immigrationChartFrame.getChartFilterSection().getSexButtons()) {
			if (event.getSource() == sexButton) {
				datasetManager.removeRowRestraint("Sex");
				datasetManager.addRowRestraint("Sex", sexButton.getText().trim());
				updateChart();
			}
		}
		
		//If an employment type button was pressed, filter the dataset so that it only displays data 
		//for that employment type
		for (JRadioButton employmentTypeButton : immigrationChartFrame.getChartFilterSection().getEmploymentTypeButtons()) {
			if (event.getSource() == employmentTypeButton) {
				datasetManager.removeRowRestraint("Employment type");
				datasetManager.addRowRestraint("Employment type", employmentTypeButton.getText().trim());
				updateChart();
			}
		}
		
		//If an education level button was pressed, filter the dataset so that it only displays data for
		//that education level
		for (JRadioButton educationLevelButton : immigrationChartFrame.getChartFilterSection().getEducationLevelButtons()) {
			if (event.getSource() == educationLevelButton) {
				datasetManager.removeRowRestraint("Education level");
				datasetManager.addRowRestraint("Education level", educationLevelButton.getText().trim());
				updateChart();
			}
		}
		
		//If an immigrant status button was pressed, filter the dataset so that it only displays data for
		//that immigrant status
		for (JRadioButton immigrantStatusButton : immigrationChartFrame.getChartFilterSection().getImmigrantStatusButtons()) {
			if (event.getSource() == immigrantStatusButton) {
				datasetManager.removeRowRestraint("Immigrant status");
				datasetManager.addRowRestraint("Immigrant status", immigrantStatusButton.getText().trim());
				updateChart();
			}
		}
		
	}
	
	//This method is an extension of the actionPerformed() method. It performs actions for
	//the date type picker radio buttons, and makes sure that the year slider only appears
	//if the user chooses to display data for a single year.
	private void checkDatePickerElements(ImmigrationLabourAreaChartFrame areaChartFrame, ActionEvent event) {
		
		//If the "15 years" button was clicked, make the year slider invisible, then 
		//make the chart display data for 15 years
		if (event.getSource() == areaChartFrame.getDatePickerSection().getDateTypePickerButtons()[0]) {
			
			areaChartFrame.getDatePickerSection().getYearSlider().setVisible(false);
			datasetManager.setRequestedYear(-1);
			datasetManager.setCategoryColumn("Year");
			
			//Also, display a warning label for the artificially adjusted years of 2006 and 2020
			areaChartFrame.getAdjustmentWarningLabel().setVisible(true);
			
			updateChart();
			
		}
		
		//If the "Single year" button was clicked, make the year slider visible, then
		//make the chart display data for the 12 months of the chosen year
		else if (event.getSource() == areaChartFrame.getDatePickerSection().getDateTypePickerButtons()[1]) {
			
			areaChartFrame.getDatePickerSection().getYearSlider().setVisible(true);
			datasetManager.setRequestedYear(areaChartFrame.getDatePickerSection().getYearSlider().getValue());
			datasetManager.setCategoryColumn("Month");
			
			//Also, hide the warning label for 2006 and 2020, since it does not apply to the single year option
			areaChartFrame.getAdjustmentWarningLabel().setVisible(false);
			
			updateChart();
			
		}
		
	}
	
	//This method is called every time the selected value of the year slider changes.
	//When this occurs, the chart will be updated to display data for the newly selected year.
	@Override
	public void stateChanged(ChangeEvent event) {
		
		//Downcast the chart frame to an area chart frame to access the year slider
		ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) getChartFrame();
		
		//If the slider's value changed, update the chart so that it displays data for the chosen year
		if (event.getSource() == areaChartFrame.getDatePickerSection().getYearSlider()) {
			
			datasetManager.setRequestedYear(areaChartFrame.getDatePickerSection().getYearSlider().getValue());
			updateChart();
			
		}
		
	}
	
	//This concrete method returns a list of values to calculate the average of.
	//For the area chart, the average is calculated over the years, and the category
	//combo box must be considered. For the histogram, the average is calculated over 
	//the age groups. 
	@Override
	protected ArrayList<Double> getValuesForAverage() {
		
		return null;
		
	}
	
	//This concrete method updates the chart data (could be area chart or histogram)
	//when one of the filters change. Also updates the appearance of the chart.
	//Source for area customization: http://www.java2s.com/Code/Java/Chart/JFreeChartAreaChartDemo.htm
	@Override
	public void updateChart() {
		
		if (getChartFrame() instanceof ImmigrationLabourAreaChartFrame) {
			
			//Get the dataset with all filters applied, from the dataset manager
			DefaultCategoryDataset filteredDataset = datasetManager.getFilteredDataset();
			
			//Get the year being displayed on the chart (or the entire range 2006-2020), so it can be included in the title
			String yearsDisplayed = (datasetManager.getRequestedYear() == -1) ? "2006-2020" : Integer.toString(datasetManager.getRequestedYear());
			
			//Create the stacked area chart from the filtered dataset
			setChart(ChartFactory.createStackedAreaChart("Immigration Labour Force in Canada - " + yearsDisplayed, 
					datasetManager.getCategoryColumn(), "Number of employed Canadians", filteredDataset, PlotOrientation.VERTICAL, true, true, false));
			
			//Make the stacked area chart continuous (Source: https://stackoverflow.com/a/7716930)
			getChart().getCategoryPlot().getDomainAxis().setCategoryMargin(0);
			
			getChartFrame().revalidate();
			getChartFrame().repaint();
			
		}
		
	}
	
	//This method navigates from one chart frame (screen) to another
	private void switchToFrame(ImmigrationLabourChartFrame newFrame) {
		
		//Delete the current frame
		getChartFrame().dispose();
		
		//Set the current frame to the new frame, then show the new frame
		setChartFrame(newFrame);
		newFrame.setVisible(true);
		
	}
	
}
