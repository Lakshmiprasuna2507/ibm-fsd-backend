package com.java.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/employee_management";

	// Database credentials
	final String USER = "root";
	final String PASS = "";

	Map<Integer, Employee> list = new TreeMap();

	public int key = 100;

	public EmployeeDAO() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (ClassNotFoundException c) {

			System.err.println("class not found");

		} catch (SQLException s) {

			System.err.println("there is sysntax error");

		}

	}

	public void createUser(Employee emp1) {

		try {
			// Execute query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String insertQueryForPrepareStmt = "INSERT INTO employee(name,gender, age, designation, department,country) VALUES (?, ?, ?, ?, ?,?)";
			pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
			pstmt.setString(1, emp1.getEmpName());
			pstmt.setString(2, emp1.getGender());
			pstmt.setInt(3, emp1.getAge());
			pstmt.setString(4, emp1.getDesignation());
			pstmt.setString(5, emp1.getDepartment());
			pstmt.setString(6, emp1.getCountry());
			int insertCount = pstmt.executeUpdate();
			System.out.println(insertCount + " Employee inserted");
		} catch (SQLException s) {
			// Handle errors for JDBC
			s.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public void updateUser(String empName, String gender, int age, String designation, String department,
			String country, int value) {

		try {
			// Execute the query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String insertQueryForPrepareStmt = "UPDATE employee SET name=?,gender=?,age=?,designation=?,department=?,country=? where id="
					+ value;
			pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
			pstmt.setString(1, empName);
			pstmt.setString(2, gender);
			pstmt.setInt(3, age);
			pstmt.setString(4, designation);
			pstmt.setString(5, department);
			pstmt.setString(6, country);
			int insertCount = pstmt.executeUpdate();
			System.out.println(insertCount + " Employee updated");
		} catch (SQLException s) {
			// Handle errors for JDBC
			s.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public Map displayUser() {

		try {

			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// Insertion with Statement
			String sql = "select * from employee";
			resultset = stmt.executeQuery(sql);

			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Name", "Gender", "Age", "Designation",
					"Department", "Country");
			while (resultset.next()) {
				// Retrieve by column name
				int id = resultset.getInt("id");
				int age = resultset.getInt("age");
				String name = resultset.getString("name");
				String designation = resultset.getString("designation");
				String department = resultset.getString("department");
				String country = resultset.getString("country");
				String gender = resultset.getString("gender");

				// Display values
				System.out.format("\t%d \t%s \t%s \t%d \t%s \t%s \t%s \n", id, name, gender, age, designation,
						department, country);
				list.put(key++, new Employee(key, name, gender, age, designation, department, country));
			}

		} catch (SQLException s) {
			// Handle errors for JDBC
			s.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return list;
	}// end main

	public void deleteEmployee(int value) {

		try {

			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "delete from employee where id=" + value;
			stmt.execute(sql);
			System.out.println("employee deleted successfully");

		} catch (SQLException s) {
			// Handle errors for JDBC
			s.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}// end main

	public void displayEmpbyid(int value) {

		try {
			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "select * from employee where id=" + value;
			resultset = stmt.executeQuery(sql);

			System.out.format("Id" + " " + "Name" + " " + "Gender" + " " + "Age" + " " + "Designation" + " "
					+ "Department" + " " + "Country\n");
			while (resultset.next()) {
				// Retrieve by column name
				int id = resultset.getInt("id");
				int age = resultset.getInt("age");
				String name = resultset.getString("name");
				String designation = resultset.getString("designation");
				String department = resultset.getString("department");
				String country = resultset.getString("country");
				String gender = resultset.getString("gender");

				// Display values
				System.out.format("\t%d \t%s \t%s \t%d \t%s \t%s \t%s\n", id, name, gender, age, designation,
						department, country);
			}

		} catch (SQLException s) {
			// Handle errors for JDBC
			s.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}// end main

}
