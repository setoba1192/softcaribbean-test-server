package com.prueba.softcaribbean.test.service;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.service.ClienteService;
import com.prueba.softcaribbean.test.config.AppConfig;
import com.prueba.softcaribbean.test.config.DbConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, DbConfig.class })
public class ClienteTestService {

	@Autowired
	private ClienteService clienteService;

	@Transactional
	@Test
	public void crear() {

		Cliente cliente = new Cliente();
		cliente.setCliente("Joan");
		cliente.setNombre("SebastianSebastian");
		cliente.setDireccion("Calle 39");
		cliente.setMail("setoba1192@gmail.com");
		cliente.setFechaRegistro(new Timestamp(new Date().getTime()));

		cliente.setUsuario("1234");
		cliente.setContacto("contacto");
		cliente.setActivo("1");
		cliente.setTelefono("3112392124");
		cliente.setLogo("Logo");

		clienteService.crear(cliente);
		assertTrue("Incorrecto", cliente.getId() > 0);
	}

	@Transactional
	@Test
	public void actualizar() {

		Cliente clienteOld = new Cliente();
		clienteOld.setId(4);
		clienteOld.setCliente("Joan");
		clienteOld.setNombre("Sebastian2");
		clienteOld.setDireccion("Calle 39");
		clienteOld.setMail("setoba1192@gmail.com");
		clienteOld.setFechaBaja(new Timestamp(new Date().getTime()));
		clienteOld.setContacto("contacto");
		clienteOld.setUsuario("1234");
		clienteOld.setActivo("1");
		clienteOld.setTelefono("3112392124");
		clienteOld.setLogo("Logo");

		clienteService.actualizar(clienteOld);

		Cliente clienteNew = (Cliente) clienteService.buscarPorId(clienteOld.getId());

		assertTrue("Incorrecto", clienteOld.getNombre().equals(clienteNew.getNombre()));
		assertTrue("Incorrecto", clienteOld.getLogo().equals(clienteNew.getLogo()));

	}

}
