package com.udla.mcao.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.mcao.entidad.Usuario;
import com.udla.mcao.repository.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository repo;
	
	public Usuario guardarUsuario(Usuario usuario) {
		return repo.save(usuario);
	}
	public Usuario buscarUsuarioPorEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public Usuario buscarUsuarioPorEmailyPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}

}
