package com.prueba.softcaribbean.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prueba.softcaribbean.model.Cliente;

public class ClienteRowMapper implements RowMapper<Object> {

	@Override
	public Cliente mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();

		cliente.setId(rs.getInt("nmcliente"));
		cliente.setCliente(rs.getString("cdcliente"));
		cliente.setNombre(rs.getString("dsnombre"));
		cliente.setDireccion(rs.getString("dsdireccion"));
		cliente.setMail(rs.getString("dsmail"));
		cliente.setFechaRegistro(rs.getTimestamp("feregistro"));
		cliente.setFechaBaja(rs.getTimestamp("febaja"));
		cliente.setUsuario(rs.getString("cdusuario"));
		cliente.setActivo(rs.getString("snactivo"));
		cliente.setTelefono(rs.getString("cdtelefono"));
		cliente.setContacto(rs.getString("dscontacto"));
		cliente.setLogo(rs.getString("dslogo"));

		return cliente;
	}

}
