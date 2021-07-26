package com.teste.apirest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pagina")
public class Pagina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name="ID_Usuario")
	private Usuario usuario;
	
	private String nome;
	private int avaliacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_Pagina")
	private List<PostagemPagina> posts;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public List<PostagemPagina> getPosts() {
		return posts;
	}

	public void setPosts(List<PostagemPagina> posts) {
		this.posts = posts;
	}
	
	public void addPost(PostagemPagina post) {
		posts.add(post);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
