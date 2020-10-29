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
			banco.setFatorBonificacao(new BigDecimal(100));
			
			ContaBancaria conta = new ContaBancaria(12345);
			banco.getContas().add(conta);
			
			conta = new ContaBancaria(23456);
			conta.setSaldo(new BigDecimal(100));
			banco.getContas().add(conta);
			
			conta = new ContaBancaria(34567);
			conta.setSaldo(new BigDecimal(200));
			banco.getContas().add(conta);
		}
	}
	
	public String formatarMoeda(BigDecimal saldo) {
		return NumberFormat.getCurrencyInstance().format(saldo.setScale(2).doubleValue());
	}
	
	private ContaBancaria getContaBancaria(int numero) throws Exception {
		ContaBancaria conta = this.banco.getContaBancaria(numero);
		
		if (conta == null) {
			throw new Exception(String.format("Erro: Conta %d não encontrada!", numero));
		}
		
		return conta;
	}

	public BigDecimal verSaldo(int numero) throws Exception {
		ContaBancaria conta = this.getContaBancaria(numero);
		ComandoBanco comando = new ComandoVerSaldo(conta);
		return comando.execute();		
	}
	
	public BigDecimal creditarConta(int numero, BigDecimal valor) throws Exception {
		ContaBancaria conta = this.banco.getContaBancaria(numero);
		ComandoBanco comando = new ComandoCreditar(conta, valor, this.banco.getFatorBonificacao());
		return comando.execute();		
	}
	
	public BigDecimal debitarConta(int numero, BigDecimal valor) throws Exception {
		ContaBancaria conta = this.getContaBancaria(numero);
		ComandoBanco comando = new ComandoDebitar(conta, valor);
		return comando.execute();		
	}
	
	public BigDecimal transferir(int numeroContaOrigem, int numeroContaDestino, BigDecimal valor) throws Exception {
		ContaBancaria contaOrigem = this.getContaBancaria(numeroContaOrigem);
		ContaBancaria contaDestino = this.getContaBancaria(numeroContaDestino);	
		ComandoBanco comando = new ComandoTransferir(contaOrigem, contaDestino, valor);
		
		return comando.execute();
	}

	public int getNumeroValido(String numeroConta) throws Exception {
		try {
			return Integer.parseInt(numeroConta);
		} catch(Exception e) {
			throw new Exception("Erro: Número da Conta Inválido!");
		}
	}
}
