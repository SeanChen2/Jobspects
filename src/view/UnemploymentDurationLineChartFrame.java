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

import view.OccupationLabourBarChartFrame.CircularGradientPanel;

public class UnemploymentDurationLineChartFrame extends JobspectsChartFrame implements ActionListener {

	private JPanel filterPanel = new JPanel();
    private ButtonGroup compareGroup = new ButtonGroup();
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

		// Create and add JTextArea
//		JTextArea textArea = new JTextArea();
//		textArea.setFont(new Font("Serif", Font.PLAIN, 16));
//		textArea.setForeground(Color.BLACK);
//		textArea.setBackground(Color.WHITE); // Set the same color as the middle gradient color
//		textArea.setBounds(1500, 500, 400, 300);
//		textArea.setLineWrap(true);
//		textArea.setWrapStyleWord(true);
//		textArea.setText("This is a JTextArea.\n" + "Nothing is written atm for testing purposes only");
//		getContentPane().add(textArea);

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
