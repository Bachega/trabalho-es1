package com.teste.apirest.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.apirest.model.Login;
import com.teste.apirest.repository.LoginRepository;

@RestController
@RequestMapping(value="/api")
public class LoginResource {
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/dologin")
	public String listaLogin(@RequestBody Login login) {
		int id = -1;
		
		try {
			id = loginRepository.doLogin(login.getEmail(), login.getSenha());
		} catch(Exception e) {
			id = -1;
		}
		
		return "{\"id_usuario\":" + id + "}";
	}
	
	@GetMapping("/login/{id}")
	public Login listaLoginUnico(@PathVariable(value="id") long id) {
		return loginRepository.findById(id);
	}
	
	@PostMapping("/login")
	public Login salvaLogin(@RequestBody Login login) {
		return loginRepository.save(login);
	}
	
	@DeleteMapping("/login")
	public void deleteLogin(@RequestBody Login login) {
		loginRepository.delete(login);
	}
	
	@PutMapping("/login")
	public Login atualizaLogin(@RequestBody Login login) {
		return loginRepository.save(login);
	}
}
