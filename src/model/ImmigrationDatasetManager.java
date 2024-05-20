package model;

import java.util.*;

import org.jfree.data.category.CategoryDataset;

public class ImmigrationDatasetManager {

	//Fields
	private Scanner dataFile;
	private CategoryDataset originalDataset;
	private HashMap<String, ArrayList<String>> filteredRows = new HashMap<>();
	private ArrayList<String> filteredColumns = new ArrayList<>();
	private String yAxisColumn;
	
	//Constructor
	public ImmigrationDatasetManager() {
		
		//Create the category dataset
		
	}
	
	//This method imports all the data from the CSV file to the category dataset
	private void importData() {
		
		
	}
	
	//This method gets the map of all the rows that are included in the filtered dataset
	public HashMap<String, ArrayList<String>> getFilteredRows() {
		
		return null;
		
	}
	
	//This method gets the list of all the columns that are included in the filtered dataset
	public ArrayList<String> getFilteredColumns() {
		
		return null;
		
	}
	
	//
	public void setYAxisColumn(String yAxisColumn) {
		
		
		
	}
	
}
