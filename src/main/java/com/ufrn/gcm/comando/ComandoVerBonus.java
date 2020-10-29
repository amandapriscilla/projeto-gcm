package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoVerBonus implements ComandoBanco {

	private ContaBancaria conta;
	
	public ComandoVerBonus(ContaBancaria conta) {
		this.conta = conta;
	}
		
	@Override
	public BigDecimal execute() throws Exception {
		return conta.getBonus();
	}

}
