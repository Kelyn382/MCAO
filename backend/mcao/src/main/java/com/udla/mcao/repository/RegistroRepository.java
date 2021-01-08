package com.udla.mcao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.Usuario;

public interface RegistroRepository extends JpaRepository<Usuario, Integer>  {

	public Usuario findByEmailId(String emailId);
	public Usuario findByEmailIdAndPassword(String emailId, String password);
	
}
