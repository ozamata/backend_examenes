package com.sistema.examenes.sistema.excepciones;

public class UsuarioFoundException extends Exception {

	public UsuarioFoundException() {
		super("El usuario con ese username ya existe en la base de datos, vuelva a interntar!!");
		
	}
	public UsuarioFoundException(String mensaje) {
		super(mensaje);
	}
	
}
