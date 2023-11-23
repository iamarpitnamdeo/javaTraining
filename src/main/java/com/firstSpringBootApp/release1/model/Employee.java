package com.firstSpringBootApp.release1.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	Long id;
	String name;
	int age;
	String designation;
	String team;
	
	
		
	public Employee() {
		super();
	}

	public Employee(Long id, String name, int age, String designation, String team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.team = team;
	}
	
	public Employee(String name, int age, String designation, String team) {
		super();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.team = team;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", designation=" + designation + ", team=" + team + "]";
	}
	
	  @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Employee employee = (Employee) obj;
	        return name.equals(employee.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }

	
}
