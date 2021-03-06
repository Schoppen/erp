package com.schoppen.schoppenerp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuarios extends MedUser{
	
	@Id
	private String cuenta;
	
	@Column(nullable=false)
	private String contrasena;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_alta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_baja;
	
	@Column(nullable=false)
	private Boolean activo;
	
	@Column(nullable=false)
	private String rol;

	@OneToMany(mappedBy="empleado")
	private Set<Tickets> tickets_gestionados = new HashSet<Tickets>();
	
	@OneToMany(mappedBy="empleado")
	private Set<Pedidos> pedidos_gestionados = new HashSet<Pedidos>();

	
	
	
	// **** GETTERS & SETTERS **** \\	
	
	
	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Tickets> getTickets_gestionados() {
		return tickets_gestionados;
	}

	public void setTickets_gestionados(Set<Tickets> tickets_gestionados) {
		this.tickets_gestionados = tickets_gestionados;
	}

	public Set<Pedidos> getPedidos_gestionados() {
		return pedidos_gestionados;
	}

	public void setPedidos_gestionados(Set<Pedidos> pedidos_gestionados) {
		this.pedidos_gestionados = pedidos_gestionados;
	}
}
