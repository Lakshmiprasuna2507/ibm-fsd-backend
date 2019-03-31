package com.examples.java.servlet.annotations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;

@WebListener()
public class ListenerAnnotationEx implements ServletRequestListener {

    
    public ListenerAnnotationEx() {
        
    }

	
    

	public void contextInitialized(ServletContextEvent sce,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
	out.println("application started");
		
	}


	public void contextDestroyed(ServletContextEvent sce,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		out.println("application stopped");
	}

}
