package com.examples.spring.web.rest;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@RequestMapping(value = { "/", "/employee", "/employee-name" }, method = RequestMethod.GET)
	public String employee() {
		return "Welcome to RESTful services :)";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET, params = { "name" })
	public String getEmployee(@RequestParam(required = false, defaultValue = "Hello") String name) {
		return "Welcome to RESTful services training :) - " + name;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = { "text/plain" })
	public @ResponseBody String postEmployeeMap(@RequestBody String employee) {
		return "Welcome to RESTful services training :) - " + employee;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" }, produces = { "application/xml", "application/json" })
	public Employee postEmployeeObject(@RequestBody Employee employee) {
		employee.setName(employee.getName() + " - POST object mapping example");
		return employee;
	}

	@RequestMapping(value = "/employee/collection", method = RequestMethod.POST)
	public Map<String, String> postEmployeeMap(@RequestBody Map<String, String> employee) {
		employee.put("updated", "POST collection mapping example");
		return employee;
	}

	@RequestMapping(value = "/employee/entity", method = RequestMethod.POST)
	public ResponseEntity<Employee> postEmployeeEntity(@RequestBody Employee employee) {
		employee.setName(employee.getName() + " Updated");

		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("message", "POST entity mapping example");

		ResponseEntity<Employee> res = new ResponseEntity<Employee>(employee, resHeaders, HttpStatus.CREATED);
		return res;
	}

	@RequestMapping(value = "/employee/{messageId}", method = RequestMethod.PUT)
	public Map<String, String> putEmployeeWithPathVariable(@RequestBody Map<String, String> greeting,
			@PathVariable String messageId, @MatrixVariable(required = false) String msgType,
			@MatrixVariable String id) {
		employee.put(messageId, "PUT collection mapping with path variable example");
		if (msgType != null) {
			Employee.put(msgType, "Testing");
		}
		return employee;
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.PUT)
	public Employee putEmployeeWithMatrixParameters(@RequestBody Employee employee,
			@MatrixVariable("messageId") String messageId) {
		return employee;
	}
}


