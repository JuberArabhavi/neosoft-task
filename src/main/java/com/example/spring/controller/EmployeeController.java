package com.example.spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.exception.AlreadyExistException;
import com.example.spring.exception.RecordNotFoundException;
import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepository;

@RestController
@RequestMapping ("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	@RequestMapping ("employees")
	public List<Employee> createEmployee(@RequestBody List<Employee> employee ) {
		Set<Employee> uniqueEmployees = new HashSet<>(employee);
		
		try {
			return employeeRepository.saveAll(uniqueEmployees);
		} catch (Exception e) {
			throw new AlreadyExistException("The record Already Exists");
		}
	}
	
	@GetMapping("employees/{id}")
	public Employee findById(Long id) {
		Optional < Employee > employeeInfo = employeeRepository.findById(id);

	    Employee employee = null;
	    if (employeeInfo.isPresent()) {
	      employee = employeeInfo.get();
	    } else {
	      throw new RecordNotFoundException("The employee information is not available:" + id);
	    }
		return employee;
	}
}
