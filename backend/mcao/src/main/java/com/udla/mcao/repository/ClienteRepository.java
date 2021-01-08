package com.udla.mcao.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	
		<T>List<T> findAllByOrderByNombreCliente(Class<T> type);

}
