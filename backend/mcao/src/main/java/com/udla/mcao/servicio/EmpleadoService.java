package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.Empleado;
import com.udla.mcao.enums.TipoMensaje;

import com.udla.mcao.projection.EmpleadoProjection;
import com.udla.mcao.repository.EmpleadoRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	
	public RespuestaHTTP guardar(Empleado empleado) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			empleadoRepository.save(empleado);
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Información Guardada con éxito.");

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
			empleadoRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<EmpleadoProjection> lista() {
		return empleadoRepository.findAllByOrderByNombreEmpleado(EmpleadoProjection.class);
	}
	
	
	
	
	
	
	
	
	
	
	
}
