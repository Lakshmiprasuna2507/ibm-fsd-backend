package com.examples.java.employeeServlet;



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
			String userName=request.getParameter("user");
			String passWord=request.getParameter("pass");
			PrintWriter out=response.getWriter();
			if(userName.equals(session.getAttribute("fname"))&&passWord.equals(session.getAttribute("pass"))) {
			
			
			RequestDispatcher rd=request.getRequestDispatcher("form.jsp");
			rd.forward(request, response);
			
			//response.sendRedirect("http://localhost:8080/ServletFormEx/home.jsp");
			}else {
				out.println("enter correct username and password");
			}
			
			
		}

	}


