package com.prueba.softcaribbean.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.service.ClienteService;
import com.prueba.softcaribbean.web.util.Mensaje;

@RestController
public class ClienteRestController {

	private static final String api = "api/cliente";

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = api + "/{id}", method = RequestMethod.GET)
	public @ResponseBody Cliente obtenerClientePorId(@PathVariable int id) {

		return (Cliente) clienteService.buscarPorId(id);
	}

	@RequestMapping(value = api, method = RequestMethod.POST)
	public @ResponseBody Mensaje crearCliente(@RequestBody Cliente cliente) {

		clienteService.crear(cliente);

		return new Mensaje("Cliente creado exitosamente.", cliente);
	}

	@RequestMapping(value = api, method = RequestMethod.PUT)
	public @ResponseBody Mensaje actualizarCliente(@RequestBody Cliente cliente) {

		clienteService.actualizar(cliente);

		return new Mensaje("Cliente actualizado exitosamente.", cliente);
	}

	@RequestMapping(value = api, method = RequestMethod.GET)
	public @ResponseBody List<Object> listarClientes() {

		return clienteService.listar();
	}

}
