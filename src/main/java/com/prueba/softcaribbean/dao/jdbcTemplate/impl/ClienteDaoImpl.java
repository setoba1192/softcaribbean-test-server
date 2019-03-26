package com.prueba.softcaribbean.dao.jdbcTemplate.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.prueba.softcaribbean.dao.ClienteDao;
import com.prueba.softcaribbean.dao.rowmapper.ClienteRowMapper;
import com.prueba.softcaribbean.model.Cliente;

@Repository("ClienteDaoImpl")
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crear(Object object) {
		// TODO Auto-generated method stub
		final Cliente cliente = (Cliente) object;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

				String SQL = "INSERT INTO thom_cliente (cdcliente, dsnombre, dsdireccion, dsmail, febaja, cdusuario, ";
				SQL += "snactivo, cdtelefono, dscontacto, dslogo ) ";
				SQL += "VALUES (?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement pstm = connection.prepareStatement(SQL, new String[] { "nmcliente" });

				pstm.setString(1, cliente.getCliente());
				pstm.setString(2, cliente.getNombre());
				pstm.setString(3, cliente.getDireccion());
				pstm.setString(4, cliente.getMail());
				pstm.setTimestamp(5, cliente.getFechaBaja());
				pstm.setString(6, cliente.getUsuario());
				pstm.setString(7, cliente.getActivo());
				pstm.setString(8, cliente.getTelefono());
				pstm.setString(9, cliente.getContacto());
				pstm.setString(10, cliente.getLogo());

				// TODO Auto-generated method stub
				return pstm;
			}
		}, keyHolder);
		if (result > 0) {
			cliente.setId(keyHolder.getKey().intValue());

		}
	}

	@Override
	public Object buscarPorId(int id) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM thom_cliente where nmcliente = ?;";

		List<Object> clientes = jdbcTemplate.query(SQL, new Object[] { id }, new ClienteRowMapper());

		return clientes.size() > 0 ? clientes.get(0) : null;
	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM thom_cliente;";

		return jdbcTemplate.query(SQL, new ClienteRowMapper());
	}

	@Override
	public void actualizar(Object object) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente) object;

		String SQL = "UPDATE thom_cliente set cdcliente = ?, dsnombre = ?, dsdireccion =?, dsmail = ?, febaja = ?, cdusuario = ?, ";
		SQL += "snactivo = ?, cdtelefono = ?, dscontacto = ?, dslogo = ? where nmcliente = ?;";

		jdbcTemplate.update(SQL,
				new Object[] { cliente.getCliente(), cliente.getNombre(), cliente.getDireccion(), cliente.getMail(),
						cliente.getFechaBaja(), cliente.getUsuario(), cliente.getActivo(), cliente.getTelefono(),
						cliente.getContacto(), cliente.getLogo(), cliente.getId() });

	}

}
