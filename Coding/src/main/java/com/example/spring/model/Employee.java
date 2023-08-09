package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Created by 
 * @Author : Juber
 * 03-08-23
 * */

@JsonIgnoreProperties(value = {
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
	
	public Employee() {
	}

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
}
