package com.teste.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.apirest.model.Pagina;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {
	Pagina findById(long id);
	Pagina findByUsuarioId(long id);
}
