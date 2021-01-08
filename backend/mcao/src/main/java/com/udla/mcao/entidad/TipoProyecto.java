package com.udla.mcao.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tipo_proyecto")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "tipo_proyecto", valueColumnName = "valor", allocationSize = 1 )
public class TipoProyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
	
	@Column(name = "nombre")
	private String nombre;
	

	public TipoProyecto() {
		super();
	}
	
	public TipoProyecto(Long id) {
		super();
		this.id = id;
	}
	

	public TipoProyecto(TipoProyecto proyecto) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
