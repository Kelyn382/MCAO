package com.udla.mcao.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>
{
	
		<T>List<T> findAllByOrderByCodigo(Class<T> type);
		<T>List<T> findByOrderByFechaIngreso(Class<T> type);
		<T>List<T> findByFechaIngresoGreaterThanEqualAndFechaIngresoLessThanEqualOrderByFechaIngreso(Date fechaInicio, Date fechaFin, Class<T> type);
		<T>List<T> findByTipoProyectoId(Long idTipoProyecto, Class<T> type);

}
