package com.zycus.clientonboard.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.zycus.clientonboard.controller.RequestValidator;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private RequestValidator requestValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(requestValidator);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Map<String, Object>> constraintViolationExceptionHandler(ConstraintViolationException e) {

		Map<String, Object> errors = new HashMap<>();

		for (ConstraintViolation<?> c : e.getConstraintViolations()) {
			errors.put(c.getMessage(), c.getInvalidValue());
		}
		return new ResponseEntity<Map<String, Object>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ClientOnboardException.class })
	public ResponseEntity<Map<String, String>> clientOnboardExceptionHandler(ClientOnboardException e) {

		Map<String, String> errors = new HashMap<>();
		errors.put("Client data validation Error", e.getMessage());

		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> exceptionHandler(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
