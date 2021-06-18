package com.cognizant.customerservice.exception;

public class ServiceFailException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ServiceFailException(String message)
	{
		super(message);
	}

}
