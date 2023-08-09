package com.example.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Exception.ErrorResponse;
import com.example.spring.Exception.UserNotFoundException;
import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepository;

@RestController
@RequestMapping ("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	@RequestMapping ("employees")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee ) {
		try {
				Employee emp = employeeRepository.save(employee);
				return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		} catch (ErrorResponse e) {
			ErrorResponse response = new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("employees/{id}")
	public Employee findById(Long id) {
		Optional < Employee > employeeInfo = employeeRepository.findById(id);

	    Employee employee = null;
	    if (employeeInfo.isPresent()) {
	      employee = employeeInfo.get();
	    } else {
	      throw new UserNotFoundException("The employee information is not available:" + id);
	    }
		return employee;
	}
}
