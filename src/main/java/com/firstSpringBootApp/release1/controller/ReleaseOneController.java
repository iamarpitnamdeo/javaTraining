package com.firstSpringBootApp.release1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringBootApp.release1.model.Employee;
import com.firstSpringBootApp.release1.service.EmployeeService;

@RestController
public class ReleaseOneController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)	
	public List<Employee> getEmployee() {			
		return  employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee added successfully";
	}
	
	
}
