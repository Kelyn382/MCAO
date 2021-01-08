package com.udla.mcao.projection;

import java.util.Date;

public interface TareaProjection {
	
	Long getId();
	Long getIdCliente();
	Long getIdUsuario();
	Long getPrioridad();
	String getDescripcion();
	String getCodigo();
	Date getFechaIngreso();
	Date getFechaEntrega();

}
