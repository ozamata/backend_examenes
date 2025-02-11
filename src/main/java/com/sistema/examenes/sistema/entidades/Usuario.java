package com.sistema.examenes.sistema.entidades;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



//crear anotaciones
@Entity
@Table (name="usuarios")

public class Usuario  implements UserDetails{
	//poner id en autoincremtando
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private boolean enable=true;
	private String perfil;
	
	
	   public Usuario(Long id, String username, String password, String nombre, String apellido, String email, String telefono, boolean enable, String perfil) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.email = email;
	        this.telefono = telefono;
	        this.enable = enable;
	        this.perfil = perfil;
	    }
	   
	//un registro usuario podra tener muchos registro roles
	//cascade  eliminar usuario con su relacion a otra tabla nestoralmeida.com
	//EAGER = ansioso  LAZY=perezoso (busqueda) devolver todo los registros relacionado , lazy  si yo lo indico
	//mappedBy indica que el usuario va ser propietario,  los roles asignar al usuario
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol>usuarioRoles=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}
	

	 public Usuario() {
		 
	 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//obteniendo los nombres de los roles
		Set<Authority> autoridades=new HashSet<>();
		//recorrer todo los roles y retornar
		this.usuarioRoles.forEach(usuarioRol ->{
			autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
		});
		return autoridades;
	}
	
	//este codigo demuestra que va estar activo 
	  @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}



	
	
	

}
