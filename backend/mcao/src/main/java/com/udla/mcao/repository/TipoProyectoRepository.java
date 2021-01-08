package com.udla.mcao.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.TipoProyecto;

public interface TipoProyectoRepository extends JpaRepository<TipoProyecto, Long>
{
	
		<T>List<T> findAllByOrderById(Class<T> type);

}
