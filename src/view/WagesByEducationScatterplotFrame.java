package view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.WagesByEducationChartController;
import model.DatasetManager;


/*
 * Name: Kelvin Nguyen
 * WagesByEducationScatterplotFrame
 * Group 1
 * Date: May 17th, 2024
 */

public class WagesByEducationScatterplotFrame extends JobspectsChartFrame {

	// Fields
	private JLabel chartFilterLabel;
    private JRadioButton[] yearButtons;
    private JRadioButton[] incomeLevelButtons;
    private JRadioButton[] educationLevelButtons;
    
    // Constructor Method
    public WagesByEducationScatterplotFrame() {
    	
		//Use an average calculation panel with a combo box to select which data 
		//category to calculate the average for
		setAverageCalculationPanel(new AverageCalculationPanel(true));
		
    	// Build the frame
    	buildFrame();
    }
    
    // Getters and Setters
	public JLabel getChartFilterLabel() {
		return chartFilterLabel;
	}

	public void setChartFilterLabel(JLabel chartFilterLabel) {
		this.chartFilterLabel = chartFilterLabel;
	}

	public void setYearButtons(JRadioButton[] yearButtons) {
		this.yearButtons = yearButtons;
	}

	public void setIncomeLevelButtons(JRadioButton[] incomeLevelButtons) {
		this.incomeLevelButtons = incomeLevelButtons;
	}

	public void setEducationLevelButtons(JRadioButton[] educationLevelButtons) {
		this.educationLevelButtons = educationLevelButtons;
	}

	// Utility Methods
	// Build the frame
    public void buildFrame() {
    	setSize(1920, 1080);
    	getScreenTitleLabel().setText("    Does a Higher Education Correlate to a Higher Income? ");
        DatasetManager datasetManager = new DatasetManager();
        
    }
    
	public void setUpYearSection() {
    	
    }
    
    public void setUpIncomeLevelSection() {
    	
    }
    
    public void setUpEducationLevelSection() {
    	
    }
    
    public void getYearButtons() {

    }
    
    public void getIncomeLevelButtons() {
    	
    }
    
    public void getEducationLevelButtons() {
    	
    }
    
    public void updateChart() {
    	
    }
    
    public void getValuesForAverage() {
    	
    }
    
}