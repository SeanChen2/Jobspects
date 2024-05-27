package controller;

import view.OccupationLabourBarChartFrame;
import view. JobspectsMenuFrame; // Import the frame you want to navigate to

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OccupationLabourBarChartController extends ChartController{
    private OccupationLabourBarChartFrame frame = new OccupationLabourBarChartFrame();;

    public OccupationLabourBarChartController(JobspectsMenuFrame menuFrame) {
        super(menuFrame);
    	setChartFrame(frame);
        initialize();
    }

    private void initialize() {
        frame.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBackButtonClicked();
            }
        });
    }

//    private void onBackButtonClicked() {
//        // Perform action when the back button is clicked
//        System.out.println("Back button clicked!");
//
//        // Navigate to another frame
//        // For example, navigate to AnotherFrame
//        JobspectsMenuFrame anotherFrame = new JobspectsMenuFrame();
//        anotherFrame.setVisible(true);
//
//        // Close the current frame
//        frame.dispose();
//    }

	@Override
	public void updateChart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<Double> getValuesForAverage() {
		// TODO Auto-generated method stub
		return null;
	}
}
