package com.firstSpringBootApp.release1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBootApp.release1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
