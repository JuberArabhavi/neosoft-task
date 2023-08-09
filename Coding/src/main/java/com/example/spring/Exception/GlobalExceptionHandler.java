package com.example.spring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	  public ResponseEntity < ErrorResponse > userNotFoundException(UserNotFoundException ex) {
		ErrorResponse errorModel = new ErrorResponse(0, ex.getMessage());
	    return new ResponseEntity < ErrorResponse > (errorModel, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity < ? > globleExcpetionHandler(Exception ex) {
	    ErrorResponse errorModel = new ErrorResponse(0, ex.getMessage());
	    return new ResponseEntity < > (errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
