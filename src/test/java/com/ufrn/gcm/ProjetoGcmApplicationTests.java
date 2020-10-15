package com.ufrn.gcm;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import com.ufrn.gcm.service.BancoService;

@SpringBootTest
class ProjetoGcmApplicationTests {
	
	@Autowired
	private BancoService bancoService;
	
	@Test
	void contextLoads() throws Exception {
		assertNotNull(bancoService);
	}
	
	@Test
	void testarVerSaldo() throws Exception {
		assertEquals(bancoService.verSaldo(12345), BigDecimal.ZERO);
	}
	
	@Test
	void testarFalhaVerSaldo() throws Exception {
		assertThrows(Exception.class, () -> {
			bancoService.verSaldo(12344);
		});
	}
	
	@Test
	void testarCreditar() throws Exception {
		assertEquals(bancoService.creditarConta(12345, BigDecimal.TEN), BigDecimal.TEN);
	}
	
	@Test
	void testarCreditarNegativo() throws Exception {
		assertThrows(Exception.class, () -> {
			bancoService.creditarConta(12345, new BigDecimal(-200));
		});
	}
	
	@Test
	void testarDebitarSaldoInsuficiente() throws Exception {
		assertThrows(Exception.class, () -> {
			bancoService.debitarConta(12345, new BigDecimal(200));
		});
	}
	
	@Test
	void testarDebitar() throws Exception {
		assertEquals(bancoService.debitarConta(23456, new BigDecimal(90)), BigDecimal.TEN);
	}
	
	@Test
	void testarTransferirSaldoInsuficiente() throws Exception {
		assertThrows(Exception.class, () -> {
			bancoService.transferir(12345, 23456, new BigDecimal(200));
		});
	}
}
