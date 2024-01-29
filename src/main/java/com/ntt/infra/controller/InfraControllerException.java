package com.ntt.infra.controller;

public class InfraControllerException extends Exception{

	
	String message;
	Throwable cause;
	
	public InfraControllerException(String message) {
		super(message);
		this.message = message;
	}

	public InfraControllerException(String message, Throwable cause) {
		super(message,cause);
		this.message = message;
		this.cause = cause;
	}
	
	
}
