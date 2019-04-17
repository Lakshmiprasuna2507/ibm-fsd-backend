package com.examples.spring.web.rest;

public class Employee {

	private int id;
	String name;
	String gender;
	String designation;
	
	public Employee() {
		
	}
	public Employee(int id, String name, String gender, String designation) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
