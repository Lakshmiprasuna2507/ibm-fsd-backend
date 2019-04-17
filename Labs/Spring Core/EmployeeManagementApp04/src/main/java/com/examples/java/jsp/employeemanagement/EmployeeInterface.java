package com.examples.java.jsp.employeemanagement;

import java.util.Map;

public interface EmployeeInterface {

	public void addEmployee(Employee emp);

	public Map<Integer, Employee> viewEmployee();

	public void updateEmployee(String name,String gender,int age,String designation,String department,String country,int value);

	public void deleteEmployee(int value);

	public void displayEmployeeBasedOnId(int id);

	public void printStatistics();

	public void importDetails();

	public void exportDetails();

	public void exit();
}
