package com.examples.spring.boot.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.spring.boot.rest.model.Employee;
import com.examples.spring.boot.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public void add(Employee employee) {
		employeeRepo.save(employee);
	}

	public void update(Employee employee) {
		employeeRepo.save(employee);
	}

	public Employee get(String id) {
		return employeeRepo.findById(id).get();
	}

	public void delete(String id) {
		employeeRepo.delete(employeeRepo.findById(id).get());
	}

	public List<Employee> list() {
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : employeeRepo.findAll()) {
			employees.add(employee);
		}
		return employees;
	}

}
