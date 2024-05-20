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

	
	public DatasetManager(){
		importData();
		initTourism();
		initUnemployment();
		initOccupationLabour();
	}

	private void importData() {
		
		
	}

	private void initOccupationLabour() {
		//1header
		//2-8320 line of march 1
		//648962-657281 september 20
		
		
	}

	private void initUnemployment() {
		//37921
		
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
	
	public String getFilteredRows(){
		return null;
	}
	
	public String getFilteredColumns(){
		return null;
	}
	
	public void setYAxisColumn(String yAxisColumn){
		this.yAxisColumn = yAxisColumn;
	}
	 
	
	
}
