package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

//This class is a panel that allows the user to customize the area chart by date, in two different ways:
//- Select a specific year to display. Then all 12 months will be displayed.
//- Display all years from 2006-2020. Each year will display the sum of values for all the months
public class ImmigrationLabourDatePickerPanel extends JPanel {

	//Fields
	private JLabel dateRangeLabel = new JLabel("Date range:");
	private JPanel filterPanelTemplate;
	
	//An array of 2 radio buttons to allow the user to choose between two area chart types:
	//displaying data for for all the years, or the months of a single year
	private JRadioButton[] dateTypePickerButtons = new JRadioButton[2];
	
	//A slider that allows the user to select which year to display - ONLY displayed
	//if the user chooses to display the months of a single year
	private JSlider yearSlider = new JSlider(2006, 2020, 2020);
	
	//Constructor
	public ImmigrationLabourDatePickerPanel(JPanel filterPanelTemplate) {
		
		this.filterPanelTemplate = filterPanelTemplate;
		
		//Use the null layout manager to allow components to be placed on this panel using coordinates
		setLayout(null);
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		setPreferredSize(new Dimension(1600, 400));
		setMaximumSize(new Dimension(1600, 400));
		
		setUpDateRangeLabel();
		setUpDateTypePickerButtons();
		setUpYearSlider();
		
	}
	
	//Getters for all the interactive GUI elements (radio buttons, slider)
	
	public JRadioButton[] getDateTypePickerButtons() {
		return dateTypePickerButtons;
	}

	public JSlider getYearSlider() {
		return yearSlider;
	}

	//This method adds the header label for the date range panel
	private void setUpDateRangeLabel() {
		
		dateRangeLabel.setBounds(30, 20, 300, 40);
		dateRangeLabel.setForeground(JobspectsFrame.DARK_PURPLE);
		dateRangeLabel.setFont(new Font("Sans Serif", Font.BOLD, 32));
		add(dateRangeLabel);
		
	}
	
	//This method adds the two radio buttons that allow the user to choose between displaying months/years
	private void setUpDateTypePickerButtons() {
		
		//Create the two chart options as radio buttons
		dateTypePickerButtons[0] = new JRadioButton("  15 years");
		dateTypePickerButtons[1] = new JRadioButton("  Single year");
		
		//Position the buttons beside each other
		dateTypePickerButtons[0].setBounds(30, 80, 300, 50);
		dateTypePickerButtons[1].setBounds(330, 80, 300, 50);
		
		//Group the radio buttons together so that only one can be selected at a time
		ButtonGroup dateTypePickerButtonGroup = new ButtonGroup();
		for (JRadioButton dateTypePickerButton : dateTypePickerButtons) {
			
			dateTypePickerButtonGroup.add(dateTypePickerButton);
			
			//At the same time, style the button by setting its font and colour,
			//deactivating some of the default JRadioButton visual effects
			dateTypePickerButton.setFont(new Font("Sans Serif", Font.BOLD, 25));
			dateTypePickerButton.setForeground(JobspectsFrame.DARK_PURPLE);
			dateTypePickerButton.setFocusPainted(false);
			
			//Add the radio buttons to the panel
			add(dateTypePickerButton);
			
		}
		
	}
	
	//This method adds the slider that allows the user to choose which year to display the months for.
	//Note that this is only used if the user chooses to display data for months of a single year.
	private void setUpYearSlider() {
		
		//Position the year slider directly under the 2 radio buttons
		yearSlider.setBounds(30, 140, 650, 100);
		
		yearSlider.setPaintLabels(true);
		yearSlider.setPaintTicks(true);
		yearSlider.setMajorTickSpacing(2);
		
		add(yearSlider);
		
		//Make the year slider invisible initially; it will only appear when the user selects "Single year"
		yearSlider.setVisible(false);
		
	}
	
}
