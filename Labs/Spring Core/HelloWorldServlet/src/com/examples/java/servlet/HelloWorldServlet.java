package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	public void init() {
		System.out.println("HelloWorld Servlet initilized...");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException  {
		System.out.println("calling get method");
		this.doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//System.out.println("Host:"+request.getRemoteHost());
		System.out.println("context path:"+request.getContextPath());
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements() ) {
			String headerName = headerNames.nextElement();
			System.out.println("headername"+request.getHeader(headerName));
			
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
	}
	public void service(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("invoked");
		try {
		PrintWriter out=response.getWriter();
		out.println("hello world");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		System.out.println("destroyed");
	}
}