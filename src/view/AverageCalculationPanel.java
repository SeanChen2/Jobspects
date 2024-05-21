package view;



	
	/*averageLabel: JLabel
- averageTypes: String[]
- averageTypeComboBox: JComboBox
- categoryComboBox: JComboBox
- calculateAverageButton: JButton
- resultLabel: JLabel
<<constructor>> AverageCalculationPanel(
addCategoryComboBox: boolean)
- setUpAverageCalculationComboBox(): void
- setUpAverageLabel(): void
+ getAverageTypeComboBox(): JComboBox
+ getCategoryComboBox(): JComboBox
+ getCalculateAverageButton(): JButton
+ getResultLabel(): JLabel
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	
	
	
import javax.swing.*;

public class AverageCalculationPanel extends JPanel {
	
	//Fields
	private JLabel averageLabel;
	private String[] averageTypes;
	private JComboBox<String> averageTypeComboBox;
	private JComboBox<String> categoryComboBox;
	private JButton calculateAverageButton = new JButton("Calculate");
	private JLabel resultLabel;
	
	//Constructor
	public AverageCalculationPanel(boolean addCategoryComboBox) {
		
		
		
	}
	
	//Getters
	public JComboBox<String> getAverageTypeComboBox() {
		return averageTypeComboBox;
	}

	public JComboBox<String> getCategoryComboBox() {
		return categoryComboBox;
	}

	public JButton getCalculateAverageButton() {
		return calculateAverageButton;
	}

	public JLabel getResultLabel() {
		return resultLabel;
	}
	
	
	//Methods
	private void setUpAverageCalculationComboBox() {
		
		
		
	}
	
	private void setUpAverageLabel() {
		
		
		
	}
	
}

