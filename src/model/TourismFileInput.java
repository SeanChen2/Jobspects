package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * reads Abishan's csv file
 */
public class TourismFileInput {

	//abishan
	private ArrayList<Integer>[] touristBusinesses = new ArrayList[7];//this is where all the numeric data is stored
	private int[] years = new int[7];//stores what year it is
	private String[] options;//options are 0, 1-4, 5-9, 10-19, 20-49, 50-99, 100-199, 200+ employees
	private String optionString;//options stored in a string and split into the array above
	
	//constructor
		public TourismFileInput(){
			initTourism();
		}

	
	//getters and setters
	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getOptionString() {
		return optionString;
	}

	public void setOptionString(String optionString) {
		this.optionString = optionString;
	}

	public ArrayList<Integer>[] getTouristBusinesses() {
		return touristBusinesses;
	}


	public void setTouristBusinesses(ArrayList<Integer>[] touristBusinesses) {
		this.touristBusinesses = touristBusinesses;
	}


	public int[] getYears() {
		return years;
	}


	public void setYears(int[] years) {
		this.years = years;
	}




	private void initTourism() {
		for(int i = 0; i < touristBusinesses.length; i++){
			touristBusinesses[i] = new ArrayList<Integer>();
			//making each tourist object
		}
		
		try{
			Scanner inputFile = new Scanner(new File("data/tourismFile.csv"));//Scanner
			System.out.println("hello");
			//reads the tourism employment file
			inputFile.useDelimiter(",|\n");//how to separate each next()
			String tourismTitle = inputFile.nextLine();//sets the title
			inputFile.nextLine();//ignore the next line
			
			optionString = inputFile.nextLine();//sets the options
			System.out.print(options);
			while(inputFile.hasNextInt()){
				
				for(int i = 0; i < touristBusinesses.length; i++){
					
					years[i] = inputFile.nextInt();//keeps track of which year it is
					System.out.println("years = " + years[i]);
					for(int in = 0; in < 9; in++) {
						touristBusinesses[i].add(inputFile.nextInt());//adding the numerical data
						
						System.out.println(touristBusinesses[i].get(in));
					}
					//adds the # of businesses for each year
				} 
			}
			
            inputFile.close();//closes the file

		}
		catch (FileNotFoundException e) {
            System.err.println("tourismFile.csv file error");//if file is not found by scanner
        }
		
		options = optionString.split(",");//split the large line into each separate option in the array
		for(String ss : options) {
			System.out.println("option " + ss);
		}
		
	}
	 
	
	
}