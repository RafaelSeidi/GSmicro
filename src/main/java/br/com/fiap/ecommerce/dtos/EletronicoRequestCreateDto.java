package br.com.fiap.ecommerce.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletronicoRequestCreateDto {
	private int consumo;
	private String modelo;
	private String nome;
	private int quantidade;
}
