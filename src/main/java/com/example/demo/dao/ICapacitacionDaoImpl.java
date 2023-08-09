package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Capacitacion;
import com.example.demo.modelo.CapacitacionRowMapper;

@Repository
public class ICapacitacionDaoImpl implements ICapacitacionDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ICapacitacionDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Capacitacion> listarCapacitaciones() {
		String sql = """
				SELECT id, nombre, detalle FROM capacitaciones
				""";
		return jdbcTemplate.query(sql, new CapacitacionRowMapper());
	}

	@Override
	public int agregarCapacitacion(Capacitacion capacitacion) {
		String sql = """
				INSERT INTO capacitaciones(nombre, detalle) values(?, ?);
			""";
		return jdbcTemplate.update(sql,
				capacitacion.getNombre(),
				capacitacion.getDetalle());		
	}

}
