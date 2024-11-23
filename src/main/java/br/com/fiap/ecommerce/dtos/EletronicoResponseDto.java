package br.com.fiap.ecommerce.dtos;

import lombok.Data;

@Data
public class EletronicoResponseDto {
	private int consumo;
	private String modelo;
	private String nome;
	private int quantidade;
	private Long id;
	
	
	public int getConsumo() {
		return consumo;
	}



	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
}
