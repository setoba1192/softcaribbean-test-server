package com.prueba.softcaribbean.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prueba.softcaribbean.exception.ObjetoNoEncontradoException;
import com.prueba.softcaribbean.exception.ObjetoYaExistenteException;
import com.prueba.softcaribbean.exception.ValidacionDominioException;
import com.prueba.softcaribbean.web.util.Mensaje;

@RestControllerAdvice
public class ManejadorExcepcion {

	private static final Logger logger= Logger.getLogger(ManejadorExcepcion.class);

	@ExceptionHandler({ ValidacionDominioException.class, ObjetoYaExistenteException.class })
	public Mensaje validacionDominioException(Exception e, HttpServletResponse response) {
		logger.error(e.getStackTrace());
		e.printStackTrace();
		response.setStatus(400);
		return new Mensaje(e.getMessage());
	}

	@ExceptionHandler({ ObjetoNoEncontradoException.class })
	public Mensaje objetoNoEncontradoException(Exception e, HttpServletResponse response) {
		logger.error(e.getStackTrace());
		e.printStackTrace();
		response.setStatus(404);
		return new Mensaje(e.getMessage());
	}

	@ExceptionHandler({ RuntimeException.class })
	public Mensaje runtimeException(RuntimeException e, HttpServletResponse response) {
		logger.fatal(e.getStackTrace());
		e.printStackTrace();
		response.setStatus(500);
		return new Mensaje(e.getMessage());
	}

}