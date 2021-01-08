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

import com.udla.mcao.entidad.Material;
import com.udla.mcao.servicio.MaterialService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/material")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@GetMapping(value = "/lista")
	public List<Material> listado() {
		return materialService.lista();
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody Material material) {
		return materialService.guardar(material);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return materialService.eliminar(id);
	}
	
	@GetMapping(value = "/listaPorTipo/{idTipoMaterial}")
	public List<Material> listado(@PathVariable("idTipoMaterial") Long idTipoMaterial) {
		return materialService.listaPorTipo(idTipoMaterial);
	}


}
