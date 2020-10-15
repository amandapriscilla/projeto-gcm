package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;


public class ComandoDebitar implements ComandoBanco{
	
	private ContaBancaria conta;
	private BigDecimal valor;
	
	public ComandoDebitar(ContaBancaria conta, BigDecimal valor) {
		this.conta = conta;
		this.valor = valor;
	}
	
	public BigDecimal execute() {
		if(conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO)>=0) {
			conta.setSaldo(conta.getSaldo().subtract(valor));
			return conta.getSaldo();
		}
		return null;
	}
}
