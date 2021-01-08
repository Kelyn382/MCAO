package com.udla.mcao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.udla.mcao.entidad.Empleado;

import com.udla.mcao.projection.EmpleadoProjection;
import com.udla.mcao.servicio.EmpleadoService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/empleado")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping(value = "/lista")
	public List<EmpleadoProjection> listado() {
		return empleadoService.lista();
	}
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody Empleado empleado) {
		return empleadoService.guardar(empleado);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return empleadoService.eliminar(id);
	}
	
}
