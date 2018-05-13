package com.entersoft.cursocm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.entersoft.cursocm.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = -2250694580252995762L;
	
	private Integer id;
	
	@NotEmpty(message="O campo nome é obrigatório.")
	@Length(min=5, max=80, message="O nome deve ter no mínimo 5 e no máximo 80 caracteres.")
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
