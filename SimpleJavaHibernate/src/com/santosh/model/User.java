package com.santosh.model;

import java.util.Date;


public class User {

	private int userid;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(java.util.Date dob2) {
		this.dob = dob2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}
}
