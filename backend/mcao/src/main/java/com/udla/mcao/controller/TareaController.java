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

import com.udla.mcao.dto.ReporteTareaDTO;
import com.udla.mcao.entidad.Tarea;
import com.udla.mcao.servicio.TareaService;
import com.udla.mcao.util.RespuestaHTTP;

@RestController
@RequestMapping(value = "/tarea")
public class TareaController {

	@Autowired
	TareaService tareaService;

	@GetMapping(value = "/lista")
	public List<Tarea> listado() {
		return tareaService.lista();
	}
	
	
	@PostMapping(value = "/guardar")
	public RespuestaHTTP guardar(@RequestBody Tarea tarea) {
		return tareaService.guardar(tarea);
	}
	
	@DeleteMapping(value = "/{id}")
	public RespuestaHTTP eliminar(@PathVariable("id") Long id) {
		return tareaService.eliminar(id);
	}

	
	@PostMapping(value = "/reporte")
	public List<Tarea> reporte(@RequestBody ReporteTareaDTO reporteTareaDTO) {
		return tareaService.reporte(reporteTareaDTO);
	}


	@PostMapping(value = "/reporteCalidad")
	public List<Tarea> reporteCalidad(@RequestBody ReporteTareaDTO reporteTareaDTO) {
		return tareaService.reporte(reporteTareaDTO);
	}

}
