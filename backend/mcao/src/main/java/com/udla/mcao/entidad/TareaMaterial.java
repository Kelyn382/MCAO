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
@Table(name = "tarea_material")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "tarea_material", valueColumnName = "valor", allocationSize = 1 )
public class TareaMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
		
	@Column(name = "cantidad")
	private Double cantidad;
	
	@Column(name = "costo")
	private Double costo;
	
	@Column(name = "total")
	private Double total;

	
	@JsonIgnoreProperties(value = "tareaMateriales")
	@ManyToOne
	@JoinColumn(name = "id_tarea")
	private Tarea tarea;

	
	@JsonIgnoreProperties(value = "tareaMateriales")
	@ManyToOne
	@JoinColumn(name = "id_material")
	private Material material;

	
	
	public TareaMaterial() {
		super();
	}
	
	public TareaMaterial(Long id) {
		super();
		this.id = id;
	}
	

	public TareaMaterial(TareaMaterial tareaMaterial) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	
	
}
