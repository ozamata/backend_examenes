package com.sistema.examenes.sistema.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name="roles")
public class Rol {

	
	
	@Id
	private Long rolId;
	private String rolNombre;
	//un rol puede pertenecer a muchos usuarios 
	//cascade ALL cuando eliminar usuario eliminas todos sus roles
	//lazy indicia que voy a llamar
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
	private Set<UsuarioRol>usuarioRoles=new HashSet<>();

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}



	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	
	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public Rol() {
		 
	 }
	
	
	
}
