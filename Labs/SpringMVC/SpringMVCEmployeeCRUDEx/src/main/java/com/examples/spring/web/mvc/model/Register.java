package com.examples.spring.web.mvc.model;

public class Register {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int phoneno;
	
	public Register() {
		
	}
	
	public Register(String firstname,String lastname,String username,String password,int phoneno) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.username=username;
		this.password=password;
		this. phoneno= phoneno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	
}
