package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import view.OccupationLabourBarChartFrame.CircularGradientPanel;

public class UnemploymentDurationLineChartFrame extends JobspectsChartFrame implements ActionListener{
	
	public UnemploymentDurationLineChartFrame() {
		setSize(1920, 1080);
		// You'll never see it coming Sean
		setTitle("Jobspects😎");
		//CircularGradientPanel gradientPanel = new CircularGradientPanel();
		//gradientPanel.setLayout(null);
		//setContentPane(gradientPanel);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setAverageCalculationPanel(new AverageCalculationPanel(true));
		
		setUpChartNavButtons();
		
		 setUpFilterPanel();
		 
		 setUpCompareCategorySection();
		 
		 setUpFilterSection();
		 
		 SetUpAverageSection();
		 
//		 getChartNavButtons();
//		 
//		 getCompareCategoryButtons();
//		 
//		 getSexButtons();
//		 
		// getTimeRangeTextFields()
		

		// Create and add label
		getScreenTitleLabel().setText("    What factors affect the Duration of Employment in Canada?");

		// Set position for label
//		titleLabel.setBounds(10, 30, 5000, 100); // (x, y, width, height)

		// Add label to content pane
//		getContentPane().add(titleLabel);

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
		
		//setVisible(false);


	}
	


	private void setUpChartNavButtons() {
		// TODO Auto-generated method stub
		
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




	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
