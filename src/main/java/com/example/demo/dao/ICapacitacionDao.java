package com.example.demo.dao;

import java.util.List;

import com.example.demo.modelo.Capacitacion;

public interface ICapacitacionDao{
	
	List<Capacitacion> listarCapacitaciones();
	int agregarCapacitacion(Capacitacion capacitacion);
}
