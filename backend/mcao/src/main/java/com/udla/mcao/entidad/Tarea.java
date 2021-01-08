package com.udla.mcao.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tarea")
@TableGenerator(name = "TABLE_GEN", table = "secuencia", pkColumnName = "nombre", pkColumnValue = "tarea", valueColumnName = "valor", allocationSize = 1 )
public class Tarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id; 
	
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "prioridad")
	private Long prioridad;
	
	@Column(name = "fecha_entrega")
	private Date fechaEntrega;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "estado")
	private Long estado;

	@Column(name = "tiempo_horas")
	private Double tiempoHoras;

	@Column(name = "total")
	private Double total;
		
	@JsonIgnoreProperties(value = "tareas")
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@JsonIgnoreProperties(value = "tareas")
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	@JsonIgnoreProperties(value = "tareas")
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	
	@JsonIgnoreProperties(value = "tareas")
	@OneToMany(mappedBy = "tarea")
	private List<TareaMaterial> tareaMateriales;
	
	
	
//	@JsonIgnoreProperties(value = "tareas")
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private TipoProyecto TipoProyecto;
		
	public Tarea() {
		super();
	}
	
	public Tarea(Long id) {
		super();
		this.id = id;
	}
	

	public Tarea(Tarea tarea) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TareaMaterial> getTareaMateriales() {
		return tareaMateriales;
	}

	public void setTareaMateriales(List<TareaMaterial> tareaMateriales) {
		this.tareaMateriales = tareaMateriales;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTiempoHoras() {
		return tiempoHoras;
	}

	public void setTiempoHoras(Double tiempoHoras) {
		this.tiempoHoras = tiempoHoras;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoProyecto getTipoProyecto() {
		return TipoProyecto;
	}

	public void setTipoProyecto(TipoProyecto tipoProyecto) {
		TipoProyecto = tipoProyecto;
	}


	
	
	
	
}
