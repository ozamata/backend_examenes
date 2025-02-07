package com.sistema.examenes.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.sistema.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUsername(String username);

}
