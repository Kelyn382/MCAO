package com.udla.mcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udla.mcao.entidad.Usuario;
import com.udla.mcao.servicio.RegistroService;

@RestController
public class RegistroController {
	
	@Autowired
	private RegistroService service;
	
	@PostMapping(value="/registroUsuario")
	public Usuario registroUsuario(@RequestBody Usuario usuario) throws Exception {
		String  tempEmailId = usuario.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Usuario userobj = service.buscarUsuarioPorEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("usuario con" +tempEmailId+ "ya existe");
			}
		}
		Usuario userObj = null;
		userObj = service.guardarUsuario(usuario);
		return userObj;
	}
	
	@PostMapping("/login")
	public Usuario loginUser(@RequestBody Usuario usuario) throws Exception {
		String tempEmailId = usuario.getEmailId();
		String tempPass = usuario.getPassword();
		Usuario userObj =null;
		
		if(tempEmailId!= null && tempPass !=null) {
			userObj = service.buscarUsuarioPorEmailyPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("credenciales incorrectas");
		}
		return userObj;
	}

}
