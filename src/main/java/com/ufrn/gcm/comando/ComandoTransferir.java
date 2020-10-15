package com.ufrn.gcm.comando;

import java.math.BigDecimal;

import com.ufrn.gcm.dominio.ContaBancaria;

public class ComandoTransferir implements ComandoBanco {
	
	ContaBancaria A, B;
	BigDecimal valor;
	
	public ComandoTransferir(ContaBancaria A, ContaBancaria B, BigDecimal valor) {
		this.A = A;
		this.B = B;
		this.valor = valor;
	}
	
	public BigDecimal execute() {
		if (valor.compareTo(BigDecimal.ZERO)>=0 && A.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO)>=0 ) {
			B.setSaldo(B.getSaldo().add(valor));
			A.setSaldo(A.getSaldo().subtract(valor));			
		}
		return null;
	}
}
