package com.teste.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.apirest.model.Usuario;
import com.teste.apirest.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioService.createUsuario(usuario);
	}
	
	@GetMapping("/listar")
	public List<Usuario> listaUsuarios(@RequestBody Usuario usuario) {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/carregar/{id}")
	public Usuario listaLoginUnico(@PathVariable(value="id") long id) {
		return usuarioService.getUsuarioById(id);
	}
	
}
