//package controller;
//
//public class UnemploymentDurationChartController {
//
//}
//

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import view.JobspectsMenuFrame;
import view.UnemploymentDurationLineChartFrame;

public class UnemploymentDurationChartController extends ChartController implements ActionListener{
	
	JButton[] chartNavButtons;
	
	
	public UnemploymentDurationChartController(JobspectsMenuFrame menuFrame) {
		
		super(menuFrame);
		
		setChartFrame(new UnemploymentDurationLineChartFrame());
		showChartFrame();
		
		updateChart();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void updateChart() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(500, "sdfsdf", "2020");
		dataset.addValue(111, "sdfsdf", "2024");
		
		dataset.addValue(520, "(trying again)", "1999");
		dataset.addValue(1111, "(trying again)", "2024");
		
		

		setChart(ChartFactory.createLineChart("Placeholder", "Date", "Jobless induviduals", dataset, PlotOrientation.VERTICAL, true, true, false));
		
		
	}

	@Override
	//wants it not to be void in chartController
	public ArrayList<Double> getValuesForAverage() {
		return null;
		// TODO Auto-generated method stub
	}

}
