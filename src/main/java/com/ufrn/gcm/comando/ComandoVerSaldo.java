package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoVerSaldo implements ComandoBanco {

	private ContaBancaria conta;
	
	public ComandoVerSaldo(ContaBancaria conta) {
		this.conta = conta;
	}
		
	@Override
	public BigDecimal execute() throws Exception {
		return conta.getSaldo();
	}

}
