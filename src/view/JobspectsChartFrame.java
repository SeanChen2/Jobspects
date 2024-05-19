package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

//This is a general class for all 5 chart frames in the project.
//Each data sub-topic has its own chart frame, all of which share
//common design elements that are defined in this abstract class.
public abstract class JobspectsChartFrame extends JobspectsFrame {
	
	//Object references
	private AverageCalculationPanel averageCalculationPanel;
	
	//Fields
	private JButton backButton = new JButton("<");
	private JLabel screenTitleLabel = new JLabel(" ");
	private JPanel chartPanelTemplate;
	
	//Constructor method:
	public JobspectsChartFrame() {
		
		setUpFrame();
		setUpChartPanel();
		
	}
	
	//Necessary getters for GUI elements on the frame
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JLabel getScreenTitleLabel() {
		return screenTitleLabel;
	}

	public JPanel getChartPanelTemplate() {
		return chartPanelTemplate;
	}
	
	public AverageCalculationPanel getAverageCalculationPanel() {
		return averageCalculationPanel;
	}
	
	//This method sets up the basic appearance of the chart frame, including:
	//a back button and a screen title
	private void setUpFrame() {
		
		//Set up the back button
		backButton.setBounds(30, 30, 70, 70);
		backButton.setBackground(Color.WHITE);
		backButton.setForeground(DARK_PURPLE);
		backButton.setFocusPainted(false);
		backButton.setFont(new Font("Sans Serif", Font.BOLD, 30));
		add(backButton);
		
		//Set up the title label
		screenTitleLabel.setBounds(120, 30, FRAME_WIDTH - 180, 70);
		screenTitleLabel.setBackground(Color.WHITE);
		screenTitleLabel.setForeground(DARK_PURPLE);
		screenTitleLabel.setOpaque(true);
		screenTitleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
		add(screenTitleLabel);
		
	}
	
	//This method sets up a large, empty panel on the left side of the screen, used
	//to hold a chart later on
	private void setUpChartPanel() {
		
		chartPanelTemplate = new JPanel();
		chartPanelTemplate.setBounds(30, 230, FRAME_WIDTH / 2 + 100, FRAME_HEIGHT - 300);
		chartPanelTemplate.setBackground(Color.WHITE);
		add(chartPanelTemplate);
		
	}
	
}
