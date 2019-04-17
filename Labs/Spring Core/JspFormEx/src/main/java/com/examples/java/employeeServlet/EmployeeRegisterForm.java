package com.examples.java.employeeServlet;



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
			ServletContext context=getServletContext();
			Enumeration<String> paramNames=context.getInitParameterNames();
			while(paramNames.hasMoreElements()) {
				String paramName=paramNames.nextElement();
				System.out.println(paramName+":"+context.getInitParameter(paramName));
		}
		}
		
		 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			  HttpSession session=request.getSession();
			  System.out.println(session.getId());
			  
			  response.setContentType("text/html"); String
			  userName=request.getParameter("fname"); String
			  lastName=request.getParameter("lname"); String
			  password=request.getParameter("pass"); String
			  phoneno=request.getParameter("pno"); session.setAttribute("fname", userName);
			  session.setAttribute("lname", lastName); session.setAttribute("pass",
			  password); session.setAttribute("pno", phoneno);
			 
			 
			
			RequestDispatcher rd=request.getRequestDispatcher("registerform.jsp");
			rd.forward(request, response);
		}

	}


