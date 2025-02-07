package com.sistema.examenes.sistema.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class UsuarioRol {

	//RELACIONES DE TABLAS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioRolId;
	
	//relaciones
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToOne
	private Rol rol;

	public Long getUsuarioRolId() {
		return usuarioRolId;
	}

	public void setUsuarioRolId(Long usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	 

	public UsuarioRol() {
		 
	 }
	
	
	
}
