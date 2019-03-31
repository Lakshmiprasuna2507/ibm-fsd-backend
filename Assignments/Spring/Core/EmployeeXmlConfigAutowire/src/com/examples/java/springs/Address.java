package com.examples.java.springs;

public class Address {

	private String city;
	private String country;
	private int pin;
	
	public String getCity() {
		return city;
	}

	public Address(String city, String country, int pin) {
	
		this.city = city;
		this.country = country;
		this.pin = pin;
	}

	public Address() {
	
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	
}
