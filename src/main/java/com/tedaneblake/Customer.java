package com.tedaneblake;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // auto generate id number
	//data
	private Long id;
	private String firstName;
	private String lastName;
	
	//Methods
	
	//constructors
	
	// The default constructor exists only for the sake of JPA
	protected Customer() {
		
	}
	
	public Customer (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}
	
	// getters 
	public String getFirstName() {
		return firstName;
	}
	public Long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
}
