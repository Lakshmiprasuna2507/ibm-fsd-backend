package com.examples.java.jsp.employeeManagementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.java.jsp.employeemanagement.EmployeeService;


public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeService emp=new EmployeeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
