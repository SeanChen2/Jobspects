package model;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ImmigrationDatasetManager {

	//Fields
	private Scanner dataFile;
	
	//Names of the data column(s) used to display the values (y-axis) and categories (x-axis).
	//NOTE: if there are multiple value columns, each one gets its own "series" on the chart
	//(this is useful for the area chart, where each series is represented by an area)
	private ArrayList<String> valueColumns = new ArrayList<>();
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
	
	//The data from the CSV file stored in table format - one "table" for each year
	private HashMap<Integer, ArrayList<ImmigrationDataRow>> data = new HashMap<>();
	
	//Field for which year the data is being displayed for (default 2020)
	private int requestedYear = 2020;
	
	//Constructor
	public ImmigrationDatasetManager() {
		
		//Fill the data map with the years from 2006 to 2020 (as outlined in the CSV file)
		for (int year = 2006; year <= 2020; year++)
			data.put(year, new ArrayList<ImmigrationDataRow>());
		
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

	public HashMap<Integer, ArrayList<ImmigrationDataRow>> getData() {
		return data;
	}

	public void setData(HashMap<Integer, ArrayList<ImmigrationDataRow>> data) {
		this.data = data;
	}
	
	public int getRequestedYear() {
		return requestedYear;
	}

	public void setRequestedYear(int requestedYear) {
		this.requestedYear = requestedYear;
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
			data.get(year).add(new ImmigrationDataRow(month, year, province, 
					immigrantStatus, employmentType, sex, age,
					employmentFigures[0], employmentFigures[1], employmentFigures[2], employmentFigures[3],
					employmentFigures[4], employmentFigures[5], employmentFigures[6], employmentFigures[7],
					employmentFigures[8], employmentFigures[9], employmentFigures[10], employmentFigures[11]));
			
		}
		
	}
	
	//This method adds an entry to the filtered rows map, to "restrain" which rows are included in the dataset
	public void addRowRestraint(String column, String requiredValue) {
		
		filteredRows.put(column, requiredValue);
		
	}
	
	//This method generates a dataset with all the filters/constraints appliwed
	public DefaultCategoryDataset getFilteredDataset() {
		
		DefaultCategoryDataset filteredDataset = new DefaultCategoryDataset();
		
		RowIterator:
		for (ImmigrationDataRow row : data.get(requestedYear)) {
			
			//First, disregard this row if it doesn't satisfy the row filters
			for (Entry<String, String> filter : filteredRows.entrySet()) {
				
				if (!row.getValue(filter.getKey()).equals(filter.getValue())) {
					continue RowIterator;
				}
			}
			
			System.out.println(row);
			
			if (seriesColumn == null) {
				
				//Add each column series to the appropriate year on the x-axis
				for (String valueColumn : valueColumns)
					filteredDataset.addValue(row.getEmploymentFigure(valueColumn), valueColumn, row.getValue(categoryColumn));
				
			} else {
				
				//If the series are defined by a certain column, there is guaranteed to be only one value column
				filteredDataset.addValue(row.getEmploymentFigure(valueColumns.get(0)), seriesColumn, row.getValue(categoryColumn));
				
			}
			
		}
		
		return filteredDataset;
		
	}
	
}
