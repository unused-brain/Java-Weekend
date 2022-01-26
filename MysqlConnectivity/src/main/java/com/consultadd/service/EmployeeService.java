package com.consultadd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public boolean isPresent(Employee employee) {
		
		if(employeeRepository.existsById(employee.getEmployeeId())) {
			return true;
		}
		
		return false;
	}
}
