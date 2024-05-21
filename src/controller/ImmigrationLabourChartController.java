package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JRadioButton;

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
public class ImmigrationLabourChartController extends ChartController {
	
	//Reference to the immigration labour dataset manager
	private ImmigrationDatasetManager datasetManager = new ImmigrationDatasetManager();
	
	//Field for the CSV data file being read: "Labour Force Estimates by Immigration"
	private Scanner dataFile;
	
	//Constructor
	public ImmigrationLabourChartController(JobspectsMenuFrame menuFrame) {
		
		super(menuFrame);
		
		//Open the area chart frame by default
		setChartFrame(new ImmigrationLabourAreaChartFrame());
		
		//By default, show the employment figures for the entire labour force in Canada
		datasetManager.setCategoryColumn("Month");
		datasetManager.addRowRestraint("Province", "Canada");
		datasetManager.addRowRestraint("Immigrant status", "Total");
		datasetManager.addRowRestraint("Employment type", "Labour force");
		datasetManager.addRowRestraint("Sex", "Both Sexes");
		datasetManager.addRowRestraint("Age", "15 Years +");
		
		//By default, each area on the chart represents a different education level
		filterEducationLevelColumns();
		
		updateChart();
		showChartFrame();
		
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
		
		//AREA CHART EXCLUSIVE: handle the "compare by" buttons
		if (immigrationChartFrame instanceof ImmigrationLabourAreaChartFrame) {
			
			//Downcast the chart frame to an area chart frame, then check all the "compare by" buttons
			ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) immigrationChartFrame;
			checkCompareCategoryButtons(areaChartFrame.getCompareCategorySection().getCompareCategoryButtons(), event);
			
		}
		
		//For both chart frames: handle the "filter by" buttons
		checkChartFilterButtons(event);
		
	}
	
	//This method is an extension of the actionPerformed() method. It performs actions for
	//all the "compare by" buttons, which are found only in the area chart frame.
	private void checkCompareCategoryButtons(JRadioButton[] compareCategoryButtons, ActionEvent event) {
		
		//If the "education level" radio button was pressed, and education level isn't already being compared,
		//filter the dataset so that it includes all the education level columns
		if (event.getSource() == compareCategoryButtons[0] && !datasetManager.getFilteredColumns().contains("High school graduate"))
			filterEducationLevelColumns();
		
		//If the "immigrant status" radio button was pressed, and immigrant status isn't already being compared,
		//filter the dataset so that it includes all the available immigrant status rows
		else if (event.getSource() == compareCategoryButtons[1])
			filterImmigrantStatusRows();
		
	}
	
	//This method adds all the education level columns into the dataset
	private void filterEducationLevelColumns() {
		
		//Display data for all immigrant statuses
		datasetManager.getFilteredRows().put("Immigrant status", "Total");
		
		//Retrieve the list of value columns from the dataset manager, and clear it
		ArrayList<String> valueColumns = datasetManager.getValueColumns();
		valueColumns.clear();
		
		valueColumns.add("No certifications");
		valueColumns.add("High school graduate");
		valueColumns.add("High school graduate, some post-secondary");
		valueColumns.add("Post-secondary certificate or diploma");
		valueColumns.add("University degree");
		valueColumns.add("Bachelor's degree");
		valueColumns.add("Above bachelor's degree");
		
	}
	
	//This method adds all the immigrant status rows into the dataset
	private void filterImmigrantStatusRows() {
		
		HashMap<String, ArrayList<String>> filteredRows = datasetManager.getFilteredRows();
		ArrayList<String> filteredColumns = datasetManager.getFilteredColumns();
		
		filteredColumns.clear();
		filteredColumns.add("Total, all education levels");
		
		filteredRows.get("Immig").clear();
		
		filteredRows.get("Immig").add("Born in Canada");
		filteredRows.get("Immig").add("Very recent immigrants, 5 years or less");
		filteredRows.get("Immig").add("Recent immigrants 5+ to 10 years");
		filteredRows.get("Immig").add("Established immigrants, 10+ years");
		filteredRows.get("Immig").add("Non-landed immigrants");
		
	}
	
	//This method is an extension of the actionPerformed() method. It performs actions for
	//all the chart filter buttons, which are found in both the area chart and histogram frames.
	private void checkChartFilterButtons(ActionEvent event) {
		
		
		
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
			
			//TODO: dynamic year choosing
			
			//Create the area chart from the filtered dataset
			setChart(ChartFactory.createAreaChart("Immigration Labour Force in Canada - " + "2020", "Month", "Number of employed Canadians", 
					filteredDataset, PlotOrientation.VERTICAL, true, true, false));
			
			//Make the chart's areas translucent so that the overlap is visible
			getChart().getCategoryPlot().setForegroundAlpha(0.5f);
			
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
