package com.teste.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.apirest.model.Usuario;
import com.teste.apirest.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(long id) {
		return usuarioRepository.findById(id);
	}
	
	public void deleteUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public Usuario atuaLogin(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
