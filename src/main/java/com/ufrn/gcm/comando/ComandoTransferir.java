package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoTransferir implements ComandoBanco {
	
	ContaBancaria contaOrigem, contaDestino;
	BigDecimal valor;
	
	public ComandoTransferir(ContaBancaria contaOrigem, ContaBancaria contaDestino, BigDecimal valor) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
	}
	
	@Override
	public BigDecimal execute() throws Exception {
		if (valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new Exception("Erro: Valor não pode ser negativo!");
		}
		
		if (contaOrigem.getSaldo().compareTo(valor) < 0) {
			throw new Exception(String.format(
					"Erro: Conta %d não possui saldo suficiente!", contaOrigem.getNumero()));
		}
		
		contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
		contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
		
		return contaOrigem.getSaldo();
	}
}
