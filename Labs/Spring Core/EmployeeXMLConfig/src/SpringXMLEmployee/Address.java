package SpringXMLEmployee;



	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Component;

	
		public class Address {
	
			private String city;
	
			private String country;
	
			private Integer pin;
			
			public String getCity() {
				return city;
			}

			public Address(String city, String country, Integer pin) {
			
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

			public Integer getPin() {
				return pin;
			}

			public void setPin(Integer pin) {
				this.pin = pin;
			}

			
		}





