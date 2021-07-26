package com.teste.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.apirest.model.Login;
import com.teste.apirest.model.Usuario;
import com.teste.apirest.repository.LoginRepository;
import com.teste.apirest.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario doLogin(Login login) {
		Login l = loginRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
		
		if(l != null)
			return l.getUsuario();
		
		return null;
	}
	
	public Login getLoginById(long id) {
		return loginRepository.findById(id);
	}
	
	public Login createLogin(Login login, long id) {
		login.setUsuario(usuarioRepository.findById(id));
		System.out.println(login.getUsuario());
		return loginRepository.save(login);
	}			
	
	public void deleteLogin(Login login) {
		loginRepository.delete(login);
	}
	
	public Login updateLogin(Login login) {
		return loginRepository.save(login);
	}
}
