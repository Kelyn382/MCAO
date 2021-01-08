package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.dto.ReporteTareaDTO;
import com.udla.mcao.entidad.Tarea;
import com.udla.mcao.entidad.TareaMaterial;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.repository.TareaMaterialRepository;
import com.udla.mcao.repository.TareaRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class TareaService {

	@Autowired
	TareaRepository tareaRepository;

	@Autowired
	TareaMaterialRepository tareaMaterialRepository;

	
	public RespuestaHTTP guardar(Tarea tarea){

		RespuestaHTTP respuesta = new RespuestaHTTP();
		double total=0;
		try {
			
			for (TareaMaterial tm : tarea.getTareaMateriales()) {
				total = tm.getTotal()+total;
			}
		
			Double horaHombre =  tarea.getEmpleado().getSalario() /160;
			total += (horaHombre*tarea.getTiempoHoras());
				
			tarea.setTotal(total);
			
			tareaRepository.save(tarea);
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Información Guardada con éxito.");
			
			for (TareaMaterial tm : tarea.getTareaMateriales()) {
				tm.setTarea(tarea);
				tareaMaterialRepository.save(tm);
			}
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido guardar la información.");
		}

		return respuesta;

	}
	
	

	public RespuestaHTTP eliminar(Long id) {
		RespuestaHTTP respuesta = new RespuestaHTTP();
		try {
			tareaRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<Tarea> lista() {
		return tareaRepository.findAllByOrderByCodigo(Tarea.class);
	}

	
	public List<Tarea> reporte(ReporteTareaDTO reporteTareaDTO) {
		
		if(reporteTareaDTO.getFechaInicio() != null & reporteTareaDTO.getFechaFin() != null) {
			return tareaRepository.findByFechaIngresoGreaterThanEqualAndFechaIngresoLessThanEqualOrderByFechaIngreso(reporteTareaDTO.getFechaInicio(), reporteTareaDTO.getFechaFin(), Tarea.class);
		}else {
			return tareaRepository.findByOrderByFechaIngreso(Tarea.class);			
		}
		
	}

	
	public List<Tarea> reporteCalidad(ReporteTareaDTO reporteTareaDTO) {
		
		if(reporteTareaDTO.getCalidad() != null) {
			return tareaRepository.findByTipoProyectoId(reporteTareaDTO.getCalidad(), Tarea.class);
		}else {
			return tareaRepository.findByOrderByFechaIngreso(Tarea.class);			
		}
		
	}


}
