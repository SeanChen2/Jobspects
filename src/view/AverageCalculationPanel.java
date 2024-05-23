package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AverageCalculationPanel extends JPanel {
    private JLabel averageLabel;
    private String[] averageTypes = {"Mean", "Median"};
    private JComboBox<String> averageTypeComboBox;
    private JComboBox<String> categoryComboBox;
    private JButton calculateAverageButton;
    private JLabel resultLabel;

    public AverageCalculationPanel(boolean addCategoryComboBox) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        averageLabel = new JLabel("Calculate Average:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(averageLabel, gbc);

        averageTypeComboBox = new JComboBox<>(averageTypes);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(averageTypeComboBox, gbc);

        if (addCategoryComboBox) {
            categoryComboBox = new JComboBox<>();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new JLabel("Category:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            add(categoryComboBox, gbc);
        }

        calculateAverageButton = new JButton("Calculate");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(calculateAverageButton, gbc);

        resultLabel = new JLabel("Result:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);
    }

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

    public void setCategoryOptions(String[] categories) {
        categoryComboBox.setModel(new DefaultComboBoxModel<>(categories));
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }
}



