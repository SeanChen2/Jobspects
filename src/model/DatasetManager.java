package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * reads cvs and xlsx files
 */
public class DatasetManager {

	String yAxisColumn;
	//abishan
	private ArrayList<Integer>[] touristBusinesses = new ArrayList[7];
	private int[] years = new int[7];
	
	//toby
	private ArrayList<Double>[] gender = new ArrayList[3];
	
	// Kelvin
	private ArrayList<PersonEducationIncome> person = new ArrayList<>();
	
	//Randiv
	private ArrayList<UnemploymentDataRow> unemployment = new ArrayList<>();
	

	
	public DatasetManager(){
		importData();
		initTourism();
		initUnemployment();
		initOccupationLabour();
		initWagesEmployment();
	}

	private void importData() {
		
		
	}

	private void initOccupationLabour() {
		//1header
		//2-8320 line of march 1
		//648962-657281 september 20
		
		
	}

	private void initUnemployment() {
		// 37921
		// src: https://www.youtube.com/watch?v=-Aud0cDh-J8
		// Create a string variable to hold the value
		String line = "";
		// Accumulator
		int index = 0;

		// Try and catch: if the file cannot be read display and error otherwise read
		// the file
		try {
			// Use a BufferedReader to read the file
			BufferedReader br = new BufferedReader(new FileReader("data/UnemploymentDuration.csv"));

			// While there is still more data to read
			while ((line = br.readLine()) != null) {
				// CSV columns are separated by commas
				String[] data = line.split(",");

//				        // Extracting data and creating a new PersonEducationIncome object
//				        int year = Integer.parseInt(data[0]);
//				        int yearsOfEducation = Integer.parseInt(data[1]);
//				        double averageIncome = Double.parseDouble(data[2]);

				// String date = dataFile.next();
				String date = data[0];
				String month = date.substring(0, 3); // Since each month is a 3-character abbreviation
				int year = Integer.parseInt(date.substring(3));

				// Input the String values
				String geography = data[1];
				String duration = data[2].trim(); // Remove unnecessary leading spaces
				String age = data[3];
				double bothSexes = Double.parseDouble(data[4]);
				double male = Double.parseDouble(data[5]);
				double female = Double.parseDouble(data[6]);

				// Add to the ArrayList
				unemployment.add(new UnemploymentDataRow(month, year, geography, duration, age, bothSexes, male, female));

				// Increment index
				index++;
			}

			// If the file canont be found or read, print these errors
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initTourism() {
		for(int i = 0; i < touristBusinesses.length; i++){
			touristBusinesses[i] = new ArrayList<Integer>();
		}
		
		try{
			Scanner inputFile = new Scanner(new File("files/tourism.xlsx"));
			//reads the tourism employment file
			inputFile.useDelimiter(",|\n\r");
			
			while(inputFile.hasNext()){
				String tourismTitle = inputFile.nextLine();//sets the title
				String heading = inputFile.nextLine();//sets the headings on top
				for(int i = 0; i < touristBusinesses.length; i++){
					years[i] = inputFile.nextInt();//keeps track of which year it is
					for(int in = 0; in < 9; in++)
					touristBusinesses[i].add(inputFile.nextInt());
					//adds the # of businesses for each year
				}
			}
			
            inputFile.close();//closes the file

		}
		catch (FileNotFoundException e) {
            System.err.println("tourism.xslx File error");
        }
		
	}
	
	// Read the EducationVersusIncome.csv
	// Source: https://www.youtube.com/watch?v=-Aud0cDh-J8
	private void initWagesEmployment() {
		// Create a string variable to hold the value
		String line = "";
		// Accumulator
		int index = 0;

		// Try and catch: if the file cannot be read display and error otherwise read the file
		try {
			// Use a BufferedReader to read the file
			BufferedReader br = new BufferedReader(new FileReader("data/EducationVersusIncome.csv"));

			// While there is still more data to read
			while ((line = br.readLine()) != null) {
				// CSV columns are separated by commas
				String[] data = line.split(","); 

		        // Extracting data and creating a new PersonEducationIncome object
		        int year = Integer.parseInt(data[0]);
		        int yearsOfEducation = Integer.parseInt(data[1]);
		        double averageIncome = Double.parseDouble(data[2]);

		        // Add to the ArrayList
		        person.add(new PersonEducationIncome(year, yearsOfEducation, averageIncome));

		        // Increment index
		        index++;
		}

		// If the file canont be found or read, print these errors
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public String getFilteredRows(){
		return null;
	}
	
	public String getFilteredColumns(){
		return null;
	}
	
	public void setYAxisColumn(String yAxisColumn){
		this.yAxisColumn = yAxisColumn;
	}

	public ArrayList<PersonEducationIncome> getPerson() {
		return person;
	}

	public void setPerson(ArrayList<PersonEducationIncome> person) {
		this.person = person;
	}

	public ArrayList<UnemploymentDataRow> getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(ArrayList<UnemploymentDataRow> unemployment) {
		this.unemployment = unemployment;
	}
	
	
	 
	
	
}
