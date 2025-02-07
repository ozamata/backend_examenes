package com.sistema.examenes.sistema;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.examenes.sistema.entidades.Rol;
import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.entidades.UsuarioRol;
import com.sistema.examenes.sistema.servicios.UsuarioService;

@SpringBootApplication
//implementar coomanrunner ahora de compilar se ejecuta dentro de voud RUN
public class SistemaExamenesBackendApplication implements CommandLineRunner{

	//inyectar un servicio
	@Autowired
	private UsuarioService usuarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//guardar un usuario
		/*Usuario usuario = new Usuario();
		usuario.setNombre("christian");
		usuario.setApellido("perez");
		usuario.setUsername("cperez");
		usuario.setPassword("12345");
		usuario.setEmail("cperez@gmail.com");
		usuario.setTelefono("959595951");
		usuario.setPerfil("foto.png");
		
		Rol rol=new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");
		
		Set<UsuarioRol>usuarioRoles= new HashSet<>();
		UsuarioRol usuarioRol= new UsuarioRol(); 
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		

		Usuario usuarioGuardado=usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.print(usuarioGuardado.getUsername());
		
		
		*/
		
		
	}

}
