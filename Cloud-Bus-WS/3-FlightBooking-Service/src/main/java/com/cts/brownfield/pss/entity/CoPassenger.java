package com.cts.brownfield.pss.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoPassenger {

	@Id
	@GeneratedValue
	private long copassengerId;
	private String firstName;
	private String lastName;
	private String gender;
	

	public CoPassenger() {
		// TODO Auto-generated constructor stub
	}
	
	public CoPassenger(String firstName, String lastName, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		
	}

	public long getCopassengerId() {
		return copassengerId;
	}

	public void setCopassengerId(long copassengerId) {
		this.copassengerId = copassengerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	@Override
	public String toString() {
		return "Co-Passenger [id=" + copassengerId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + "]";
	}

}
