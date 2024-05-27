
package controller;
//this controller will be called on in order to open up the Tourism Frame

import java.util.ArrayList;

import view.JobspectsMenuFrame;
import view.TourismEmploymentPieChartFrame;

public class TourismEmploymentChartController extends ChartController {
	
	TourismEmploymentPieChartFrame pieChart = new TourismEmploymentPieChartFrame();//Hae the frame
	public TourismEmploymentChartController(JobspectsMenuFrame menuFrame) {
		super(menuFrame);
	//	setChartFrame(pieChart);//had to comment this because ScrollPane and gridlayout weren't allowing me to inherit JobspectsChartFrame
		new TourismEmploymentPieChartFrame();//opens up the frame in case updateChart() is not needed
	}

	@Override
	public void updateChart() {
		new TourismEmploymentPieChartFrame();

		//opens up the frame
	}

	@Override
	protected ArrayList<Double> getValuesForAverage() {
		//We scrapped this method since ran out of time
		return null;
	}

}
