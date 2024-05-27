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
    private ArrayList<UnemploymentDataRow> unemploymentDuration;
    private ArrayList<PersonEducationIncome> unemploymentDurationUpdated;
	
	
	public UnemploymentDurationChartController(JobspectsMenuFrame menuFrame) {
		
		super(menuFrame);
		
		setChartFrame(new UnemploymentDurationLineChartFrame());
		
		updateChart();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void updateChart() {
		System.out.println("PASS");
		unemploymentDuration = datasetManager.getUnemployment();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getMale(), "Male", String.valueOf(row.getYear()));
        }
		
		for (UnemploymentDataRow row  : unemploymentDuration) {
            dataset.addValue(row.getFemale(), "Female", String.valueOf(row.getYear()));
        }
		
		
//		dataset.addValue(500, "sdfsdf", "2020");
//		dataset.addValue(111, "sdfsdf", "2024");
//		
//		dataset.addValue(520, "(trying again)", "1999");
//		dataset.addValue(1111, "(trying again)", "2024");
		
		setChart(ChartFactory.createLineChart("Placeholder", "Date", "Jobless induviduals", dataset, PlotOrientation.VERTICAL, true, true, false));
		
		
	}
	
	@Override
	//wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}

}