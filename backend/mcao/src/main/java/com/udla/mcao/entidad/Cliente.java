package com.udla.mcao.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "cliente")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "cliente", valueColumnName = "valor", allocationSize = 1 )
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	@Column(name = "apellido_cliente")
	private String apellidoCliente;
	
	@Column(name = "cedula")
	private Integer cedula;
	
	@Column(name = "telefono_cliente")
	private String telefonoCliente;
	
	@Column(name = "direccion_cliente")
	private String direccionCliente;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Long id) {
		super();
		this.id = id;
	}
	

	public Cliente(Cliente cliente) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonCliente) {
		this.telefonoCliente = telefonCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	
	
}
