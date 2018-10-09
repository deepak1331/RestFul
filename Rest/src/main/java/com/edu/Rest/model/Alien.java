package com.edu.Rest.model;

public class Alien {
	private int userId;
	private String userName;
	private String userTechnology;
	private String userOrganization;
	private int userAge;

	

	public Alien(int userId, String userName, String userTechnology, String userOrganization, int userAge) {
		this.userId = userId;
		this.userName = userName;
		this.userTechnology = userTechnology;
		this.userOrganization = userOrganization;
		this.userAge = userAge;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTechnology() {
		return userTechnology;
	}

	public void setUserTechnology(String userTechnology) {
		this.userTechnology = userTechnology;
	}

	public String getUserOrganization() {
		return userOrganization;
	}

	public void setUserOrganization(String userOrganization) {
		this.userOrganization = userOrganization;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return userId+ " | " + userName + " | " + userTechnology + " | " + userOrganization + " | " + userAge;
	}

}
