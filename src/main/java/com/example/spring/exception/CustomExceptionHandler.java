package com.example.spring.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private String INCORRECT_REQUEST = "INCORECT_REQUEST";
	private String BAD_REQUEST = "BAD_REQUEST";
	private String INTERNAL_SERVER_ERROR = "ALREADY_EXIST";

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorModel = new ErrorResponse(INCORRECT_REQUEST, details);
		return new ResponseEntity<ErrorResponse>(errorModel, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ErrorResponse>  handleAlreadyExistException(AlreadyExistException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorModel = new ErrorResponse(INTERNAL_SERVER_ERROR, details);
		return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MissingHeaderInfoException.class)
	public ResponseEntity<ErrorResponse> handleMissingHeaderInfoException(MissingHeaderInfoException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
