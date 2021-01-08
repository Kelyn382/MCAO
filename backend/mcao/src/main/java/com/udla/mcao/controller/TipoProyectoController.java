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

import com.udla.mcao.entidad.TipoProyecto;
import com.udla.mcao.projection.TipoProyectoProjection;
import com.udla.mcao.servicio.TipoProyectoService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/tipoProyecto")
public class TipoProyectoController {

	@Autowired
	TipoProyectoService tipoProyectoService;

	@GetMapping(value = "/lista")
	public List<TipoProyectoProjection> listado() {
		return tipoProyectoService.lista();
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody TipoProyecto tipoProyecto) {
		return tipoProyectoService.guardar(tipoProyecto);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return tipoProyectoService.eliminar(id);
	}

}
