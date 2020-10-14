package com.ufrn.gcm.controller;

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
}
