
package controller;
//this controller will be called on in order to open up the Tourism Frame

import java.util.ArrayList;

import view.JobspectsMenuFrame;
import view.TourismEmploymentPieChartFrame;

public class TourismEmploymentChartController extends ChartController {
	
	TourismEmploymentPieChartFrame pieChart = new TourismEmploymentPieChartFrame();//Hae the frame
	public TourismEmploymentChartController(JobspectsMenuFrame menuFrame) {
		super(menuFrame);
		setChartFrame(pieChart);
		
	}

	@Override
	public void updateChart() {
		
		//opens up the frame
	}

	@Override
	protected ArrayList<Double> getValuesForAverage() {
		//We scrapped this method since ran out of time
		return null;
	}

}
