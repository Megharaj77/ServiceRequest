package com.ntt.infra.service;

public class InfraServiceException extends Exception{

	String message;
	Throwable cause;
	
	public InfraServiceException(String message , Throwable cause) {
		super(message,cause);
		this.message = message;
		this.cause = cause;
		
		
	}
	
	public InfraServiceException(String message) {
		super(message);
	}
}
