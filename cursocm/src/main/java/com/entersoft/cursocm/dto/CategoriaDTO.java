package com.entersoft.cursocm.dto;

import java.io.Serializable;

import com.entersoft.cursocm.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = -2250694580252995762L;
	
	private Integer id;
	private String nome;
	
	
	public CategoriaDTO() { }
	
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
