package com.teste.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.apirest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findById(long id);
	
	//Usuario findByEmailAndSenha(String email, String senha);
	
}
