package com.teste.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.teste.apirest.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findById(long id);
	
	Login findByEmailAndSenha(String email, String senha);
	
}