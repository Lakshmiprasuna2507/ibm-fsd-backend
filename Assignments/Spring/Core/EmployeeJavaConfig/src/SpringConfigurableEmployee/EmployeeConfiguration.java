package SpringConfigurableEmployee;



	import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Configurable;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	@Configurable
	@ComponentScan 
	public class EmployeeConfiguration {

		@Bean
		public Employee employee() {
			return new Employee(dob(),skills(),addresses());
		}
		public List<String> skills() {
			ArrayList<String> abc=new ArrayList<String>();
			abc.add("C");
			abc.add("C++");
			abc.add("JAVA");
			return abc;
		}
		@Bean
		public LocalDate dob() {
			return LocalDate.parse("1997-07-25");
		}
		@Bean
		public Address addresses() {
			return new Address("Bangalore","India",560045);
		}
	}



