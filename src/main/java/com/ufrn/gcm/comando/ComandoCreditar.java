package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoCreditar implements ComandoBanco {
	
	private ContaBancaria conta;
	private BigDecimal valor;
	private BigDecimal fatorBonificacao;
	
	public ComandoCreditar(ContaBancaria conta, BigDecimal valor, BigDecimal fatorBonificacao) {
		this.conta = conta;
		this.valor = valor;
		this.fatorBonificacao = fatorBonificacao;
	}
	
	@Override
	public BigDecimal execute() throws Exception {
		if(valor.compareTo(BigDecimal.ZERO) < 0) {
			throw new Exception("Erro: Valor depositado não pode ser negativo!");
		}
		
		if(fatorBonificacao != null &&  fatorBonificacao.compareTo(BigDecimal.ZERO) > 0) { 
			processaBonificacao();
		} // else ignorar = sem bonus
		
		conta.setSaldo(conta.getSaldo().add(valor));
		return conta.getSaldo();
	}

	private void processaBonificacao() {

		BigDecimal bonusCredito = valor.divide(fatorBonificacao);
		BigDecimal bonusAcumulado = conta.getBonus().add(bonusCredito);
		conta.setBonus(bonusAcumulado);
		
	}
}
