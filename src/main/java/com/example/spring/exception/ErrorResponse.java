package com.example.spring.exception;

import java.util.List;

public class ErrorResponse {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;	
	private List<String> details;
	
	public ErrorResponse(String errorMessage, List<String> details) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
