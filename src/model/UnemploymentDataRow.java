package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UnemploymentDataRow {
	private String month;
	private int year;
	private String geography;
	private String duration;
	private String age;
	private double bothSexes;
	private double male;
	private double female;
	
	public UnemploymentDataRow(String month, int year, String geography, String duration, String age, double bothSexes, double male,
			double female) {
		super();
		this.month = month;
		this.year = year;
		this.geography = geography;
		this.duration = duration;
		this.age = age;
		this.bothSexes = bothSexes;
		this.male = male;
		this.female = female;
	}

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

	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}
	

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getBothSexes() {
		return bothSexes;
	}

	public void setBothSexes(double bothSexes) {
		this.bothSexes = bothSexes;
	}

	public double getMale() {
		return male;
	}

	public void setMale(double male) {
		this.male = male;
	}

	public double getFemale() {
		return female;
	}

	public void setFemale(double female) {
		this.female = female;
	}

	@Override
	public String toString() {
		return "UnemploymentDataRow [month=" + month + ", year=" + year + ", geography=" + geography + ", duration="
				+ duration + ", age=" + age + ", bothSexes=" + bothSexes + ", male=" + male + ", female=" + female
				+ "]";
	}	

}


