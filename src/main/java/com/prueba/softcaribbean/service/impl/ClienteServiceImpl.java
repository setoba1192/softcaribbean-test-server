package com.prueba.softcaribbean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.softcaribbean.dao.ClienteDao;
import com.prueba.softcaribbean.exception.ObjetoNoEncontradoException;
import com.prueba.softcaribbean.exception.ValidacionDominioException;
import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.service.ClienteService;
import com.prueba.softcaribbean.web.util.Utils;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public void crear(Object object) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente) object;

		Utils.validateEmptyStringAndLength(cliente.getCliente(), 15, "Cliente");
		Utils.validateEmptyStringAndLength(cliente.getNombre(), 120, "Nombre");
		Utils.validateEmptyStringAndLength(cliente.getDireccion(), 120, "Dirección");
		Utils.validateEmptyStringAndLength(cliente.getMail(), 120, "Email");
		Utils.validateEmptyStringAndLength(cliente.getUsuario(), 120, "Usuario");
		Utils.validateEmptyStringAndLength(cliente.getActivo(), 1, "Activo");
		Utils.validateEmptyStringAndLength(cliente.getTelefono(), 60, "Teléfono");
		Utils.validateEmptyStringAndLength(cliente.getContacto(), 120, "Contacto");
		Utils.validateEmptyStringAndLength(cliente.getLogo(), 50, "Logo");

		clienteDao.crear(cliente);

	}

	@Override
	public Object buscarPorId(int id) {
		// TODO Auto-generated method stub
		if (id <= 0) {
			throw new ValidacionDominioException("Debe ingresar un id válido");
		}

		Cliente cliente = (Cliente) clienteDao.buscarPorId(id);

		if (cliente == null) {

			throw new ObjetoNoEncontradoException("No se encontró ningún cliente.");
		}

		return cliente;
	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		return clienteDao.listar();
	}

	@Override
	public void actualizar(Object object) {
		// TODO Auto-generated method stub

		Cliente cliente = (Cliente) object;

		Utils.validateEmptyStringAndLength(cliente.getCliente(), 15, "Cliente");
		Utils.validateEmptyStringAndLength(cliente.getNombre(), 120, "Nombre");
		Utils.validateEmptyStringAndLength(cliente.getDireccion(), 120, "Dirección");
		Utils.validateEmptyStringAndLength(cliente.getMail(), 120, "Email");
		if (cliente.getFechaBaja() == null) {

			throw new ValidacionDominioException("Debe ingresar la fecha de baja.");
		}

		Utils.validateEmptyStringAndLength(cliente.getUsuario(), 120, "Usuario");
		Utils.validateEmptyStringAndLength(cliente.getActivo(), 1, "Activo");
		Utils.validateEmptyStringAndLength(cliente.getTelefono(), 60, "Teléfono");
		Utils.validateEmptyStringAndLength(cliente.getContacto(), 120, "Contacto");
		Utils.validateEmptyStringAndLength(cliente.getLogo(), 50, "Logo");

		clienteDao.actualizar(cliente);

	}

}
