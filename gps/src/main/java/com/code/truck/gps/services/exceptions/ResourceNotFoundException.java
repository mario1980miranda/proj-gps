package com.code.truck.gps.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(final String msg) {
		super(msg);
	}

}
