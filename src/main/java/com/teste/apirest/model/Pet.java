package com.teste.apirest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pet")
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name="ID_Tipo_Pet")
	private TipoPet tipoPet;
	
	@ManyToOne
	@JoinColumn(name="ID_Usuario")
	private Usuario usuario;
	
	private String nome;
	private int faixaEtaria;
	private int sexo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public TipoPet getTipoPet() {
		return tipoPet;
	}
	
	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
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
	
	public int getFaixaEtaria() {
		return faixaEtaria;
	}
	
	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	public int getSexo() {
		return sexo;
	}
	
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
