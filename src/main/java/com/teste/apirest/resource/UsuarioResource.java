package com.teste.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.apirest.model.Usuario;
import com.teste.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(@RequestBody Usuario usuario) {
		return usuarioRepository.findAll();
	}
}
