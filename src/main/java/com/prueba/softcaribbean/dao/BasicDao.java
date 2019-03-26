package com.prueba.softcaribbean.dao;

import java.util.List;

public interface BasicDao {

	public void crear(Object object);

	public Object buscarPorId(int id);

	public List<Object> listar();

	public void actualizar(Object object);
}
