package com.example.ras.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ras.dto.EmployeeDto;
import com.example.ras.entity.Department;
import com.example.ras.entity.Employee;
import com.example.ras.helper.ApiResponse;
import com.example.ras.repository.DepartmentRepository;
import com.example.ras.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Value("${app.owner.name}")
    private String ownerName;

	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDto>> getEmployee() {
		logger.info("Inside getEmployee");
		List<Employee> employees = employeeService.getAllEmployee();
		List<EmployeeDto> employeeDto = new ArrayList<>();
		for(Employee emp : employees ) {
			EmployeeDto e = new EmployeeDto();
			e.setId(emp.getId());
			e.setEmail(emp.getEmail());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			employeeDto.add(e);
			
		}
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping("/get/{limit}/{offset}")
	public ResponseEntity<List<EmployeeDto>> getEmployeesWithLimit(@PathVariable int limit , @PathVariable int offset) {
		logger.info("Inside getEmployeesWithLimit");
		List<Employee> employees = employeeService.getEmployeesWithLimit(limit, offset);
		List<EmployeeDto> employeeDto = new ArrayList<>();
		for(Employee emp : employees ) {
			EmployeeDto e = new EmployeeDto();
			e.setId(emp.getId());
			e.setEmail(emp.getEmail());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			employeeDto.add(e);
			
		}
		return ResponseEntity.ok(employeeDto);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employee){
		
		logger.info("inside addEmployee");
		
		Employee e = new Employee();
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setSalary(employee.getSalary());
		
		Department dept = departmentRepository.findById(employee.getDepartmentId())
	            .orElseThrow(() -> new RuntimeException("Department not found"));
		e.setDepartment(dept);
		
		Employee saved = employeeService.addEmployee(e);
		
		EmployeeDto response = new EmployeeDto();
		response.setName(saved.getName());
		response.setEmail(saved.getEmail());
		response.setId(saved.getId());
		response.setSalary(saved.getSalary());
		response.setDepartmentId(saved.getDepartment().getId());
		
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<Employee> findByEmployee(@Param(value = "email") String email ){
		Employee saved = employeeService.findByEmail(email);
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Optional<Employee>> optionalFindByEmployee(@PathVariable String email ){
		Optional<Employee> saved = employeeService.optionalFindByEmail(email);
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<Employee>> listOfEmployee(@RequestParam String email ){
		List<Employee> saved = employeeService.listOfFindByEmail(email);
		return ResponseEntity.ok(saved);
	}

	
	@DeleteMapping("/delete")
	public String deleteEmployee() {
		return "deleteEmployee";
	}
	
	@PatchMapping("/update")
	public String updateEmployeeUsingPatch() {
		return "updateEmployee";
	}
	
	@PutMapping("/update")
	public String updateEmployeeUsingPut() {
		return "employee";
	}
	
	@GetMapping("/config")
	public String config() {
		return ownerName;
	}
	
	@GetMapping("/salaryCondition")
	public ResponseEntity<ApiResponse<List<EmployeeDto>>> getEmployeeWithSalaryCondition() {
		logger.info("Inside getEmployeesWithSalaryCondition");
		List<Employee> employees = employeeService.getEmployeeWithSalaryCondition();
		List<EmployeeDto> employeeDto = new ArrayList<>();
		for(Employee emp : employees ) {
			EmployeeDto e = new EmployeeDto();
			e.setId(emp.getId());
			e.setEmail(emp.getEmail());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setDepartmentId(
				    emp.getDepartment() == null ? 0 : emp.getDepartment().getId()
				);
			employeeDto.add(e);
			
		}
		ApiResponse<List<EmployeeDto>> response =
	            new ApiResponse<>("Employees fetched successfully",
	                    employeeDto,
	                    HttpStatus.OK.value());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
