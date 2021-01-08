package com.udla.mcao.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "material")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "material", valueColumnName = "valor", allocationSize = 1 )
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
		
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "cantidad")
	private Double cantidad;
	
	@Column(name = "costo")
	private Double costo;
	
	@JsonIgnoreProperties(value = "materiales")
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoMaterial tipoMaterial;
	
	public Material() {
		super();
	}
	
	public Material(Long id) {
		super();
		this.id = id;
	}
	
	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Material(Material material) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
	
}
