package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * Created by 
 * @Author : Juber
 * 03-08-23
 * */

@JsonIgnoreProperties(ignoreUnknown = true ,value = {
		"empMobileNo"
})
@Entity
@Table (name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empId")
	private Long empId;
	
	@Column (name = "empName")
	private String empName;
	
	@Column (name = "empAddress")
	private String empAddress;
	
	@JsonIgnore
	@Column (name = "empMobileNo")
	private Long empMobileNo;

	@Column (name = "empAdhaarNo")
	private Long empAdhaarNo;
	
	@Column (name = "empPanNo")
	private String empPanNo;
	
	@ManyToOne(cascade= CascadeType.MERGE, fetch= FetchType.LAZY)
	@JoinColumn (name = "deptId")
	public Department department;

	
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Long getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(Long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public Long getEmpAdhaarNo() {
		return empAdhaarNo;
	}

	public void setEmpAdhaarNo(Long empAdhaarNo) {
		this.empAdhaarNo = empAdhaarNo;
	}

	public String getEmpPanNo() {
		return empPanNo;
	}

	public void setEmpPanNo(String empPanNo) {
		this.empPanNo = empPanNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
