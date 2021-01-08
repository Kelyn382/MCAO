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

import com.udla.mcao.entidad.Cliente;
import com.udla.mcao.projection.ClienteProjection;
import com.udla.mcao.servicio.ClienteService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping(value = "/lista")
	public List<ClienteProjection> listado() {
		return clienteService.lista();
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return clienteService.eliminar(id);
	}

}
