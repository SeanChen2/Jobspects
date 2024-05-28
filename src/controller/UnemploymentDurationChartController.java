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

import view.ImmigrationLabourChartFrame;
import view.JobspectsMenuFrame;
import view.UnemploymentDurationLineChartFrame;
import model.DatasetManager;
import model.PersonEducationIncome;
import model.UnemploymentDataRow;

public class UnemploymentDurationChartController extends ChartController implements ActionListener {

	// Create instance of the dataset Manager
	private DatasetManager datasetManager = new DatasetManager();
	JButton[] chartNavButtons;
	private ButtonGroup compareGroup;
	// create new Arraylist of Data rows fror
	private ArrayList<UnemploymentDataRow> unemploymentDuration = new ArrayList<>();
	private int sexButtoncounter = 0;

	public UnemploymentDurationChartController(JobspectsMenuFrame menuFrame) {
		// Get methods & variables from superclass
		super(menuFrame);
		// Setup the frame, implementing the title and back button
		setChartFrame(new UnemploymentDurationLineChartFrame());
		
		//Create instance of UnemploymentDurationChartFrame
		UnemploymentDurationLineChartFrame UnemploymentDurationChartFrame = (UnemploymentDurationLineChartFrame) getChartFrame();
		//Add actionlisteners to sexButtons
		UnemploymentDurationChartFrame.getMaleButton().addActionListener(this);
		UnemploymentDurationChartFrame.getFemaleButton().addActionListener(this);
		UnemploymentDurationChartFrame.getAllButton().addActionListener(this);
		

		// initially setup the chart
		updateChart();
	}

	@Override
	public void updateChart() {
		// Add info from dataset to arraylist
		unemploymentDuration = datasetManager.getUnemployment();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//Only create chart if sexButtons: all or Male are selected
		if (sexButtoncounter <= 1) {
			// create values for one line on line chart
			for (UnemploymentDataRow row : unemploymentDuration) {
				dataset.addValue(row.getMale() * 10, "Male", String.valueOf(row.getYear()));
			}
		}
		//Only create chart if sexButtons: all or Female are selected
		if (sexButtoncounter == 0 || sexButtoncounter == 2) {
			// create values for other line on line chart
			for (UnemploymentDataRow row : unemploymentDuration) {
				dataset.addValue(row.getFemale() * 10, "Female", String.valueOf(row.getYear()));
			}
		}
		
		
		// Create chart and setup axis and title
		setChart(ChartFactory.createLineChart("Unemployment in Ontario", "Year", "Number of People", dataset,
				PlotOrientation.VERTICAL, true, true, false));
		
		//Refresh the frame to make sure the new chart displays
		getChartFrame().revalidate();
		getChartFrame().repaint();

	}

	@Override
	// wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}
	
	   public void actionPerformed(ActionEvent e) {
	        super.actionPerformed(e);
	        checkChartFilterButtons(e);
	    }

	//This method is an extension of the actionPerformed() method. It performs actions for all the filter buttons
	private void checkChartFilterButtons(ActionEvent event) {
		//create instance of UnemploymentDurationLineChartFrame
		UnemploymentDurationLineChartFrame UnemploymentDurationChartFrame = (UnemploymentDurationLineChartFrame) getChartFrame();
		//Listener for "All" radio button
		if (event.getSource() == UnemploymentDurationChartFrame.getAllButton()) {
			sexButtoncounter = 0;
			//refresh chart
			updateChart();
		}
		//Listener for "Male" radio button
		else if (event.getSource() == UnemploymentDurationChartFrame.getMaleButton()) {
			sexButtoncounter = 1;
			//refresh chart
			updateChart();
		}
		//Listener for "Female" radio button
		else if (event.getSource() == UnemploymentDurationChartFrame.getFemaleButton()) {
			sexButtoncounter = 2;
			//refresh chart
			updateChart();
		}
	}
}