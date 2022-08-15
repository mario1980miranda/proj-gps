package com.code.truck.gps.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseException(final String msg) {
		super(msg);
	}
}
