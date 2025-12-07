package com.example.ras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ras.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

	public Employee findByEmail(String email);
	public List<Employee> findAllByEmail(String email);
	
	@Query(value = "SELECT * FROM employees LIMIT ?1 OFFSET ?2" , nativeQuery = true)
	List<Employee> getEmployeesWithLimit(int limit , int offset);
	
	@Query(value = "SELECT * FROM employees WHERE salary > 30000" , nativeQuery = true)
	List<Employee> getEmployeesWithSalaryCondition();
}
