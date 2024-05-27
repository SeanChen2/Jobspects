package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.DatasetManager;
import model.PersonEducationIncome;
import view.JobspectsMenuFrame;
import view.WagesByEducationScatterplotFrame;

/*
 * Name: Kelvin Nguyen
 * WagesByEducationChartController
 * Group 1
 * Date: May 17th, 2024
 */


public class WagesByEducationChartController extends ChartController implements ActionListener {

    // Set frame size as constants
    private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;

    // Fields
//    private DatasetManager datasetManager = new DatasetManager();
    private JPanel filterPanelTemplate;
    private ButtonGroup yearGroup;
    private ButtonGroup educationGroup;
    private ButtonGroup salaryGroup;
    private JButton filterDataButton;
    private ArrayList<PersonEducationIncome> yearsOfEdu = new ArrayList<>();
    private ArrayList<PersonEducationIncome> yearsOfEduUpdated = new ArrayList<>();
    private String selectedYear;
    private String selectedEducation;
    private String selectedSalary;
    private int convertedEducation;
    private int convertedSalary;

    // Constructor Method
    public WagesByEducationChartController(JobspectsMenuFrame menuFrame) {
        super(menuFrame);
        setChartFrame(new WagesByEducationScatterplotFrame());
        createChart();
        createFilterPanel();
    }

    public JButton getFilterDataButton() {
		return filterDataButton;
	}


	public void setFilterDataButton(JButton filterDataButton) {
		this.filterDataButton = filterDataButton;
	}

    public ArrayList<PersonEducationIncome> getYearsOfEdu() {
		return yearsOfEdu;
	}

	public void setYearsOfEdu(ArrayList<PersonEducationIncome> yearsOfEdu) {
		this.yearsOfEdu = yearsOfEdu;
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
//        yearsOfEdu = datasetManager.getPerson();

        // Loop through the array and begin inputting the data into the graph
        for (PersonEducationIncome element : yearsOfEdu) {
            series.add(element.getYearsOfEducation(), element.getAverageIncome());
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
        // Create the panel
        filterPanelTemplate = new JPanel();
        filterPanelTemplate.setBounds(1100, 180, FRAME_WIDTH / 8 + 100, FRAME_HEIGHT - 300);
        filterPanelTemplate.setBackground(Color.WHITE);
        getChartFrame().add(filterPanelTemplate);

        // Set the layout manager
        filterPanelTemplate.setLayout(new FlowLayout());

        // Create the label
        JLabel title = new JLabel();
        title.setText("Filter By:");
        title.setFont(new Font("Sans Serif", Font.BOLD, 25));
        filterPanelTemplate.add(title);

        // Create a new JPanel to hold the "Year" label and radio buttons
        JPanel yearPanel = new JPanel(new GridLayout(0, 3, 5, 5)); // Adjust the columns as needed

        // Create the category labels
        JLabel years = new JLabel();
        years.setText("Year:");
        years.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        yearPanel.add(years);

        // Initialize ButtonGroup for years
        yearGroup = new ButtonGroup();

        // Create radio buttons for years
        for (int i = 0; i < 23; i++) {
            JRadioButton radioButton = new JRadioButton(String.valueOf(1997 + i));
            yearGroup.add(radioButton);
            yearPanel.add(radioButton);
        }

        // Create an "all" option. too
        JRadioButton button23 = new JRadioButton("All");
        yearGroup.add(button23);
        yearPanel.add(button23);

        // Add the yearPanel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(yearPanel);
        scrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(scrollPane);

        // Create a panel within the filter panel for education levels
        JPanel educationPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        // Create the title for the education panel
        JLabel education = new JLabel();
        education.setText("Education Level:");
        education.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        educationPanel.add(education);

        // Initialize ButtonGroup for education levels
        educationGroup = new ButtonGroup();

        // Create radio buttons for education levels
        String[] educationLevels = {
            "Elementary School", "High School", "High School Graduate",
            "University", "Undergraduate Degree", "College Degree",
            "Community College", "College", "Graduate Degree",
            "Masters Degree", "All"
        };

        for (String level : educationLevels) {
            JRadioButton radioButton = new JRadioButton(level);
            educationGroup.add(radioButton);
            educationPanel.add(radioButton);
        }

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

        // Initialize ButtonGroup for salary ranges
        salaryGroup = new ButtonGroup();

        // Create radio buttons for salary ranges
        String[] salaryRanges = {
            "<$400", "$401 - $800", "$801 - $1200",
            "$1201 - $1600", "$1601 - $2000", ">$2000", "All"
        };

        for (String range : salaryRanges) {
            JRadioButton radioButton = new JRadioButton(range);
            salaryGroup.add(radioButton);
            salaryPanel.add(radioButton);
        }

        // Add the salaryPanel to a JScrollPane
        JScrollPane salaryScrollPane = new JScrollPane(salaryPanel);
        salaryScrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

        // Add the scrollPane to the filterPanelTemplate
        filterPanelTemplate.add(salaryScrollPane);

        // Create the button to input data
        Icon fd = new ImageIcon("./images/FilterDataButton.png");
        filterDataButton = new JButton(fd);
        filterDataButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        filterDataButton.setOpaque(false);
        filterPanelTemplate.add(filterDataButton);

        // Add action listener to the filter button
        filterDataButton.addActionListener(this);

        // Repaint the parent container to reflect changes
        filterPanelTemplate.revalidate();
        filterPanelTemplate.repaint();
    }

    @Override
    // When the user picks the filters and presses the filter data button, check to see if it is valid and recieve their choices
    public void actionPerformed(ActionEvent e) {
    	yearsOfEduUpdated = new ArrayList<>(yearsOfEdu);
        // If user presses the back button, make sure the program does not confuse it with the filter data button
        super.actionPerformed(e);

        if (e.getSource() == getFilterDataButton()) {
            // Check to see if the user selected all fields, if not then call the isSelectionMade method
            if (!isSelectionMade(yearGroup, "Year") ||
                !isSelectionMade(educationGroup, "Education Level") ||
                !isSelectionMade(salaryGroup, "Salary")) {
                // If it is working get out of this group of statements
                return;
            }
            // Retrieve selected button texts
            selectedYear = getUserChoice(yearGroup);
            selectedEducation = getUserChoice(educationGroup);
            
            // Adjust the type of the variable
            convertedEducation = convertEducation(selectedEducation);
            selectedSalary = getUserChoice(salaryGroup);

            // Remove all the data that does nto fit within the year the user selects
            for (int i = 0; i < yearsOfEduUpdated.size(); i++) {
                if (!selectedYear.equals("All")) {
                	if (yearsOfEduUpdated.get(i).getYear() != Integer.parseInt(selectedYear)) {
                		yearsOfEduUpdated.remove(i);
                		i--;
                	}
                }
            }
            
            // Remove all the educuation types that the user did not select
            // Check to see if the user pressed all, if not run the loop
            if (convertedEducation != -1) {
                for (int i = 0; i < yearsOfEduUpdated.size(); i++) {
                    if (!selectedEducation.equals("All")) {
                    	// Remove the data if it is not equal
                        if (yearsOfEduUpdated.get(i).getYearsOfEducation() != convertedEducation) {
                        	yearsOfEduUpdated.remove(i);
                        	// Decrease the index to check the new index as it has been shortned by one
                        	i--;
                        }
                    }
                }
            }

            // Convert the salary to an int
            convertSalary(selectedSalary);
            
         
   		 for (int i = 0; i < yearsOfEduUpdated.size(); i++) {
             System.out.println(yearsOfEduUpdated.get(i).toString());
   		 }
   		 
   		 // Update the chart
         updateChart();
         
       }
    }
    
    // Conver the education field from a String to an int
	private int convertEducation(String selectedEducation) {
		if (selectedEducation.equals("All"))
	        return -1;
		switch (selectedEducation) {
	       case "Elementary School": return 8;
	       case "High School": return 10;
	       case "High School Graduate": return 12;
	       case "University": return 14;
	       case "Undergraduate Degree": return 16;
	       case "College Degree": return 15;
	       case "Community College": return 14;
	       case "College": return 14;
	       case "Graduate Degree": return 15;
	       case "Masters Degree": return 17;
	       }
	       return -1;
		 }

	// Directy remove data from the dataset here
	private void convertSalary(String selectedSalary) {
	    if (selectedSalary.equals("All")) {
	        return;
	    }
	    
	    // Use the switch case to remove the correct data
	    for (int i = 0; i < yearsOfEduUpdated.size(); i++) {
	        double income = yearsOfEduUpdated.get(i).getAverageIncome();
	        switch (selectedSalary) {
	            case "<$400":
	                if (income >= 400) {
	                    yearsOfEduUpdated.remove(i);
	                    i--; 
	                }
	                break;
	            case "$401 - $800":
	                if (!(income >= 401 && income <= 800)) {
	                    yearsOfEduUpdated.remove(i);
	                    i--; 
	                }
	                break;
	            case "$801 - $1200":
	                if (!(income >= 801 && income <= 1200)) {
	                    yearsOfEduUpdated.remove(i);
	                    i--;
	                }
	                break;
	            case "$1201 - $1600":
	                if (!(income >= 1201 && income <= 1600)) {
	                    yearsOfEduUpdated.remove(i);
	                    i--;
	                }
	                break;
	            case "$1601 - $2000":
	                if (!(income >= 1601 && income <= 2000)) {
	                    yearsOfEduUpdated.remove(i);
	                    i--;
	                }
	                break;
	            case ">$2000":
	                if (income <= 2000) {
	                    yearsOfEduUpdated.remove(i);
	                    i--;
	                }
	                break;
	        }
	    }
	}


	// Method to validate if a selection is made in the ButtonGroup
    private boolean isSelectionMade(ButtonGroup group, String groupName) {
    	// If a field is left empty
        if (getUserChoice(group) == "nothing") {
            // If there was an empty selection, return an error message
            javax.swing.JOptionPane.showMessageDialog(null, "Please select a " + groupName + ".", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            // Return false
            return false;
        }
        // Otherwise if it is no longer empty then return true
        return true;
    }

    // SOURCE: https://www.javatpoint.com/java-jradiobutton
    // Get the correct field the user selected from the JRadioButton groups
    private String getUserChoice(ButtonGroup group) {

    	// Get all of the choices for the ButtonGroup
        for (AbstractButton button : java.util.Collections.list(group.getElements())) {
        	// If the button "is selected":
            if (button.isSelected()) {
            	// Return the selected button choice
                return button.getText();
            }
        }
        // If none are selected then return "nothing"
        return "nothing";
    }

	@Override
	public void updateChart() {
	    // Clear existing data
	    getChart().getXYPlot().setDataset(null);
	    
	    // Create the dataset
	    XYSeries series = new XYSeries("Data");

	    // Loop through the updated data and add it to the series
	    for (PersonEducationIncome element : yearsOfEduUpdated) {
	        series.add(element.getYearsOfEducation(), element.getAverageIncome());
	    }

	    // Add it to the chart
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    dataset.addSeries(series);

	    // Set the dataset to the chart
	    getChart().getXYPlot().setDataset(dataset);
	}
}