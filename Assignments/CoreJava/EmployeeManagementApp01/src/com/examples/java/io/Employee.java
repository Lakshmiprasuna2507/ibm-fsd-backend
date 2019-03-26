package com.examples.java.io;

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

	public class Employee {

		
		private static AtomicInteger idGenerator = new AtomicInteger(100);
		private final int empId;
		private String empName;
		private String gender;
		private int age;
		private String designation;
		private String department;
		private double salary;
		private String country;

		public Employee(int empId, String empName, String gender, int age, String designation, String department,
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

		public Employee() {
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

	}

		// Employees are sorted by name
		