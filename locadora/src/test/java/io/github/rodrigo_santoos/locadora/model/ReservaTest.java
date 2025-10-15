package io.github.rodrigo_santoos.locadora.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.rodrigo_santoos.locadora.exception.ReservaInvalidaException;

import static org.assertj.core.api.Assertions.*;

public class ReservaTest {
	
	private Cliente cliente;
	private Carro carro;
	
	@BeforeEach
	void inicializandoAntesDeTudo() {
		this.cliente = new Cliente("Rodrigo");
		
		this.carro = new Carro("Audi", 1000.00);
	}
	
	@Test
	@DisplayName("Teste para verificar se a reserva foi criada")
	 void testeDeveCriarReserva() {
		
		// 1 cenario
		

		
		// 2 execucao
		Reserva reserva = new Reserva(cliente, carro, 1);
		
		// 3 verificacao
		assertThat(reserva).isNotNull();
		
	}
	
	
	@Test
	@Disabled
	@DisplayName("Teste para verificar se a reserva foi criada abaixo de 1 dia")
	 void testeNaoDeveCriarReservaComMenosDeUmDia() {
		
		//como verificar se deu uma exception
		
		// aqui ele espera que lanca uma exception, se lancar significa que esta certo
		assertThrows(ReservaInvalidaException.class, () -> new Reserva(cliente,carro, 0));
		
		//aqui ele espera que nao lanca uma exception
		assertDoesNotThrow(() -> new Reserva(cliente,carro, 1));
		
		//aqui estamos pegando o erro
		Exception catchException = catchException(() -> new Reserva(cliente,carro, 0));
		
		//aqui estamos verificando se a classe intanciada é a ReservaInvalidaException e se a mensagem é esse 
		assertThat(catchException).isInstanceOf(ReservaInvalidaException.class).hasMessage("Dias nao pode ser menor que 1");
		
	}
	
	@Test
	@DisplayName("Teste para verificar o calculo total da reserva")
	 void testeDeveCalcularTotalReserva() {
		
		// 1 cenarios

		
		Reserva reserva = new Reserva(cliente,carro, 5);
		
		// 2 execucao
		Double calcularTotalDaReserva = reserva.calcularTotalDaReserva();
		
		// 3 verificacao
		assertThat(calcularTotalDaReserva).isNotNull().isEqualTo(4950);
		
		
	}

}
 