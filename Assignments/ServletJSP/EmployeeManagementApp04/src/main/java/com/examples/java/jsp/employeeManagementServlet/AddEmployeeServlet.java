package com.examples.java.jsp.employeeManagementServlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.java.jsp.employeemanagement.Employee;
import com.examples.java.jsp.employeemanagement.EmployeeService;


public class AddEmployeeServlet extends HttpServlet {
	EmployeeService emp=new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String designation=request.getParameter("designation");
		String department=request.getParameter("department");
		String country=request.getParameter("country");
	
		emp.addEmployee(new Employee(name,gender,age,designation,department,country));
     response.sendRedirect("form.jsp");
	}

}
