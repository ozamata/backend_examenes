package com.sistema.examenes.sistema.entidades;
// lo contrario de request
public class JwtResponse {

	//devuelve el token
	
	private String token;

	public JwtResponse(String token) {
		this.token = token;
	}
	
	public JwtResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
