package SpringConfigurableEmployee;



	import java.time.LocalDate;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	
		public class Employee {
	
 int id;
			private String name;
			private LocalDate dob;
			private String designation;
			private double salary;
			private List<String>skills;
			private Address addresses;
		

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

			@Autowired
			public Employee(LocalDate dob, List<String> skills, Address addresses) {
				
				this.dob = dob;
				this.skills = skills;
				this.addresses = addresses;
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
		  public Employee(int id,String name,Address addresses) {
			this.id=id;
			this.name=name;
			this.addresses=addresses;
		}

			public void printDetails() {
				
			}


			public Employee(LocalDate dob, Address addresses) {
				
				this.dob = dob;
				this.addresses = addresses;
			}


public Address getAddresses() {
	return addresses;
}


public void setAddresses(Address addresses) {
	this.addresses = addresses;
}


		



		}







