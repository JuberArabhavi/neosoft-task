package com.example.spring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.exception.AlreadyExistException;
import com.example.spring.model.Department;
import com.example.spring.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> saveDepartment(List<Department> department) {
		Set<Department> uniqueDepartment = new HashSet<>(department);

		try {
			return departmentRepository.saveAll(uniqueDepartment);
		} catch (Exception e) {
			throw new AlreadyExistException("The record already exists");
		}
	}

	public String updateDepartments(Long id, Department department) {
		Optional<Department> updateDept = departmentRepository.findById(id);

		if (updateDept.isPresent()) {
			updateDept.get().setDeptName(department.getDeptName());
			updateDept.get().setDeptCode(department.getDeptCode());
			return "Department record updated successfully";
		} else {
			return "Department id to be updated not found";
		}
		
	}

}
