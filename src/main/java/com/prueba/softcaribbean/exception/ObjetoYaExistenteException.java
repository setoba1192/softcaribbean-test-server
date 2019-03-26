package com.prueba.softcaribbean.exception;

public class ObjetoYaExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4140091136626098777L;

	public ObjetoYaExistenteException(String message) {
		super(message);

	}

	public ObjetoYaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}
}
