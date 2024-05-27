package view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;
import org.jfree.data.general.*;

import model.TourismFileInput;

import org.jfree.chart.*;
//the inner panel that was displayed inside the scrollpane
public class TourismEmploymentInnerPanel extends JPanel{

	//fields
	JFreeChart[] pieChart = new JFreeChart[7];
	PieDataset[] das = new PieDataset[7]; //= //createDataset();
	ChartPanel[] cPanel = new ChartPanel[7];
	
	TourismFileInput file = new TourismFileInput();//grabbing the data from the file reader
	int[] yearsArray = file.getYears();//getting the years
	ArrayList<Integer>[]  theData = file.getTouristBusinesses();//getting the number data
	String[] options = file.getOptions();//getting the files

	
	public TourismEmploymentInnerPanel() {//constructor
		setLayout(null);
		setBackground(JobspectsFrame.DARK_PURPLE);
        setPreferredSize(new Dimension(300,500));//set size
	
		//making each chart in the scrollPane
		for(int i = 0; i < 7; i ++) {
			das[i] = createDataset(i);//create the dataset
			pieChart[i] = ChartFactory.createPieChart(String.valueOf(yearsArray[i]), das[i], true, true, true);//create each piechart
			cPanel[i] = new ChartPanel(pieChart[i]);//create the pie chart panel
			cPanel[i].setBounds(100, i*420, 400, 350);
			add(cPanel[i]);

		}
		setPreferredSize(new Dimension(300,2940));//set size of panel
		
		
		
	}

	private PieDataset createDataset(int index) {
		//this is where the values are added
		DefaultPieDataset ds = new DefaultPieDataset();
		
		//add each option and its data
		ds.setValue(options[2], theData[index].get(1));
		ds.setValue(options[3], theData[index].get(2));
		ds.setValue(options[4], theData[index].get(3));
		ds.setValue(options[5], theData[index].get(4));
		ds.setValue(options[6], theData[index].get(5));
		ds.setValue(options[7], theData[index].get(6));
		ds.setValue(options[8], theData[index].get(7));
		ds.setValue(options[9], theData[index].get(8));
		return ds;
	}

	
}