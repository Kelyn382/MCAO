package com.udla.mcao.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.TipoMaterial;

public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long>
{
	
		<T>List<T> findAllByOrderByNombre(Class<T> type);

}
