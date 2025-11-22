package com.foodAdda.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static ErrorResponse getErrorResponseObject(Exception ex, int code, String message) {
		ErrorResponse error = new ErrorResponse();
		
		error.setError(ex.getMessage());
		error.setStatus(code);
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(message);
		
		return error;

	}

	//for given Task
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleUserAlreadyExistsExceptions(RuntimeException ex) {
    	System.out.println("Printing Exception message");		
		return new ResponseEntity<String>("Printing SOUT for Exception", HttpStatus.CONFLICT);
    }
	
	
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsExceptions(UserAlreadyExistsException ex) {
    	ErrorResponse error = getErrorResponseObject(ex, HttpStatus.CONFLICT.value(),"User Already Exists");		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
    }
	
	// Handles @Valid errors
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(error ->
          errors.put(error.getField(), error.getDefaultMessage())
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

  }

}