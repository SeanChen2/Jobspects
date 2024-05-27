package application;

import controller.JobspectsMainController;

/*
================================================================================================
Name(s): 

Sean Chen (20%)
-------------------------------------------------------------------------------------------------
JobspectsMainController (100%)
ChartController (100%)
JobspectsChartFrame (95%)
ImmigrationLabourChartFrame (100%)
ImmigrationLabourAreaChartFrame (100%)
ImmigrationLabourHistogramFrame (100%)
ImmigrationLabourCompareCategoryPanel (100%)
ImmigrationLabourChartFilterPanel (100%) 
ImmigrationLabourDatePickerPanel (100%)
ImmigrationLabourChartController (100%)
ImmigrationDatasetManager (100%)
ImmigrationDataRow (100%)
OccupationLabourBarChartFrame (5%)

Randiv Waduge (20%)
-------------------------------------------------------------------------------------------------
UnemploymentDurationLineChartFrame (100%)
UnemploymentDurationChartController (100%)
UnemploymentDataRow (100%)
DatasetManager (40%)
HelpFrame (100%)

Kelvin Nguyen (20%)
-------------------------------------------------------------------------------------------------
JobspectsApplication (100%), JobspectsTitleFrame (100%),  JobspectsMenuFrame (100%), PersonEducationIncome  (100%), 
WagesByEducationChartController (100%), WagesByEducationScatterplotFrame (100%), JFreeChart Scatterplot (100%), 
DatasetManager (20%), JobspectsChartFrame (5%)

Abishan Shanmuhesan (30%)
-------------------------------------------------------------------------------------------------
TourismFileInput(100%, with help from Sean), TourismEmploymentInnerPanel(100%), TourismEmploymentDerivativeInnerPanel(100%), 
JobspectsFrame(with features by Sean & Toby), TourismEmploymentPieChartFrame(100%), TourismEmploymentDerivativeFrame(100%), 
TourismEmploymentChartController(100%), DatasetManager(30%)

Toby Yau (20%)
-------------------------------------------------------------------------------------------------
occupationlabourbarchartcontroller(100%),
OccupationlabourbarchartFrame(95%),
Labour(100%),
occupationlabourbarController(100%), 

================================================================================================
Date: May 26, 2024
================================================================================================
Course Code:
ICS4U1-1
Mr. Fernandes
================================================================================================
Title: Jobspects
================================================================================================
Description:
Jobspects is an application that explores Canada's constantly changing job market through the industries making up our 
labour force, if immigration has affected our labour force and if unemployment & education contribute to job opportunities. 
Through graphs and other visual representations of the data we collected, this program assists users in understanding current 
trends and predicting future trends of the job market.
================================================================================================

Features:
TourismEmploymentPieChartFrame, TourismEmploymentInnerPanel, TourismEmploymentDerivativeFrame, TourismEmploymentDerivativeInnerPanel (Abishan)
-------------------------------------------------------------------------------------------------
Pie chart to show the number of businesses per year on the left. There is a JScrollPane on the right, which separates the 
data to show each year’s breakdown, and compares the possible number of employees (e.g 0, 1-4, 5-9, 10-19, 20-49, 50-99, 
100-199, 200+). The pie chart not only shows the percentage breakdown, but the actual numerical data that came from the 
csv file. My additional feature, the derivative shows the rate of change(more businesses formed if greater than 0, and 
more businesses dissolved if less than 0, and balance in both if equal to 0). This is done so that the user can learn 
about how fast businesses are being created and ended each year, especially when it comes to 2020 and the pandemic. 
There is a general line graph showing the number of employees and comparing it with each other, and a JScrollPane of 
line charts individually zooming into the smaller ones which have impactful but low scale changes. *The data is taken 
from 2017 - 2023*

ImmigrationLabourAreaChartFrame and ImmigrationLabourHistogramFrame (Sean): 
-------------------------------------------------------------------------------------------------
- Filters: A side panel that contains radio button filters for sex, education level, immigrant status, and employment type. 
When the user clicks on a radio button, the chart updates immediately to reflect the new combination of filters. 
- Comparison filters: In the area chart frame, there is also a set of radio buttons (in the “Compare by” section) 
that allow the user to choose what each coloured area represents (e.g. each area represents a different education level), 
showing the difference between demographics more clearly.
- Year picker slider: Each frame also contains a slider that can pick which year to display data for. The years range from 2006-2020. Each time the slider is updated, the chart refreshes immediately. In the area chart frame, there is an additional set of radio buttons that allows the user to pick between displaying aggregate data for all 15 years (each year’s data is the sum of all its months), and displaying data for all 12 months of a specific year.
- Navigation buttons: let the user pick between the area chart and histogram


PersonEducationIncome, WagesByEducationChartController, WagesByEducationScatterplotFrame (Kelvin):
-------------------------------------------------------------------------------------------------
- A frame consisting of a scatter plot that displays the average weekly income versus the years of education a person has, 
a filter panel where the user can filter out certain data and a back button
- To the right is a filter panel where the user can filter out the different years, income levels and levels of education in order to 
shave down on the data
- Whenever the user clicks the “Filter Data” button, the chart will immediately update and display the information according to the filters
The application will also prompt the user to select a filter for all the categories to avoid errors in the filters and dataset


OccupationLabourBarChartFrame (Toby):
-------------------------------------------------------------------------------------------------
Occupation frame Incorporates the JFreechart to display a bar graph which was SUPPOSED to contain many occupations along with the 
genders/age’s working in that specific job, it uses JText area as a little description of what the graph is displaying, and
 uses the JButton to access the JMenu
-------------------------------------------------------------------------------------------------


UnemploymentDurationLineChart, UnemploymentDurationChartController, UnemploymentDataRow (Randiv):
--------------------------------------------------------------------------------------------------
- Unemployment chart utilizes the JFreeChart Library to display a line graph that displays the number of unemployed individuals over 
several years
- To the right is a filter panel that was meant to allow the user to filter the line graph by duration, range and gender. As well as if 
it was being compared by age or by geography.
- Contains a back button to return to menu and a title containing the page’s topic

================================================================================================
Major Skills:
-------------------------------------------------------------------------------------------------
GUI Objects (Java Swing)
- Using GUI objects such as JFrames, JPanels, JLabels, JButtons, e.t.c. to display our graphs to the user
JFreeChart API
- Making different types of data charts to display to the user with either filters or scrollpanes to show specific
data from the file reading
- Used data from filereader to generate charts with varying filters
Algorithm (During planning we made algorithms to help)
Object Oriented Programming:
- Using inheritance/polymorphism to create a “template” for the rest of our GUI frames (background, screen header, and back button)
- Using inheritance/polymorphism to create a controller class for each chart frame
- Accessing fields through getters and setters
File Reading
- Using File readers such as Scanner and BufferedReader to read data from a CSV file
MVC (Model, View, Controller) design pattern

================================================================================================
Areas of Concern:
-------------------------------------------------------------------------------------------------
Imported API: JFreeChart
Size: 1920 x 1080 (does not scale with other screen sizes)
Run JobspectsApplication to start the program
Some charts will take awhile to load. Please allow up to 10 seconds for every screen to load.

Incomplete/partial solutions:
-------------------------------------------------------------------------------------------------
TourismEmploymentDerivativeFrame’s backbutton doesn’t re-open the menu frame, this frame is almost completed as an additional feature
UnemploymentLineChart: Filters on the right panel do not work. Scale on x-axis is incorrect.
Occupation frame has trouble with his graph/csv file
Unfinished feature — Average calculation: would allow the user to calculate the average value of a list of data, picking between the mean and median (e.g. for a line chart that displays number of people employed over 15 years, find the average number of people employed per year). Remnants of this feature remain as fields and abstract methods in the code.
Incomplete Help Frame: Explains how to use each chart frame (i.e. filters) and navigate between them, button to open it does not work, most explanations are missing

*/

//This class acts as the "play button" of the application. It runs the main controller to start it off.
public class JobspectsApplication {

	//Main method: Run the main controller to facilitate the "flow" between classes of the application
	public static void main(String[] args) {
		new JobspectsMainController();

	}
}

