package com.example.desafio.produto;

public class ProdutoDTO {
	
	private String nome;
	private Double mediaNotas;

	public ProdutoDTO(String nome, Double mediaNotas) {
		this.nome = nome;
		this.mediaNotas = mediaNotas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getMediaNotas() {
		return mediaNotas;
	}

	public void setMediaNotas(Double mediaNotas) {
		this.mediaNotas = mediaNotas;
	}

}
