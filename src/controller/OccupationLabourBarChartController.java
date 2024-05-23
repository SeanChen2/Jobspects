package controller;

import view.OccupationLabourBarChartFrame;
import view. JobspectsMenuFrame; // Import the frame you want to navigate to

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OccupationLabourBarChartController {
    private OccupationLabourBarChartFrame frame;

    public OccupationLabourBarChartController(OccupationLabourBarChartFrame frame) {
        this.frame = frame;
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

    private void onBackButtonClicked() {
        // Perform action when the back button is clicked
        System.out.println("Back button clicked!");

        // Navigate to another frame
        // For example, navigate to AnotherFrame
        JobspectsMenuFrame anotherFrame = new JobspectsMenuFrame();
        anotherFrame.setVisible(true);

        // Close the current frame
        frame.dispose();
    }
}
