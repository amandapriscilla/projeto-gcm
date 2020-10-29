package com.ufrn.gcm.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private BigDecimal fatorBonificacao;

	private List<ContaBancaria> contas;

	public Banco() {
		contas = new ArrayList<ContaBancaria>();
	}

	public BigDecimal getFatorBonificacao() {
		return fatorBonificacao;
	}

	public void setFatorBonificacao(BigDecimal fatorBonificacao) {
		this.fatorBonificacao = fatorBonificacao;
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}

	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}
	
	public ContaBancaria getContaBancaria(int numero) {
		for (ContaBancaria conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
}
