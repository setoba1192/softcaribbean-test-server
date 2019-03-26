package com.prueba.softcaribbean.exception;

public class ValidacionDominioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659405421519686252L;

	public ValidacionDominioException(String message) {
		super(message);
	}

	public ValidacionDominioException(String message, Throwable cause) {
		super(message, cause);
	}
}
