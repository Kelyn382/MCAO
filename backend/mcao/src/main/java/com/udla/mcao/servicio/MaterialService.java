package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.Material;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.repository.MaterialRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	public RespuestaHTTP guardar(Material material) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			materialRepository.save(material);
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
			materialRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<Material> lista() {
		return materialRepository.findAllByOrderByDescripcion(Material.class);
	}

	public List<Material> listaPorTipo(Long idTipoMaterial) {
		return materialRepository.findByTipoMaterialId(idTipoMaterial, Material.class);
	}

}
