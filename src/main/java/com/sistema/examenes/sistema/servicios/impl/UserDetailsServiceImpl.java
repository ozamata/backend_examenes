package com.sistema.examenes.sistema.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.repositorios.UsuarioRepository;

//CARGAR UN USUARIO BUSCAR UN USUARIO
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//cargar el usuario su username
		Usuario usuario=this.usuarioRepository.findByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		return usuario;
	}
//implementa de user detailservice
	
	
}
