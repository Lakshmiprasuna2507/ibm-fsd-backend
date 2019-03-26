package com.examples.java.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeDAO {
 
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";//jdbctraining-> schema

	// Database credentials
	static final String USER = "root"; 
	static final String PASS = "pass@word1"; 


public void createUser(EmployeeDetails emp) {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		// STEP 2: Register JDBC driver with Driver Manager
		Class.forName("com.mysql.jdbc.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		System.out.println("Connection estabilished: " + conn);

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();

		// Insertion with Statement


		String insertQueryForPrepareStmt = "INSERT INTO employee (name,gender, age, designation, department, country) VALUES (?, ?, ?, ?, ?,?)";
		pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getGender());
		pstmt.setInt(3, emp.getAge());
		pstmt.setString(4, emp.getDesignation()  );
		pstmt.setString(5, emp.getDepartment());
		pstmt.setString(6,emp.getCountry());			
		int insertCount = pstmt.executeUpdate();
		System.out.println(insertCount + " Employee(s) inserted");
	} catch (SQLException se) {
		// Handle errors for JDBC
		se.printStackTrace();
	} catch (Exception e) {
		// Handle errors for Class.forName
		e.printStackTrace();
	} finally {
		// finally block used to close resources
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException se2) {
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException se2) {
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		} // nothing we can do
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // end finally try
	} // end try
	System.out.println("Goodbye!");
}// end main
//}// end FirstExample

public void updateUser(String empName, String gender, int age, String designation, String department,String country,int value) {

Connection conn = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
// STEP 2: Register JDBC driver with Driver Manager
Class.forName("com.mysql.jdbc.Driver");

// STEP 3: Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

System.out.println("Connection estabilished: " + conn);

// STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();

// Insertion with Statement


String insertQueryForPrepareStmt = "UPDATE employee SET name=?,gender=?,age=?,designation=?,department=?,country=? where id="+value;
pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
pstmt.setString(1,empName);
pstmt.setString(2, gender);
pstmt.setInt(3,age);
pstmt.setString(4, designation);
pstmt.setString(5, department);
pstmt.setString(6,country);			
int insertCount = pstmt.executeUpdate();
System.out.println(insertCount + " Employee(s) updated");
} catch (SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
} catch (Exception e) {
// Handle errors for Class.forName
e.printStackTrace();
} finally {
// finally block used to close resources
try {
if (rs != null) {
	rs.close();
}
} catch (SQLException se2) {
}
try {
if (pstmt != null) {
	pstmt.close();
}
} catch (SQLException se2) {
}
try {
if (stmt != null)
	stmt.close();
} catch (SQLException se2) {
} // nothing we can do
try {
if (conn != null)
	conn.close();
} catch (SQLException se) {
se.printStackTrace();
} // end finally try
} // end try
System.out.println("Goodbye!");
}// end main
public int key=100;
public Map displayUser() {
Connection conn = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
Map<Integer, EmployeeDetails> list=new TreeMap();

try {
// STEP 2: Register JDBC driver with Driver Manager
Class.forName("com.mysql.jdbc.Driver");

// STEP 3: Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

System.out.println("Connection estabilished: " + conn);

// STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();

// Insertion with Statement


String sql="select * from employee";
rs=stmt.executeQuery(sql);



System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Name","Gender", "Age","Designation", "Department","Country");
while (rs.next()) {
// Retrieve by column name
int id = rs.getInt("id");
int age = rs.getInt("age");
String name = rs.getString("name");
String designation = rs.getString("designation");
String department = rs.getString("department");
String country = rs.getString("country");
String gender=rs.getString("gender");

// Display values
System.out.format("\t%d \t%s \t%s \t%d \t%s \t%s \t%s \n", id ,name ,gender ,age , designation , department , country );
list.put(key++, new EmployeeDetails(name,gender,age,designation,department,country));
}

} catch (SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
} catch (Exception e) {
// Handle errors for Class.forName
e.printStackTrace();
} finally {
// finally block used to close resources
try {
if (rs != null) {
	rs.close();
}
} catch (SQLException se2) {
}
try {
if (pstmt != null) {
	pstmt.close();
}
} catch (SQLException se2) {
}
try {
if (stmt != null)
	stmt.close();
} catch (SQLException se2) {
} // nothing we can do
try {
if (conn != null)
	conn.close();
} catch (SQLException se) {
se.printStackTrace();
} // end finally try
} // end try
System.out.println("Goodbye!");
return list;
}// end main
//}// end FirstExample

public void deleteEmployee(int value) {
Connection conn = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
// STEP 2: Register JDBC driver with Driver Manager
Class.forName("com.mysql.jdbc.Driver");

// STEP 3: Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

System.out.println("Connection estabilished: " + conn);

// STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();

String sql="delete from employee where id="+value;
stmt.execute(sql);
System.out.println("employee deleted successfully");



} catch (SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
} catch (Exception e) {
// Handle errors for Class.forName
e.printStackTrace();
} finally {
// finally block used to close resources
try {
if (rs != null) {
	rs.close();
}
} catch (SQLException se2) {
}
try {
if (pstmt != null) {
	pstmt.close();
}
} catch (SQLException se2) {
}
try {
if (stmt != null)
	stmt.close();
} catch (SQLException se2) {
} // nothing we can do
try {
if (conn != null)
	conn.close();
} catch (SQLException se) {
se.printStackTrace();
} // end finally try
} // end try
System.out.println("Goodbye!");
}// end main
//}// end FirstExample

public void displayEmpbyid(int value) {
Connection conn = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
// STEP 2: Register JDBC driver with Driver Manager
Class.forName("com.mysql.jdbc.Driver");

// STEP 3: Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

System.out.println("Connection estabilished: " + conn);

// STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();

String sql="select * from employee where id="+value;
rs=stmt.executeQuery(sql);



System.out.format("\t%d \t%s \t%s \t%d \t%s \t%s \t%s\n", "Id", "Name","Gender", "Age","Designation", "Department","Country");
while (rs.next()) {
// Retrieve by column name
int id = rs.getInt("id");
int age = rs.getInt("age");
String name = rs.getString("name");
String designation = rs.getString("designation");
String department = rs.getString("department");
String country = rs.getString("country");
String gender=rs.getString("gender");

// Display values
System.out.format("\t%d \t%s \t%s \t%d \t%s \t%s \t%s\n", id,  name,gender,age, designation, department, country);
}


} catch (SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
} catch (Exception e) {
// Handle errors for Class.forName
e.printStackTrace();
} finally {
// finally block used to close resources
try {
if (rs != null) {
	rs.close();
}
} catch (SQLException se2) {
}
try {
if (pstmt != null) {
	pstmt.close();
}
} catch (SQLException se2) {
}
try {
if (stmt != null)
	stmt.close();
} catch (SQLException se2) {
} // nothing we can do
try {
if (conn != null)
	conn.close();
} catch (SQLException se) {
se.printStackTrace();
} // end finally try
} // end try
System.out.println("Goodbye!");
}// end main
//}// end FirstExample

}
