package com.ufrn.gcm.service;

import java.math.BigDecimal;

import java.text.NumberFormat;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ufrn.gcm.comando.ComandoBanco;
import com.ufrn.gcm.comando.ComandoVerSaldo;
import com.ufrn.gcm.comando.ComandoCreditar;
import com.ufrn.gcm.comando.ComandoDebitar;
import com.ufrn.gcm.comando.ComandoTransferir;
import com.ufrn.gcm.dominio.Banco;
import com.ufrn.gcm.dominio.ContaBancaria;

@Service
public class BancoService {

	private Banco banco;
	
	@PostConstruct
    public void init() {
		if (banco == null) {
			banco = new Banco();
			
			ContaBancaria conta = new ContaBancaria();
			conta.setNumero(12345);
			conta.setSaldo(BigDecimal.ZERO);
			banco.getContas().add(conta);
			
			conta = new ContaBancaria();
			conta.setNumero(23456);
			conta.setSaldo(new BigDecimal(100));
			banco.getContas().add(conta);
			
			conta = new ContaBancaria();
			conta.setNumero(34567);
			conta.setSaldo(new BigDecimal(200));
			banco.getContas().add(conta);
		}
    }
	
	public String formatarMoeda(BigDecimal saldo) {
		return NumberFormat.getCurrencyInstance().format(saldo.setScale(2).doubleValue());
	}

	public BigDecimal verSaldo(int numero) throws Exception {
		ComandoBanco comando = new ComandoVerSaldo(banco, numero);
		BigDecimal saldo = comando.execute();
		
		if (saldo == null) {
			throw new Exception("Conta não encontrada!");
		}
		return saldo;
	}
	
	public BigDecimal creditarConta(int numero, BigDecimal valor) throws Exception {
		ContaBancaria conta = this.banco.getContaBancaria(numero);
		ComandoBanco comando = new ComandoCreditar(conta, valor);
		valor = comando.execute();
		
		if (valor == null) {
			throw new Exception("Valor inválido!");
		}
		return valor;
	}
	
	public BigDecimal debitarConta(int numero, BigDecimal valor) throws Exception {
		ContaBancaria conta = this.banco.getContaBancaria(numero);
		ComandoBanco comando = new ComandoDebitar(conta, valor);
		valor = comando.execute();
		
		if (valor == null) {
			throw new Exception("Saldo insuficiente!");
		}
		return valor;
	}
	
	public BigDecimal transferir(int A, int B, BigDecimal valor) throws Exception {
		ContaBancaria Aconta = this.banco.getContaBancaria(A);
		ContaBancaria Bconta = this.banco.getContaBancaria(B);	
		ComandoBanco comando = new ComandoTransferir(Aconta, Bconta, valor);
		valor = comando.execute();
		if (valor == null) {
			throw new Exception("Algo deu errado!");
		}
		return valor;
	}
}
