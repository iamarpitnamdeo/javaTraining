package com.firstSpringBootApp.release1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpringBootApp.release1.model.Employee;
import com.firstSpringBootApp.release1.repository.EmployeeRepository;

import jakarta.annotation.PostConstruct;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	
	@PostConstruct
	public void initDB() {
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee(1l,"Raj",21,"Java Developer","Development"));
		employee.add(new Employee(2l,"Kartik",24,"Manual Tester","Testing"));
		employee.add(new Employee(3l,"Rajat",22,"Automation Tester","Testing"));
		employee.add(new Employee(4l,"Naresh",21,"React Developer","Development"));
		
		employeeRepository.saveAll(employee);
	}

	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public void addEmployee(Employee employee){
		
		employeeRepository.save(employee);
		
	}
	
	
	
}
