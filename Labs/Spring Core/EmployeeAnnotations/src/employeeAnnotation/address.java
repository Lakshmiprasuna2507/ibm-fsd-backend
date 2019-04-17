package employeeAnnotation;

public class address {

	private String city;
	private String country;
	private int pin;
	
	public String getCity() {
		return city;
	}

	public address(String city, String country, int pin) {
	
		this.city = city;
		this.country = country;
		this.pin = pin;
	}

	public address() {
	
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


