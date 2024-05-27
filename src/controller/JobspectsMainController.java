package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HelpFrame;
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
	private HelpFrame helpFrame = new HelpFrame();
	
	//A field to keep track of which frame (screen) the user is currently on.
	//This does NOT include the chart frames, since these are controlled by
	//separate controllers
	private JobspectsFrame currentFrame;
	
	//Constructor
	public JobspectsMainController() {
		
		//Add action listeners to all the buttons in the frames
		addActionListeners();
		
		//Fill the chart controller array with 5 chart controllers
		chartControllers[0] = new OccupationLabourBarChartController(menuFrame);
		chartControllers[1] = new ImmigrationLabourChartController(menuFrame);
		chartControllers[2] = new UnemploymentDurationChartController(menuFrame);
		chartControllers[3] = new WagesByEducationChartController(menuFrame);
		chartControllers[4] = new TourismEmploymentChartController(menuFrame);
		
		
		
		
		//Show the title frame when the app is opened
		currentFrame = titleFrame;
		titleFrame.setVisible(true);
		
	}
	
	//This method is called whenever one of the buttons in the title frame or menu frame is pressed
	private void addActionListeners() {
		
		//Listen for when the "start" button in the title frame is pressed
		titleFrame.getStartButton().addActionListener(this);
		
		//Listen for when one of the dataset selection buttons in the menu frame is pressed
		for (int buttonIndex = 0; buttonIndex < NUM_CHARTS; buttonIndex++)
			menuFrame.getSelectionButtons()[buttonIndex].addActionListener(this);
		
	}
	
	//This method handles what happens when a button from the title screen or menu screen
	//is pressed. These buttons will simply navigate between screens.
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Title frame: if the "Get Started" button was pressed, navigate to the menu frame
		if (event.getSource() == titleFrame.getStartButton()) {
			switchToFrame(menuFrame);
		}
		
		else {
			
			//Menu frame: if any of the chart selection panels were pressed, let the corresponding
			//controller activate the correct chart frame
			for (int index = 0; index < NUM_CHARTS; index++) {
				
				if (event.getSource() == menuFrame.getSelectionButtons()[index]) {
					currentFrame.setVisible(false);
					chartControllers[index].showChartFrame();
				}
				
				
			}
			
			if (event.getSource() == menuFrame.getHelpButton()) {
				switchToFrame(helpFrame);
			}
			
		}
		
	}
	
	//This method navigates from one frame (screen) to another
	private void switchToFrame(JobspectsFrame newFrame) {
		
		//Hide the current frame
		currentFrame.setVisible(false);
		
		//Set the current frame to the new frame, then show the new frame
		currentFrame = newFrame;
		currentFrame.setVisible(true);
		
	}
	
}
