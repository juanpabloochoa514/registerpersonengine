package com.Person_Engine.microservice_Persons.exceptions;

public class ExceptionPersons extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExceptionPersons () {
		super ();
	}
	
	public ExceptionPersons(String message, Throwable cause) {
        super(message, cause);
    }
	
	public ExceptionPersons(String message) {
		super(message);
	}

}
