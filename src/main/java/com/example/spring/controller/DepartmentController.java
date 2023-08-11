package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.exception.RecordNotFoundException;
import com.example.spring.model.Department;
import com.example.spring.repository.DepartmentRepository;
import com.example.spring.service.DepartmentService;

@RestController
@RequestMapping("/api/v3/")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PutMapping
	@RequestMapping("departments")
	public List<Department> saveDepartment (@RequestBody List<Department> department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping
	@RequestMapping ("getDepartments")
	public List<Department> getAllDepartments () {
		
		try {
			return (List<Department>) departmentRepository.findAll();
		} catch (Exception e) {
			throw new RecordNotFoundException("Department records does not exists");
		}
	}
	
	@GetMapping
	@RequestMapping("departments/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		try {
			if (department.isPresent()) {
				return new ResponseEntity<> (department.get(), HttpStatus.OK);
			} else {
				throw new RecordNotFoundException("Searched department "+ id + "does not exists");
			}
		} catch (Exception e) {
			throw new RecordNotFoundException("Searched department Id '"+ id + "' does not exists");
		}
	}
	
	
	@PutMapping
	@RequestMapping("updatedepartments/{id}")
	public String updateDepartment(@PathVariable Long id, Department department) {
		return departmentService.updateDepartments(id, department);
	}
}
