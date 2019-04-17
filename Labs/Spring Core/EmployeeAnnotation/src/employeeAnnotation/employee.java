package employeeAnnotation;

import java.time.LocalDate;
import java.util.List;



public class employee {

	private int id;
	private String name;
	private LocalDate dob;
	private String designation;
	private double salary;
	private List<String>skills;
	private address address1;
	public address getAddress() {
		return address1;
	}


	public void setAddress(address address1) {
		this.address1 = address1;
	}


	private boolean fulltime;
	
	//setters and getters
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


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	

	public List<String> getSkills() {
		return skills;
	}


	public void setSkills(List<String> skills) {
		this.skills = skills;
	}


	public boolean isFulltime() {
		return fulltime;
	}


	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	//constructor
  public employee(int id,String name,address address) {
	this.id=id;
	this.name=name;
	this.address1=address1;
}

	public void printDetails() {
		
	}
	



}
