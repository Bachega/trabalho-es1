package com.teste.apirest.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.apirest.model.Pagina;
import com.teste.apirest.model.PostagemPagina;
import com.teste.apirest.repository.PaginaRepository;
import com.teste.apirest.repository.UsuarioRepository;

@Service
public class PaginaService {
	
	@Autowired
	private PaginaRepository paginaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Pagina loadPageByUserId(long id) {
		return paginaRepository.findByUsuarioId(id);
	}
	
	public Pagina createPage(Pagina pagina, long id) {
		pagina.setUsuario(usuarioRepository.findById(id));
		pagina.setAvaliacao(0);
		pagina.setPosts(new ArrayList<PostagemPagina>());
		return paginaRepository.save(pagina);
	}
	
	@Transactional
	public PostagemPagina makePost(PostagemPagina post, long id) {
		Pagina p = paginaRepository.findById(id);
		p.addPost(post);
		return post;
	}
}
