package com.firstSpringBootApp.release1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@RequestMapping(value="/allemployee", method=RequestMethod.GET)	
	public List<Employee> getEmployee() {			
		return  employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee added successfully";
	}
	
	@RequestMapping(value="/employee/{name}", method=RequestMethod.GET)	
	public List<Employee> getEmployee1(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable long id)
	{
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully";
	}
	
	@PutMapping(value="/employee/{empName}")
	public String updateCompany(@PathVariable String empName,@RequestBody Employee employee)
	{
		employeeService.updateCompany(empName, employee);
		return "Employee Updated Successfully";
	}
	

	
}
