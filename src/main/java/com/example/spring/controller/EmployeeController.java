package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepository;

@RestController
@RequestMapping ("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	@RequestMapping ("employees")
	public Employee createEmployee(@RequestBody Employee employee ) {
		return employeeRepository.save(employee);
	}
}
