package controller;

import java.awt.event.ActionEvent;
import java.util.Scanner;

import view.ImmigrationLabourChartFrame;

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
		
		
		
	}
	
	//This method handles what happens when a button in one of the immigration labour
	//chart frames is pressed
	@Override
	public void actionPerformed(ActionEvent event) {
		
		super.actionPerformed(event);
		
		
		
	}
	
	//This concrete method updates the chart data (could be area chart or histogram)
	//when one of the filters change. Also updates the appearance of the chart.
	@Override
	public void updateChart() {
		
		
		
	}
	
}
