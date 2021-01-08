package com.udla.mcao.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.Material;

public interface MaterialRepository extends JpaRepository<Material, Long>
{
	
		<T>List<T> findAllByOrderByDescripcion(Class<T> type);
		<T>List<T> findByTipoMaterialId(Long idTipoMaterial, Class<T> type);

}
