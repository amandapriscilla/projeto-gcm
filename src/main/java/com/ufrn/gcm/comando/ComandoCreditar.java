package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoCreditar implements ComandoBanco {
	
	private ContaBancaria conta;
	private BigDecimal valor;
	
	public ComandoCreditar(ContaBancaria conta, BigDecimal valor) {
		this.conta = conta;
		this.valor = valor;
	}
	
	@Override
	public BigDecimal execute() throws Exception {
		if(valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new Exception("Erro: Valor a creditar não pode ser negativo!");
		}
		
		conta.setSaldo(conta.getSaldo().add(valor));
		return conta.getSaldo();
	}
}
