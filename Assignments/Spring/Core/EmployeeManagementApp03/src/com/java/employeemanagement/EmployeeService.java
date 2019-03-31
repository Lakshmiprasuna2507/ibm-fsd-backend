package com.java.employeemanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService implements EmployeeInterface {
	
	@Autowired
  public EmployeeService(EmployeeDAO emp) {
     this.emp1 = emp;

	}
  public EmployeeDAO emp1;
  public void setEmp(EmployeeDAO emp) {
    this.emp1 = emp;

	}
public EmployeeDAO getEmp() {

		return emp1;
}

	Map<Integer, Employee> employees = new TreeMap<>();
	Employee employee = new Employee();
	// private Scanner input;
	Scanner in = new Scanner(System.in);
	EmployeeDAO emp;

	private int age;
	private String gender;
	private String empName;
	private String department;
	private String country;
	private String designation;

	

	@Override
	public void addEmployee() {
		System.out.println("--------Enter Your Details-------- ");
		System.out.print("Enter your Empname: ");
		empName = in.next();
		boolean b = false;
		String s = "[a-zA-Z]+";
		while (!b) {
			if (empName.matches(s)) {
				b = true;
			} else {
				System.out.println("error:Enter only Alphabets");
				empName = in.next();
			}
		}
		System.out.print("Enter your gender: ");
		String gender = in.next();
		System.out.print("Enter your age: ");
		int age = in.nextInt();
		boolean a = false;
		String ageValidation = "[0-9]+";
		String st = String.valueOf(age);
		while (!a) {
			if (st.matches(ageValidation)) {
				if (age < 20 || age > 50) {
					System.out.println("Error:Enter valid age between 20 and 50");
					age = in.nextInt();
				} else {
					a = true;
				}
			} else {
				System.out.println("Error:Enter valid age between 20 and 50");
				age = in.nextInt();
			}
		}
		System.out.print("Enter your designation: ");
		String designation = in.next();
		System.out.print("Enter your department: ");
		String department = in.next();
		System.out.print("Enter your country: ");
		String country = in.next();
		emp1.createUser(new Employee(empName, gender, age, designation, department, country));
		System.out.println("Employee Details Added successfully");
   }

	public void viewEmployee() {
		employees = emp1.displayUser();
    }
   @SuppressWarnings("unused")
	public void updateEmployee() {
		int value;
		boolean flag = false;
		System.out.print("Enter the key to update data:");
		value = in.nextInt();
		System.out.print("Enter Employee Name:");
		String empName = in.next();
		boolean flag1 = false;
		String name = "[a-zA-Z ]+";
		while (!flag1) {
			if ((empName.matches(name))) {
                   flag1 = true;
                   } else {
				System.out.println("enter only alphabets");
                 }
            System.out.print("Enter Employee Gender:");
			String gender = in.next();
			System.out.println(gender);
			System.out.print("Enter Employee Age:");
			int age = in.nextInt();
			boolean isAge = false;
			String ageValidation = "[0-9]+";
            while (!isAge) {
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
            String sal = "[0-9.]+";
			boolean isSal = false;
			System.out.print("Enter Employee Country:");
			String country = in.next();
			emp1.updateUser(empName, gender, age, designation, department, country, value);
            System.out.println("Data Updated succesfully");
			flag = true;

		}
	}

	public void deleteEmployee() {
		int value;
		boolean flag = false;
		System.out.print("Enter the key to delete:");
		value = in.nextInt();
		emp1.deleteEmployee(value);

	}

	public void displayEmployeeBasedOnId() {
		int id;
		int values;
		System.out.print("Enter the id to display data:");
		id = in.nextInt();
		emp1.displayEmpbyid(id);
	}

	public void printStatistics() {
		List<Employee> employee = new ArrayList<Employee>(employees.values());

		long count = employee.stream().filter(e -> e.getAge() > 20).count();
		System.out.println("Number of employee greater than age 20:" + count);

		List<Integer> getempId = new ArrayList<>();
		getempId = employee.stream().filter(e -> e.getAge() > 20).map(e -> e.getEmpId()).collect(Collectors.toList());
		for (Object empids : getempId) {
			System.out.println("empid greater than age 20:" + empids);
		}
		Map<String, Long> groupbydept = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("employees count by department:");
		System.out.println(groupbydept);
		Map map = new TreeMap();
		map = employee.stream().sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
		System.out.println("employee count by department in oredered:");
		System.out.println(map);
		Map<String, Double> avgAge = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));
		System.out.println("average employee age by department:");
		System.out.println(avgAge);
		List<Employee> list = employee.stream().filter(name -> name.getEmpName().startsWith("s"))
				.collect(Collectors.toList());
		System.out.println("List employee start with s:");
		System.out.println(list);
		List<String> dept = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 3).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("List department have more than 3 three employees:");
		System.out.println(dept);

	}

	public synchronized void importDetails() {

		try {

			File file = new File("C:\\Users\\LakshmiprasunaAredhu\\Desktop\\JDBCEmployee\\Employee.txt");

			System.out.println("File: " + file);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] array = line.split(",");
				int id = Integer.parseInt(array[0]);
				String name = array[1];
				String gender = array[2];
				int age = Integer.parseInt(array[3]);
				String designation = array[4];
				String department = array[5];
				String country1 = array[6];

				emp1.createUser(new Employee(id, name, gender, age, designation, department, country1));
			}
			System.out.println("Imported successfully");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public synchronized void exportDetails() {
		BufferedWriter bw = null;
		String str = " ";
		try {
			BufferedWriter out = new BufferedWriter(
					new FileWriter("C:\\Users\\LakshmiprasunaAredhu\\Desktop\\JDBCEmployee\\Employee1.txt"));
			for (Employee emp : employees.values()) {
				out.write(emp.getEmpName() + emp.getAge() + emp.getEmpId() + emp.getGender() + emp.getDepartment()
						+ emp.getDesignation() + emp.getCountry());
				out.newLine();
				out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exported  Successfully");
	}

	@Override
	public void exit() {

	}
}
