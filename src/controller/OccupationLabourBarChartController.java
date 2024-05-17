package controller;

import view.OccupationLabourBarChartFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OccupationLabourBarChartController implements ActionListener {
    private OccupationLabourBarChartFrame frame;

    public OccupationLabourBarChartController(OccupationLabourBarChartFrame frame) {
        this.frame = frame;
        this.frame.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == frame.getBackButton()) {
            // Handle button click event
            System.out.println("Back button clicked");
            new view.JobspectsTitleFrame();
            frame.dispose();
        }
    }
}
