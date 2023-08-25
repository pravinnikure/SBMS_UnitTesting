package com.app.restapi.exceptions;


@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException 
{
	public StudentNotFoundException() {
		super();
	}
	
	public StudentNotFoundException(String message)
	{
		super(message);
	}
	
}
