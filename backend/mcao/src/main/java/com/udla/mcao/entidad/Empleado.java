package com.udla.mcao.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity 
@Table(name ="empleado")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "empleado", valueColumnName = "valor", allocationSize = 1 )


public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
	
	@Column(name = "nombre_empleado")
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado")
	private String apellidoEmpleado;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "salario")
	private Double salario;

	
	public Empleado() {
		super();
	}
	
	public Empleado(Long id) {
		super();
		this.id = id;
	}
	

	public Empleado(Empleado empleado) {
		super();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	
	
	
	
}
