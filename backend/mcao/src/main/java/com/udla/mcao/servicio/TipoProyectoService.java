package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.TipoProyecto;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.projection.TipoProyectoProjection;
import com.udla.mcao.repository.TipoProyectoRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class TipoProyectoService {

	@Autowired
	TipoProyectoRepository tipoProyectoRepository;

	public RespuestaHTTP guardar(TipoProyecto tipoProyecto) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			tipoProyectoRepository.save(tipoProyecto);
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
			tipoProyectoRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<TipoProyectoProjection> lista() {
		return tipoProyectoRepository.findAllByOrderById(TipoProyectoProjection.class);
	}

}
