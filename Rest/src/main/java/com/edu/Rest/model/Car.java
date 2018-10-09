package com.edu.Rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	private String company;
	private String model;
	private int year;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Car(String company, String model, int year) {
		super();
		this.company = company;
		this.model = model;
		this.year = year;
	}

	@Override
	public String toString() {
		return company + " - " + model + " Model : " + year;
	}

}
