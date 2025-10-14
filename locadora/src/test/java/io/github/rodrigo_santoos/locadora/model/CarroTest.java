package io.github.rodrigo_santoos.locadora.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarroTest {
	
	@Test // aqui estamos dizendo ao JUNIT que essa funcao é de teste
	@DisplayName("Deve calcular o valor do Aluguel") // aqui estamos dando um nome para aparecer quando rodar o teste
	void testeDeveCalcularValorAluguel() {
		
		// 1 - cenario
		Carro carro = new Carro("AUDI", 100.00);
		
		// 2- execucao
		Double calcularValorAluguelDiario = carro.calcularValorAluguelDiario(3);
		
		// 3 - verificacao
		//aqui estamos dizendo que esperamos um valor que venha assim
		Assertions.assertEquals(300.00, calcularValorAluguelDiario);
	}
	
	@Test 
	@DisplayName("Deve calcular o valor do Aluguel com desconto") 
	void testeDeveCalcularValorAluguelComDesconto() {
		
		// 1 - cenario
		Carro carro = new Carro("AUDI", 100.00);
		
		int diasAlugados = 5;
		
		// 2- execucao
		Double calcularValorAluguelDiario = carro.calcularValorAluguelDiario(diasAlugados);
		
		// 3 - verificacao
		//aqui estamos dizendo que esperamos um valor que venha assim
		Assertions.assertEquals(450.00, calcularValorAluguelDiario);
	}

}
