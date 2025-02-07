package com.sistema.examenes.sistema.servicios;

import java.util.Set;

import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.entidades.UsuarioRol;

public interface UsuarioService {
	
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

	
	public Usuario obtenerUsuario(String username);
	public void eliminarUsuario(Long usuarioId);
	
	
}
