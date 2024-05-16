package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class OccupationLabourBarChartFrame extends JFrame implements ActionListener {
    private JButton back;
    
    class CircularGradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();

            // Define the center and radius of the circular gradient
            Point2D center = new Point2D.Float(width / 2, height / 2);
            float radius = Math.min(width, height) / 2;

            // Define the colors
            Color color1 = new Color(60,1,35); // red (Top color)
            Color color2 = new Color(60,1,35); // White (Middle color)
            Color color3 = new Color(20,0,56); // gold (Bottom color)


            // Define the fractions for the gradient
            float[] fractions = {0.0f, 0.5f, 1.0f};
            Color[] colors = {color1, color2, color3};

            // Create the radial gradient paint
            RadialGradientPaint rgp = new RadialGradientPaint(center, radius, fractions, colors);

            // Set the paint and fill the entire panel
            g2d.setPaint(rgp);
            g2d.fillRect(0, 0, width, height);
        }
    }

    public OccupationLabourBarChartFrame() {
        setSize(1920, 1080);
        setTitle("Title Frame");
        CircularGradientPanel gradientPanel = new CircularGradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create button
        back = new JButton("<");
        back.addActionListener(this);

        // Set absolute position for button
        back.setBounds(10, 10, 50, 30); // (x, y, width, height)

        // Add button to content pane
        getContentPane().add(back);

     // Create and add label
        JLabel titleLabel = new JLabel("What are Canada's top jobs? Are there any trends/biases?");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 55));
        titleLabel.setForeground(Color.WHITE); // Set text color to white

        // Set position for label
        titleLabel.setBounds(10, 30, 5000, 100); // (x, y, width, height)

        // Add label to content pane
        getContentPane().add(titleLabel);

        // Set content pane layout to null for absolute positioning
        getContentPane().setLayout(null);

        setVisible(true);
        
        // Create and add JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE); // Set the same color as the middle gradient color
        textArea.setBounds(1500, 500, 400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("This is a JTextArea.\n"
        		+ "Nothing is written atm for testing purposes only");
        getContentPane().add(textArea);

        // Set content pane layout to null for absolute positioning
        getContentPane().setLayout(null);
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