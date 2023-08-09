package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Capacitacion;

@Repository
public interface ICapacitacionDao extends CrudRepository<Capacitacion, Integer> {
	
}
