package com.entersoft.cursocm.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.entersoft.cursocm.domain.Cliente;
import com.entersoft.cursocm.domain.enums.TipoCliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 8611480420989878273L;
	
	private Integer id;
	
	@NotEmpty(message="O nome é um campo obrigatório.")
	@Length(min=8, max=120, message="O campo nome deve ter entre 8 e 120 caracteres.")
	private String nome;
	
	@Email(message="E-mail inválido")
	private String email;
	
	private String cpfOuCnpj;
	private TipoCliente tipo;

	public ClienteDTO() { }

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpfOuCnpj = obj.getCpfOuCnpj();
		this.tipo = obj.getTipo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
}
