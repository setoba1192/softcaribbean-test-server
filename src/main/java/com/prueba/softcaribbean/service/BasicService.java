package com.prueba.softcaribbean.service;

import java.util.List;

public interface BasicService {

	public void crear(Object object);

	public void actualizar(Object object);

	public Object buscarPorId(int id);

	public List<Object> listar();

}
