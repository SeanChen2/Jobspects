package view;
//this is the frame that displays the tourism graph
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import org.jfree.data.general.*;

import model.TourismFileInput;

import org.jfree.chart.*;
public class TourismEmploymentPieChartFrame extends JobspectsChartFrame implements MouseListener{

	//fields
	JPanel mainPanel = new JPanel();
	JLabel forwardButton = new JLabel();
	JLabel title = new JLabel();
	
	TourismFileInput file = new TourismFileInput();//grabbing the data from the file reader
	int[] yearsArray = file.getYears();//getting the years
	ArrayList<Integer>[]  theData = file.getTouristBusinesses();//getting the number data
	String[] options = file.getOptions();//grabbing the employee options
	TourismEmploymentInnerPanel innerPanel = new TourismEmploymentInnerPanel();//creating the inner Panel
	
	public TourismEmploymentPieChartFrame() {//constructor
		mainPanel.setLayout(null);
		setTitle("Jobspects");
		setIconImage(new ImageIcon("images/logo.png").getImage());//setting Icon image

		//getContentPane().setBackground(Color.BLUE);
		setSize(1280, 720);
		//title.setText("    Tourism Employment");
		//title.setBounds(700, 0, 600, 100);
		//title.setFont(new Font("Arial", Font.BOLD, 50));
		
		setAverageCalculationPanel(new AverageCalculationPanel(false));
		
		//setting the button as a picture
		ImageIcon picture = new ImageIcon("images/ForwardButton.png");
		java.awt.Image image = picture.getImage();
		java.awt.Image newImage = image.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		picture = new ImageIcon(newImage);
		forwardButton.setBounds(650, 0, 600, 130);
		forwardButton.setIcon(picture);
		forwardButton.setText("        Click here to learn more about the trends of tourism employment");
		//the prompt for the user to press the button
		forwardButton.setForeground(Color.white);
		forwardButton.addMouseListener(this);//makes is clickable

		//this is the heading for the frame
		ImageIcon picture1 = new ImageIcon("images/touristTitle.png");
		java.awt.Image image1 = picture1.getImage();
		java.awt.Image newImage1 = image1.getScaledInstance(200, 70, java.awt.Image.SCALE_SMOOTH);
		picture = new ImageIcon(newImage1);
		title.setBounds(650, 0, 300, 70);
		title.setIcon(picture1);
		//making the heading a picture of a screenshot
		
		PieDataset dataset = createDataset();//creates dataset
		JFreeChart chart  = ChartFactory.createPieChart("Tourism Businesses by Year", dataset, true, true, true);//making JFreeChart
		ChartPanel cp = new ChartPanel(chart);//the panel placed on the ScrollPane
		cp.setBounds(650, 140, 500, 500);
		GridLayout gridLayout = new GridLayout(2,2);//setting the GridLayout so that the ScrollPane would display
		mainPanel.setBackground(JobspectsFrame.DARK_PURPLE);//setting background
      
		//adding objects to Panel
		mainPanel.setLayout(gridLayout);
		mainPanel.add(title);
        mainPanel.add(forwardButton);
		mainPanel.add(cp);	


		//mainPanel.setOpaque(false);
	
	    //innerPanel.setSize(400, 300);
		
		JScrollPane scrollableChartPanel = new JScrollPane(innerPanel);//making scrollPane
		
		scrollableChartPanel.setPreferredSize(new Dimension(innerPanel.getWidth(),100)); //setting size
		scrollableChartPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //adding vertical scroll
		mainPanel.add(scrollableChartPanel);
	

		JScrollPane scrollableMainPanel = new JScrollPane(mainPanel);
		//mainPanel.add(tAreaPanel);
		add(mainPanel);
		//add(scrollableMainPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	private PieDataset createDataset() {
		DefaultPieDataset ds = new DefaultPieDataset();//creating the dataset
		
		//adding each year and the business count to the pie chart
		ds.setValue(String.valueOf(yearsArray[0]), theData[0].get(0));
		ds.setValue(String.valueOf(yearsArray[1]), theData[1].get(0));
		ds.setValue(String.valueOf(yearsArray[2]), theData[2].get(0));
		ds.setValue(String.valueOf(yearsArray[3]), theData[3].get(0));
		ds.setValue(String.valueOf(yearsArray[4]), theData[4].get(0));
		ds.setValue(String.valueOf(yearsArray[5]), theData[5].get(0));
		ds.setValue(String.valueOf(yearsArray[6]), theData[6].get(0));


		return ds;
	}



	public static void main(String[] args) {
		new TourismEmploymentPieChartFrame();//for testing purposes
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == forwardButton){
			//closes this frame, and opens up derivative
			this.dispose();
			new TourismEmploymentDerivativeFrame();
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