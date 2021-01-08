package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.TipoMaterial;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.projection.TipoMaterialProjection;
import com.udla.mcao.repository.TipoMaterialRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class TipoMaterialService {

	@Autowired
	TipoMaterialRepository tipoMaterialRepository;

	public RespuestaHTTP guardar(TipoMaterial tipoMaterial) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			tipoMaterialRepository.save(tipoMaterial);
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
			tipoMaterialRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<TipoMaterialProjection> lista() {
		return tipoMaterialRepository.findAllByOrderByNombre(TipoMaterialProjection.class);
	}

}
