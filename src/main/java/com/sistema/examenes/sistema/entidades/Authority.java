package com.sistema.examenes.sistema.entidades;

import org.springframework.security.core.GrantedAuthority;

//implementar metodos de grantedauthority
public class Authority implements GrantedAuthority{

	private String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}

	//obtener autoridad
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
	

}
