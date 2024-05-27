package view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;

import model.TourismFileInput;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
//the pnale showing each employee category's derivative, because some of them appear to be straight lines on the main frame's derivative
public class TourismEmploymentDerivativeInnerPanel extends JPanel{

	//fields
	JFreeChart[] fc = new JFreeChart[8];
	CategoryDataset[] das = new CategoryDataset[8]; 
	ChartPanel[] cPanel = new ChartPanel[8];
	
	TourismFileInput file = new TourismFileInput();//grabbing the data from the file reader
	int[] yearsArray = file.getYears();//getting the years
	ArrayList<Integer>[]  theData = file.getTouristBusinesses();//getting the number data
	String[] options = file.getOptions();

	
	public TourismEmploymentDerivativeInnerPanel() {
		setLayout(null);
		setBackground(Color.lightGray);
		//setBounds(70, 100, 320, 500);
        setPreferredSize(new Dimension(300,500));
	//	bar.setBounds(300, 0, 20, 500);
		//bar.setOrientation(1);
		//add(bar);
		
		for(int i = 0; i < 8; i ++) {
			das[i] = createDataset(i);//creates dataset
			fc[i] = ChartFactory.createLineChart
					("Businesses with " + String.valueOf(options[i+2]), "year", "new businesses per year", das[i], PlotOrientation.VERTICAL, false, true, true);
			//creating the line chart
			cPanel[i] = new ChartPanel(fc[i]);
			//creating chart panel
			cPanel[i].setBounds(20, i*420, 560, 350);
			add(cPanel[i]);

		}
		setPreferredSize(new Dimension(300,3340));
		
		
		
	}

	private CategoryDataset createDataset(int index) {
		//creates dataset
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		//adding each year's value, and its data
		ds.addValue(theData[1].get(index+1)-theData[0].get(index+1), options[index+2], String.valueOf(yearsArray[1]));
		ds.addValue(theData[2].get(index+1)-theData[1].get(index+1), options[index+2], String.valueOf(yearsArray[2]));
		ds.addValue(theData[3].get(index+1)-theData[2].get(index+1), options[index+2], String.valueOf(yearsArray[3]));
		ds.addValue(theData[4].get(index+1)-theData[3].get(index+1), options[index+2], String.valueOf(yearsArray[4]));
		ds.addValue(theData[5].get(index+1)-theData[4].get(index+1), options[index+2], String.valueOf(yearsArray[5]));
		ds.addValue(theData[6].get(index+1)-theData[5].get(index+1), options[index+2], String.valueOf(yearsArray[6]));
		return ds;
	}

	
}