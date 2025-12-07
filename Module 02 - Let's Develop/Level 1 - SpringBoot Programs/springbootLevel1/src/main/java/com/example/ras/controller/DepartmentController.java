package com.example.ras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ras.dto.DepartmentDto;
import com.example.ras.entity.Department;
import com.example.ras.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping("/add")
	public ResponseEntity addDepartment(@RequestBody DepartmentDto departmentDto) {
		
		Department department = new Department();
		department.setName(departmentDto.getName());
		departmentRepository.save(department);
		
		DepartmentDto response = new DepartmentDto();
		response.setId(department.getId());
		response.setName(department.getName());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity getDepartment(@PathVariable long id) {
		Department department = new Department();
		department = departmentRepository.getById(id);
		DepartmentDto response = new DepartmentDto();
		response.setId(department.getId());
		response.setName(department.getName());
		response.setEmployees(department.getEmployees());
		return ResponseEntity.ok(response);
		
	}

}
