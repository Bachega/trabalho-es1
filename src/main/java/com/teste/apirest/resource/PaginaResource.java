package com.teste.apirest.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.apirest.model.Pagina;
import com.teste.apirest.model.PostagemPagina;
import com.teste.apirest.service.PaginaService;

@RestController
@RequestMapping(value="/pagina")
public class PaginaResource {
	
	@Autowired
	private PaginaService paginaService;
	
	@GetMapping("/carregar/{id}")
	public Pagina getPaginaByIdUsuario(@PathVariable(value="id") long id) {
		return paginaService.loadPageByUserId(id);
	}
	
	@PostMapping("/cadastrar/{id}")
	public Pagina createPagina(@RequestBody Pagina pagina, @PathVariable(value="id") long id) {
		return paginaService.createPage(pagina, id);
	}
	
	@PostMapping("/post/{id}")
	public PostagemPagina fazerPost(@RequestBody PostagemPagina postagem, @PathVariable(value="id") long id) {
		return paginaService.makePost(postagem, id);
	}
}
