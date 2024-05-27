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
		// You'll never see it coming Sean
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
		JLabel title = new JLabel();
		title.setText("Compare by:");
		title.setFont(new Font("Sans Serif", Font.BOLD, 36));
		title.setBounds(0, 0, WIDTH, HEIGHT);
		filterPanel.add(title);

		geographyButton = new JRadioButton("Geography");
		ageGroupButton = new JRadioButton("Age Group");
		compareGroup.add(geographyButton);
		compareGroup.add(ageGroupButton);
		filterPanel.add(geographyButton);
		filterPanel.add(ageGroupButton);

	}

	private void setUpFilterSection() {
		JLabel filterLabel = new JLabel("Filter by:");
		filterLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
		filterPanel.add(filterLabel);

		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		filterPanel.add(sexLabel);

		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		allButton = new JRadioButton("All");
		sexGroup.add(maleButton);
		sexGroup.add(femaleButton);
		sexGroup.add(allButton);
		filterPanel.add(maleButton);
		filterPanel.add(femaleButton);
		filterPanel.add(allButton);

		JLabel timeRangeLabel = new JLabel("Time Range:");
		timeRangeLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		filterPanel.add(timeRangeLabel);

		JPanel timeRangePanel = new JPanel();
		startTimeField = new JTextField(4);
		endTimeField = new JTextField(4);
		timeRangePanel.add(startTimeField);
		timeRangePanel.add(new JLabel("to"));
		timeRangePanel.add(endTimeField);
		filterPanel.add(timeRangePanel);
		
		
		//
		//
		//
		
		// Create a panel within the filter panel for education levels
		JPanel durationPanel = new JPanel(new GridLayout(0, 1, 5, 5));

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
			durationGroup.add(radioButton);
		}

		// Add the educationPanel to a JScrollPane
		JScrollPane durationScrollPane = new JScrollPane(durationPanel);
		durationScrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

		// Add the scrollPane to the filterPanelTemplate
		filterPanel.add(durationScrollPane);

	}

	private void SetUpAverageSection() {
//		JLabel averageLabel = new JLabel("Calculate average:");
//        averageLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
//        filterPanel.add(averageLabel);
//        
//        averageTypeComboBox = new JComboBox<>(new String[] { "Mean", "Median" });
//        ageGroupComboBox = new JComboBox<>(new String[] { "All Age Groups", "15-24", "25-54", "55+" });
//        JPanel averagePanel = new JPanel();
//        averagePanel.add(averageTypeComboBox);
//        averagePanel.add(ageGroupComboBox);
//        filterPanel.add(averagePanel);
//
//        JButton calculateButton = new JButton("Calculate");
//        calculateButton.addActionListener(this);
//        filterPanel.add(calculateButton);
//
//        averageResultLabel = new JLabel("Average: ");
//        averageResultLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
//        filterPanel.add(averageResultLabel);

	}

	public JButton[] getChartNavButtons() {
		// TODO Auto-generated method stub
		// Create a new JPanel to hold the "Year" label and radio buttons
		JPanel yearPanel = new JPanel(new GridLayout(0, 3, 5, 5)); // Adjust the columns as needed

		// Create the category labels
		JLabel years = new JLabel();
		years.setText("Year:");
		years.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		yearPanel.add(years);

		// Initialize ButtonGroup for years
		sexGroup = new ButtonGroup();

		// Create radio buttons for years
		for (int i = 0; i < 23; i++) {
			JRadioButton radioButton = new JRadioButton(String.valueOf(1997 + i));
			sexGroup.add(radioButton);
			yearPanel.add(radioButton);
		}

		// Create an "all" option. too
		JRadioButton button23 = new JRadioButton("All");
		sexGroup.add(button23);
		yearPanel.add(button23);

		// Add the yearPanel to a JScrollPane
		JScrollPane scrollPane = new JScrollPane(yearPanel);
		scrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

		// Add the scrollPane to the filterPanelTemplate
		filterPanel.add(scrollPane);
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
