package com.java.employeemanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	@Bean
	public EmployeeDAO employeeDAO() {
		return new EmployeeDAO();
	}
	@Bean
	public EmployeeService employee() {
		return new EmployeeService(employeeDAO());
		
	}

}
