package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;

import model.DatasetManager;
import model.PersonEducationIncome;
import view.JobspectsMenuFrame;
import view.WagesByEducationScatterplotFrame;

public class WagesByEducationChartController extends ChartController {
    
	private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;
    
    private DatasetManager datasetManager = new DatasetManager();
    private JPanel filterPanelTemplate;
    

    // Constructor Method
    public WagesByEducationChartController(JobspectsMenuFrame menuFrame) {
		super(menuFrame);
    	setChartFrame(new WagesByEducationScatterplotFrame());
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
        
        setChart(chart);
    }
    
    public void createFilterPanel() {
		filterPanelTemplate = new JPanel();
		filterPanelTemplate.setBounds(1100, 180, FRAME_WIDTH / 8 + 100, FRAME_HEIGHT - 300);
		filterPanelTemplate.setBackground(Color.WHITE);
		getChartFrame().add(filterPanelTemplate);
        
        // Set the layout manager
        filterPanelTemplate.setLayout(new FlowLayout());

        JLabel title = new JLabel();
        title.setText("Filter By:");
        title.setFont(new Font("Sans Serif", Font.BOLD, 25));
        filterPanelTemplate.add(title);

        // Create a new JPanel to hold the "Year" label and radio buttons
        JPanel yearPanel = new JPanel(new GridLayout(0, 3, 5, 5)); // Adjust the columns as needed
        
        JLabel years = new JLabel();
        years.setText("Year");
        years.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        yearPanel.add(years);

        // Create radio buttons
        JRadioButton[] radioButtons = new JRadioButton[23];
        ButtonGroup yearGroup = new ButtonGroup();

        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(String.valueOf(1997 + i));
            yearGroup.add(radioButtons[i]);
            yearPanel.add(radioButtons[i]);
        }
        
        // Add the yearPanel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(yearPanel);
        scrollPane.setPreferredSize(new java.awt.Dimension(250, 150)); // Adjust the size as needed

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(scrollPane);
        
        // Repaint the parent container to reflect changes
        filterPanelTemplate.revalidate();
        filterPanelTemplate.repaint();
    }
}