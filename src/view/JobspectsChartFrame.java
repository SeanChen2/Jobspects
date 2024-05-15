package view;

import javax.swing.*;
import org.jfree.chart.ChartPanel;

//This is a general class for all 5 chart frames in the project.
//Each data sub-topic has its own chart frame, all of which share
//common design elements that are defined in this abstract class.
public abstract class JobspectsChartFrame extends JobspectsFrame {
	
	//Object references
	private AverageCalculationPanel averageCalculationPanel;
	
	//Fields
	private JButton backButton;
	private JLabel screenTitleLabel;
	private ChartPanel chartPanel;
	
	//Constructor method:
	public JobspectsChartFrame() {
		
		
		
	}
	
	//Necessary getters for GUI elements on the frame
	public JButton getBackButton() {
		return backButton;
	}

	public ChartPanel getChartPanel() {
		return chartPanel;
	}
	
	//This method sets up a large, empty panel on the left side of the screen, used
	//to hold a chart later on
	private void setUpChartPanel() {
		
		
		
	}
	
	//This method sets up the basic appearance of the chart frame, including:
	//a back button, screen title, and chart panel
	private void setUpFrame() {
		
		
		
	}
	
}
