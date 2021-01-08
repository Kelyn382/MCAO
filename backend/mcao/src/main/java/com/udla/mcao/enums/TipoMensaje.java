package com.udla.mcao.enums;

public enum TipoMensaje {
	
	SUCCESS("success"), 
	WARN("warn"), 
	ERROR("error"), 
	INFO("info");
	
	
	String valor;

	private TipoMensaje(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
