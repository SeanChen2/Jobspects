package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DatasetManager;
import view.OccupationLabourBarChartFrame.CircularGradientPanel;

public class UnemploymentDurationLineChartFrame extends JobspectsChartFrame implements ActionListener {

	private DatasetManager datasetManager = new DatasetManager();

	private JPanel filterPanel = new JPanel();
	private ButtonGroup compareGroup = new ButtonGroup();
	private ButtonGroup durationGroup = new ButtonGroup();
	ButtonGroup sexGroup = new ButtonGroup();
	private JRadioButton geographyButton;
	private JRadioButton ageGroupButton;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JRadioButton allButton;
	private JTextField startTimeField;
	private JTextField endTimeField;
	private JComboBox<String> averageTypeComboBox;
	private JComboBox<String> ageGroupComboBox;
	private JLabel averageResultLabel;

	public UnemploymentDurationLineChartFrame() {
		setSize(1920, 1080);
		
		setTitle("Jobspects😎");

		setAverageCalculationPanel(new AverageCalculationPanel(true));

		setUpChartNavButtons();

		setUpFilterPanel();

		setUpCompareCategorySection();

		setUpFilterSection();

		SetUpAverageSection();

		// Create and add label
		getScreenTitleLabel().setText("    What factors affect the Duration of Employment in Canada?");

		// Set content pane layout to null for absolute positioning
		getContentPane().setLayout(null);

		// Set content pane layout to null for absolute positioning
		getContentPane().setLayout(null);

		// setVisible(false);

	}

	private void setUpChartNavButtons() {
		// TODO Auto-generated method stub

	}

	private void setUpFilterPanel() {
		// Display the filter "sections" vertically using a box layout
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		// a yellow so light that it just looks white
		filterPanel.setBackground(Color.decode("#fffef7"));

		// Make the filter panel vertically scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterScrollPane.setBackground(Color.WHITE);
		add(filterScrollPane);

	}

	private void setUpCompareCategorySection() {
		//Create panel to hold comparison factors for graph
        JPanel comparePanel = new JPanel(new GridLayout(3, 1));
        comparePanel.setBackground(Color.decode("#fffef7"));

        //create heading
		JLabel title = new JLabel();
		title.setText("Compare by:");
		title.setFont(new Font("Sans Serif", Font.BOLD, 36));
		title.setBounds(0, 0, WIDTH, HEIGHT);
		comparePanel.add(title);

		//create radiobuttons
		geographyButton = new JRadioButton("Geography");
		geographyButton.setBackground(Color.decode("#fffef7"));
		ageGroupButton = new JRadioButton("Age Group");
		ageGroupButton.setBackground(Color.decode("#fffef7"));
		compareGroup.add(geographyButton);
		compareGroup.add(ageGroupButton);
		comparePanel.add(geographyButton);
		comparePanel.add(ageGroupButton);
		
		//Add to panel
		filterPanel.add(comparePanel);

	}

	private void setUpFilterSection() {
        JPanel filterSectionPanel = new JPanel(new GridLayout(7, 1));
        filterSectionPanel.setBackground(Color.decode("#fffef7"));

		JLabel filterLabel = new JLabel("Filter by:");
		filterLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
        filterSectionPanel.add(filterLabel);

		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        filterSectionPanel.add(sexLabel);

		maleButton = new JRadioButton("Male");
		maleButton.setBackground(Color.decode("#fffef7"));
		femaleButton = new JRadioButton("Female");
		femaleButton.setBackground(Color.decode("#fffef7"));
		allButton = new JRadioButton("All");
		allButton.setBackground(Color.decode("#fffef7"));
		sexGroup.add(maleButton);
		sexGroup.add(femaleButton);
		sexGroup.add(allButton);

		filterSectionPanel.add(maleButton);
		filterSectionPanel.add(femaleButton);
		filterSectionPanel.add(allButton);

		JLabel timeRangeLabel = new JLabel("Time Range:");
		timeRangeLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
		filterSectionPanel.add(timeRangeLabel);

		JPanel timeRangePanel = new JPanel();
        timeRangePanel.setBackground(Color.decode("#fffef7"));
		startTimeField = new JTextField(4);
		endTimeField = new JTextField(4);
		timeRangePanel.add(startTimeField);
		timeRangePanel.add(new JLabel("to"));
		timeRangePanel.add(endTimeField);
		filterSectionPanel.add(timeRangePanel);
		
        filterPanel.add(filterSectionPanel);

		// Create a panel within the filter panel for education levels
		JPanel durationPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        durationPanel.setBackground(Color.decode("#fffef7"));

		// Create the title for the education panel
		JLabel duration = new JLabel();
		duration.setText("Duration");
		duration.setFont(new Font("Sans Serif", Font.PLAIN, 24));
		durationPanel.add(duration);

		// Initialize ButtonGroup for education levels

		// Create radio buttons for education levels
		String[] durationTypes = { "Total unemployed", "1 - 4 weeks", "5 - 13 weeks", "14 - 25 weeks", "26 weeks",
				"27 weeks or more", "27 - 51 weeks", "52 weeks", "Average weeks unemployed (no top-code)",
				"Average weeks unemployed (top-code = 99 weeks)" };

		for (String type : durationTypes) {
			JRadioButton radioButton = new JRadioButton(type);
			durationGroup.add(radioButton);
			radioButton.setBackground(Color.decode("#fffef7"));
			durationPanel.add(radioButton);
		}

		// Add the educationPanel to a JScrollPane
		JScrollPane durationScrollPane = new JScrollPane(durationPanel);
		durationScrollPane.setPreferredSize(new java.awt.Dimension(500, 200));

		// Add the scrollPane to the filterPanelTemplate
		filterPanel.add(durationScrollPane);

	}

	private void SetUpAverageSection() {


	}

	public JButton[] getChartNavButtons() {
//		// TODO Auto-generated method stub
//		// Create a new JPanel to hold the "Year" label and radio buttons
//		JPanel yearPanel = new JPanel(new GridLayout(0, 3, 5, 5)); // Adjust the columns as needed
//
//		// Create the category labels
//		JLabel years = new JLabel();
//		years.setText("Year:");
//		years.setFont(new Font("Sans Serif", Font.PLAIN, 20));
//		yearPanel.add(years);
//
//		// Initialize ButtonGroup for years
//		sexGroup = new ButtonGroup();
//
//		// Create radio buttons for years
//		for (int i = 0; i < 23; i++) {
//			JRadioButton radioButton = new JRadioButton(String.valueOf(1997 + i));
//			sexGroup.add(radioButton);
//			yearPanel.add(radioButton);
//		}
//
//		// Create an "all" option. too
//		JRadioButton button23 = new JRadioButton("All");
//		sexGroup.add(button23);
//		yearPanel.add(button23);
//
//		// Add the yearPanel to a JScrollPane
//		JScrollPane scrollPane = new JScrollPane(yearPanel);
//		scrollPane.setPreferredSize(new java.awt.Dimension(250, 150));
//
//		// Add the scrollPane to the filterPanelTemplate
//		filterPanel.add(scrollPane);
		return null;

	}

	private JRadioButton[] getCompareCategoryButtons() {
		// TODO Auto-generated method stub
		return null;

	}

	private JRadioButton[] getSexButtons() {
		// TODO Auto-generated method stub
		return null;

	}

//	private JTextFields[] getTimeRangeTextFields() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

	}

}
