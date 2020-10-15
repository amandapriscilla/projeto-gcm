package com.ufrn.gcm.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.gcm.service.BancoService;

@RestController
public class BancoController {
	
	@Autowired
	private BancoService bancoService;
	
	@GetMapping("/verSaldo/{numero}")
	public String verSaldo(@PathVariable(value = "numero") int numeroConta) {
		try {
			return String.format("A conta %d possui o saldo de %s", numeroConta, 
					bancoService.formatarMoeda(bancoService.verSaldo(numeroConta)));
		} catch (Exception e) {
			return "Erro: Não foi possível encontrar a conta bancária!";
		}
	}
	
	@GetMapping("/creditarConta/{numero}/{valor}")
	public String creditarConta(@PathVariable(value = "numero") int numeroConta, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			return String.format("A conta %d possui o saldo de %s", numeroConta, 
					bancoService.formatarMoeda(bancoService.creditarConta(numeroConta, valor)));
		} catch (Exception e) {
			return "Erro: Crédito negativo é inválido!";
		}
	}
	
	@GetMapping("/debitarConta/{numero}/{valor}")
	public String debitarConta(@PathVariable(value = "numero") int numeroConta, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			return String.format("A conta %d possui o saldo de %s", numeroConta, 
					bancoService.formatarMoeda(bancoService.debitarConta(numeroConta, valor)));
		} catch (Exception e) {
			return "Erro: Saldo insuficiente para debitar";
		}
	}
	
	@GetMapping("/transferir/{numero}/{numero2}/{valor}")
	public String transferir(@PathVariable(value = "numero") int numeroConta, @PathVariable(value = "numero2") int numeroConta2, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			return String.format("A conta %d possui o saldo de %s", numeroConta, 
					bancoService.formatarMoeda(bancoService.transferir(numeroConta, numeroConta2, valor)));
		} catch (Exception e) {
			return "";
		}
	}
}
