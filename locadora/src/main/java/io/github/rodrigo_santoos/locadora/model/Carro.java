package io.github.rodrigo_santoos.locadora.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
	
	private String modelo;
	private Double valorDiario;

	
	public Double calcularValorAluguelDiario(int diario) {
		
		if(diario >= 5) {
			return (valorDiario * diario) - 50;
		}
		
		return valorDiario * diario;
	}
	
}
