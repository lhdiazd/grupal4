package com.example.demo.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CapacitacionRowMapper implements RowMapper<Capacitacion> {

	@Override
	public Capacitacion mapRow(ResultSet rs, int rowNum) throws SQLException {		
		return new Capacitacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("detalle"));
	}

	
	
}
