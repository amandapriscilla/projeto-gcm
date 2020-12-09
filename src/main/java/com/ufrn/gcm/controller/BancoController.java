package com.ufrn.gcm.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufrn.gcm.service.BancoService;

@Controller
public class BancoController {
	
	@Autowired
	private BancoService bancoService;

	@RequestMapping(value={"", "/", "index"})
	public String index() {
		return "index";
	}
	
	@PostMapping("/app")
	public String entrarConta(@RequestParam("numero") String numeroConta, ModelMap modelMap) {

		try {
			BigDecimal saldo = bancoService.verSaldo(bancoService.getNumeroValido(numeroConta));
			populaDados(numeroConta, saldo, modelMap);
			return "app";
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("erro", e.getMessage());
			return "index";
		}
	}
	
	private void populaDados(String numeroConta, BigDecimal saldo, ModelMap modelMap) {
		modelMap.put("conta", numeroConta);
		modelMap.put("saldo", bancoService.formatarMoeda(saldo));
	}
	
	@PostMapping("/depositar")
	public String creditarConta(@RequestParam("numero") String numeroConta,
			@RequestParam("valor") Optional<BigDecimal> valorCreditado, ModelMap modelMap) {
		BigDecimal saldo = BigDecimal.ZERO;;
		String pagina = "creditar";
		try {
			if(valorCreditado.isPresent()) {
				bancoService.creditarConta(bancoService.getNumeroValido(numeroConta), valorCreditado.get());
				pagina = "app";
			}
			saldo = bancoService.verSaldo(bancoService.getNumeroValido(numeroConta));
			populaDados(numeroConta, saldo, modelMap);
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("erro", e.getMessage());
			return "index";
		}
	}
	
	@PostMapping("/debitar")
	public String debitarConta(@RequestParam("numero") String numeroConta,
			@RequestParam("valor") Optional<BigDecimal> valorDebitado, ModelMap modelMap) {
		
		BigDecimal saldo = BigDecimal.ZERO;;
		String pagina = "debitar";
		try {
			if(valorDebitado.isPresent()) {
				bancoService.debitarConta(bancoService.getNumeroValido(numeroConta), valorDebitado.get());
				pagina = "app";
			}
			saldo = bancoService.verSaldo(bancoService.getNumeroValido(numeroConta));
			populaDados(numeroConta, saldo, modelMap);
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("erro", e.getMessage());
			return "index";
		}
	}
	
	@PostMapping("/transferir")
	public String transferir(@RequestParam("numero") String numeroConta, 
			@RequestParam("destino") Optional<String> numeroContaDestino,
			@RequestParam("valor") Optional<BigDecimal> valorTransferencia, ModelMap modelMap) {
		
		BigDecimal saldo = BigDecimal.ZERO;;
		String pagina = "transferir";
		try {
			if(valorTransferencia.isPresent()) {
				if (!numeroContaDestino.isPresent()) {
					throw new Exception("Erro: Conta de destino não pode ser vazia!");
				}
				
				bancoService.transferir(bancoService.getNumeroValido(numeroConta),
						bancoService.getNumeroValido(numeroContaDestino.get()),
						valorTransferencia.get());
				pagina = "app";
			}
			saldo = bancoService.verSaldo(bancoService.getNumeroValido(numeroConta));
			populaDados(numeroConta, saldo, modelMap);
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("erro", e.getMessage());
			return "index";
		}
	}

	// METODOS DE ACESSO RESTFUL

	@GetMapping("/verSaldo/{numero}")
	public String verSaldo(@PathVariable(value = "numero") int numeroConta) {
		try {
			BigDecimal saldo = bancoService.verSaldo(numeroConta);
			return String.format("A conta %d possui o saldo de %s.", numeroConta, bancoService.formatarMoeda(saldo));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/creditar/{numero}/{valor}")
	public String creditarConta(@PathVariable(value = "numero") int numeroConta, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			BigDecimal novoSaldo = bancoService.creditarConta(numeroConta, valor);
			return String.format("Valor de %s creditado na conta %d. Novo saldo: %s.", 
					bancoService.formatarMoeda(valor), numeroConta, bancoService.formatarMoeda(novoSaldo));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/debitar/{numero}/{valor}")
	public String debitarConta(@PathVariable(value = "numero") int numeroConta, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			BigDecimal novoSaldo = bancoService.debitarConta(numeroConta, valor);
			return String.format("Valor de %s debitado da conta %d. Novo saldo: %s.", 
					bancoService.formatarMoeda(valor), numeroConta, bancoService.formatarMoeda(novoSaldo));					
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/transferir/{numeroOrigem}/{numeroDestino}/{valor}")
	public String transferir(@PathVariable(value = "numeroOrigem") int numeroContaOrigem, 
			@PathVariable(value = "numeroDestino") int numeroContaDestino, @PathVariable(value = "valor") BigDecimal valor ) {
		try {
			BigDecimal novoSaldo = bancoService.transferir(numeroContaOrigem, numeroContaDestino, valor);
			return String.format("Valor de %s transferido para a conta %d. Novo saldo da conta %d: %s.", 
					bancoService.formatarMoeda(valor), numeroContaDestino, numeroContaOrigem, bancoService.formatarMoeda(novoSaldo));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
