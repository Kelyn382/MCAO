package com.udla.mcao.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.TareaMaterial;

public interface TareaMaterialRepository extends JpaRepository<TareaMaterial, Long>
{
	

	<T>List<T> findAllByTareaId(Long idTarea, Class<T> type);

}
