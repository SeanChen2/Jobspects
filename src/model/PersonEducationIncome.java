package model;

/*
 * Name: Kelvin Nguyen
 * PersonEducationIncome
 * Group 1
 * Date: May 17th, 2024
 */


public class PersonEducationIncome {
	
	// Fields
	private int year;
	private int yearsOfEducation;
	private double averageIncome;
	
	public PersonEducationIncome(int year, int yearsOfEducation, double averageIncome) {
		
		// Set the fields (no need for verifying values)
		this.year = year;
		this.yearsOfEducation = yearsOfEducation;
		this.averageIncome = averageIncome;
	}

	// Getters (no need for setters as they are all already valid.
	public int getYear() {
		return year;
	}

	public int getYearsOfEducation() {
		return yearsOfEducation;
	}

	public double getAverageIncome() {
		return averageIncome;
	}

	@Override
	public String toString() {
		return "PersonEducationIncome [year=" + year + ", yearsOfEducation=" + yearsOfEducation + ", averageIncome="
				+ averageIncome + "]";
	}
	
	
	
	
}
