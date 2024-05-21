package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import view.OccupationLabourBarChartFrame.CircularGradientPanel;

public class UnemploymentDurationLineChartFrame extends JFrame implements ActionListener{
	
	private JButton backButton;
	private JButton[] chartNavButtons = new JButton[2];
	private JPanel filterPanel = new JPanel();
	//private UnemploymentDurationFilterPanel chartFilterSection;
	


	public UnemploymentDurationLineChartFrame() {
		
		//getScreenTitleLabel().setText("	  What factors affect the Duration of Employment in Canada?");

		setSize(1920, 1080);
		// You'll never see it coming Sean
		setTitle("Jobspects😎");
		//CircularGradientPanel gradientPanel = new CircularGradientPanel();
		//gradientPanel.setLayout(null);
		//setContentPane(gradientPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpChartNavButtons();
		
		 setUpFilterPanel();
		 
		 setUpCompareCategorySection();
		 
		 setUpFilterSection();
		 
		 SetUpAverageSection();
		 
		 getChartNavButtons();
		 
		 getCompareCategoryButtons();
		 
		 getSexButtons();
		 
		// getTimeRangeTextFields()
		
		// Create button
		backButton = new JButton("<");
		backButton.addActionListener(this);

		// Set absolute position for button
		backButton.setBounds(10, 10, 50, 30); // (x, y, width, height)

		// Add button to content pane
		getContentPane().add(backButton);

		// Create and add label
		JLabel titleLabel = new JLabel("What factors affect the Duration of Employment in Canada?");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 55));
		titleLabel.setForeground(Color.WHITE); // Set text color to white

		// Set position for label
		titleLabel.setBounds(10, 30, 5000, 100); // (x, y, width, height)

		// Add label to content pane
		getContentPane().add(titleLabel);

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
		
		setVisible(false);


	}
	


	private void setUpChartNavButtons() {
		// TODO Auto-generated method stub
		//Set up and add the back button
		chartNavButtons[0] = new JButton("Line Graph");
		chartNavButtons[0].setBounds(30, 150, 250, 60);
		chartNavButtons[0].setBackground(new Color(232, 192, 225));
		chartNavButtons[0].setForeground(JobspectsFrame.DARK_PURPLE);
		chartNavButtons[0].setFont(new Font("Sans Serif", Font.BOLD, 24));
		chartNavButtons[0].setFocusPainted(false);
		add(chartNavButtons[0]);
		
		chartNavButtons[1] = new JButton("Time Series Chart");
		chartNavButtons[1].setBounds(290, 150, 250, 80);
		chartNavButtons[1].setBackground(new Color(232, 192, 225));
		chartNavButtons[1].setForeground(JobspectsFrame.DARK_PURPLE);
		chartNavButtons[1].setFont(new Font("Sans Serif", Font.BOLD, 24));
		chartNavButtons[1].setFocusPainted(false);
		add(chartNavButtons[1]);
		
	}



	private void setUpFilterPanel() {
		// TODO Auto-generated method stub
		
	}



	private void setUpCompareCategorySection() {
		// TODO Auto-generated method stub
		
	}



	private void setUpFilterSection() {
		// TODO Auto-generated method stub
		
	}



	private void SetUpAverageSection() {
		// TODO Auto-generated method stub
		
	}



	public  JButton[] getChartNavButtons() {
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



	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
            // Handle button click event
            System.out.println("Back button clicked");
            new JobspectsTitleFrame();
            dispose();
        }
	}

}
