package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;

import model.AverageCalculator;
import model.DatasetManager;
import view.JobspectsMenuFrame;

//This is a general class for all the chart controllers.
//Each of the 5 data sub-topics has its own chart screen, which requires
//a controller class to handle any button presses.
public abstract class ChartController implements ActionListener {
	
	//Object references
	private JobspectsMenuFrame menuFrame;
	private DatasetManager dataset;
	private AverageCalculator averageCalculator;
	
	//Reference to the chart screen that this controller is controlling
	private ChartFrame chartFrame;
	
	//Fields
	private JFreeChart chart;
	
	//Constructor
	public ChartController() {
		
		
		
	}
	
	//This method handles what happens when a button in this controller's 
	//corresponding chart frame is pressed. Every chart controller must be able to
	//navigate back to the main menu whenever the back button is pressed.
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		
	}
	
	//This method calculates the average value of a given data list.
	//The type of average (mean or median) is selected by the user in the chart frame.
	public void calculateAverage(String averageType, ArrayList<Double> data) {
		
		
		
	}
	
	//This abstract method requires concrete classes to define how to initialize
	//and update the chart data when the filters change
	public abstract void updateChart();
	
}
