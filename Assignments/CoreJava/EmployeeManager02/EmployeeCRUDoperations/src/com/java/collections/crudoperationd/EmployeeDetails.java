package com.java.collections.validations;

    import java.util.concurrent.atomic.AtomicInteger;
	import java.util.stream.Collectors;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.time.Instant;
	import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.time.Month;
	import java.util.*;

	public class EmployeeDetails {

		private static AtomicInteger idGenerator = new AtomicInteger(100);
		private final int empId;
		private String empName;
		private String gender;
		private int age;
		private String designation;
		private String department;
		private double salary;
		private String country;

		public EmployeeDetails(int empId, String empName, String gender, int age, String designation, String department,
				double salary, String country) {

			this.empId = idGenerator.getAndIncrement();
			this.empName = empName;
			this.gender = gender;
			this.age = age;
			this.designation = designation;
			this.department = department;
			this.salary = salary;
			this.country = country;
			//empId++;
		}

		public EmployeeDetails() {
			// TODO Auto-generated constructor stub
			this.empId=0;
		}

		// employee setters and getters
		public int getEmpId() {
			return empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age2) {
			this.age = age2;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public TreeMap<Integer, EmployeeDetails> getEmployees() {
			return employees;
		}

		public void setEmployees(TreeMap<Integer, EmployeeDetails> employees) {
			this.employees = employees;
		}

		// Employees are sorted by name
		@SuppressWarnings("rawtypes")
		Comparator EMPLOYEE_SORT_BY_NAME1 = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {

				if (o1 instanceof EmployeeDetails && o2 instanceof EmployeeDetails) {

					return ((EmployeeDetails) o1).getEmpName().compareTo(((EmployeeDetails) o2).getEmpName());

				}
				return 0;
			}

			// can directly compare the employee objects with generic declaration

		};

		TreeMap<Integer, EmployeeDetails> employees = new TreeMap<>();
		EmployeeDetails employee;
		//private Scanner input;
		Scanner in = new Scanner(System.in);

		public void addEmployee() {

			System.out.println("--------Enter Your Details-------- ");
			System.out.print("Enter your Empname: ");
			empName = in.next();
			System.out.print("Enter your gender: ");
			gender = in.next();
			System.out.print("Enter your age: ");
			age = in.nextInt();
			System.out.print("Enter your designation: ");
			designation = in.next();
			System.out.print("Enter your department: ");
			department = in.next();
			System.out.print("Enter your salary: ");
			salary = in.nextDouble();
			System.out.print("Enter your country: ");
			country = in.next();
			employee = new EmployeeDetails(empId, empName, gender, age, designation, department, salary, country);
			employees.put(employee.getEmpId(), employee);
			System.out.println("Employee Details Added successfully");

		}

		@Override
		public String toString() {
			return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", age=" + age
					+ ", designation=" + designation + ", department=" + department + ", salary=" + salary + ", country="
					+ country + "]";
		}

		public void viewEmployee() {
			List<EmployeeDetails> employeesSorted = new ArrayList<EmployeeDetails>(employees.values());
			Collections.sort(employeesSorted, EMPLOYEE_SORT_BY_NAME1);

			if (!employeesSorted.isEmpty()) {
				System.out.format("EmpId \t EmpName \t Gender \t Age \t Designation \t Department \t Salary \t Country\n");
				for (EmployeeDetails emp : employeesSorted) {

					System.out.format(" %d \t %s \t %s \t %s \t %s \t %s\t %s \t %s\n", emp.empId, emp.empName, emp.gender,
							emp.age, emp.designation, emp.department, emp.salary, emp.country);

				}
			} else {
				System.out.println("Empty");
			}
		}
		@SuppressWarnings("unused")
		public void updateEmployee() {
			int value;
			boolean flag = false;
			System.out.print("Enter the key to update data:");
			value = in.nextInt();
			while (!flag) {
				if (employees.containsKey(value)) {
					System.out.print("Enter Employee Name:");
					empName = in.next();
					boolean flag1 = false;
					String name = "[a-zA-Z ]+";
					while (!flag1) {
						if ((empName.matches(name))) {

							flag1 = true;

						} else {
							System.out.println("enter only alphabets");
							empName = in.next();
						}
					}
					System.out.print("Enter Employee Gender:");
					 String gender = in.next();
					System.out.print("Enter Employee Age:");
					 int age = in.nextInt();
					boolean isAge = false;
					String ageValidation = "[0-9]+";

					while (!isAge) {
						//if (age.matches(ageValidation)) {
							//int agevalue = Integer.parseInt(age);
							if (age < 20 || age > 80) {
								System.out.println("Enter valid age between 20 and 80");
								age = in.nextInt();
							} else {
								isAge = true;
							}

					}
				}
							else {
							System.out.println("enter only numbers");
							age = in.nextInt();

						}
					}
					System.out.print("Enter Employee Designation:");
					designation = in.next();
					System.out.print("Enter Employee Department:");
					department = in.next();
					System.out.print("Enter salary:");
					salary =   in.nextDouble();
					String sal = "[0-9.]+";
					boolean isSal = false;
					
					System.out.print("Enter Employee Country:");
					country = in.next();
					employees.get(value).setEmpName(empName);
					employees.get(value).setAge(age);
					employees.get(value).setDesignation(designation);
					employees.get(value).setDepartment(department);
					employees.get(value).setSalary(salary);
					employees.get(value).setCountry(country);

					System.out.println("Data Updated succesfully");
					flag = true;

				}

				/*else {
					System.out.println("No available key to update enter valid key");
					value = in.nextInt();

				}*/
			//}

		//}
			/*int key;
			boolean flag = false;
			System.out.println("enter the key to update the data");
			key = in.nextInt();
			while(!flag)
			{
				if(employees.containsKey(key)) {
					System.out.print("Enter your EmpId: ");
					empId = in.nextInt();
					System.out.print("Enter your Empname: ");
					empName = in.next();
					System.out.print("Enter your gender: ");
					gender = in.next();
					System.out.print("Enter your age: ");
					age = in.nextInt();
					System.out.print("Enter your designation: ");
					designation = in.next();
					System.out.print("Enter your department: ");
					department = in.next();
					System.out.print("Enter your salary: ");
					salary = in.nextInt();
					System.out.print("Enter your country: ");
					country = in.next();
					employee.empId = empId;
					employee.empName = empName;
					employee.gender = gender;
					employee.age = age;
					employee.designation = designation;
					employee.department = department;
					employee.salary = salary;
					employee.country = country;
					
					employees.put(key, employee);
					System.out.println("Details updated successfully ");
					flag = true;
			}else {
				System.out.println("enter valid key");
				key = in.nextInt();
			}
			
		}
			
	   }*/
		
		public void deleteEmployee() {
			int value;
			boolean flag = false;
			System.out.print("Enter the key to delete:");
			value = in.nextInt();
			while (!flag) {
				if (employees.containsKey(value)) {
					employees.remove(value);
					flag = true;
					System.out.println("Removed Succesfully");
				} else {
					System.out.println("Entered value doesnt exist to delete enter valid value");
					value = in.nextInt();

				}
			}
					
			
		}
		public void displayEmployeeBasedOnId() {
			int id;
			int values;
			System.out.print("Enter the id to display data:");
			id = in.nextInt();
			boolean flag = false;
			if (!employees.isEmpty()) {

				for (EmployeeDetails emp : employees.values()) {
					while (!flag) {
						if (emp.empId == id) {
							System.out.format("EmpId \t EmpName \t Gender \t Age \t Designation \t Department \t Salary \t Country\n");
							System.out.format(" %d \t %s \t %s \t %s \t %s \t %s \t %s \t %s\n", emp.empId, emp.empName, emp.gender,
									emp.age, emp.designation, emp.department, emp.salary, emp.country);

							flag = true;
						} else {
							System.out.println("Entered key doesnt exist please enter valid value");
							id = in.nextInt();
						}

					}
				}
			} else {
				System.out.println("No data to display");
			}

		}

		public void printStatistics() {
			List<EmployeeDetails> employee= new ArrayList<EmployeeDetails>(employees.values());


		   long count =employee
				   .stream()
				   .filter(e->e.getAge() > 20).count();
		   System.out.println("Number of employee greater than age 20:"+ count);
		   
		   List<Integer> getempId=new ArrayList<>();
		   getempId=employee
				   .stream()
				   .filter(e->e.getAge() > 20)
				   .map(e->e.getEmpId()).collect(Collectors.toList());
		   for(Object empids:getempId)
		   {
			   System.out.println("empid greater than age 20:" +empids);
		   }
		    Map<String,Long > groupbydept=employees.values()
		    		.stream()
		    		.collect(Collectors.groupingBy(EmployeeDetails::getDepartment,Collectors.counting()));
		    System.out.println("employees count by department:");
		    System.out.println(groupbydept);
		    Map map =new TreeMap();
		    map = employee
		    		.stream()
		    		.sorted(Comparator.comparing(EmployeeDetails::getDepartment)).collect(Collectors.groupingBy(EmployeeDetails::getDepartment,TreeMap::new, Collectors.counting()));
		    System.out.println("employee count by department in oredered:");
		    System.out.println(map);
		    Map<String, Double> avgAge=employee
		    		.stream()
		    		.collect(Collectors.groupingBy(EmployeeDetails::getDepartment,Collectors.averagingInt(EmployeeDetails::getAge)));
		    System.out.println("average employee age by department:");
		    System.out.println(avgAge);
		     List<EmployeeDetails> list=employee
		    		 .stream()
		    		 .filter(name->name.getEmpName().startsWith("s")).collect(Collectors.toList());
		     System.out.println("List employee start with s:");
		     System.out.println(list);
		     List<String> dept=employee
		    		 .stream()
		    		 .collect(Collectors.groupingBy(EmployeeDetails::getDepartment,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>3).map(Map.Entry::getKey).collect(Collectors.toList());
			System.out.println("List department have more than 3 three employees:");
		     System.out.println(dept);
		   //today's date
				Date today = new Date();
				System.out.println(today);
				
		}
	         
}
