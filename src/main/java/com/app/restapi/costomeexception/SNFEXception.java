package com.app.restapi.costomeexception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.restapi.exceptions.StudentNotFoundException;

@RestControllerAdvice
public class SNFEXception 
{
//	@ExceptionHandler(StudentNotFoundException.class)
//	public ResponseEntity<String> showSNFEXception(StudentNotFoundException e)
//	{
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorMessage> showSNFEXception(StudentNotFoundException e)
	{
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(e.getMessage(), "Student", "NOT FOUND", new Date().toString())
				,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
