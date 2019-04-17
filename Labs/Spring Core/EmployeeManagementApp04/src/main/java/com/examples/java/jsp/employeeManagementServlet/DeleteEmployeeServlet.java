package com.examples.java.jsp.employeeManagementServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.java.jsp.employeemanagement.EmployeeService;



public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService emp=new EmployeeService();
		String did=request.getParameter("did");
		System.out.println(did);
		
		emp.deleteEmployee(Integer.parseInt(did));
		PrintWriter out=response.getWriter();
		out.println("employee deleted successfully");
		response.sendRedirect("form.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
