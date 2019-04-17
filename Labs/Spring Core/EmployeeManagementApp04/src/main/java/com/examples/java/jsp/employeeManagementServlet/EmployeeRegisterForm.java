package com.examples.java.jsp.employeeManagementServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeRegisterForm extends HttpServlet {

	public void init() {
		ServletContext context = getServletContext();
		Enumeration<String> paramNames = context.getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			System.out.println(paramName + ":" + context.getInitParameter(paramName));
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println(session.getId());

		response.setContentType("text/html");
		String userName = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String country = request.getParameter("country");
		

		session.setAttribute("name", userName);
		session.setAttribute("password", password);
		

		RequestDispatcher rd = request.getRequestDispatcher("registerform.jsp");
		rd.forward(request, response);
	}

}
