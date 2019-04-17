package com.examples.java.jsp.employeemanagement;

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
	
	
	Map<Integer, Employee> employees = new TreeMap<>();
	EmployeeDAO emp1 = new EmployeeDAO();
	Scanner scanner = new Scanner(System.in);
	

	@Override
	public void addEmployee(Employee employee) {
		
		emp1.createUser(employee);
		
   }

	public Map<Integer,Employee> viewEmployee() {
		employees = emp1.displayUser();
		return employees;
    }
   @SuppressWarnings("unused")
   @Override
	public void updateEmployee(String name,String gender,int age,String designation,String department,String country,int value) {
		
			emp1.updateUser(name, gender, age, designation, department, country, value);
          

		}
	
   @Override
	public void deleteEmployee(int value) {
		
		emp1.deleteEmployee(value);

	}

	public void displayEmployeeBasedOnId( int id) {
		
		emp1.displayEmpbyid(id);
	}

	public synchronized void importDetails() {

		try {

			File file = new File("C:\\Users\\LakshmiprasunaAredhu\\Desktop\\JDBCEmployee\\Employee.txt");
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

	@Override
	public void printStatistics() {
		// TODO Auto-generated method stub
		
	}
}
