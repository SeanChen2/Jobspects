
package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;

public class TourismEmploymentPieChartFrame extends JFrame{

	JPanel mainPanel = new JPanel();
	JLabel title = new JLabel();
	JLabel innerPanelTitle = new JLabel();
	
	TourismEmploymentInnerPanel tp = new TourismEmploymentInnerPanel();
	public TourismEmploymentPieChartFrame() {
		mainPanel.setLayout(null);

		//getContentPane().setBackground(Color.BLUE);
		setSize(1280, 720);
		title.setText("Tourism Employment");
		title.setBounds(600, 0, 600, 100);
		title.setFont(new Font("Arial", Font.BOLD, 50));

		innerPanelTitle.setText("Businesses by # of employees");
		innerPanelTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		innerPanelTitle.setBounds(120, 20, 300, 100);
		
		
		PieDataset f = createDataset();
		JFreeChart ch  = ChartFactory.createPieChart("Tourism Businesses by Year", f, true, true, true);
		ChartPanel cp = new ChartPanel(ch);
		cp.setBounds(650, 140, 500, 500);
		GridLayout gridLayout = new GridLayout(2,2);
        mainPanel.setLayout(gridLayout);
        mainPanel.add(title);
		mainPanel.add(innerPanelTitle);
		
		mainPanel.add(cp);	
		//mainPanel.setOpaque(false);
	
	    //tp.setSize(400, 300);
		
		JScrollPane scrollableChartPanel = new JScrollPane(tp);
		//scrollableChartPanel.setViewport(tp);
		//scrollableChartPanel.add(tp);
		scrollableChartPanel.setPreferredSize(new Dimension(tp.getWidth(),100)); 
		//scrollableChartPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollableChartPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		mainPanel.add(scrollableChartPanel);
	

		JScrollPane scrollableMainPanel = new JScrollPane(mainPanel);
		//mainPanel.add(tAreaPanel);
		add(mainPanel);
		//add(scrollableMainPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	private PieDataset createDataset() {
		DefaultPieDataset ds = new DefaultPieDataset();
		
		
		ds.setValue("2017", 10);
		ds.setValue("2018", 10);
		ds.setValue("2019", 10);
		ds.setValue("2020", 10);
		ds.setValue("2021", 10);
		ds.setValue("2022", 10);
		ds.setValue("2023", 10);

		return ds;
	}



	public static void main(String[] args) {
		new TourismEmploymentPieChartFrame();
	}
}