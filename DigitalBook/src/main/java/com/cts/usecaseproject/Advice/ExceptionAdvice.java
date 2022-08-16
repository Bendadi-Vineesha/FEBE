package com.cts.usecaseproject.Advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.usecaseproject.Exceptions.BookException;
import com.cts.usecaseproject.Model.ErrorMessage;


@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<?> handleEx(BookException e) {
		System.out.println(e.getMessage());
		return new ResponseEntity<ErrorMessage>(
			new ErrorMessage(e.getMessage(), e.getClass().toString()), 
			HttpStatus.OK
		);
	}

}
