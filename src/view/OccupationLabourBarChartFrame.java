package view;
import javax.swing.*;

import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.OccupationLabourBarChartController;

import model.Labour;

public class OccupationLabourBarChartFrame extends JobspectsChartFrame {
    private JButton back;
    private ArrayList<Labour> labourList = new ArrayList<Labour>();

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
            Color color1 = new Color(60, 1, 35); // red (Top color)
            Color color2 = new Color(60, 1, 35); // White (Middle color)
            Color color3 = new Color(20, 0, 56); // gold (Bottom color)

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
        setUpFrame(); // Initialize the common frame elements

        setSize(1920, 1080);
        setTitle("Title Frame");
        
        readFile();

        CircularGradientPanel gradientPanel = new CircularGradientPanel();
        gradientPanel.setLayout(null);
        setContentPane(gradientPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back = getBackButton(); // Use the back button from the parent class

        // Set absolute position for button
        back.setBounds(10, 10, 50, 30); // (x, y, width, height)
        getContentPane().add(back); // Add button to content pane

//        // Add ActionListener to the back button
//        back.addActionListener(e -> {
//           new OccupationLabourBarChartController();
//        });

        // Create and add label
        JLabel titleLabel = getScreenTitleLabel(); // Use the screen title label from the parent class
        titleLabel.setText("What are Canada's top jobs? Are there any trends/biases?");
        getContentPane().add(titleLabel); // Add label to content pane

        // Create and add JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE); // Set the same color as the middle gradient color
        textArea.setBounds(1500, 500, 400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("This is a JTextArea.\n" + "Nothing is written atm for testing purposes only");
        getContentPane().add(textArea);

        // Create and add the bar chart panel
        JPanel barChartPanel = createBarChartPanel();
        barChartPanel.setBounds(50, 150, 800, 600);
        getContentPane().add(barChartPanel);
    }

    //
    private void readFile() {
		
    	Scanner inputFile;
		
    	try {
			inputFile = new Scanner(new File("data/Occupation.csv"));
			

	    	inputFile.useDelimiter(",|\r\n");
	    	
	    	//this skips the first nine lines certain lines from the data to make it more compact/smaller
	    	for (int skip = 0; skip < 9; skip++) {
	    		inputFile.nextLine();
	    	}
	    	
	    	int index = 0;
	    	
	    	while(inputFile.hasNext()) {

	    		
	    		labourList.add(index,new Labour());
	    		
	    		labourList.get(index).setMonth(inputFile.next());
	    		labourList.get(index).setGeography(inputFile.next());
	    		labourList.get(index).setLaborForce(inputFile.next());
	    		labourList.get(index).setOccupation(inputFile.next());
	    		labourList.get(index).setAge(inputFile.next());
	    		labourList.get(index).setBoth(inputFile.next());
	    		labourList.get(index).setMale(inputFile.next());
	    		labourList.get(index).setFemale(inputFile.next());
	    		
	    		// skips every 7 initial skip
		    	for (int skip = 0; skip < 7; skip++) {
		    		inputFile.nextLine();
		    	}


	    		index++;
	    		
	    	}
	    	

	    	
    		System.out.println(labourList.get(7).getLaborForce());
    	//	System.out.println(labourList.get(1).getAge());
    		//System.out.println(labourList.get(2).getAge());

	    	
		} catch (FileNotFoundException error) {
			
			System.out.println(error);
			
		}

    	
		
	}

	private JPanel createBarChartPanel() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Occupation Labour Statistics", // Chart title
                "Occupation", // X-axis label
                "Number of Jobs", // Y-axis label
                createDataset(), // Dataset
                PlotOrientation.VERTICAL,
                true, true, false);

        return new ChartPanel(barChart);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(12000, "Jobs", "Software Developer");
        dataset.addValue(8000, "Jobs", "Data Analyst");
        dataset.addValue(15000, "Jobs", "Project Manager");
        // Add more data as needed

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OccupationLabourBarChartFrame frame = new OccupationLabourBarChartFrame();
            frame.setVisible(true);
        });
    }
}
