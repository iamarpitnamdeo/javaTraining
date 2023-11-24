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
	
	List<Employee> employee = new ArrayList<>();
	
	@PostConstruct
	public void initDB() {
		
		employee.add(new Employee(1l,"Raj",21,"Java Developer","Development"));
		employee.add(new Employee(2l,"Kartik",24,"Manual Tester","Testing"));
		employee.add(new Employee(3l,"Rajat",22,"Automation Tester","Testing"));
		employee.add(new Employee(4l,"Naresh",21,"React Developer","Development"));
		
		employeeRepository.saveAll(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	public void addEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	public List<Employee> getEmployeeByName(String empName)
	{
		return employeeRepository.findByName(empName);
	}

	public void deleteEmployee(long id)
	{
		Employee employeeToDelete = employee.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
		
		if(employeeToDelete!=null)
		{
			employee.remove(employeeToDelete);
			employeeRepository.deleteById(id);
		}
	}
	
    public void updateCompany(String empName,Employee updatedEmp)
    {
    	
    	for(Employee emp : employee)
    	{
    		if(emp.getName().equals(empName))
    		{
    			emp.setName(updatedEmp.getName());
    			emp.setAge(updatedEmp.getAge());
    			emp.setDesignation(updatedEmp.getDesignation());
    			emp.setTeam(updatedEmp.getTeam());
    			employeeRepository.save(emp);
    			
    		}
    	}
    }
}
