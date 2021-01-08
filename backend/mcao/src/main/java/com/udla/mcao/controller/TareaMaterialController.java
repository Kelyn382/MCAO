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

import com.udla.mcao.entidad.TareaMaterial;
import com.udla.mcao.projection.TareaMaterialProjection;
import com.udla.mcao.servicio.TareaMaterialService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/tareaMaterial")
public class TareaMaterialController {

	@Autowired
	TareaMaterialService tareaMaterialService;

	@GetMapping(value = "/lista")
	public List<TareaMaterialProjection> listado(Long idTarea) {
		return tareaMaterialService.lista(idTarea);
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody TareaMaterial tareaMaterial) {
		return tareaMaterialService.guardar(tareaMaterial);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return tareaMaterialService.eliminar(id);
	}

}
