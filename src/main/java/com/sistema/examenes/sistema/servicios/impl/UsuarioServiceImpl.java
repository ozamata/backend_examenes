package com.sistema.examenes.sistema.servicios.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.entidades.UsuarioRol;
import com.sistema.examenes.sistema.repositorios.RolRepository;
import com.sistema.examenes.sistema.repositorios.UsuarioRepository;
import com.sistema.examenes.sistema.servicios.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@Autowired
		private RolRepository rolRepository;

		@Override
		public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
			Usuario usuarioLocal=usuarioRepository.findByUsername(usuario.getUsername());
			//si es diferente de null existe ya el usuario
			if(usuarioLocal != null) {
				System.out.println("el usuario ya existe");
				throw new Exception("El usuario ya esta presente");
			}else {
				//rrecorre los roles y guardar
				for(UsuarioRol usuarioRol:usuarioRoles) {
					rolRepository.save(usuarioRol.getRol());
				}
				//añadir todo los roles a la clase usuario
				usuario.getUsuarioRoles().addAll(usuarioRoles);
				usuarioLocal=usuarioRepository.save(usuario);
			}
			return usuarioLocal;
			
		}

		@Override
		public Usuario obtenerUsuario(String username) {
			// TODO Auto-generated method stub
			return  usuarioRepository.findByUsername(username);
		}

		@Override
		public void eliminarUsuario(Long usuarioId) {

			usuarioRepository.deleteById(usuarioId);
		}
		
		
}
