package com.example.ras.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.ras.entity.Employee;

import lombok.Data;

@Data
public class DepartmentDto {
	
	private long id;
	private String name;
	private List<Employee> employees = new ArrayList<>();
}
