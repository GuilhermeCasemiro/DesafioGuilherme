package com.example.desafio.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_granel")
public class ProdutoGranel extends Produto {

	@Column(name = "preco_quilograma", nullable = false)
	private Double precoPorQuilograma;

	public Double getPrecoPorQuilograma() {
		return precoPorQuilograma;
	}

	public void setPrecoPorQuilograma(Double precoPorQuilograma) {
		this.precoPorQuilograma = precoPorQuilograma;
	}
}
