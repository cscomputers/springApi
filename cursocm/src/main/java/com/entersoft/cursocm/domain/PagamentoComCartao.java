package com.entersoft.cursocm.domain;

import javax.persistence.Entity;

import com.entersoft.cursocm.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{

	private static final long serialVersionUID = 9048794674044403007L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() { }
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
