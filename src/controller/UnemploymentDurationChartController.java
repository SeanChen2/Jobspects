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
	
    private DatasetManager datasetManager = new DatasetManager();
	JButton[] chartNavButtons;
    private ButtonGroup compareGroup;
    private ArrayList<UnemploymentDataRow> unemploymentDuration = new ArrayList<>();
    private ArrayList<PersonEducationIncome> unemploymentDurationUpdated = new ArrayList<>();
	
	
	public UnemploymentDurationChartController(JobspectsMenuFrame menuFrame) {
		
		super(menuFrame);
		
		setChartFrame(new UnemploymentDurationLineChartFrame());
		
		updateChart();
	}

	@Override
	public void updateChart() {
		unemploymentDuration = datasetManager.getUnemployment();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getMale(), "Male", String.valueOf(row.getYear()));
        }
		
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getFemale(), "Female", String.valueOf(row.getYear()));
        }
		

		
		setChart(ChartFactory.createLineChart("Unemployment in Ontario", "Year", "Number of People", dataset, PlotOrientation.VERTICAL, true, true, false));
		
		
	}
	
	@Override
	//wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}

}