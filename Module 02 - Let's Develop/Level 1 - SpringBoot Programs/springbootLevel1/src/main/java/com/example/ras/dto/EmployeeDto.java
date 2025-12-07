package com.example.ras.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

	
	private long id;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
	private String email;
	
	private double salary;
	
	private long departmentId;
}
