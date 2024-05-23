package model;

public class Labour {
	
	private String month;
	private String geography;
	private String laborForce;
	private String occupation;
	private String age;
	private String both;
	private String male;
	private String female;
	public Labour(String month, String geography, String laborForce, String occupation, String age, String both,
			String male, String female) {
		super();
		this.month = month;
		this.geography = geography;
		this.laborForce = laborForce;
		this.occupation = occupation;
		this.age = age;
		this.both = both;
		this.male = male;
		this.female = female;
	}
	public Labour() {
		// TODO Auto-generated constructor stub
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getGeography() {
		return geography;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	public String getLaborForce() {
		return laborForce;
	}
	public void setLaborForce(String laborForce) {
		this.laborForce = laborForce;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBoth() {
		return both;
	}
	public void setBoth(String both) {
		this.both = both;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getFemale() {
		return female;
	}
	public void setFemale(String female) {
		this.female = female;
	}
	@Override
	public String toString() {
		return "Labour [month=" + month + ", geography=" + geography + ", laborForce=" + laborForce + ", occupation="
				+ occupation + ", age=" + age + ", both=" + both + ", male=" + male + ", female=" + female + "]";
	}

	

}
