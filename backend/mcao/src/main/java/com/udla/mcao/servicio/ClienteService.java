package com.udla.mcao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.Cliente;
import com.udla.mcao.enums.TipoMensaje;
import com.udla.mcao.projection.ClienteProjection;
import com.udla.mcao.repository.ClienteRepository;
import com.udla.mcao.util.RespuestaHTTP;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public RespuestaHTTP guardar(Cliente cliente) {

		RespuestaHTTP respuesta = new RespuestaHTTP();

		try {
			clienteRepository.save(cliente);
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
			clienteRepository.deleteById(id);			
			respuesta.setTipoMensaje(TipoMensaje.SUCCESS.getValor());
			respuesta.setMensaje("Registro eliminado con éxito.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setTipoMensaje(TipoMensaje.ERROR.getValor());
			respuesta.setMensaje("No se ha podido eliminar el registro");
		}

		return respuesta;
	}
	
	public List<ClienteProjection> lista() {
		return clienteRepository.findAllByOrderByNombreCliente(ClienteProjection.class);
	}

}
