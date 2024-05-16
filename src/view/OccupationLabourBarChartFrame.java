package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OccupationLabourBarChartFrame extends JFrame implements ActionListener {
    private JButton back;

    public OccupationLabourBarChartFrame() {
        setSize(1920, 1080);
        setTitle("Title Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create button
        back = new JButton("<");
        back.addActionListener(this);

        // Set absolute position for button
        back.setBounds(10, 10, 50, 30); // (x, y, width, height)

        // Add button to content pane
        getContentPane().add(back);

        // Create and add label
        JLabel titleLabel = new JLabel("What are Canada's top jobs? Are their any trends/bia's?");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 55	));

        // Set absolute position for label
        titleLabel.setBounds(10,30, 5000, 100); // (x, y, width, height)

        // Add label to content pane
        getContentPane().add(titleLabel);

        // Set content pane layout to null for absolute positioning
        getContentPane().setLayout(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == back) {
            // Handle button click event
            System.out.println("Back button clicked");
            new JobspectsTitleFrame();
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OccupationLabourBarChartFrame::new);
    }
}