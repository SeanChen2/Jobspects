package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class UnemploymentDurationChartController extends ChartController implements ActionListener{
	
	JButton[] chartNavButtons;
	
	
	public UnemploymentDurationChartController() {
		super(menuFrame);

		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void updateChart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}

}
