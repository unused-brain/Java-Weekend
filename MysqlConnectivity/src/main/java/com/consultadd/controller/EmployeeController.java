package com.consultadd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultadd.model.Employee;
import com.consultadd.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/add")
	public String saveEmployee(@RequestBody Employee employee) {
		if(employeeService.isPresent(employee)) {
			return "Employee Already Exists!";
		}
		
		employeeService.saveEmployee(employee);
		
		return "Employee added successfully";
	}
}
