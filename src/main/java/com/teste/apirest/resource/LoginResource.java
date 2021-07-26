package com.teste.apirest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.teste.apirest.model.Login;
import com.teste.apirest.model.Usuario;
import com.teste.apirest.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginResource {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/do")
	public Usuario doLogin(@RequestBody Login login) {
		Usuario u = loginService.doLogin(login);
		
		if(u == null)
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		
		return u;	
	}
	
	@GetMapping("/get/{id}")
	public Login getLoginById(@PathVariable(value="id") long id) {
		Login l = loginService.getLoginById(id);
		
		if(l == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return l;
	}
	
	@PostMapping("/cadastrar/{id}")
	public Login salvaLogin(@RequestBody Login login, @PathVariable(value="id") long id) {
		Login l = loginService.createLogin(login, id);
		
		if(l == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return l;
	}	
	
	
	@DeleteMapping("/deletar")
	public void deleteLogin(@RequestBody Login login) {
		loginService.deleteLogin(login);
	}
	
	@PutMapping("/atualizar")
	public Login atualizaLogin(@RequestBody Login login) {
		return loginService.updateLogin(login);
	}
	
}
