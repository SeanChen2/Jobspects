package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;

import model.AverageCalculator;
import model.DatasetManager;
import view.JobspectsChartFrame;
import view.JobspectsMenuFrame;

//This is a general class for all the chart controllers.
//Each of the 5 data sub-topics has its own chart screen, which requires
//a controller class to handle any button presses.
public abstract class ChartController implements ActionListener {
	
	//Object references
	private JobspectsMenuFrame menuFrame;
	private AverageCalculator averageCalculator;
	
	//Reference to the chart screen that this controller is controlling
	private JobspectsChartFrame chartFrame;
	
	//Reference to the chart displayed in the chart panel
	private JFreeChart chart;
	
	//Constructor
	public ChartController(JobspectsMenuFrame menuFrame) {
		this.menuFrame = menuFrame;
		
	}
	
	//Necessary getters and setters for objects
	
	public JFreeChart getChart() {
		return chart;
	}
	
	//Special setter: also posts the chart onto the chart panel template
	public void setChart(JFreeChart chart) {
		this.chart = chart;
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(0, 0, chartFrame.getChartPanelTemplate().getWidth(), chartFrame.getChartPanelTemplate().getHeight());
		
		//Remove the current chart, then add the new one
		chartFrame.getChartPanelTemplate().removeAll();
		chartFrame.getChartPanelTemplate().add(chartPanel);
	}
	
	public JobspectsChartFrame getChartFrame() {
		return chartFrame;
	}
	
	
	//Special setter: also adds action listeners to the back button and average calculation button
	public void setChartFrame(JobspectsChartFrame chartFrame) {
		this.chartFrame = chartFrame;
		
		chartFrame.getBackButton().addActionListener(this);
		chartFrame.getAverageCalculationPanel().getCalculateAverageButton().addActionListener(this);
	}
	
	//This method shows the chart frame that this controller is controlling
	public void showChartFrame() {
		chartFrame.setVisible(true);
	}
	
	//This method handles what happens when a button in this controller's 
	//corresponding chart frame is pressed. Every chart controller must be able to
	//navigate back to the main menu whenever the back button is pressed, and
	//calculate an average value when the "Calculate" button is pressed.
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//If the chart frame's back button was pressed, navigate to the main menu
		if (event.getSource() == chartFrame.getBackButton()) {
			
			chartFrame.setVisible(false);
			menuFrame.setVisible(true);
			
		}
		
		//If the chart frame's average calculation button was pressed, calculate the average
		if (event.getSource() == chartFrame.getAverageCalculationPanel().getCalculateAverageButton())
			calculateAverage();
		
	}
	
	//This abstract method requires concrete classes to define how to initialize
	//and update the chart data when the filters change
	public abstract void updateChart();
	
	//This abstract method requires concrete classes to return a list of values for
	//the average calculation
	protected abstract ArrayList<Double> getValuesForAverage();
	
	//This method calculates an average value of the chart data with filters applied.
	//The type of average (mean or median) is selected by the user in the chart frame.
	//Then, this average is displayed on the result label.
	public void calculateAverage() {
		
		//Retrieve the requested average type (mean or median), and
		//the list of values to calculate the average for
		String averageType = (String) chartFrame.getAverageCalculationPanel().getAverageTypeComboBox().getSelectedItem();
		ArrayList<Double> data = getValuesForAverage();
		
		//Initialize the average calculator object with the list of values
		averageCalculator = new AverageCalculator(data);
		
		//Based on the requested average type (mean or median), calculate the average
		double average = 0.0;
		
		if (averageType.equals("Mean"))
			average = averageCalculator.calculateMean();
		else if (averageType.equals("Median"))
			average = averageCalculator.calculateMedian();
		
		//Post the calculated average (rounded to 2 decimal places) onto the result label
		chartFrame.getAverageCalculationPanel().getResultLabel().setText(String.format("%.2f", average));
		
	}

	protected JobspectsMenuFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(JobspectsMenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
}
