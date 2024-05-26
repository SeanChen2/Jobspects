package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import view.OccupationLabourBarChartFrame.CircularGradientPanel;

public class UnemploymentDurationLineChartFrame extends JobspectsChartFrame implements ActionListener{
	
	private JPanel filterPanel = new JPanel();	

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
		 
		// getTimeRangeTextFields()
		
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
		//Display the filter "sections" vertically using a box layout
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterPanel.setBackground(Color.decode("#fffef7"));

		
		//Make the filter panel vertically scrollable
		JScrollPane filterScrollPane = new JScrollPane(filterPanel, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		filterScrollPane.setBounds(FRAME_WIDTH / 2 + 150, 180, FRAME_WIDTH / 2 - 200, FRAME_HEIGHT - 290);
		filterScrollPane.setBackground(Color.WHITE);
		add(filterScrollPane);
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
