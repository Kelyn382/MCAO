package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.TareaMaterial;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.projection.TareaMaterialProjection;
import com.udla.mcao.repository.TareaMaterialRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class TareaMaterialService {

	@Autowired
	TareaMaterialRepository tareaMaterialRepository;

	public RespuestaHTTP guardar(TareaMaterial tareaMaterial) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			tareaMaterialRepository.save(tareaMaterial);
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
			tareaMaterialRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<TareaMaterialProjection> lista(Long idTarea) {
		return tareaMaterialRepository.findAllByTareaId(idTarea,TareaMaterialProjection.class);
	}

}
