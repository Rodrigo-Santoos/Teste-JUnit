package io.github.rodrigo_santoos.locadora.model;

import io.github.rodrigo_santoos.locadora.exception.ReservaInvalidaException;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Reserva {
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private Carro carro;
	
	private Integer dias;

	
	public Double calcularTotalDaReserva() {
		return this.carro.calcularValorAluguelDiario(this.dias);
	}


	public Reserva(Cliente cliente, Carro carro, Integer dias) {
		super();
		
		if (dias < 1) 
			throw new ReservaInvalidaException("Dias nao pode ser menor que 1");
		
		this.cliente = cliente;
		this.carro = carro;
		this.dias = dias;
	}
}
