package view;

import java.awt.Color;
import javax.swing.border.AbstractBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

//This is a general class for all 5 chart frames in the project.
//Each data sub-topic has its own chart frame, all of which share
//common design elements that are defined in this abstract class.
public abstract class JobspectsChartFrame extends JobspectsFrame {
	
	//Reference to the panel that calculates an average value based on the chart data (UNFINISHED)
	private AverageCalculationPanel averageCalculationPanel;
	
	//A button that navigates back to the menu frame
	private JButton backButton;
	
	//An empty label that displays a header for the screen
	private JLabel screenTitleLabel = new JLabel(" ");
	
	//An empty panel for the chart to be displayed on
	private JPanel chartPanelTemplate;
	
	//Constructor method: set up the common elements of the chart frame
	public JobspectsChartFrame() {
		
		setUpFrame();
		setUpChartPanel();
		
	}
	
	//Necessary getters and setters for GUI elements on the frame
	
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
	
	public void setAverageCalculationPanel(AverageCalculationPanel averageCalculationPanel) {
		this.averageCalculationPanel = averageCalculationPanel;
	}
	

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public void setScreenTitleLabel(JLabel screenTitleLabel) {
		this.screenTitleLabel = screenTitleLabel;
	}

	public void setChartPanelTemplate(JPanel chartPanelTemplate) {
		this.chartPanelTemplate = chartPanelTemplate;
	}

	//This method sets up the basic appearance of the chart frame, including:
	//a back button and a screen title
	protected void setUpFrame() {
		
		//Set up the back button with an image, and position it in the top left corner
        backButton = new JButton(new ImageIcon("./images/BigBackButton.png"));
        backButton.setBounds(30, 30, 70, 70);
		add(backButton);
		
		//Set up the title label with a white background and purple text, and position it at the
		//top of the screen. Use a bold, size 30 font.
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
		
		//Set up the chart panel with a null layout, so that the chart can be added with coordinates
		chartPanelTemplate = new JPanel(null);
		
		//Position the chart panel on the left side of the screen with a white background
		chartPanelTemplate.setBounds(30, 180, FRAME_WIDTH / 2 + 100, FRAME_HEIGHT - 300);
		chartPanelTemplate.setBackground(Color.WHITE);
		add(chartPanelTemplate);	
		
	}
	
}
