package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//This template class represents a row of data found in the immigration labour force CSV file
public class ImmigrationDataRow {

	//Fields representing columns in the CSV data file
	private String month;
	private int year;
	private String province;
	private String immigrantStatus;
	private String employmentType;
	private String sex;
	private String age;
	private double allEducationLevelsValue;
	private double noPseValue;
	private double noCertificationsValue;
	private double highSchoolGradValue;
	private double highSchoolGradSomePseValue;
	private double pseValue;
	private double certificateOrDiplomaValue;
	private double withoutHighSchoolGradValue;
	private double withHighSchoolGradValue;
	private double universityDegreeValue;
	private double bachelorDegreeValue;
	private double aboveBachelorDegreeValue;
	
	//Constructor: sets all the column values of this row
	public ImmigrationDataRow(String month, int year, String province, String immigrantStatus, String employmentType,
			String sex, String age, double allEducationLevelsValue, double noPseValue, double noCertificationsValue,
			double highSchoolGradValue, double highSchoolGradSomePseValue, double pseValue,
			double certificateOrDiplomaValue, double withoutHighSchoolGradValue, double withHighSchoolGradValue,
			double universityDegreeValue, double bachelorDegreeValue, double aboveBachelorDegreeValue) {
		
		this.month = month;
		this.year = year;
		this.province = province;
		this.immigrantStatus = immigrantStatus;
		this.employmentType = employmentType;
		this.sex = sex;
		this.age = age;
		this.allEducationLevelsValue = allEducationLevelsValue;
		this.noPseValue = noPseValue;
		this.noCertificationsValue = noCertificationsValue;
		this.highSchoolGradValue = highSchoolGradValue;
		this.highSchoolGradSomePseValue = highSchoolGradSomePseValue;
		this.pseValue = pseValue;
		this.certificateOrDiplomaValue = certificateOrDiplomaValue;
		this.withoutHighSchoolGradValue = withoutHighSchoolGradValue;
		this.withHighSchoolGradValue = withHighSchoolGradValue;
		this.universityDegreeValue = universityDegreeValue;
		this.bachelorDegreeValue = bachelorDegreeValue;
		this.aboveBachelorDegreeValue = aboveBachelorDegreeValue;
		
	}

	//Getters and setters for all fields
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getImmigrantStatus() {
		return immigrantStatus;
	}

	public void setImmigrantStatus(String immigrantStatus) {
		this.immigrantStatus = immigrantStatus;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getAllEducationLevelsValue() {
		return allEducationLevelsValue;
	}

	public void setAllEducationLevelsValue(double allEducationLevelsValue) {
		this.allEducationLevelsValue = allEducationLevelsValue;
	}

	public double getNoPseValue() {
		return noPseValue;
	}

	public void setNoPseValue(double noPseValue) {
		this.noPseValue = noPseValue;
	}

	public double getNoCertificationsValue() {
		return noCertificationsValue;
	}

	public void setNoCertificationsValue(double noCertificationsValue) {
		this.noCertificationsValue = noCertificationsValue;
	}

	public double getHighSchoolGradValue() {
		return highSchoolGradValue;
	}

	public void setHighSchoolGradValue(double highSchoolGradValue) {
		this.highSchoolGradValue = highSchoolGradValue;
	}

	public double getHighSchoolGradSomePseValue() {
		return highSchoolGradSomePseValue;
	}

	public void setHighSchoolGradSomePseValue(double highSchoolGradSomePseValue) {
		this.highSchoolGradSomePseValue = highSchoolGradSomePseValue;
	}

	public double getPseValue() {
		return pseValue;
	}

	public void setPseValue(double pseValue) {
		this.pseValue = pseValue;
	}

	public double getCertificateOrDiplomaValue() {
		return certificateOrDiplomaValue;
	}

	public void setCertificateOrDiplomaValue(double certificateOrDiplomaValue) {
		this.certificateOrDiplomaValue = certificateOrDiplomaValue;
	}

	public double getWithoutHighSchoolGradValue() {
		return withoutHighSchoolGradValue;
	}

	public void setWithoutHighSchoolGradValue(double withoutHighSchoolGradValue) {
		this.withoutHighSchoolGradValue = withoutHighSchoolGradValue;
	}

	public double getWithHighSchoolGradValue() {
		return withHighSchoolGradValue;
	}

	public void setWithHighSchoolGradValue(double withHighSchoolGradValue) {
		this.withHighSchoolGradValue = withHighSchoolGradValue;
	}

	public double getUniversityDegreeValue() {
		return universityDegreeValue;
	}

	public void setUniversityDegreeValue(double universityDegreeValue) {
		this.universityDegreeValue = universityDegreeValue;
	}

	public double getBachelorDegreeValue() {
		return bachelorDegreeValue;
	}

	public void setBachelorDegreeValue(double bachelorDegreeValue) {
		this.bachelorDegreeValue = bachelorDegreeValue;
	}

	public double getAboveBachelorDegreeValue() {
		return aboveBachelorDegreeValue;
	}

	public void setAboveBachelorDegreeValue(double aboveBachelorDegreeValue) {
		this.aboveBachelorDegreeValue = aboveBachelorDegreeValue;
	}

	//Generate a String representation of the object to display in the console
	@Override
	public String toString() {
		return "ImmigrationDataRow [month=" + month + ", year=" + year + ", province=" + province + ", immigrantStatus="
				+ immigrantStatus + ", employmentType=" + employmentType + ", sex=" + sex + ", age=" + age
				+ ", allEducationLevelsValue=" + allEducationLevelsValue + ", noPSEvalue=" + noPseValue
				+ ", noCertificationsValue=" + noCertificationsValue + ", highSchoolGradValue=" + highSchoolGradValue
				+ ", highSchoolGradSomePSEValue=" + highSchoolGradSomePseValue + ", pseValue=" + pseValue
				+ ", certificateOrDiplomaValue=" + certificateOrDiplomaValue + ", withoutHighSchoolGradValue="
				+ withoutHighSchoolGradValue + ", withHighSchoolGradValue=" + withHighSchoolGradValue
				+ ", universityDegreeValue=" + universityDegreeValue + ", bachelorDegreeValue=" + bachelorDegreeValue
				+ ", aboveBachelorDegreeValue=" + aboveBachelorDegreeValue + "]";
	}
	
	//This method gets a certain column value that is NOT a decimal value
	public String getValue(String columnName) {
		
		switch (columnName) {
		
			case "Month":
				return getMonth();
				
			case "Year":
				return Integer.toString(getYear());
				
			case "Province":
				return getProvince();
				
			case "Immigrant status":
				return getImmigrantStatus();
				
			case "Employment type":
				return getEmploymentType();
				
			case "Sex":
				return getSex();
				
			case "Age":
				return getAge();
				
			default:
				return "INVALID";
		
		}
		
	}
	
	//This method gets a decimal value for the employment figure based on education level
	public double getEmploymentFigure(String educationLevel) {
		
		switch (educationLevel) {
		
			case "All education levels":
				return getAllEducationLevelsValue();
				
			case "No post-secondary education":
				return getNoPseValue();
				
			case "No certifications":
				return getNoCertificationsValue();
				
			case "High school graduate":
				return getHighSchoolGradValue();
				
			case "High school graduate, some post-secondary":
				return getHighSchoolGradSomePseValue();
				
			case "Post-secondary education":
				return getPseValue();
				
			case "Post-secondary certificate or diploma":
				return getCertificateOrDiplomaValue();
				
			case "Without high school graduation":
				return getWithoutHighSchoolGradValue();
				
			case "With high school graduation":
				return getWithHighSchoolGradValue();
				
			case "University degree":
				return getUniversityDegreeValue();
				
			case "Bachelor's degree":
				return getBachelorDegreeValue();
				
			case "Above bachelor's degree":
				return getAboveBachelorDegreeValue();
				
			default:
				return -1.0;
				
		}
		
	}
	
	//This method adds all the numeric values (employment figures) from a given row, to this row
	public void addAllValues(ImmigrationDataRow addedRow) {
		
		//Add all the employment figures from the "added row" to this row
		this.allEducationLevelsValue += addedRow.getAllEducationLevelsValue();
		this.noPseValue += addedRow.getNoPseValue();
		this.noCertificationsValue += addedRow.getNoCertificationsValue();
		this.highSchoolGradValue += addedRow.getHighSchoolGradValue();
		this.highSchoolGradSomePseValue += addedRow.getHighSchoolGradSomePseValue();
		this.pseValue += addedRow.getPseValue();
		this.certificateOrDiplomaValue += addedRow.getCertificateOrDiplomaValue();
		this.withoutHighSchoolGradValue += addedRow.getWithoutHighSchoolGradValue();
		this.withHighSchoolGradValue += addedRow.getWithHighSchoolGradValue();
		this.universityDegreeValue += addedRow.getUniversityDegreeValue();
		this.bachelorDegreeValue += addedRow.getBachelorDegreeValue();
		this.aboveBachelorDegreeValue += addedRow.getAboveBachelorDegreeValue();
		
	}
	
	//This method adjusts the row's aggregated employment figures if the year is missing some months.
	//For every employment figure: the adjustment formula takes the mean employment figure for one month,
	//then adds it to the aggregated sum for every missing month (e.g. add the mean 2 times 
	//if Jan and Feb are missing).
	public void adjustData(int numProvidedMonths) {
		
		//Calculate the number of missing months based on the number of months provided in the data
		int numMissingMonths = 12 - numProvidedMonths;
		
		//Adjust every employment figure in this aggregated row
		this.allEducationLevelsValue += allEducationLevelsValue / numProvidedMonths * numMissingMonths;
		this.noPseValue += noPseValue / numProvidedMonths * numMissingMonths;
		this.noCertificationsValue += noCertificationsValue / numProvidedMonths * numMissingMonths;
		this.highSchoolGradValue += highSchoolGradValue / numProvidedMonths * numMissingMonths;
		this.highSchoolGradSomePseValue += highSchoolGradSomePseValue / numProvidedMonths * numMissingMonths;
		this.pseValue += pseValue / numProvidedMonths * numMissingMonths;
		this.certificateOrDiplomaValue += certificateOrDiplomaValue / numProvidedMonths * numMissingMonths;
		this.withoutHighSchoolGradValue += withoutHighSchoolGradValue / numProvidedMonths * numMissingMonths;
		this.withHighSchoolGradValue += withHighSchoolGradValue / numProvidedMonths * numMissingMonths;
		this.universityDegreeValue += universityDegreeValue / numProvidedMonths * numMissingMonths;
		this.bachelorDegreeValue += bachelorDegreeValue / numProvidedMonths * numMissingMonths;
		this.aboveBachelorDegreeValue += aboveBachelorDegreeValue / numProvidedMonths * numMissingMonths;
		
	}
	
}
