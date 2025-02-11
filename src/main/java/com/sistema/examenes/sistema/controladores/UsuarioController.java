package com.sistema.examenes.sistema.controladores;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.sistema.entidades.Rol;
import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.entidades.UsuarioRol;
import com.sistema.examenes.sistema.servicios.UsuarioService;

@RestController

//ruta de una API ACCEDER
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	//INYECTAR EL SERVICIO
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	//peticion guardar usuario
	//request body pasamos un objeto user 
	public Usuario guardarUsuario(@RequestBody Usuario usuario )throws Exception {
		usuario.setPerfil("default.png");
		//OBTIENE EL USUARIO Y LO ENCRYPTA
		usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		
		Set<UsuarioRol> usuarioRoles=new HashSet<>();
		Rol rol=new Rol();
		rol.setRolId(2L);
		rol.setRolNombre("NORMAL");
		UsuarioRol usuarioRol=new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		usuarioRoles.add(usuarioRol);
		return usuarioService.guardarUsuario(usuario, usuarioRoles);
		}
	
		//pathvariable pasar dato
		@GetMapping("/{username}")
		public Usuario obtenerUsuario(@PathVariable("username") String username) {
			return usuarioService.obtenerUsuario(username);
			
	
		}
		
		@DeleteMapping("/{usuarioId}")
		public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
			usuarioService.eliminarUsuario(usuarioId);
			
		}

}
