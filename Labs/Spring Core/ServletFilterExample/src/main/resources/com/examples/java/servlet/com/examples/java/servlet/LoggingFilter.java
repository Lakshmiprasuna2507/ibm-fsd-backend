package com.examples.java.servlet;

import javax.servlet.ServletRequest;

public class LoggingFilter implements Filter {

	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException {
		String host=(String)request.getRemoteHost();
		System.out.println("Request recieved from"+host);
	}
}
