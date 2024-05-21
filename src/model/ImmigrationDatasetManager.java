package model;

import java.util.*;
import java.io.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ImmigrationDatasetManager {

	//Fields
	private Scanner dataFile;
	private CategoryDataset originalDataset;
	
	//Names of the data column(s) used to display the values (y-axis) and categories (x-axis).
	//NOTE: if there are multiple value columns, each one gets its own "series" on the chart
	//(this is useful for the area chart, where each series is represented by an area)
	private ArrayList<String> valueColumns;
	private String categoryColumn;
	
	//Instead of having multiple value columns, each value in a specific column can get its own
	//series. Ex. one series for full-time employment, another for part-time employment. Both are
	//found in the "Char" column. NOTE: if there are multiple value columns, this variable must be null.
	private String seriesColumn;
	
	//A map of specific instructions for which data rows to include.
	//The key of this map specifies the column, and the value specifies
	//what each row must have in that column in order for it to be in the filtered dataset.
	//Ex. key="Immig", value="Non-landed immigrants" - the dataset will only include entries for
	//immigrants who are not landed yet
	private HashMap<String, String> filteredRows = new HashMap<>();
	
	//The data from the CSV file stored in table format
	private ArrayList<ImmigrationDataRow> data = new ArrayList<>();
	
	//Constructor
	public ImmigrationDatasetManager() {
		
		importData();
		
	}
	
	//Getters and setters for all necessary fields

	public ArrayList<String> getValueColumns() {
		return valueColumns;
	}

	public void setValueColumns(ArrayList<String> valueColumns) {
		this.valueColumns = valueColumns;
	}

	public String getCategoryColumn() {
		return categoryColumn;
	}

	public void setCategoryColumn(String categoryColumn) {
		this.categoryColumn = categoryColumn;
	}

	public String getSeriesColumn() {
		return seriesColumn;
	}

	public void setSeriesColumn(String seriesColumn) {
		this.seriesColumn = seriesColumn;
	}

	public HashMap<String, String> getFilteredRows() {
		return filteredRows;
	}

	public void setFilteredRows(HashMap<String, String> filteredRows) {
		this.filteredRows = filteredRows;
	}

	public ArrayList<ImmigrationDataRow> getData() {
		return data;
	}

	public void setData(ArrayList<ImmigrationDataRow> data) {
		this.data = data;
	}
	
	
	//This method imports all the data from the CSV file to the category dataset
	private void importData() {
		
		//Create a Scanner to read the CSV file, watching out for errors
		try {
			dataFile = new Scanner(new File("data/labourForceEstimatesByImmigration.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: file labourForceEstimatesByImmigration.csv not found");
		}
		
		//Split data cells in the CSV file by commas
		dataFile.useDelimiter(",|\r\n");
		
		//Skip the first line of the CSV file (the headings)
		dataFile.nextLine();
		
		//For every row of the CSV file, store all the column values in a data row object
		while (dataFile.hasNext()) {
			
			//Special input for the "month" column: split it into a month and year
			String date = dataFile.next();
			String month = date.substring(0, 3);	//Since each month is a 3-character abbreviation
			int year = Integer.parseInt(date.substring(3));
			
			//Input the String values
			String province = dataFile.next();
			String immigrantStatus = dataFile.next();
			String employmentType = dataFile.next();
			String sex = dataFile.next();
			String age = dataFile.next();
			
			//Input the 12 employment figures as numeric values. If the value is a hyphen (-), replace
			//it with 0.0
			double[] employmentFigures = new double[12];
			for (int index = 0; index < 12; index++) {
				String rawValue = dataFile.next();
				employmentFigures[index] = rawValue.equals("-") ? 0.0 : Double.parseDouble(rawValue);
			}
			
			//Input the month, year, and all of the other column values into a data row object
			data.add(new ImmigrationDataRow(month, year, province, 
					immigrantStatus, employmentType, sex, age,
					employmentFigures[0], employmentFigures[1], employmentFigures[2], employmentFigures[3],
					employmentFigures[4], employmentFigures[5], employmentFigures[6], employmentFigures[7],
					employmentFigures[8], employmentFigures[9], employmentFigures[10], employmentFigures[11]));
			
		}
		
	}
	
	//This method generates a dataset with all the filters/constraints appliwed
	public CategoryDataset getFilteredDataset() {
		
		CategoryDataset filteredDataset = new DefaultCategoryDataset();
		
		
		
		return filteredDataset;
		
	}
	
}
