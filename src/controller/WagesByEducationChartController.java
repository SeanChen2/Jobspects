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

public class WagesByEducationChartController extends ChartController implements ActionListener {
    
    // Set frame size as constants
    private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;
    
    // Fields
    private DatasetManager datasetManager = new DatasetManager();
    private JPanel filterPanelTemplate;
    private ButtonGroup yearGroup;
    private ButtonGroup educationGroup;
    private ButtonGroup salaryGroup;
    private JButton filterDataButton;

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
        
        // Create an "all" option too
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
		    String selectedYear = getUserChoice(yearGroup);
		    String selectedEducation = getUserChoice(educationGroup);
		    String selectedSalary = getUserChoice(salaryGroup);
		
		    // test
		    System.out.println("Selected Year: " + selectedYear);
		    System.out.println("Selected Education Level: " + selectedEducation);
		    System.out.println("Selected Salary: " + selectedSalary);
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
        // If none are selected then return false
        return "nothing";
    }
}