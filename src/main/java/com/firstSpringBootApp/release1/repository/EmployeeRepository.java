package com.firstSpringBootApp.release1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBootApp.release1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee> findByName(String empName);
}
