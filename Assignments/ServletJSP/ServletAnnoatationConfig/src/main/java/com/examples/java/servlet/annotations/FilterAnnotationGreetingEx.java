package com.examples.java.servlet.annotations;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = {"/annotation" })
public class FilterAnnotationGreetingEx implements Filter {

    public FilterAnnotationGreetingEx() {

    }

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

	System.out.println("hello world welcome to filter annotations");
		System.out.println("remote host name" + request.getRemoteHost());
		System.out.println("content type  " + request.getContentType());
		
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
