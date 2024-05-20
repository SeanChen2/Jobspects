package controller;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JPanel;
import model.DatasetManager;
import model.PersonEducationIncome;

public class WagesByEducationChartController extends ChartController {
    private JPanel chartPanelTemplate;
    private DatasetManager datasetManager;

    // Constructor Method
    public WagesByEducationChartController(JPanel chartPanelTemplate, DatasetManager datasetManager ) {
        this.chartPanelTemplate = chartPanelTemplate;
        this.datasetManager = datasetManager;
        createChart();
    }

    @Override
    public void updateChart() {
        // TODO Auto-generated method stub
    }

    @Override
    protected ArrayList<Double> getValuesForAverage() {
        // TODO Auto-generated method stub
        return null;
    }

    // This method creates the chart
    public void createChart() {
    	
    	// Create the dataset
        XYSeries series = new XYSeries("Data");
        
        // Create an arraylist in this file to easily reference the object
        ArrayList<PersonEducationIncome> yearsOfEdu = datasetManager.getPerson();
        
        // Loop through the array and begin inputting the data into the graph
        for (int i = 0; i < yearsOfEdu.size(); i++) {
            series.add(yearsOfEdu.get(i).getYearsOfEducation(), yearsOfEdu.get(i).getAverageIncome());
        }

        // Add it to the chart
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Weekly Income Versus Years of Education",
            "Years of Education",
            "Average Weekly Income ($)",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        // Create the panel and set dimensions
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanelTemplate.setLayout(new java.awt.BorderLayout());
        chartPanelTemplate.add(chartPanel, java.awt.BorderLayout.CENTER);
        
        // Make sure the chart appears
        chartPanelTemplate.revalidate();
        chartPanelTemplate.repaint();
    }
}