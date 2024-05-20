package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//This class is a panel that holds a section of category filters in the
//filter panel of the immigration area chart frame. These filters allow
//the user to choose which data category is represented by each of the
//areas in the area chart (education level, immigrant status)
public class ImmigrationLabourCompareCategoryPanel extends JPanel {

	//Fields
	private JLabel compareCategoryLabel = new JLabel("Compare by:");
	private JRadioButton[] compareCategoryButtons = new JRadioButton[2];
	private JPanel filterPanelTemplate;
	
	//Constructor
	public ImmigrationLabourCompareCategoryPanel(JPanel filterPanelTemplate) {
		
		//Set the filter panel template object
		this.filterPanelTemplate = filterPanelTemplate;
		
		//Use the null layout manager to allow components to be placed on this panel using coordinates
		setLayout(null);
		
		//Limit this panel's size to minimize unnecessary blank space between panels
		setPreferredSize(new Dimension(1600, 150));
		setMaximumSize(new Dimension(1600, 150));
		
		setUpCompareCategoryLabel();
		setUpCompareCategoryButtons();
		
	}
	
	//Getter for the radio buttons that select the data category filter
	public JRadioButton[] getCompareCategoryButtons() {
		return compareCategoryButtons;
	}
	
	//This method adds the header label for the category filters
	private void setUpCompareCategoryLabel() {
		
		compareCategoryLabel.setBounds(30, 20, 300, 40);
		compareCategoryLabel.setForeground(JobspectsFrame.DARK_PURPLE);
		compareCategoryLabel.setFont(new Font("Sans Serif", Font.BOLD, 32));
		add(compareCategoryLabel);
		
	}
	
	//This method adds the category filters as radio buttons under the header label
	private void setUpCompareCategoryButtons() {
		
		//Create the radio buttons that allow the user to compare by data categories
		compareCategoryButtons[0] = new JRadioButton("  Education level");
		compareCategoryButtons[1] = new JRadioButton("  Immigrant status");
		
		//Set up a grid layout panel with 1 row to display the radio buttons horizontally
		JPanel categoryButtonPanel = new JPanel(new GridLayout(1, 3));
		categoryButtonPanel.setBounds(30, 80, filterPanelTemplate.getWidth() - 60, 30);
		add(categoryButtonPanel);
		
		//Group the radio buttons together so that only one can be selected at a time
		ButtonGroup compareCategoryButtonGroup = new ButtonGroup();
		for (JRadioButton button : compareCategoryButtons) {
			compareCategoryButtonGroup.add(button);
			
			//At the same time, style the button by setting its font and colour,
			//deactivating some of the default JRadioButton visual effects
			button.setFont(new Font("Sans Serif", Font.BOLD, 25));
			button.setForeground(JobspectsFrame.DARK_PURPLE);
			button.setFocusPainted(false);
			
			//Add the radio buttons to the horizontal button panel
			categoryButtonPanel.add(button);
			
		}
		
	}
	
}
