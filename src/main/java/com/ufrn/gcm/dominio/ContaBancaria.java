package com.ufrn.gcm.dominio;

import java.math.BigDecimal;

public class ContaBancaria {
	
	private int numero;
	
	private BigDecimal saldo;
	
	private BigDecimal bonus;
	
	public ContaBancaria() {
		this.saldo = BigDecimal.ZERO;
		this.bonus = BigDecimal.ZERO;
	}
	
	public ContaBancaria(int numero) {
		this.numero = numero;
		this.saldo = BigDecimal.ZERO;
		this.bonus = BigDecimal.ZERO;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
}
