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
	
	@Override
	public BigDecimal execute() throws Exception {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new Exception("Erro: Valor não pode ser negativo!");
		}
		
		if (conta.getSaldo().compareTo(valor) < 0) {
			throw new Exception(String.format(
					"Erro: Conta %d não possui saldo suficiente!", conta.getNumero()));
		}
		
		conta.setSaldo(conta.getSaldo().subtract(valor));
		return conta.getSaldo();
	}
}
