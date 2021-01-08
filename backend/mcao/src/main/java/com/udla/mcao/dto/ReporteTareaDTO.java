package com.udla.mcao.dto;

import java.util.Date;

public class ReporteTareaDTO {
	
	private Date fechaInicio;
	private Date fechaFin;
	private Long calidad;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getCalidad() {
		return calidad;
	}
	public void setCalidad(Long calidad) {
		this.calidad = calidad;
	}
	
	
	
	

}
