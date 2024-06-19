package com.annotations;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   // use this entity for the creating tables with the class name
//@Table(name="abcd")  // The tables annotations is used for the overate the exiting tables
public class Student {
	
	@Id     // for making id is primary key(bcz from student id, we can uniquely identify each students)
	private int id;
	private String Name;
	private String City;
	
	
	
	// here i am work with the embedded object 
	
	private Certificate cert;
	

	// Getter and setter Method for the Certificate
	
	public Certificate getCert() {
		return cert;
	}

	public void setCert(Certificate cert) {
		this.cert = cert;
	}

	// for the data initials you need to create constructor.
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		Name = name;
		City = city;
	}

	// also make a default constructor to initialize the instance variable of an
	// object to their default values
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// Making the getter and setter for that to SET the data and for GET the data 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	
	// here we return the value of that 

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", City=" + City + "]";
	}
	
	 
	
	

}
