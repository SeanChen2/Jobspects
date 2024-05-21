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
	
	//Fields
	private JLabel chartFilterLabel = new JLabel("Filter by:");
	
	private JPanel filterSectionContainer = new JPanel();
	
	//String arrays that hold all the options for each filter category
	private String[] sexOptions = { "Male", "Female", "All" };
	private String[] employmentTypeOptions = { "Full-time", "Part-time", "All" };
	private String[] educationLevelOptions = { "" };	//TODO: Finish these
	private String[] immigrantStatusOptions = { "" };
	
	//Arrays that hold the radio buttons for each filter category
	private JRadioButton[] sexButtons = new JRadioButton[sexOptions.length];
	private JRadioButton[] employmentTypeButtons = new JRadioButton[employmentTypeOptions.length];
	private JRadioButton[] educationLevelButtons = new JRadioButton[educationLevelOptions.length];
	private JRadioButton[] immigrantStatusButtons = new JRadioButton[immigrantStatusOptions.length];
	
	private JPanel filterPanelTemplate;
	
	//Constructor
	public ImmigrationLabourChartFilterPanel(JPanel filterPanelTemplate, boolean addSex, boolean addEmploymentType, 
			boolean addEducationLevel, boolean addImmigrantStatus) {
		
		//Set the filter panel template object
		this.filterPanelTemplate = filterPanelTemplate;
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		setPreferredSize(new Dimension(1600, 500));
		setMaximumSize(new Dimension(1600, 500));
		
		//Use the null layout manager to allow components to be placed on this panel using coordinates
		setLayout(null);
		
		//Set up the header label for the chart filters
		setUpChartFilterLabel();
	
		//Set up the container panel that holds all the chart filter sections
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
	
	//This method sets up the header label for all the filter sections
	private void setUpChartFilterLabel() {
		
		chartFilterLabel.setBounds(30, 20, 300, 40);
		chartFilterLabel.setForeground(JobspectsFrame.DARK_PURPLE);
		chartFilterLabel.setFont(new Font("Sans Serif", Font.BOLD, 32));
		add(chartFilterLabel);
		
	}
	
	//This method sets up the container panel that holds all the chart filter sections
	private void setUpFilterSectionContainer(boolean addSex, boolean addEmploymentType, 
			boolean addEducationLevel, boolean addImmigrantStatus) {
		
		//Set up a box layout to display all the chart filter sections vertically, then add the
		//filter section panel under the chart filter label
		filterSectionContainer.setLayout(new BoxLayout(filterSectionContainer, BoxLayout.Y_AXIS));
		filterSectionContainer.setBounds(30, 80, filterPanelTemplate.getWidth() - 60, 600);
		add(filterSectionContainer);
		
		//If the current chart frame should allow the user to filter by sex, add this section
		if (addSex)
			setUpFilterSection("Sex", 63, sexOptions, sexButtons);
		
		//If the current chart frame should allow the user to filter by employment type, add this section
		if (addEmploymentType)
			setUpFilterSection("Employment type", 200, employmentTypeOptions, employmentTypeButtons);
		
		//If the current chart frame should allow the user to filter by education level, add this section
		if (addEducationLevel)
			setUpFilterSection("Education level", 180, educationLevelOptions, educationLevelButtons);
		
		//If the current chart frame should allow the user to filter by immigrant status, add this section
		if (addImmigrantStatus)
			setUpFilterSection("Immigrant status", 190, immigrantStatusOptions, immigrantStatusButtons);
		
	}
	
	//This method sets up a filter section with the specified section name, filter categories,
	//and the array to hold the filter buttons
	private void setUpFilterSection(String sectionName, int sectionNameLabelWidth,
			String[] filterCategories, JRadioButton[] filterButtonArray) {
		
		//Create a panel for this section, using a null layout to place components by coordinates
		JPanel filterSectionPanel = new JPanel(null);
		
		//Calculate how many rows of buttons there will be (given that each row holds 3 buttons)
		int	numButtonRows = (filterButtonArray.length + 2) / 3;
		
		//Limit the size of this panel to minimize blank space between filter sections
		filterSectionPanel.setPreferredSize(new Dimension(1600, 60 + 50 * numButtonRows));
		filterSectionPanel.setMaximumSize(new Dimension(1600, 60 + 50 * numButtonRows));
		
		//Set up the section label, then add it to the filter section panel
		JLabel sectionNameLabel = new JLabel(sectionName);
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
		
		//Set up a grid layout panel with 1 row to display the radio buttons, then add it to
		//the filter section panel
		JPanel filterButtonPanel = new JPanel(new GridLayout(numButtonRows, 3));
		filterButtonPanel.setBounds(0, 50 * numButtonRows, filterPanelTemplate.getWidth() - 60, 50);
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
	
	//This method sets up the section that allows the user to filter by employment type.
	//This includes a section label and the radio buttons for filter selection.
	private void setUpEmploymentTypeSection() {
		
		
		
	}
	
	//This method sets up the section that allows the user to filter by education level.
	//This includes a section label and the radio buttons for filter selection.
	private void setUpEducationLevelSection() {
		
		
		
	}
	
	//This method sets up the section that allows the user to filter by immigrant status.
	//This includes a section label and the radio buttons for filter selection.
	private void setUpImmigrantStatusSection() {
		
		
		
	}
	
}
