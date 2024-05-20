package controller;

import java.awt.FlowLayout;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.DatasetManager;
import model.PersonEducationIncome;

public class WagesByEducationChartController extends ChartController {
    private JPanel chartPanelTemplate;
    private DatasetManager datasetManager;
    private JPanel filterPanelTemplate;

    // Constructor Method
    public WagesByEducationChartController(JPanel chartPanelTemplate, DatasetManager datasetManager, JPanel filterPanelTemplate) {
        this.chartPanelTemplate = chartPanelTemplate;
        this.datasetManager = datasetManager;
        this.filterPanelTemplate = filterPanelTemplate;
        createChart();
        createFilterPanel();
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
    
    public void createFilterPanel() {
        // Create the filter panel
        filterPanelTemplate.setVisible(true);
        
        // Set the layout manager
        filterPanelTemplate.setLayout(new FlowLayout());

        JLabel title = new JLabel();
        title.setText("Filter By:");
        filterPanelTemplate.add(title);
        
        // Create radio buttons
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        JRadioButton radioButton3 = new JRadioButton("Option 3");

        // Create a button group to group the radio buttons
        ButtonGroup year = new ButtonGroup();
        year.add(radioButton1);
        year.add(radioButton2);
        year.add(radioButton3);
        
        filterPanelTemplate.add(radioButton1);
        filterPanelTemplate.add(radioButton2);
        filterPanelTemplate.add(radioButton3);
        
        // Repaint the parent container to reflect changes
        filterPanelTemplate.revalidate();
        filterPanelTemplate.repaint();
    }
}