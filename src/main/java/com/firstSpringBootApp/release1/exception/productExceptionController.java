package com.firstSpringBootApp.release1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class productExceptionController {
	
	@ExceptionHandler(value = ProductNotfoundException.class)

	public ResponseEntity<Object> exception(ProductNotfoundException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)

	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>("Please enter name", HttpStatus.BAD_REQUEST);
	}
	
	
}
