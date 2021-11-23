package com.example.desafio.produto.chocolate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.desafio.produto.ProdutoGranel;

@Entity
@Table(name = "chocolate")
public class Chocolate extends ProdutoGranel {

	@Column(name = "peso", nullable = false)
	private Double peso;

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
