package com.teste.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.apirest.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findById(long id);
	
	@Query(value="SELECT id_usuario FROM Login l WHERE l.email= :email AND l.senha= :senha", nativeQuery=true)
	int doLogin(String email, String senha);
}