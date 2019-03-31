package com.examples.spring.web.mvc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.examples.spring.web.mvc.model.Register;

public class RegisterService {
	
	private static Map<String, Register> users = new LinkedHashMap<String, Register>();
	

	public void add(Register user)
	{

		user.setId(UUID.randomUUID().toString());		
			
		users.put(user.getId(), user);
	}
	
	public void update(Register employee)
	{
		
		users.put(employee.getId(), employee);
	}
	
	public Register get(String empId)
	{
		return users.get(empId);
	}
	
	public void delete(String empId)
	{
		users.remove(empId);
	}	
	
	public List<Register> list()
	{
		return new ArrayList<Register>(users.values());
	}	
	
}
