package com.sistema.examenes.sistema.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.sistema.configuraciones.JwtUtils;
import com.sistema.examenes.sistema.entidades.JwtRequest;
import com.sistema.examenes.sistema.entidades.JwtResponse;
import com.sistema.examenes.sistema.entidades.Usuario;
import com.sistema.examenes.sistema.excepciones.UsuarioNotFoundException;
import com.sistema.examenes.sistema.servicios.impl.UserDetailsServiceImpl;

@RestController
//permite el intercambio de recursos entre back y front
@CrossOrigin("*")
public class AuthenticationController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    private JwtUtils jwtUtils;

	    @PostMapping("/generate-token")
	    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	        try{
	            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
	        }catch (UsuarioNotFoundException exception){
	            exception.printStackTrace();
	            throw new Exception("Usuario no encontrado");
	        }

	        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	        String token = this.jwtUtils.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(token));
	    }

	    private void autenticar(String username,String password) throws Exception {
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
	        }catch (DisabledException exception){
	            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
	        }catch (BadCredentialsException e){
	            throw  new Exception("Credenciales invalidas " + e.getMessage());
	        }
	    } 
	    
	    @GetMapping("/actual-usuario")
	    public Usuario obtenerUsuarioActual(Principal principal) {
	    	return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
	    	
	    }
}
