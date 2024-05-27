package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;

import com.lowagie.text.Image;

import model.TourismFileInput;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
//the frame for th derivative graph showing the rates of change in new and dissolved businesses
public class TourismEmploymentDerivativeFrame extends JFrame implements MouseListener{

	//fields
	JPanel mainPanel = new JPanel();
	JLabel backButton = new JLabel();
	JLabel title = new JLabel();
	
	TourismFileInput file = new TourismFileInput();//grabbing the data from the file reader
	int[] yearsArray = file.getYears();//getting the years
	ArrayList<Integer>[]  theData = file.getTouristBusinesses();//getting the number data
	String[] options = file.getOptions();//getting the options
	TourismEmploymentDerivativeInnerPanel tp = new TourismEmploymentDerivativeInnerPanel();//creating the inner Panel inside of the scrollpane
	
	public TourismEmploymentDerivativeFrame() {//constructor
		mainPanel.setLayout(null);
		setTitle("Jobspects");
		setIconImage(new ImageIcon("images/logo.png").getImage());//setting Icon image

		setSize(1280, 720);//sets size
		
		//the heading for the derivative
		ImageIcon picture = new ImageIcon("images/touristTitle.png");
		java.awt.Image image = picture.getImage();
		java.awt.Image newImage = image.getScaledInstance(600, 130, java.awt.Image.SCALE_SMOOTH);
		picture = new ImageIcon(newImage);
		title.setBounds(700, 0, 600, 130);
		title.setIcon(picture);
		//also setting it as a scaled image
		
		ImageIcon picture1 = new ImageIcon("images/backButton.png");//for the backButton
		java.awt.Image image1 = picture1.getImage();
		java.awt.Image newImage1 = image1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		picture1 = new ImageIcon(newImage1);
		backButton.setBounds(700, 0, 600, 170);
		backButton.setIcon(picture1);
		//giving this button a picture
		backButton.setText("   Businesses are created and ended each year on what rate?");//explanation about the frame
		backButton.setFont(new Font("Arial", Font.PLAIN, 20));
		backButton.setBounds(120, 20, 300, 100);
		backButton.setForeground(Color.white);
		backButton.addMouseListener(this);//making it clickable
		
		CategoryDataset ds = createDataset();//creates dataset
		JFreeChart ch  = ChartFactory.createLineChart
				("Tourism Rate Of Change", "year", "new businesses per year", ds, PlotOrientation.VERTICAL, true, true, true);//creates line chart
		ChartPanel cp = new ChartPanel(ch);//making chart panel
		cp.setBounds(650, 140, 500, 500);
		GridLayout gridLayout = new GridLayout(2,2);//setting gridLayout
		mainPanel.setBackground(JobspectsFrame.DARK_PURPLE);//setting background
        mainPanel.setLayout(gridLayout);
		
        //adding the GUI objects to the frame
        mainPanel.add(title);
        mainPanel.add(backButton);
		mainPanel.add(cp);	


		
    	JScrollPane scrollableChartPanel = new JScrollPane(tp);//creating scrollPane
		
		scrollableChartPanel.setPreferredSize(new Dimension(tp.getWidth(),100)); //setting scrollPane size
		scrollableChartPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //allow it to vertically scroll
		mainPanel.add(scrollableChartPanel);
	


		JScrollPane scrollableMainPanel = new JScrollPane(mainPanel);
		//mainPanel.add(tAreaPanel);
		add(mainPanel);
		//add(scrollableMainPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	private CategoryDataset createDataset() {//creates the dataset
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		//adding the total businesses/year to the chart
		ds.addValue(theData[1].get(0)-theData[0].get(0), "Total", String.valueOf(yearsArray[1]));
		ds.addValue(theData[2].get(0)-theData[1].get(0), "Total", String.valueOf(yearsArray[2]));
		ds.addValue(theData[3].get(0)-theData[2].get(0), "Total", String.valueOf(yearsArray[3]));
		ds.addValue(theData[4].get(0)-theData[3].get(0), "Total", String.valueOf(yearsArray[4]));
		ds.addValue(theData[5].get(0)-theData[4].get(0), "Total", String.valueOf(yearsArray[5]));
		ds.addValue(theData[6].get(0)-theData[5].get(0), "Total", String.valueOf(yearsArray[6]));
		
		//adding each year's employee breakdown data to the chart, to compare with the total
		for(int i = 0; i < options.length-2; i++) {
			ds.addValue(theData[1].get(i+1)-theData[0].get(i+1), options[i+2], String.valueOf(yearsArray[1]));
			ds.addValue(theData[2].get(i+1)-theData[1].get(i+1), options[i+2], String.valueOf(yearsArray[2]));
			ds.addValue(theData[3].get(i+1)-theData[2].get(i+1), options[i+2], String.valueOf(yearsArray[3]));
			ds.addValue(theData[4].get(i+1)-theData[3].get(i+1), options[i+2], String.valueOf(yearsArray[4]));
			ds.addValue(theData[5].get(i+1)-theData[4].get(i+1), options[i+2], String.valueOf(yearsArray[5]));
			ds.addValue(theData[6].get(i+1)-theData[5].get(i+1), options[i+2], String.valueOf(yearsArray[6]));
		}
	

		return ds;
	}



	public static void main(String[] args) {
		new TourismEmploymentDerivativeFrame();//For testing purposes
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == backButton) {
			//closes this frames and returns to menuframe
			this.dispose();
			new JobspectsMenuFrame();
		}
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}