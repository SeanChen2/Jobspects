package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import view.ImmigrationLabourAreaChartFrame;
import view.ImmigrationLabourChartFrame;
import view.ImmigrationLabourHistogramFrame;
import view.JobspectsFrame;

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

	//Reference to the current immigration labour chart screen (area chart or histogram)
	private ImmigrationLabourChartFrame currentChartFrame;
	
	//Field for the CSV data file being read: "Labour Force Estimates by Immigration"
	private Scanner dataFile;
	
	//Constructor
	public ImmigrationLabourChartController() {
		
		//Open the area chart frame by default
		currentChartFrame = new ImmigrationLabourAreaChartFrame();
		
		
		//By default, show the employment figures for the entire labour force, comparing
		//by education level
		getDatasetManager().getFilteredRows().put("Char", "Labour force");
		getDatasetManager().getFilteredRows().put("Immig", new ArrayList<>());
		getDatasetManager().getFilteredRows().get("Immig").add("Total");
		filterEducationLevelColumns();
		
		updateChart();
		
		currentChartFrame.setVisible(true);
		
	}
	
	//This method handles what happens when a button in one of the immigration labour
	//chart frames is pressed
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Check the back button and the "calculate average" button in the superclass
		super.actionPerformed(event);
		
		//Handle navigation between the area chart frame and the histogram frame
		
		//If we are on the histogram frame and want to navigate to the area chart, do so here
		if (currentChartFrame instanceof ImmigrationLabourHistogramFrame &&
				event.getSource() == currentChartFrame.getChartNavButtons()[0])
			switchToFrame(new ImmigrationLabourAreaChartFrame());
		
		//If we are on the area chart frame and want to navigate to the histogram, do so here
		else if (currentChartFrame instanceof ImmigrationLabourAreaChartFrame &&
				event.getSource() == currentChartFrame.getChartNavButtons()[1])
			switchToFrame(new ImmigrationLabourHistogramFrame());
		
		//AREA CHART EXCLUSIVE: handle the "compare by" buttons
		if (currentChartFrame instanceof ImmigrationLabourAreaChartFrame) {
			
			//Downcast the chart frame to an area chart frame, then check all the "compare by" buttons
			ImmigrationLabourAreaChartFrame areaChartFrame = (ImmigrationLabourAreaChartFrame) currentChartFrame;
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
		if (event.getSource() == compareCategoryButtons[0] && !getDatasetManager().getFilteredColumns().contains("High school graduate"))
			filterEducationLevelColumns();
		
		//If the "immigrant status" radio button was pressed, and immigrant status isn't already being compared,
		//filter the dataset so that it includes all the available immigrant status rows
		else if (event.getSource() == compareCategoryButtons[1])
			filterImmigrantStatusRows();
		
	}
	
	//This method adds all the education level columns into the dataset
	private void filterEducationLevelColumns() {
		
		ArrayList<String> filteredColumns = getDatasetManager().getFilteredColumns();
		HashMap<String, ArrayList<String>> filteredRows = getDatasetManager().getFilteredRows();
		
		filteredRows.clear();
		filteredRows.get("Immig").add("Total");
		
		filteredColumns.clear();
		
		filteredColumns.add("No degree, certificate or diploma");
		filteredColumns.add("High school graduate");
		filteredColumns.add("High school graduate, some post-secondary");
		filteredColumns.add("Post-secondary certificate or diploma");
		filteredColumns.add("University degree");
		filteredColumns.add("Bachelor's degree");
		filteredColumns.add("Above bachelor's degree");
		
	}
	
	//This method adds all the immigrant status rows into the dataset
	private void filterImmigrantStatusRows() {
		
		HashMap<String, ArrayList<String>> filteredRows = getDatasetManager().getFilteredRows();
		ArrayList<String> filteredColumns = getDatasetManager().getFilteredColumns();
		
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
	@Override
	public void updateChart() {
		
		//Create the dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(500, "2020", "asdsdf");
		setChart(ChartFactory.createAreaChart("Area Chart Test", "Year", "Number of cats", dataset, PlotOrientation.VERTICAL, true, true, false));
		ChartPanel chartPanel = new ChartPanel(getChart());
		currentChartFrame.getChartPanelTemplate().add(chartPanel);
		
		System.out.println("Chart added");
		
	}
	
	//This method navigates from one chart frame (screen) to another
	private void switchToFrame(ImmigrationLabourChartFrame newFrame) {
		
		//Delete the current frame
		currentChartFrame.dispose();
		
		//Set the current frame to the new frame, then show the new frame
		currentChartFrame = newFrame;
		newFrame.setVisible(true);
		
	}
	
}
