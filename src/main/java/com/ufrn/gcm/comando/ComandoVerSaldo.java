package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.Banco;
import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoVerSaldo implements ComandoBanco {

	private Banco banco;
	private int numero;
	
	public ComandoVerSaldo(Banco banco, int numeroConta) {
		this.banco = banco;
		this.numero = numeroConta;
	}
		
	@Override
	public BigDecimal execute() {
		
		for (ContaBancaria conta : banco.getContas()) {
			if (conta.getNumero() == numero) {
				return conta.getSaldo();
			}
		}
		
		return null;
	}

}
