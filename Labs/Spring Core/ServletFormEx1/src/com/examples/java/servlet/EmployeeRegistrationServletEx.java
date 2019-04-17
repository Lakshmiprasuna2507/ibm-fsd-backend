package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeRegistrationServletEx extends HttpServlet{
	
	public void init() {
		System.out.println("Employee Registration");
		
		//display servlet config parameters
		ServletConfig config= getServletConfig();
		System.out.println();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" GET Method");
		this.doPost(request, response);
		}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	
//	HttpSession session	=request.getSession();
//	System.out.println("session ID:"+session.getId());
//
//		String FirstName=request.getParameter("firstname");
//		String LastName=request.getParameter("lastname");
//		
//		session.setAttribute(FirstName, FirstName);
//		session.setAttribute(LastName, LastName);
		HttpSession session	=request.getSession();
		String FirstName=request.getParameter("firstname");
		String LastName=request.getParameter("lastname");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Thank you for registering</h2>");
		out.println("FirstName:"+FirstName+"<br>");
		out.println("LastName:"+LastName);
		out.println("</html></body>");
				
		
	}

	public void destroy() {
		System.out.println("destroyed");
		
	}

}
