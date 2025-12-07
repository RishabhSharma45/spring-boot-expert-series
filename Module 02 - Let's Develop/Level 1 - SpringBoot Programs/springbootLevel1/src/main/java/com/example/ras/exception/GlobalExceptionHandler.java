package com.example.ras.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleEmployeeNotFound(
	            EmployeeNotFoundException ex,
	            WebRequest request){
		ErrorResponse error = new ErrorResponse(
				 LocalDateTime.now(),
	                ex.getMessage(),
	                request.getDescription(false),
	                HttpStatus.NOT_FOUND.value()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}

}
