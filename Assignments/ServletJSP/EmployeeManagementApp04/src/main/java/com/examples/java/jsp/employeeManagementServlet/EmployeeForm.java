package com.examples.java.jsp.employeeManagementServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeForm extends HttpServlet {
	public void init() {
		ServletConfig config=getServletConfig();
		Enumeration<String> paramNames=config.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName=paramNames.nextElement();
			System.out.println(paramName+":"+config.getInitParameter(paramName));
		}
		}
	

   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method called");
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		PrintWriter out=response.getWriter();
		if(userName.equals(session.getAttribute("name"))&&passWord.equals(session.getAttribute("password"))) {
		
		
		RequestDispatcher rd=request.getRequestDispatcher("form.jsp");
		rd.forward(request, response);
		
		}else {
			out.println("enter correct username and password");
		}
		
		
	}

}
