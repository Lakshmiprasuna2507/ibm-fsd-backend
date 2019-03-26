package com.examples.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeService implements EmployeeInterface {
	@SuppressWarnings("rawtypes")
	Comparator EMPLOYEE_SORT_BY_NAME1 = new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {

			if (o1 instanceof Employee && o2 instanceof Employee) {

				return ((Employee) o1).getEmpName().compareTo(((Employee) o2).getEmpName());

			}
			return 0;
		}

		// can directly compare the employee objects with generic declaration

	};

	TreeMap<Integer, Employee> employees = new TreeMap<>();
	Employee employee;
	//private Scanner input;
	Employee emp=new Employee();
	Scanner in = new Scanner(System.in);

	
	public void addEmployee() {

		System.out.println("--------Enter Your Details-------- ");
		System.out.print("Enter your Empname: ");
		String empName = in.next();
		System.out.print("Enter your gender: ");
		String gender = in.next();
		System.out.print("Enter your age: ");
		int age = in.nextInt();
		System.out.print("Enter your designation: ");
		String designation = in.next();
		System.out.print("Enter your department: ");
		String department = in.next();
		System.out.print("Enter your salary: ");
		double salary = in.nextDouble();
		System.out.print("Enter your country: ");
		String country = in.next();
		employee = new Employee(emp.getEmpId(), empName, gender, age, designation, department, salary, country);
		employees.put(employee.getEmpId(), employee);
		System.out.println("Employee Details Added successfully");

	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + emp.getEmpId() + ", empName=" + emp.getEmpName() + ", gender=" + emp.getGender() + ", age=" + emp.getAge()
				+ ", designation=" +emp.getDesignation() + ", department=" + emp.getDepartment() + ", salary=" + emp.getSalary() + ", country="
				+ emp.getCountry() + "]";
	}

	public void viewEmployee() {
		List<Employee> employeesSorted = new ArrayList<Employee>(employees.values());
		Collections.sort(employeesSorted, EMPLOYEE_SORT_BY_NAME1);

		if (!employeesSorted.isEmpty()) {
			System.out.format("EmpId \t EmpName \t Gender \t Age \t Designation \t Department \t Salary \t Country\n");
			for (Employee emp : employeesSorted) {

				System.out.format(" %d \t %s \t %s \t %s \t %s \t %s\t %s \t %s\n", emp.getEmpId(), emp.getEmpName(), emp.getGender(),
						emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getSalary(), emp.getCountry());

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
		 String empName="";
		 int age=0;
		 String gender="";
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
				  gender = in.next();
				System.out.print("Enter Employee Age:");
				  age = in.nextInt();
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

				     
				
				System.out.print("Enter Employee Designation:");
				 String designation = in.next();
				System.out.print("Enter Employee Department:");
				 String department = in.next();
				System.out.print("Enter salary:");
				 double salary =   in.nextDouble();
				String sal = "[0-9.]+";
				boolean isSal = false;
				
				System.out.print("Enter Employee Country:");
				 String country = in.next();
				employees.get(value).setEmpName(empName);
				employees.get(value).setAge(age);
				employees.get(value).setDesignation(designation);
				employees.get(value).setDepartment(department);
				employees.get(value).setSalary(salary);
				employees.get(value).setCountry(country);

				System.out.println("Data Updated succesfully");
				flag = true;

			}
		}
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

			for (Employee emp : employees.values()) {
				while (!flag) {
					if (emp.getEmpId() == id) {
						System.out.format("EmpId \t EmpName \t Gender \t Age \t Designation \t Department \t Salary \t Country\n");
						System.out.format(" %d \t %s \t %s \t %s \t %s \t %s \t %s \t %s\n", emp.getEmpId(), emp.getEmpName(), emp.getGender(),
								emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getSalary(), emp.getCountry());

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
		List<Employee> employee= new ArrayList<Employee>(employees.values());


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
	    		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	    System.out.println("employees count by department:");
	    System.out.println(groupbydept);
	    Map map =new TreeMap();
	    map = employee
	    		.stream()
	    		.sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new, Collectors.counting()));
	    System.out.println("employee count by department in oredered:");
	    System.out.println(map);
	    Map<String, Double> avgAge=employee
	    		.stream()
	    		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getAge)));
	    System.out.println("average employee age by department:");
	    System.out.println(avgAge);
	     List<Employee> list=employee
	    		 .stream()
	    		 .filter(name->name.getEmpName().startsWith("s")).collect(Collectors.toList());
	     System.out.println("List employee start with s:");
	     System.out.println(list);
	     List<String> dept=employee
	    		 .stream()
	    		 .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>3).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("List department have more than 3 three employees:");
	     System.out.println(dept);
	   //today's date
			Date today = new Date();
			System.out.println(today);
			
	     LocalDateTime currentTime = LocalDateTime.now();
          System.out.println("Current DateTime: " + currentTime);
          Instant timestamp = Instant.now();
           System.out.println(timestamp);
          LocalDate date1 = currentTime.toLocalDate();
          System.out.println("date1: " + date1);
          Month month = currentTime.getMonth();
          int day = currentTime.getDayOfMonth();
          int seconds = currentTime.getSecond();
	}
         
          
          
	   /* double  avgsalary = employee.values()
	    		 .stream()
	    		 .collect(Collectors.averagingDouble(EmployeeDetails::getSalary)).doubleValue();
	     *//*int count1 = 0;
		int count2 = 0;
		int countValue = employees.size();
		int salaries;
		int salaryValue = 0;
		for (EmployeeDetails emp : employees.values()) {
			int age = emp.age;
			//int aged = Integer.parseInt(age);
			if (age >= 35) {
				count1++;
				} else if (age >= 20) {
				count2++;
			}
		}
		System.out.println("Total " + count2 + " employees are of age greaterthan 20");
		System.out.println("Total " + count1 + " employees are of age greaterthan 35");
		
		for (EmployeeDetails emp : employees.values()) {

			T sal = emp.salary;
			
			salaries = Integer.parseInt((String) sal);


			salaryValue += salaries;
		}
		int averageSalary = (salaryValue) / (countValue);
		System.out.println("Average Salary of " + countValue + " employees " + averageSalary);*/
     
	    
	
	public synchronized void importDetails() {
	
		String file= "C:\\Users\\LakshmiprasunaAredhu\\Desktop\\USER\\Employee.txt";
try {
        Employee emp = new Employee();
        BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		while( br.readLine() != null)
		{     line=br.readLine();
			String[] array=line.split(",");
			int id= Integer.parseInt(array[0]);
			String name=array[1];
			String gender=array[2];
			int age= Integer.parseInt(array[3]);
			String designation=array[4];
			String department=array[5];
			double salary= Double.parseDouble(array[6]);
			String country=array[7];
			emp = new Employee(emp.getEmpId(),name,gender,age,designation,department,salary,country);
		    employees.put(emp.getEmpId(),emp);
		}
		System.out.println("Imported successfully");
		br.close();
}catch(IOException e) {
	System.out.println("ERROR: unable to read file" +file);
	e.printStackTrace();
}
	
}

	public  void exportDetails()
	{
		BufferedWriter bw= null;
		String str =" ";
		 try {
			 File file = new File("C:\\Users\\LakshmiprasunaAredhu\\Desktop\\USER\\Employee1.txt");
			 if(!file.exists()) {
				 file.createNewFile();
				 }
			 FileWriter fw = new FileWriter(file);
			 bw =new BufferedWriter(fw);
			 for(Map.Entry<Integer, Employee>entry:employees.entrySet()) {
				 str= "key:"+entry.getKey()+".value: "+entry.getValue();
				 bw.write(str);
				 bw.newLine();
				 bw.flush();
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 System.out.println("File written Successfully");
	}
}





