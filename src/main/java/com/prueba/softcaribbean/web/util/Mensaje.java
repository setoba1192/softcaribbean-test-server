package com.prueba.softcaribbean.web.util;

public class Mensaje {

	private String mensaje;
	private Object body;

	public Mensaje() {

	}

	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Mensaje(String mensaje, Object body) {
		this.mensaje = mensaje;
		this.body = body;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the body
	 */
	public Object getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(Object body) {
		this.body = body;
	}

}
