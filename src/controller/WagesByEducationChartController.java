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
import view.ImmigrationLabourAreaChartFrame;
import view.JobspectsMenuFrame;
import view.WagesByEducationScatterplotFrame;

public class WagesByEducationChartController extends ChartController {
    
	private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;
    
	private JPanel chartPanelTemplate;
    private DatasetManager datasetManager = new DatasetManager();
    private JPanel filterPanelTemplate;
    

    // Constructor Method
    public WagesByEducationChartController(JobspectsMenuFrame menuFrame) {
		super(menuFrame);
    	setChartFrame(new WagesByEducationScatterplotFrame());
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
        
        // Create an "all" option too
        JRadioButton button23 = new JRadioButton("All");
        yearGroup.add(button23);
        yearPanel.add(button23);
        
        // Add the yearPanel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(yearPanel);
        scrollPane.setPreferredSize(new java.awt.Dimension(250, 150)); // Adjust the size as needed

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(scrollPane);
        
    	// Create a panel within the filter panel
        JPanel educationPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        
        // Create the title for the panel within
        JLabel education = new JLabel();
        education.setText("Education Level:");
        education.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        educationPanel.add(education);
        
        // Create a pabel within the filter panel
        ButtonGroup educationGroup = new ButtonGroup();
        
        // Options for JButtons (repetitive code moving forward)
        JRadioButton elementaryButton = new JRadioButton("Elementary School");
        
        // Add it to the group of radio buttons and the panel
        educationGroup.add(elementaryButton);
        educationPanel.add(elementaryButton);
        
        JRadioButton highSchoolButton = new JRadioButton("High School");
        
        educationGroup.add(highSchoolButton);
        educationPanel.add(highSchoolButton);
        
        JRadioButton highSchoolGraduateButton = new JRadioButton("High School Graduate");
        
        educationGroup.add(highSchoolGraduateButton);
        educationPanel.add(highSchoolGraduateButton);
        
        JRadioButton uniButton = new JRadioButton("University");
        
        educationGroup.add(uniButton);
        educationPanel.add(uniButton);
        
        JRadioButton uniGraduateButton = new JRadioButton("Undergraduate Degree");
        
        educationGroup.add(uniGraduateButton);
        educationPanel.add(uniGraduateButton);
        
        JRadioButton collegeDegreeButton = new JRadioButton("College Degree");
        
        educationGroup.add(collegeDegreeButton);
        educationPanel.add(collegeDegreeButton);
        
        JRadioButton communityButton = new JRadioButton("Community College");
        
        educationGroup.add(communityButton);
        educationPanel.add(communityButton);
        
        JRadioButton collegeButton = new JRadioButton("College");
        
        educationGroup.add(collegeButton);
        educationPanel.add(collegeButton);
        
        JRadioButton graduateButton = new JRadioButton("Graduate Degree");
        
        educationGroup.add(graduateButton);
        educationPanel.add(graduateButton);
        
        JRadioButton mastersButton = new JRadioButton("Masters Degree");
        
        educationGroup.add(mastersButton);
        educationPanel.add(mastersButton);
        
        JRadioButton allButton = new JRadioButton("All");
        
        educationGroup.add(allButton);
        educationPanel.add(allButton);
        
        // Add the educationPanel to a JScrollPane
        JScrollPane educationScrollPane = new JScrollPane(educationPanel);
        educationScrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(educationScrollPane);
        
        // Create the salary Panel
        JPanel salaryPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        
        // Create the title
        JLabel salary = new JLabel();
        salary.setText("Salary:");
        salary.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        salaryPanel.add(salary);
        
        // Create a ButtonGroup of options for salary
        ButtonGroup salaryGroup = new ButtonGroup();
        
        JRadioButton button400 = new JRadioButton("<$400");
        
        salaryGroup.add(button400);
        salaryPanel.add(button400);
        
        JRadioButton button800 = new JRadioButton("$401 - $800");
        
        salaryGroup.add(button800);
        salaryPanel.add(button800);
        
        JRadioButton button1200 = new JRadioButton("$801 - $1200");
        
        salaryGroup.add(button1200);
        salaryPanel.add(button1200);
        
        JRadioButton button1600 = new JRadioButton("$1201 - $1600");
        
        salaryGroup.add(button1600);
        salaryPanel.add(button1600);
        
        JRadioButton button2000 = new JRadioButton("$1601 - $2000");
        
        salaryGroup.add(button2000);
        salaryPanel.add(button2000);
        
        JRadioButton button2001 = new JRadioButton(">$2000");
        
        salaryGroup.add(button2001);
        salaryPanel.add(button2001);
        
        JRadioButton allbutton = new JRadioButton("All");
        
        salaryGroup.add(allbutton);
        salaryPanel.add(allbutton);
        
        // Add the yearPanel to a JScrollPane
        JScrollPane salaryScrollPane = new JScrollPane(salaryPanel);
        salaryScrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(salaryScrollPane);
        
        // Repaint the parent container to reflect changes
        filterPanelTemplate.revalidate();
        filterPanelTemplate.repaint();
    }
}