package com.prueba.softcaribbean.exception;

public class ObjetoNoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4140091136626098777L;

	public ObjetoNoEncontradoException(String message) {
		super(message);

	}

	public ObjetoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
