package com.ufrn.gcm.dominio;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<ContaBancaria> contas;

	public Banco() {
		contas = new ArrayList<ContaBancaria>();
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}

	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}
	
}
