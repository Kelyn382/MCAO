package com.udla.mcao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udla.mcao.entidad.Empleado;

public interface EmpleadoRepository  extends JpaRepository<Empleado, Long>
{
	<T>List<T> findAllByOrderByNombreEmpleado(Class<T> type);
}
