package com.example.ras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.example.ras.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee findByEmail(String email);
	//v/s
	public Optional<Employee> optionalFindByEmail(String email);
	// what if present more than 2..
	public List<Employee> listOfFindByEmail(String email);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> getEmployeesWithLimit(int limit , int offset);

    public List<Employee> getEmployeeWithSalaryCondition();

}
