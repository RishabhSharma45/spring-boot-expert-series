package com.example.ras.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private LocalDateTime timestamp;
    private String message;
    private String path;
    private int status;
	public ErrorResponse(LocalDateTime timestamp, String message, String path, int status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.status = status;
	}
    
    

}
