package com.example.ras.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.ras.entity.Employee;
import com.example.ras.eventandlistener.EmployeeAddedEvent;
import com.example.ras.exception.EmployeeNotFoundException;
import com.example.ras.repository.EmployeeRepository;
import com.example.ras.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee saved =  employeeRepository.save(employee);
		// Event trigger
        EmployeeAddedEvent event = new EmployeeAddedEvent(this, saved);
        eventPublisher.publishEvent(event);
        return saved;
	}

	@Override
	public Employee findByEmail(String email) {
		Employee e = employeeRepository.findByEmail(email);
		if(e==null) {
				throw new EmployeeNotFoundException("Employee not found with email: " + email);
		}
		return e;
	}

	@Override
	public Optional<Employee> optionalFindByEmail(String email) {
		return Optional.ofNullable(employeeRepository.findByEmail(email));
	}

	@Override
	public List<Employee> listOfFindByEmail(String email) {
		List<Employee> employees = employeeRepository.findAllByEmail(email);
		return employees;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesWithLimit(int limit, int offset) {
		return employeeRepository.getEmployeesWithLimit(limit, offset);
	}

	@Override
	public List<Employee> getEmployeeWithSalaryCondition() {
		return employeeRepository.getEmployeesWithSalaryCondition();
	}

}
