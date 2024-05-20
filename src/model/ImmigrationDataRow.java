package model;

//This template class represents a row of data found in the immigration labour force CSV file
public class ImmigrationDataRow {

	//Fields
	private String month;
	private int year;
	private String province;
	private String immigrantStatus;
	private String employmentType;
	private String sex;
	private String age;
	private double allEducationLevelsValue;
	private double noPSEvalue;
	private double noCertificationsValue;
	private double highSchoolGradValue;
	private double highSchoolGradSomePSEValue;
	private double pseValue;
	private double certificateOrDiplomaValue;
	private double withoutHighSchoolGradValue;
	private double withHighSchoolGradValue;
	private double universityDegreeValue;
	private double bachelorDegreeValue;
	private double aboveBachelorDegreeValue;
	
	//Constructor
	public ImmigrationDataRow(String month, int year, String province, String immigrantStatus, String employmentType,
			String sex, String age, double allEducationLevelsValue, double noPSEvalue, double noCertificationsValue,
			double highSchoolGradValue, double highSchoolGradSomePSEValue, double pseValue,
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
		this.noPSEvalue = noPSEvalue;
		this.noCertificationsValue = noCertificationsValue;
		this.highSchoolGradValue = highSchoolGradValue;
		this.highSchoolGradSomePSEValue = highSchoolGradSomePSEValue;
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

	public double getNoPSEvalue() {
		return noPSEvalue;
	}

	public void setNoPSEvalue(double noPSEvalue) {
		this.noPSEvalue = noPSEvalue;
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

	public double getHighSchoolGradSomePSEValue() {
		return highSchoolGradSomePSEValue;
	}

	public void setHighSchoolGradSomePSEValue(double highSchoolGradSomePSEValue) {
		this.highSchoolGradSomePSEValue = highSchoolGradSomePSEValue;
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
				+ ", allEducationLevelsValue=" + allEducationLevelsValue + ", noPSEvalue=" + noPSEvalue
				+ ", noCertificationsValue=" + noCertificationsValue + ", highSchoolGradValue=" + highSchoolGradValue
				+ ", highSchoolGradSomePSEValue=" + highSchoolGradSomePSEValue + ", pseValue=" + pseValue
				+ ", certificateOrDiplomaValue=" + certificateOrDiplomaValue + ", withoutHighSchoolGradValue="
				+ withoutHighSchoolGradValue + ", withHighSchoolGradValue=" + withHighSchoolGradValue
				+ ", universityDegreeValue=" + universityDegreeValue + ", bachelorDegreeValue=" + bachelorDegreeValue
				+ ", aboveBachelorDegreeValue=" + aboveBachelorDegreeValue + "]";
	}
	
}
