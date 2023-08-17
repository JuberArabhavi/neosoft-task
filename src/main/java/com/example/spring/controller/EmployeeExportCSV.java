package com.example.spring.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/v1")
public class EmployeeExportCSV {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@GetMapping("/employees/csv")
	public void getCsvExport(HttpServletResponse httpServletResponse) throws IOException {

		httpServletResponse.setContentType("text/csv");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDateTimeFormat = sdf.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename= csvExport_" + currentDateTimeFormat + ".csv";
		httpServletResponse.setHeader(headerKey, headerValue);

		List<Employee> employeeList = employeeRepository.findAll();

		CSVPrinter csvPrinter = null;
		try {
			 csvPrinter = new CSVPrinter(httpServletResponse.getWriter(), 
					CSVFormat.DEFAULT.withHeader("id","empName","empAddress","departmentName"));
			for (Employee emp : employeeList) {
				csvPrinter.printRecord(Arrays.asList(emp.getEmpId(),emp.getEmpName(), emp.getEmpAddress(), 
						emp.getDepartment().getDeptName(), emp.getDepartment().deptCode),emp.getDepartment().getDeptId());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			if (csvPrinter != null) {
				csvPrinter.close();
			}
		}
	}

}
