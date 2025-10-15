package io.github.rodrigo_santoos.locadora.model;

import static org.junit.jupiter.api.Assertions.*; // inves de fica instanciando toda hora, coloca assim que ele fica mais simples

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTeste {
	
	@Test
	@DisplayName("Deve criar cliente com Nome")
	void deveCriarClienteComNome() {
		
		// 1 cenario
		Cliente cliente = new Cliente("Rodrigo de Oliveira dos Santos");
		
		
		//2 execucao
		String nome = cliente.getNome();
		
		//3 verificacao
		
		assertNotNull(nome);
		assertTrue(nome.startsWith("R"));
		assertFalse(nome.length() > 100);
		
	}
	
	@Test
	@DisplayName("Deve Criar Nome Vazio ")
	void deveCriarClienteSemNome() {
		
		// 1 cenario
		Cliente cliente = new Cliente(null);
		
		
		//2 execucao
		String nome = cliente.getNome();
		
		//3 verificacao
		assertNull(nome);
		
	}

}
