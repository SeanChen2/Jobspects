package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DatasetSelectionPanel;
import view.JobspectsFrame;
import view.JobspectsMenuFrame;
import view.JobspectsTitleFrame;

//This is the main controller class that facilitates the flow of events
//in the application. Specifically, it allows the user to navigate from the
//title screen to the menu screen, then select one of the 5 charts to view.
public class JobspectsMainController implements ActionListener {
	
	//Constant for the number of charts in the application
	private final int NUM_CHARTS = 5;
	
	//An array of references to all of the chart controllers
	private ChartController[] chartControllers = new ChartController[NUM_CHARTS];
	
	//References to all of the main frames (not including the chart frames)
	private JobspectsTitleFrame titleFrame = new JobspectsTitleFrame();
	private JobspectsMenuFrame menuFrame = new JobspectsMenuFrame();
	
	//A field to keep track of which frame (screen) the user is currently on.
	//This does NOT include the chart frames, since these are controlled by
	//separate controllers
	private JobspectsFrame currentFrame;
	
	//Constructor
	public JobspectsMainController() {
		
		//Fill the chart controller array with 5 chart controllers
		chartControllers[0] = new OccupationLabourChartController();
		chartControllers[1] = new ImmigrationLabourChartController();
		chartControllers[2] = new UnemploymentDurationChartController();
		chartControllers[3] = new WagesByEducationChartController();
		chartControllers[4] = new TourismEmploymentChartController();
		
		//Show the title frame when the app is opened
		currentFrame = titleFrame;
		titleFrame.setVisible(true);
		
	}
	
	//This method handles what happens when a button from the title screen or menu screen
	//is pressed. These buttons will simply navigate between screens.
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Title frame: if the "Get Started" button was pressed, navigate to the menu frame
		if (event.getSource() == titleFrame.getStartButton())
			switchToFrame(menuFrame);
		
		//Menu frame: if any of the chart selection panels were pressed, let the corresponding
		//controller activate the correct chart frame
		for (int index = 0; index < NUM_CHARTS; index++) {
			
			if (event.getSource() == menuFrame.getSelectionPanels()[index].getSelectionButton()) {
				currentFrame.setVisible(false);
				chartControllers[index].showChartFrame();
			}
			
		}
		
	}
	
	//This method navigates from one frame (screen) to another
	private void switchToFrame(JobspectsFrame newFrame) {
		
		//Hide the current frame
		currentFrame.setVisible(false);
		
		//Set the current frame to the new frame, then show the new frame
		currentFrame = newFrame;
		newFrame.setVisible(true);
		
	}
	
}
