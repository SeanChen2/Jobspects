package view;

import javax.swing.*;

//This class is a panel that holds a section of chart filters in the
//filter panel of the immigration chart frames. These filters allow
//the user to choose which demographics are represented by the chart.
//Filters may include any of the following: sex, employment type, 
//education level, immigrant status
public class ImmigrationLabourChartFilterPanel extends JPanel {
	
	//Fields
	private JLabel chartFilterLabel;
	
	private JLabel sexLabel;
	private JRadioButton[] sexButtons;
	
	private JLabel employmentTypeLabel;
	private JRadioButton[] employmentTypeButtons;
	
	private JLabel educationLevelLabel;
	private JRadioButton[] educationLevelButtons;
	
	private JLabel immigrantStatusLabel;
	private JRadioButton[] immigrantStatusButtons;
	
	//Constructor
	public ImmigrationLabourChartFilterPanel(boolean addSex, boolean addEmploymentType, 
			boolean addEducationLevel, boolean addImmigrantStatus) {
		
		
		
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
		
		
		
	}

	//This method sets up the section that allows the user to filter by sex.
	//This includes a section label and the radio buttons for filter selection.
	private void setUpSexSection() {
		
		
		
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
