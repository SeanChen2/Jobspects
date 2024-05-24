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
	//The key of this map specifies the column, and the value is a list that defines what
	//the row could have in that column in order for it to be in the filtered dataset.
	//Ex. key="Immigrant Status", value=[Born in Canada, Non-landed immigrants] - the 
	//dataset will only include rows with "Born in Canada" and "Non-landed immigrants" as their
	//immigrant status
	private HashMap<String, ArrayList<String>> filteredRows = new HashMap<>();
	
	//The data from the CSV file stored in table format - one "table" for each year
	private HashMap<Integer, ArrayList<ImmigrationDataRow>> data = new HashMap<>();
	
	//This list contains the aggregates for each of the 15 years covered in the data
	private HashMap<Integer, ArrayList<ImmigrationDataRow>> yearlyData = new HashMap<>();
	
	//Field for which year the data is being displayed for.
	//NOTE: if this value is -1, the dataset will aggregate and include data for each of the 15 years
	private int requestedYear = -1;
	
	//Constant for the number of data rows provided for each month
	private int DATA_ROWS_PER_MONTH = 2400;
	
	//A map that gets the month number given the abbreviated name (e.g. Jan -> 1)
	private HashMap<String, Integer> monthToNum = new HashMap<>();
	
	//Constructor
	public ImmigrationDatasetManager() {
		
		//Fill the data maps with the years from 2006 to 2020 (as outlined in the CSV file)
		for (int year = 2006; year <= 2020; year++) {
			data.put(year, new ArrayList<ImmigrationDataRow>());
			yearlyData.put(year, new ArrayList<ImmigrationDataRow>());
		}
		
		//Fill the month-to-number map with pairs of month names and numbers
		monthToNum.put("Jan", 1);
		monthToNum.put("Feb", 2);
		monthToNum.put("Mar", 3);
		monthToNum.put("Apr", 4);
		monthToNum.put("May", 5);
		monthToNum.put("Jun", 6);
		monthToNum.put("Jul", 7);
		monthToNum.put("Aug", 8);
		monthToNum.put("Sep", 9);
		monthToNum.put("Oct", 10);
		monthToNum.put("Nov", 11);
		monthToNum.put("Dec", 12);
		
		importData();
		aggregateYears();
		
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

	public HashMap<String, ArrayList<String>> getFilteredRows() {
		return filteredRows;
	}

	public void setFilteredRows(HashMap<String, ArrayList<String>> filteredRows) {
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

	//This method imports all the data from the CSV file to the data map
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
			String immigrantStatus = dataFile.next().trim();	//Remove unnecessary leading spaces
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
	
	//This method aggregates the data for each of the 15 years, by summing up the
	//values for all 12 months.
	private void aggregateYears() {
		
		//Aggregate for every year in the data
		for (int year = 2006; year <= 2020; year++) {
			
			//Get the range of months (first and last) that exist in this year, in number format
			int firstMonth = monthToNum.get(data.get(year).get(0).getMonth());
			int lastMonth = monthToNum.get(data.get(year).get(data.get(year).size() - 1).getMonth());
			
			//Keep count of which row in the original data we're on
			int rowIndex;
			
			//Fill the yearly data map with all the rows in the first month.
			//The values of these rows will later act as the "total" for the year.
			for (rowIndex = 0; rowIndex < DATA_ROWS_PER_MONTH; rowIndex++)
				yearlyData.get(year).add(copyOfRow(data.get(year).get(rowIndex)));
			
			//Sum up all the values in the remaining months for data aggregation
			//Note that the remaining months may not be a perfect February-December case.
			//The range of months in this year must be considered.
			for (int month = firstMonth + 1; month <= lastMonth; month++) {
				
				//For every row in this month, add all of its values to the "total" rows in the yearly data list,
				//so that these "total" rows will eventually hold total values for the year.
				for (int aggregateRowIndex = 0; aggregateRowIndex < DATA_ROWS_PER_MONTH; aggregateRowIndex++) {
					yearlyData.get(year).get(aggregateRowIndex).addAllValues(data.get(year).get(rowIndex++));
				}
				
			}
			
			//If this year does not contain data for all 12 months, adjust for the missing pieces
			if (firstMonth > 1 || lastMonth < 12)
				for (int adjRowIndex = 0; adjRowIndex < yearlyData.get(year).size(); adjRowIndex++)
					yearlyData.get(year).get(adjRowIndex).adjustData(lastMonth - firstMonth + 1);
			
		}
		
	}
	
	
	//This method creates a copy of the given immigration data row
	private ImmigrationDataRow copyOfRow(ImmigrationDataRow originalRow) {
		
		return new ImmigrationDataRow(originalRow.getMonth(), originalRow.getYear(), originalRow.getProvince(), originalRow.getImmigrantStatus(),
				originalRow.getEmploymentType(), originalRow.getSex(), originalRow.getAge(), originalRow.getAllEducationLevelsValue(),
				originalRow.getNoPseValue(), originalRow.getNoCertificationsValue(), originalRow.getHighSchoolGradValue(), 
				originalRow.getHighSchoolGradSomePseValue(), originalRow.getPseValue(), originalRow.getCertificateOrDiplomaValue(),
				originalRow.getWithoutHighSchoolGradValue(), originalRow.getWithHighSchoolGradValue(), originalRow.getUniversityDegreeValue(),
				originalRow.getBachelorDegreeValue(), originalRow.getAboveBachelorDegreeValue());
		
	}
	
	//This method adds an entry to the filtered rows map, to "restrain" which rows are included in the dataset
	public void addRowRestraint(String column, String requiredValue) {
		
		//If a mapping doesn't exist for this column name yet, create the mapping
		if (!filteredRows.containsKey(column))
			filteredRows.put(column, new ArrayList<>());
		
		//Add the new required value under this column mapping
		filteredRows.get(column).add(requiredValue);
	}
	
	//This method removes an entry from the filtered rows map, given the column key to remove
	public void removeRowRestraint(String column) {
		filteredRows.remove(column);
	}
	
	
	//This method generates a dataset with all the filters/constraints applied
	public DefaultCategoryDataset getFilteredDataset() {
		
		DefaultCategoryDataset filteredDataset = new DefaultCategoryDataset();
		
		//If the user wants to see data for all 15 years, filter all the yearly data.
		//Otherwise, filter the actual data with separate months.
		if (requestedYear == -1)
			for (int year = 2006; year <= 2020; year++)
				addDataPointsFromList(yearlyData.get(year), filteredDataset);
		else
			addDataPointsFromList(data.get(requestedYear), filteredDataset);
		
		return filteredDataset;
		
	}
	
	//This method adds all the data rows from the given list to the filtered category dataset
	private void addDataPointsFromList(ArrayList<ImmigrationDataRow> dataRowList, DefaultCategoryDataset filteredDataset) {
		
		RowIterator:
		for (ImmigrationDataRow row : dataRowList) {
			
			//First, disregard this row if it doesn't satisfy the row filters
			for (Entry<String, ArrayList<String>> filter : filteredRows.entrySet())
				if (!filter.getValue().contains(row.getValue(filter.getKey())))
					continue RowIterator;
			
			//
			if (seriesColumn == null) {
				
				//Add each column series to the appropriate category on the x-axis
				for (String valueColumn : valueColumns)
					filteredDataset.addValue(row.getEmploymentFigure(valueColumn), valueColumn, row.getValue(categoryColumn));
				
			} else {

				//If the series are defined by a certain column, there is guaranteed to be only one value column
				filteredDataset.addValue(row.getEmploymentFigure(valueColumns.get(0)), row.getValue(seriesColumn), row.getValue(categoryColumn));
				
			}
			
		}
		
	}
	
}
