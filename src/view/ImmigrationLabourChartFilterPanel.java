package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//This class is a panel that holds a section of chart filters in the
//filter panel of the immigration chart frames. These filters allow
//the user to choose which demographics are represented by the chart.
//Filters may include any of the following: sex, employment type, 
//education level, immigrant status
public class ImmigrationLabourChartFilterPanel extends JPanel {
	
	//A heading for this section of filters
	private JLabel chartFilterLabel = new JLabel("Filter by:");
	
	//A container that holds all the sections of filters (e.g. sex, education level...)
	private JPanel filterSectionContainer = new JPanel();
	
	//String arrays that hold all the options for each filter category
	private String[] sexOptions = { "Male", "Female", "Both Sexes" };
	private String[] employmentTypeOptions = { "Full-time employment", "Part-time employment", "Labour force" };
	private String[] educationLevelOptions = { "No certifications", "High school graduate", 
			"Post-secondary certificate or diploma", "Bachelor's degree", "Above bachelor's degree", "All education levels" };
	private String[] immigrantStatusOptions = { "Born in Canada", "Very recent immigrants; 5 years or less", 
			"Recent immigrants; 5+ to 10 years", "Established immigrants; 10+ years", "Non-landed immigrants", "Total" };
	
	//Arrays that hold the radio buttons for each filter category
	private JRadioButton[] sexButtons = new JRadioButton[sexOptions.length];
	private JRadioButton[] employmentTypeButtons = new JRadioButton[employmentTypeOptions.length];
	private JRadioButton[] educationLevelButtons = new JRadioButton[educationLevelOptions.length];
	private JRadioButton[] immigrantStatusButtons = new JRadioButton[immigrantStatusOptions.length];
	
	//2D array that holds all the sets of radio buttons in one structure
	private JRadioButton[][] filterButtons = { sexButtons, employmentTypeButtons, educationLevelButtons, immigrantStatusButtons };
	
	//A field that holds the filter panel template for its size
	private JPanel filterPanelTemplate;
	
	//Constructor: set up the heading and radio buttons of this filter section
	public ImmigrationLabourChartFilterPanel(JPanel filterPanelTemplate, boolean addSex, boolean addEmploymentType, 
			boolean addEducationLevel, boolean addImmigrantStatus) {
		
		//Set the filter panel template object
		this.filterPanelTemplate = filterPanelTemplate;
		
		//Use the null layout manager to allow components to be placed on this panel using coordinates
		setLayout(null);
		
		//Set up the heading and radio buttons of the compare category section
		setUpChartFilterLabel();
		setUpFilterSectionContainer(addSex, addEmploymentType, addEducationLevel, addImmigrantStatus);
		
	}
	
	//Getters for all the radio buttons that represent filters
	
	public JRadioButton[] getSexButtons() {
		return sexButtons;
	}

	public JRadioButton[] getEmploymentTypeButtons() {
		return employmentTypeButtons;
	}

	public JRadioButton[] getEducationLevelButtons() {
		return educationLevelButtons;
	}

	public JRadioButton[] getImmigrantStatusButtons() {
		return immigrantStatusButtons;
	}
	
	public JRadioButton[][] getFilterButtons() {
		return filterButtons;
	}
	
	//Getter for the panel that contains all the sections of filters
	public JPanel getFilterSectionContainer() {
		return filterSectionContainer;
	}
	
	//This method sets up the header label for all the filter sections
	private void setUpChartFilterLabel() {
		
		//Position this heading at the very top with purple text and size 32 font
		chartFilterLabel.setBounds(30, 20, 300, 40);
		chartFilterLabel.setForeground(JobspectsFrame.DARK_PURPLE);
		chartFilterLabel.setFont(new Font("Sans Serif", Font.BOLD, 32));
		add(chartFilterLabel);
		
	}
	
	//This method sets up the container panel that holds all the chart filter sections
	private void setUpFilterSectionContainer(boolean addSex, boolean addEmploymentType, 
			boolean addEducationLevel, boolean addImmigrantStatus) {
		
		//Set up a box layout to display all the chart filter sections vertically, then add the
		//filter section panel under the chart filter label. NOTE: height will be set later by the controller
		filterSectionContainer.setLayout(new BoxLayout(filterSectionContainer, BoxLayout.Y_AXIS));
		filterSectionContainer.setBounds(30, 80, filterPanelTemplate.getWidth() - 60, 0);
		add(filterSectionContainer);
		
		//If the current chart frame should allow the user to filter by sex, add this section
		if (addSex)
			setUpFilterSection("Sex", 63, 3, sexOptions, sexButtons);
		
		//If the current chart frame should allow the user to filter by employment type, add this section
		if (addEmploymentType)
			setUpFilterSection("Employment type", 200, 2, employmentTypeOptions, employmentTypeButtons);
		
		//If the current chart frame should allow the user to filter by education level, add this section
		if (addEducationLevel)
			setUpFilterSection("Education level", 180, 1, educationLevelOptions, educationLevelButtons);
		
		//If the current chart frame should allow the user to filter by immigrant status, add this section
		if (addImmigrantStatus)
			setUpFilterSection("Immigrant status", 190, 1, immigrantStatusOptions, immigrantStatusButtons);
		
	}
	
	//This method sets up a filter section with the specified section name, width of the section name label,
	//filter categories, number of buttons placed per row, and the array that holds the filter buttons
	private void setUpFilterSection(String sectionName, int sectionNameLabelWidth, int buttonsPerRow,
			String[] filterCategories, JRadioButton[] filterButtonArray) {
		
		//Create a panel for this section, using a null layout to place components by coordinates
		JPanel filterSectionPanel = new JPanel(null);
		
		//Calculate how many rows of buttons there will be (given the number of buttons each row holds)
		int	numButtonRows = (filterButtonArray.length + (buttonsPerRow - 1)) / buttonsPerRow;
		
		//Limit the size of this panel to minimize blank space between filter sections
		filterSectionPanel.setPreferredSize(new Dimension(1600, 60 + 50 * numButtonRows));
		filterSectionPanel.setMaximumSize(new Dimension(1600, 60 + 50 * numButtonRows));
		
		//Set up the section label with the name of the filter section
		JLabel sectionNameLabel = new JLabel(sectionName);
		
		//Position this section label at the top of the filter section panel, with a light purple background
		//and dark purple text. Use a size 22 font and add padding around the edges of the label.
		sectionNameLabel.setBounds(0, 0, sectionNameLabelWidth, 40);
		sectionNameLabel.setOpaque(true);
		sectionNameLabel.setForeground(JobspectsFrame.DARK_PURPLE);
		sectionNameLabel.setBackground(new Color(232, 192, 225));
		sectionNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 22));
		sectionNameLabel.setBorder(new EmptyBorder(10, 10, 10, 10));	//Add padding to the label
		filterSectionPanel.add(sectionNameLabel);
		
		//Fill the given array with filter buttons, based on the filter categories
		for (int index = 0; index < filterButtonArray.length; index++)
			filterButtonArray[index] = new JRadioButton("  " + filterCategories[index]);
		
		//Set up a grid layout panel with the calculated number of rows to display the radio buttons, then add it to
		//the filter section panel.
		JPanel filterButtonPanel = new JPanel(new GridLayout(numButtonRows, 3));
		filterButtonPanel.setBounds(0, 50, filterPanelTemplate.getWidth() - 60, 50 * numButtonRows);
		filterSectionPanel.add(filterButtonPanel);
		
		//Group the radio buttons together so that only one can be selected at a time
		ButtonGroup filterButtonGroup = new ButtonGroup();
		for (JRadioButton button : filterButtonArray) {
			
			filterButtonGroup.add(button);
			
			//At the same time, style the button by setting its font and colour,
			//deactivating some of the default JRadioButton visual effects
			button.setFont(new Font("Sans Serif", Font.BOLD, 25));
			button.setForeground(JobspectsFrame.DARK_PURPLE);
			button.setFocusPainted(false);
			
			//Add the radio buttons to the horizontal button panel
			filterButtonPanel.add(button);
			
		}
		
		//Add this filter section panel to the container
		filterSectionContainer.add(filterSectionPanel);
		
	}
	
}
