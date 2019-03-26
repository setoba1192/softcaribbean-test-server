package com.prueba.softcaribbean.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.softcaribbean.test.config.DbConfig;
import com.prueba.softcaribbean.dao.ClienteDao;
import com.prueba.softcaribbean.model.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DbConfig.class })
public class ClienteTestDao {

	@Autowired
	private ClienteDao clienteDao;

	@Transactional
	@Test
	public void testCrear() {

		Cliente cliente = new Cliente();
		cliente.setCliente("Joan");
		cliente.setNombre("Sebastian");
		cliente.setDireccion("Calle 39");
		cliente.setMail("setoba1192@gmail.com");
		//cliente.setFechaRegistro(new Timestamp(new Date().getTime()));

		cliente.setUsuario("1234");
		cliente.setActivo("1");
		cliente.setTelefono("3112392124");
		cliente.setContacto("Prueba");
		cliente.setLogo("Logo");

		clienteDao.crear(cliente);

		assertTrue("Correcto", cliente.getId() > 0);

	}

	@Transactional
	@Test
	public void testActualizar() {

		Cliente clienteOld = new Cliente();
		clienteOld.setId(4);
		clienteOld.setCliente("Joan");
		clienteOld.setNombre("Sebastian2");
		clienteOld.setDireccion("Calle 39");
		clienteOld.setMail("setoba1192@gmail.com");
		clienteOld.setFechaRegistro(new Timestamp(new Date().getTime()));

		clienteOld.setUsuario("1234");
		clienteOld.setActivo("1");
		clienteOld.setTelefono("3112392124");
		clienteOld.setLogo("Logo");

		clienteDao.actualizar(clienteOld);

		Cliente clienteNew = (Cliente) clienteDao.buscarPorId(clienteOld.getId());

		assertTrue("Incorrecto", clienteOld.getNombre().equals(clienteNew.getNombre()));
		assertTrue("Incorrecto", clienteOld.getLogo().equals(clienteNew.getLogo()));

	}

	@Test
	public void testBuscarPorId() {

		Cliente cliente = (Cliente) clienteDao.buscarPorId(4);

		assertNotNull(cliente);

	}

	@Test
	public void testListar() {

		List<Object> clientes = clienteDao.listar();
		for (Object cliente : clientes) {

			System.out.println(cliente);

		}
		assertTrue("Correcto", clientes.size() > 0);
	}
}
