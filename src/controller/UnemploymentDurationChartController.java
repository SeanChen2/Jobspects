package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import view.JobspectsMenuFrame;
import view.UnemploymentDurationLineChartFrame;
import model.DatasetManager;
import model.PersonEducationIncome;
import model.UnemploymentDataRow;


public class UnemploymentDurationChartController extends ChartController implements ActionListener{
	
	//Create instance of the dataset Manager
    private DatasetManager datasetManager = new DatasetManager();
	JButton[] chartNavButtons;
    private ButtonGroup compareGroup;
    //create new Arraylist of Data rows fror
    private ArrayList<UnemploymentDataRow> unemploymentDuration = new ArrayList<>();
	
	
	public UnemploymentDurationChartController(JobspectsMenuFrame menuFrame) {
		//Get methods & variables from superclass
		super(menuFrame);
		//Setup the frame, implementing the title and back button
		setChartFrame(new UnemploymentDurationLineChartFrame());
		//initially setup the chart
		updateChart();
	}

	@Override
	public void updateChart() {
		//Add info from dataset to arraylist
		unemploymentDuration = datasetManager.getUnemployment();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//create values for one line on line chart
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getMale()*10, "Male", String.valueOf(row.getYear()));
        }
		
		//create values for other line on line chart
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getFemale()*10, "Female", String.valueOf(row.getYear()));
        }
		

		//Create chart and setup axis and title
		setChart(ChartFactory.createLineChart("Unemployment in Ontario", "Year", "Number of People", dataset, PlotOrientation.VERTICAL, true, true, false));
		
		
	}
	
	@Override
	//wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}

}