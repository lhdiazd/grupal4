package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ICapacitacionDao;
import com.example.demo.modelo.Capacitacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Controller
public class CapacitacionController {
	
	
	private Logger log = LogManager.getLogger(CapacitacionController.class);
	
	private ICapacitacionDao iCapacitacionDao;
	
	public CapacitacionController(ICapacitacionDao iCapacitacionDao) {
		this.iCapacitacionDao = iCapacitacionDao;
	}
	
	
	@GetMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
		log.info("Se llamo al metodo listar capacitacion");
		var capacitaciones = iCapacitacionDao.listarCapacitaciones();
		model.addAttribute("capacitaciones", capacitaciones);		
		return ("listarCapacitaciones");
	}
	
	@RequestMapping("/crearCapacitacion")
	public String crearCapacitacion(Model model) {
		log.info("Se llamo al metodo crear capacitacion");
		Capacitacion capacitacion = new Capacitacion();
		model.addAttribute("capacitacion", capacitacion);		
		return ("crearCapacitacion");
	}
	
	@PostMapping("/crearCapacitacion")
	public String insertarCapacitacion(Capacitacion capacitacion) {
		int filasAfectadas = iCapacitacionDao.agregarCapacitacion(capacitacion);
		if(filasAfectadas > 0) {
			log.info("Capacitación creada exitosamente");			
		} else {
			log.info("Error al crear capacitacion");			
		}
		
        return "redirect:/listarCapacitaciones";
    }
	
}
