package SpringConfigurableEmployee;




	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Component;

		public class Address {
	@Value("Bangalore")
			private String city;
	@Value("India")
			private String country;
	@Value("560045")
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







