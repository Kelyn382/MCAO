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

import com.udla.mcao.entidad.TipoMaterial;
import com.udla.mcao.projection.TipoMaterialProjection;
import com.udla.mcao.servicio.TipoMaterialService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/tipoMaterial")
public class TipoMaterialController {

	@Autowired
	TipoMaterialService tipoMaterialService;

	@GetMapping(value = "/lista")
	public List<TipoMaterialProjection> listado() {
		return tipoMaterialService.lista();
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody TipoMaterial tipoMaterial) {
		return tipoMaterialService.guardar(tipoMaterial);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return tipoMaterialService.eliminar(id);
	}

}
