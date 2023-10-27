package com.tcs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	
	@ExceptionHandler(RoomNumberNotFoundException.class)
	public ResponseEntity<?> handleRoomNumberNotFoundException(RoomNumberNotFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	
	
}
